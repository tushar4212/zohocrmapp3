package com.zoho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Contact;
import com.zoho.repositories.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	@Override
	public void saveContactInfo(Contact contact) {
		contactRepo.save(contact);

	}


	@Override
	public List<Contact> getAllContacts() {
        List<Contact> leads = contactRepo.findAll();
		return leads;
	}


	@Override
	public Contact getContactInfo(long id) {
        Optional<Contact> findById = contactRepo.findById(id);
        Contact contact = findById.get();
		return contact;
	}

}
