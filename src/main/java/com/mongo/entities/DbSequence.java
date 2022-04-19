package com.mongo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
public class DbSequence {

	@Id
    private String  seqId;
    private int seqValue;
	public String getSeqId() {
		return seqId;
	}
	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}
	public int getSeqValue() {
		return seqValue;
	}
	public void setSeqValue(int seqValue) {
		this.seqValue = seqValue;
	}
	public DbSequence() {
		super();
	}
	public DbSequence(String seqId, int seqValue) {
		super();
		this.seqId = seqId;
		this.seqValue = seqValue;
	}
    
}
