package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.User;
/***
 * ����UserDao��ӿڼ��䷽����
 * @author Administrator
 *
 */
public interface UserDao {
	public User getUser(int id);  
	public List<User> getAllUser();  
	public void addUser(User user);  
	public boolean delUser(String id);  
	public boolean updateUser(User user);
}