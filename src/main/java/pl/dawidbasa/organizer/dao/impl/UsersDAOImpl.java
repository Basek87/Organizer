package pl.dawidbasa.organizer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.dawidbasa.organizer.dao.UsersDAO;
import pl.dawidbasa.organizer.model.MyUser;
@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public MyUser findByUserName(String username) {

		List<MyUser> users = new ArrayList<MyUser>();
		users = sessionFactory.getCurrentSession()
			.createQuery("FROM MyUser WHERE username=?",MyUser.class)
			.setParameter(0, username)
			.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}


	
}