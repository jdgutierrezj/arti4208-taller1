package com.mati.arti4208.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MailRepository extends MongoRepository<MailDocument, String> {

    public MailDocument findByTo(String to);
    public MailDocument findByFrom(String from);

}
