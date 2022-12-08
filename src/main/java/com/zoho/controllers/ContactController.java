package com.zoho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contact;
import com.zoho.services.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/listcontacts")
	public String getAllContacts(Model model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contact";
	}
	
	@RequestMapping("/contactInfo")
	public String getContactInfo(@RequestParam("id") long id,Model model) {
		Contact contact = contactService.getContactInfo(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}

}
