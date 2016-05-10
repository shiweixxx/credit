/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����: 2012-12-12 11:40:40
 */
package com.mongodb.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;

import com.mongodb.entity.Company;

/**
 * @author 
 */
public interface AbstractRepository<T> {


	/**
	 * 添加对象
	 * @author 
	 */
	public void insert(T entity);

	/**
	 * 根据ID查找对象
	 * @author 
	 */
	public T findOne(ObjectId id, Class<?> entity);
	
	public T findOne(String loginName,Class<?> entity);

	public List<T> findByRegex(String regex,Class<T> entity);

	/**
	 * 删除指定的ID对象
	 * @author 
	 */
	public void removeOne(String id, Class<?> entity);

	/**
	 * 通过ID找到并修改
	 * @author 
	 */
	public void findAndModify(String id);

	public List<T> findAll(Class<?> entity);

	/**
	 * 修改实体
	 */
	public void updateEntity(Object entity);
	
	/**
	 * 条件查询
	 * @param <T>
	 * @param criteria
	 * @param entity
	 * @return
	 */
	public <T> T findEntityByCriteria(Criteria criteria,Class<T> entity);

}
