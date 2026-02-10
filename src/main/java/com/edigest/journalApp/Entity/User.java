package com.edigest.journalApp.Entity;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data // Getter, Setter,RequiredArgsConstructor,ToString,EqualsAndHashCode,Value
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "users")
// If we have not provided anything here then collection(table name) will go to Entity directly or else we should provide the collection name
//Document annotation will provide information to Spring that this mapped to Mongodb collections
public class User {
    //JournalEntry will be an instance and will equal to Documents(Row)
    @Id //Id annotation is a unique key for our collection(table) available in documents(row)

    private ObjectId id; //provides unique id via mongodb
    @Indexed(unique = true) //validate for uniqueness else throw error at the same time, in Spring boot-need to provide manually under appl^n properties
    @NonNull //Not null acceptance for username, annotation of lombok
    private String userName;
    @NonNull //Not null acceptance for password, annotation of lombok
    private String password;
    //To link User collections with JournalEntry collection, combining them into a list using Array
    @DBRef //It will annotate db from mongo, Its creating user reference into journalEntries
    // containing reference of users collection and unique id of users
    private List<JournalEntry> journalEntries=  new ArrayList<>();
    private List<String> roles;

}
