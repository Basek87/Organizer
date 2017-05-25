package pl.dawidbasa.organizer.dao;


import pl.dawidbasa.organizer.model.MyUser;

public interface UsersDAO {

	public MyUser findByUserName(String username);
}
