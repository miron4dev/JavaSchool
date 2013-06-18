package com.tsystems.demail.entity;

import java.io.Serializable; 
import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mails")
public class Mails implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Date registration_date;
    
    @Column(nullable = false)
    private int user_id;
    
    @ManyToOne
    @JoinColumn(name="user_id" , referencedColumnName="id", insertable=false, updatable=false)
    private Accounts accounts;
    
    @OneToMany(mappedBy = "mails", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Folders> folders;
    
    public Mails() {
    }
    
    
    public Mails(String name, Date registration_date, int user_id)
    {
        this.name = name;
        this.registration_date = registration_date;
        this.user_id = user_id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mails)) {
            return false;
        }
        Mails other = (Mails) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tsystems.demail.entity.mails[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Accounts getProfile() {
        return accounts;
    }

    public void setProfile(Accounts accounts) {
        this.accounts = accounts;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Set<Folders> getFolders() {
        return folders;
    }

    public void setFolders(Set<Folders> folders) {
        this.folders = folders;
    }

}
