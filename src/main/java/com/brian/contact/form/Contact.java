package com.brian.contact.form;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="contacts")
public class Contact {

 @Id
 @Column(name="id")
 @GeneratedValue
 private Integer id;

 @Column(name="nombre")
 private String firstname;

 @Column(name="apellido")
 private String lastname;

 @Column(name="email")
 private String email;

 @Column(name="telefono")
 private String telephone;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

 
 
}