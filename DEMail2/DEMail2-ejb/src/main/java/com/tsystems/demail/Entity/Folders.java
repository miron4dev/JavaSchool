package com.tsystems.demail.Entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: eugene
 * Date: 6/23/13
 * Time: 3:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "folders", catalog = "demail")
@Entity
public class Folders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int mail_id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="mail_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Mails mails;

    @OneToMany(mappedBy = "folders", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Messages> messages;

    public Folders() {
    }

    public Folders(int mail_id, String name){
        this.mail_id = mail_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMail_id() {
        return mail_id;
    }

    public void setMail_id(int mail_id) {
        this.mail_id = mail_id;
    }

    public Mails getMails() {
        return mails;
    }

    public void setMails(Mails mails) {
        this.mails = mails;
    }

    public Set<Messages> getMessages() {
        return messages;
    }

    public void setMessages(Set<Messages> messages) {
        this.messages = messages;
    }
}
