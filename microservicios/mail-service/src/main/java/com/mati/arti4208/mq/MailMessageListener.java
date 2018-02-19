package com.mati.arti4208.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mati.arti4208.MailServiceApplication;
import com.mati.arti4208.data.MailDocument;
import com.mati.arti4208.data.MailRepository;
import com.mati.arti4208.mail.EmailServiceImpl;

@Service
public class MailMessageListener {

    private static final Logger log = LoggerFactory.getLogger(MailMessageListener.class);

    @Autowired
	private MailRepository repository;
    
    @Autowired
	private EmailServiceImpl mailService;
    
    @RabbitListener(queues = MailServiceApplication.QUEUE_MAIL_NAME)
    public void receiveMessage(final MailDocument mailMessage) {
        log.info("Sending mail : ", mailMessage.toString());
        mailService.sendSimpleMessage(mailMessage.getTo(), mailMessage.getSubject(), mailMessage.getBody());
        log.info("Storing mailDocumento mongodb : ", mailMessage.toString());
        repository.save(mailMessage);
    }
}