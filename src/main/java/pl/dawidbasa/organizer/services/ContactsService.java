package pl.dawidbasa.organizer.services;

import java.util.List;

import pl.dawidbasa.organizer.model.Contact;

public interface ContactsService {
	public List<Contact> findCurrentContacts();
	public Contact getContact(long id);
	public void addNewContact(Contact contact);
	public void updateContact(Contact contact);
	public void removeContact(Contact contact);
	public void attachContactPic(Contact contact, String rootDirectory);
}
