package com.edigest.journalApp.controller;

import com.edigest.journalApp.Entity.JournalEntry;
import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.service.JournalEntryService;
import com.edigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/Journal") //endpoint
public class JournalEntryController {
    // It will contain many types of controller inside it
    // REST Controller is a special type of classes, special type of components
    // which will handle our HTTP

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

        @GetMapping
        public ResponseEntity<?> getAllJournalEntriesOfUser() { //localhost:8080/journal - Using GET API
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
            String userName = authentication.getName();
            User user = userService.findByUserName(userName);

            List<JournalEntry> all = user.getJournalEntries();
            if (all != null && !all.isEmpty()) {

                return new ResponseEntity<>(all, HttpStatus.OK ) ;
            }
            return new ResponseEntity<>( HttpStatus.NOT_FOUND ) ;
        }

        @PostMapping
        public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) { //localhost:8080/journal - Using POST API
            //It's Entry will be created under Body of Postman using Raw JSON for that need to use @RequesBody of java objects(POJO)

            try {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
                String userName = authentication.getName();
                journalEntryService.saveEntry(myEntry, userName);
                return new ResponseEntity<>(myEntry, HttpStatus.CREATED ) ;
            }
            catch (Exception e) {
                return new ResponseEntity<>( HttpStatus.BAD_REQUEST ) ;
            }

        }

        @GetMapping("id/{myId}") //Asks for users entries object id
        public ResponseEntity<?> getJournalEntryById(@PathVariable ObjectId myId) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
            String userName = authentication.getName();
            User user = userService.findByUserName(userName);
            List <JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList()); // asking to convert into to List
            if (!collect.isEmpty()) {
                Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
                if (journalEntry.isPresent()) {
                    return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK ) ;
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND ) ;

        }

        @DeleteMapping("id/{myId}")
        public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId) { //?-> Wild card Pattern
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
            String userName = authentication.getName();
            boolean removed = journalEntryService.deleteById(myId, userName);
            if (removed) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("id/{id}")
        public ResponseEntity<?> updateJournalEntryById(
                @PathVariable ObjectId id,
                @RequestBody JournalEntry newEntry) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //It will help store password in Encrypted way
            String userName = authentication.getName();
            User user = userService.findByUserName(userName);
            List <JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
            if (!collect.isEmpty()) {
                Optional<JournalEntry> journalEntry = journalEntryService.findById(id);
                if (journalEntry.isPresent()) {
                    JournalEntry old = journalEntry.get();
                    old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
                    old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
                    journalEntryService.saveEntry(old);
                    return  new ResponseEntity<>(old,HttpStatus.OK) ;
                }
            }
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }

}