package org.hn.Dao;

import org.hn.entity.User;

public interface UserDao {
	
	User getUser(String username,String password);
}
