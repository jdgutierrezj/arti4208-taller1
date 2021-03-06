package com.mati.arti4208.mq;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class AuditDocument implements Serializable {
    public String id;
    public String createTime;
    public String username;
    public String serviceId;

    public AuditDocument() {}

    public AuditDocument(String createTime, String username, String serviceId) {
        this.createTime = createTime;
        this.username = username;
        this.serviceId = serviceId;
    }

	@Override
	public String toString() {
		return "AuditDocument [id=" + id + ", createTime=" + createTime + ", username=" + username + ", serviceId="
				+ serviceId + "]";
	}
   
}
