package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityUser {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   int id;
   
   @Column
   String username;
   
   @Column
   String userage;

   public EntityUser()
   {}
		   
public EntityUser(int id, String username, String userage) {
	super();
	this.id = id;
	this.username = username;
	this.userage = userage;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getUserage() {
	return userage;
}

public void setUserage(String userage) {
	this.userage = userage;
}

  
}