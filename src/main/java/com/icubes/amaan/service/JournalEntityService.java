package com.icubes.amaan.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icubes.amaan.Repository.JournalEntityRepo;
import com.icubes.amaan.entity.JournalEntity;

@Component
public class JournalEntityService {
    
    @Autowired
    private JournalEntityRepo journalEntityRepo;


    public void saveEntry(JournalEntity entity){
        journalEntityRepo.save(entity);

    }

    public List<JournalEntity> getEntry(){
       return journalEntityRepo.findAll();
    }

    public Optional<JournalEntity> getJournalEntityById(ObjectId id){
        return journalEntityRepo.findById(id);
    }

    public void deleteJournalEntity(ObjectId id){
        journalEntityRepo.deleteById(id);
    }


}
