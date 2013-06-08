package com.tsystems.demail;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Accounts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String user;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String FirstName;
    
    @Column(nullable = false)
    private String LastName;
    
    @Column(nullable = false, unique = true)
    private String MobilePhone;
    
    @Column(nullable = false)
    private Date BirthDay;

    public Accounts() 
    {
        
    }
    
    public Accounts(String user, String password, String FirstName, String LastName, String MobilePhone, Date BirthDay)
    {
        this.user = user;
        this.password = password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.MobilePhone = MobilePhone;
        this.BirthDay = BirthDay;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String MobilePhone) {
        this.MobilePhone = MobilePhone;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hibernatetest.Accounts[ id=" + id + " ]";
    }

}
