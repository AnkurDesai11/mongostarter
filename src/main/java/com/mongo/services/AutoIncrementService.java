package com.mongo.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongo.entities.DbSequence;

@Service
public class AutoIncrementService {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public int getNextSequenceId(String sequenceName) {
		//get sequence no
        Query query = new Query(Criteria.where("seqId").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seqValue", 1);
        //modify in document
        DbSequence counter = this.mongoOperations.findAndModify(
        		query, update,
        		new FindAndModifyOptions().returnNew(true).upsert(true),
                DbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeqValue() : 1;
	}
	
}
