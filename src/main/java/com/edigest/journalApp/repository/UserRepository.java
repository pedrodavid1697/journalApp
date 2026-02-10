package com.edigest.journalApp.repository;

import com.edigest.journalApp.Entity.JournalEntry;
import com.edigest.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, ObjectId> {
    //<User Entry -> Entity, POJO, Collections(Table), String -> Data Type>
    User findByUserName(String username); //findBy- keywords, Username-field name

    void deleteByUserName(String username);

}
