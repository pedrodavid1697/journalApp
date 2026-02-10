//package com.edigest.journalApp.controller;
//
//import com.edigest.journalApp.Entity.JournalEntry;
//import com.edigest.journalApp.Entity.User;
//import com.edigest.journalApp.service.JournalEntryService;
//import com.edigest.journalApp.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/Journal") //endpoint
//public class JournalEntryController2 {
//    // It will contain many types of controller inside it
//    // REST Controller is a special type of classes, special type of components
//    // which will handle our HTTP
//
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    @Autowired
//    private UserService userService;
//
//        @GetMapping("{userName}")
//        public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) { //localhost:8080/journal - Using GET API
//
//            User user = userService.findByUserName(userName);
//
//            List<JournalEntry> all = user.getJournalEntries();
//            if (all != null && !all.isEmpty()) {
//
//                return new ResponseEntity<>(all, HttpStatus.OK ) ;
//            }
//            return new ResponseEntity<>( HttpStatus.NOT_FOUND ) ;
//        }
//
//        @PostMapping("{userName}")
//        public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName) { //localhost:8080/journal - Using POST API
//            //It's Entry will be created under Body of Postman using Raw JSON for that need to use @RequesBody of java objects(POJO)
//
//            try {
//                myEntry.setDate(LocalDateTime.now());
//                journalEntryService.saveEntry(myEntry, userName);
//                return new ResponseEntity<>(myEntry, HttpStatus.CREATED ) ;
//            }
//            catch (Exception e) {
//                return new ResponseEntity<>( HttpStatus.BAD_REQUEST ) ;
//            }
//
//        }
//
//        @GetMapping("id/{myId}")
//        public ResponseEntity<?> getJournalEntryById(@PathVariable ObjectId myId) {
//
//            Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
//            if (journalEntry.isPresent()) {
//                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK ) ;
//            }
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND ) ;
//
//        }
//
//        @DeleteMapping("id/{userName}/{myId}")
//        public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String userName) { //?-> Wild card Pattern
//            journalEntryService.deleteById(myId, userName);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        @PutMapping("id/{userName}/{id}")
//        public ResponseEntity<?> updateJournalEntryById(
//                @PathVariable ObjectId id,
//                @RequestBody JournalEntry newEntry,
//                @PathVariable String userName) {
//
//            JournalEntry old = journalEntryService.findById(id).orElse(null);
//            if (old !=null) {
//                old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
//                old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
//                journalEntryService.saveEntry(old);
//                return  new ResponseEntity<>(old,HttpStatus.OK) ;
//            }
//
//            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
//        }
//
//}