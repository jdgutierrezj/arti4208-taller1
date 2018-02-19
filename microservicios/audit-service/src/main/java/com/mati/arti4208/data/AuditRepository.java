package com.mati.arti4208.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditRepository extends MongoRepository<AuditDocument, String> {

    public AuditDocument findByUsername(String username);

}
