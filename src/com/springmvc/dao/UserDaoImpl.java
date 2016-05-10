package com.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.springmvc.entity.User;
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;  
	public void setSessionFactory(SessionFactory sessionFactory) {  
		this.sessionFactory = sessionFactory;  
	}  
	public User getUser(int id) {  

		String hql = "from User u where u.id=?";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		query.setInteger(0, id);
		
		return (User)query.uniqueResult();  
	}  

	/**
	 * ��ѯ�����û�
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {  
		String hql = "from User"; 
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		return query.list();  
	}  

	/**
	 * ����û�
	 */
	public void addUser(User user) {  
		sessionFactory.getCurrentSession().save(user);  
	}  

	/**
	 * ����û�idɾ���û�
	 */
	public boolean delUser(String id) {  

		String hql = "delete User u where u.id = ?";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		query.setString(0, id);  

		return (query.executeUpdate() > 0);  
	}  

	/**
	 * �༭�û�
	 */
	public boolean updateUser(User user) {  

		String hql = "update User u set u.userName = ?,u.age=?,u.Telephone=? where u.id = ?";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		query.setString(0, user.getUserName());  
		query.setString(1, user.getAge());  
		query.setString(2, user.getTelephone());
		query.setInteger(3, user.getId()); 
		return (query.executeUpdate() > 0);  
	}
 

}