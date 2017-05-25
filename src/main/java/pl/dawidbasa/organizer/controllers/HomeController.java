package pl.dawidbasa.organizer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.dawidbasa.organizer.model.Contact;
import pl.dawidbasa.organizer.services.ContactsService;

@Controller
@RequestMapping(value = "/main")
public class HomeController {

	@Autowired
	private ContactsService contactsService;

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showMainPage(Model model) {
		List<Contact> contactsList = contactsService.findCurrentContacts();
		model.addAttribute("list", contactsList);
		model.addAttribute("contact", new Contact());
		return "mainPage";
	}

	@RequestMapping(value = "/submitNewContact", method = RequestMethod.POST)
	public String submitNew(@Valid @ModelAttribute("contact") Contact contact, BindingResult result,
			HttpServletRequest request, Model model) {

		if (!result.hasErrors()) {
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			contactsService.addNewContact(contact);
			contactsService.attachContactPic(contact, rootDirectory);
		} else {
			List<Contact> contactsList = contactsService.findCurrentContacts();
			model.addAttribute("list", contactsList);
			model.addAttribute("Visible", true);
			return "mainPage";
		}

		return "redirect:/main";

	}
	
}
