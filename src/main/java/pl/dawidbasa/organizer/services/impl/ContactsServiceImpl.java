package pl.dawidbasa.organizer.services.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import pl.dawidbasa.organizer.dao.ContactsDAO;
import pl.dawidbasa.organizer.model.Contact;
import pl.dawidbasa.organizer.services.ContactsService;

@Service
@Transactional
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	private ContactsDAO contactDAO;

	public ContactsDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ContactsDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	public List<Contact> findCurrentContacts() {
		return this.contactDAO.getContacts();
	}

	public Contact getContact(long id) {
		return this.contactDAO.getContact(id);
	}

	public void addNewContact(Contact contact) {
		this.contactDAO.addNewContact(contact);
	}

	public void updateContact(Contact contact) {
		this.contactDAO.updateContact(contact);
	}

	public void removeContact(Contact contact) {
		this.contactDAO.deleteContact(contact);

	}
	public void attachContactPic(Contact contact, String rootDirectory)  {
		MultipartFile profilePic = contact.getProfilePic();
		File destFile = new File(rootDirectory + "resources\\images\\" + contact.getId() + ".png");
		try {
			if (profilePic != null && !profilePic.isEmpty()) {
				profilePic.transferTo(destFile);
			}
		} catch (Exception e) {

		}
	}

}
