package com.brian.contact.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brian.contact.form.Contact;
import com.brian.contact.service.ContactService;

@Controller
public class ContactController {
@Autowired
 private ContactService contactService;

@RequestMapping("/index")
public String listContacts(Map<String, Object> map) {
map.put("contact", new Contact());
map.put("contactList", contactService.listContact());
return "contact";
 }

@RequestMapping(value = "/add", method = RequestMethod.POST)
 public String addContact(@ModelAttribute("contact") 
 Contact contact, BindingResult result) {
contactService.addContact(contact);
return "redirect:/index";
 }

@RequestMapping("/delete/{contactId}")
 public String deleteContact(@PathVariable("contactId") Integer contactId) {
contactService.removeContact(contactId);
return "redirect:/index";
}



@RequestMapping(value = "/edit/{contactId}" , method=RequestMethod.GET)
public String editContact(Model model,@PathVariable("contactId") Integer contactId) {
	model.addAttribute("contact", contactService.getContactById(contactId));
	return "edit";
	
    }
    

@RequestMapping(value = "edit/update/{contactId}" , method=RequestMethod.POST)
public String update(@PathVariable("contactId")  Integer contactId, @ModelAttribute("contact") Contact contact) {
	System.out.println("llega al controlador");
	contactService.updateContact(contact);
    return "redirect:/index";
	
}
}