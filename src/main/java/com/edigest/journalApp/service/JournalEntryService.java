package com.edigest.journalApp.service;


//Business logic written here

import com.edigest.journalApp.Entity.JournalEntry;
import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository; //Using Dependency Injection here,  as we are injecting journalEntryRepository to this class
    // this is an interface and interface should have implementations so, spring will inject implementation in runtime to this class

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) { //Creating Post Call Endpoint
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUserName(null); // It won't allow null value to execute hence, to prevent from this we r using @transactional-keep valid process to session once failed rolls back every processed
            userService.saveUser(user);
        }
        catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the Entry ", e);
        }

    }

    public void saveEntry(JournalEntry journalEntry) { //Creating Put Call Endpoint
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() { //Creating Get Call Endpoint
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));// deleting record as per id match using lambda expression
            if (removed ) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while deleting the Entry ", e);
        }
        return removed;
    }

}
