package com.zoho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contact;
import com.zoho.entities.Lead;
import com.zoho.services.ContactService;
import com.zoho.services.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String  viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("lead") Lead lead, Model model) {
		
		leadService.saveLeadInfo(lead);
		model.addAttribute("lead", lead);
		model.addAttribute("msg", "Lead is saved");
		return "lead_info";
	}
	
	@RequestMapping("/listleads")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/leadInfo")
	public String getOneLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getLeadInfo(id);
		Contact cont=new Contact();
		cont.setFirstName(lead.getFirstName());
		cont.setLastName(lead.getLastName());
		cont.setEmail(lead.getEmail());
		cont.setMobile(lead.getMobile());
		cont.setSource(lead.getSource());
		
		contactService.saveContactInfo(cont);
		
		leadService.deleteOneLead(id);
		
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contact";
		
	}

}
