package pl.dawidbasa.organizer.dao;

import java.util.List;

import pl.dawidbasa.organizer.model.Contact;

public interface ContactsDAO {
	
	public List<Contact> getContacts();
	public Contact getContact(long id);
	public void addNewContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);

}
