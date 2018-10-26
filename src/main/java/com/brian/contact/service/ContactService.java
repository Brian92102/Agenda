package com.brian.contact.service;

import java.util.List;

import com.brian.contact.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	 public List<Contact> listContact();
	 public void removeContact(Integer id);
	 public void updateContact(Contact contact);
	 public Contact getContactById(Integer id);

}
