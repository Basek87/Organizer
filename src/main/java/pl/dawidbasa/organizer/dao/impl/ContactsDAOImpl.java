package pl.dawidbasa.organizer.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.dawidbasa.organizer.dao.ContactsDAO;
import pl.dawidbasa.organizer.model.Contact;

@Repository
public class ContactsDAOImpl implements ContactsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Contact> getContacts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Contact> contactsList = session.createQuery("FROM Contact",Contact.class).getResultList();
		return contactsList;
	}

	public Contact getContact(long id){
		Session session = this.sessionFactory.getCurrentSession();
		Contact contactById = (Contact) session.createQuery("SELECT c FROM Contact c WHERE c.id=:id").setParameter("id", id).getSingleResult();
		return contactById;
	}
	
	public void addNewContact(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(contact);
	}

	public void updateContact(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(contact);
	}

	public void deleteContact(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(contact);
	}

}
