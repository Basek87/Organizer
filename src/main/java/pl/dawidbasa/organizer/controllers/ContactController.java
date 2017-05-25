package pl.dawidbasa.organizer.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbasa.organizer.model.Contact;
import pl.dawidbasa.organizer.services.ContactsService;

@Controller
@RequestMapping(value="/main/contact")
public class ContactController {

	@Autowired
	private ContactsService contactService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editContact(@RequestParam("id") int id, Model model) {

		Contact contact = contactService.getContact(id);
		model.addAttribute("contact", contact);
		model.addAttribute("originalContact", contact);
		return "contactPage";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {

		Contact contact = contactService.getContact(id);
		contactService.removeContact(contact);
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {

		if (!result.hasErrors()) {
			contactService.updateContact(contact);
			return "redirect:/main/contact?id=" + contact.getId();
		} else {
			model.addAttribute("contact", contact);
			long id = contact.getId();
			Contact originalContact = contactService.getContact(id);
			model.addAttribute("originalContact", originalContact);
			return "contactPage";
		}
	}
	
	@RequestMapping(value="/uploadPic", method = RequestMethod.POST)
	public String uploadPic(@ModelAttribute("contact") Contact contact, HttpServletRequest request, Model model){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		contactService.attachContactPic(contact, rootDirectory);
		return "redirect:/main/contact?id=" + contact.getId();
	}
}
	
