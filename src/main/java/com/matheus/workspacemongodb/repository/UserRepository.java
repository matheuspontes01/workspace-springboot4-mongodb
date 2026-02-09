package com.matheus.workspacemongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheus.workspacemongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
