package com.edigest.journalApp.Entity;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data // Getter, Setter,RequiredArgsConstructor,ToString,EqualsAndHashCode,Value
@NoArgsConstructor // requires to use when JSON to POJO parameter changes
@AllArgsConstructor
@Builder
@Document(collection = "journalEntry")
 // If we have not provided anything here then collection(table name) will go to Entity directly or else we should provide the collection name
//Document annotation will provide information to Spring that this mapped to Mongodb collections
public class JournalEntry {
    //JournalEntry will be an instance and will equal to Documents(Row)
    @Id //Id annotation is a unique key for our collection(table) available in documents(row)
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;



    // This entry called as POJO Class (plan old java object)
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getDate() {return date; }
//
//    public void setDate(LocalDateTime date) { this.date = date; }

}
