package com.mati.arti4208.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mail")
public class MailDocument {
	@Id
	private String id;
	private String createTime;
	private String to;
	private String subject;
	private String from;
	private String body;
	
	public MailDocument() {}
	
	public MailDocument(String createTime, String to,String subject, String from, String body) {
		super();
		this.createTime = createTime;
		this.to = to;
		this.subject = subject;
		this.from = from;
		this.body = body;
	}

	public String getCreateTime() {		
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MailDocument [createTime=" + createTime + ", to=" + to + ", subject=" + subject + ", from=" + from
				+ ", body=" + body + "]";
	}
	
	
	
}
