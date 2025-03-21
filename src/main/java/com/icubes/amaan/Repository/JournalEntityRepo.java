package com.icubes.amaan.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.icubes.amaan.entity.JournalEntity;

public interface JournalEntityRepo extends MongoRepository<JournalEntity, ObjectId>{
    
}
