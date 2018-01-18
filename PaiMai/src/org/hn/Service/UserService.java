package org.hn.Service;

import org.hn.Dao.UserDao;
import org.hn.Dao.UserDaoImpl;
import org.hn.entity.User;

public class UserService {
	
	private UserDao userdao = new UserDaoImpl();
	
	public User Login(String username,String password){
		
		return userdao.getUser(username, password);
	}
}
