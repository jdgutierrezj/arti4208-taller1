package com.mati.arti4208.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mati.arti4208.AuditServiceApplication;
import com.mati.arti4208.data.AuditDocument;
import com.mati.arti4208.data.AuditRepository;

@Service
public class AuditMessageListener {

    private static final Logger log = LoggerFactory.getLogger(AuditMessageListener.class);

    @Autowired
	private AuditRepository repository;
    
    @RabbitListener(queues = AuditServiceApplication.QUEUE_AUDIT_NAME)
    public void receiveMessage(final AuditDocument auditMessage) {
    	System.out.println("Mensaje " + auditMessage.toString());
        log.info("Received message as specific class: {}", auditMessage.toString());
        repository.save(auditMessage);
    }
}