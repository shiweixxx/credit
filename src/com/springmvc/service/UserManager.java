package com.springmvc.service;

import java.util.List;
import com.springmvc.entity.User;

public interface UserManager {  
	
	public User getUser(int id);  
	public List<User> getAllUser();  
	public void addUser(User user);  
	public boolean delUser(String id);  
	public boolean updateUser(User user);  
}
