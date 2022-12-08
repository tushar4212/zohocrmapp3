package com.zoho.services;


import java.util.List;

import com.zoho.entities.Contact;

public interface ContactService {
	
	public void saveContactInfo(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactInfo(long id);

}
