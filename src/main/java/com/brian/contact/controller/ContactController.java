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
 //System.out.println(this.contactService.listContact());
return "contact";
 }

@RequestMapping(value = "/add", method = RequestMethod.POST)
 public String addContact(@ModelAttribute("contact") //commandName="contact" puede usarse modelAtribute en el jsp y aca utilizar simplemente el nombre de la variable
 Contact contact, BindingResult result) {
contactService.addContact(contact);
return "redirect:/index";
 }

@RequestMapping("/delete/{contactId}")
 public String deleteContact(@PathVariable("contactId") Integer contactId) {
contactService.removeContact(contactId);
return "redirect:/index";
}

/*@RequestMapping(value = "/edit/{contactId}" , method=RequestMethod.GET)
public ModelAndView editContact(@PathVariable("contactId") Integer contactId) {
	System.out.println("llega al controlador");
    ModelAndView modelAndView = new ModelAndView("edit");  //se tiene que llamar como la vista?
    Contact contact = contactService.getContactById(contactId);
    modelAndView.addObject("contact",contact);  // contact se tiene que llamar asi porque en el jsp se asocia con el codename="contact"(hay que chekearlo si realmente es asi)
    return modelAndView;
}*/

/*@RequestMapping(value = "/update/{contactId}", method=RequestMethod.POST)
public ModelAndView editContact(@ModelAttribute("contact") Contact contact, @PathVariable("contactId") Integer contactId) {
	System.out.println(contact.getFirstname());
     
    ModelAndView modelAndView = new ModelAndView("edit");
     
    contactService.updateContact(contact);
     
    String message = "Contact was successfully edited.";
    modelAndView.addObject("message", message);
     
    return modelAndView;
}*/
 


/*@RequestMapping(value = "/edit/{contactId}" , method=RequestMethod.GET)
public String editContact(@PathVariable("contactId") Integer contactId,Map<String, Object> map) {
	Contact contact = contactService.getContactById(contactId);
	map.put("contact",contact );
	return "edit";
}*/

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