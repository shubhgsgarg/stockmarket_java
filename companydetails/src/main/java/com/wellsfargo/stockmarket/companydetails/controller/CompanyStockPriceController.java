package com.wellsfargo.stockmarket.loginsignup.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
   
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long userId ;
    
    @Column(name="isadmin")
    private String isAdmin;
    
    @Id
    @Column(name="username")
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @Column(name="verified")
    private String verified;
    
    public User() {
    	
    }
    public User(String userName,String password, String email,String isAdmin) {
    	super();
    	
    	this.userName = userName;
    	this.password = password;
    	this.email = email;
    	this.isAdmin = isAdmin;
    	
    
    	
    }    
    
    public long getUserId() {
    	return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return isAdmin;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }
}