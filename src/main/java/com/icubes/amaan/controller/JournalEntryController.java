package com.icubes.amaan.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.icubes.amaan.entity.JournalEntity;
import com.icubes.amaan.service.JournalEntityService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntityService journalEntityService;

    @GetMapping("/getJournal")
    public ResponseEntity<List<JournalEntity>> getAll() {
        List<JournalEntity> enteries = journalEntityService.getEntry();
        if(enteries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(enteries, HttpStatus.OK);
        
    }

    @PostMapping("/createJournal")
    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntityService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {         
               return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntity> getJournalEntity(@PathVariable ObjectId myId) {
       Optional<JournalEntity> journalEntry = journalEntityService.getJournalEntityById(myId);
       if(journalEntry.isPresent()){
        return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<JournalEntity> deleteJournalEntity(@PathVariable ObjectId myId) {
        Optional<JournalEntity> journalEntry = journalEntityService.getJournalEntityById(myId); 
        if(journalEntry.isPresent()){
         journalEntityService.deleteJournalEntity(myId);
         return new ResponseEntity<>(HttpStatus.OK);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateJournalEntity(@PathVariable ObjectId myId, @RequestBody JournalEntity myEntry) {
       JournalEntity old =  journalEntityService.getJournalEntityById(myId).orElse(null);
        if(old != null){
            old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("")? myEntry.getTitle() : old.getTitle());
            old.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("")? myEntry.getContent() : old.getContent());
            journalEntityService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
