package com.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.entities.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
	
	
}
