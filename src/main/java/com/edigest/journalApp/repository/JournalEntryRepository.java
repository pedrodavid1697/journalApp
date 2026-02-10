package com.edigest.journalApp.repository;

import com.edigest.journalApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository <JournalEntry, ObjectId> {
    //<Journal Entry -> Entity, POJO, Collections(Table), String -> Data Type>

}
