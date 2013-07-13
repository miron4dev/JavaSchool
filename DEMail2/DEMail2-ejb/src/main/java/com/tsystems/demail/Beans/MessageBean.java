package com.tsystems.demail.Beans;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Date;

@Named
@Stateless
public class MessageBean {

    private String from;
    private String to;
    private String subject;
    private String body;
    private Date date;
    private String id;

    public MessageBean() {}

    public MessageBean(String from, String to, String subject, String body, Date date, String id) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.date = date;
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getId() {
        return id;
    }
}
