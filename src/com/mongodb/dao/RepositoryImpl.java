package com.mongodb.dao;

import java.util.List;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.entity.Company;


@Component("dataManager")
public class RepositoryImpl implements AbstractRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/*
	 * (non-Javadoc)
	 * 添加实体
	 */
	@Override
	public void insert(Object entity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(entity);  
	}
	/*
	 * (non-Javadoc)
	 * 根据id 查找
	 */
	@Override
	public Object findOne(ObjectId id, Class entity) {
		return  mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), entity);
	}
	/*
	 * (non-Javadoc)
	 * 根据正则表达式查询
	 */
	@Override
	public List<Object> findByRegex(String regex,Class entity) {
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);   
	    Criteria criteria = new Criteria("name").regex(pattern.toString());   
	    return mongoTemplate.find(new Query(criteria), entity);  
	}

	@Override
	public void removeOne(String id, Class entity) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("id").in(id);   
        if(criteria != null){   
             Query query = new Query(criteria);   
             if(query != null && mongoTemplate.findOne(query, entity) != null)   
                 mongoTemplate.remove(mongoTemplate.findOne(query, entity));   
        }   
	}

	@Override
	public void findAndModify(String id) {
		// TODO Auto-generated method stub
		//mongoTemplate.find(new Query(Criteria.where("id").is(id)), new Update().inc("age", 3));
	}

	@Override
	public List findAll(Class entity) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(entity);
	}

	@Override
	public void updateEntity(Object entity) {
		// TODO Auto-generated method stub
		mongoTemplate.save(entity);
	}

	@Override
	public Object findEntityByCriteria(Criteria criteria, Class entity) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(criteria);
		return  mongoTemplate.findOne(query, entity);
	}
	/* (non-Javadoc)
	 * 根据用户名登陆系统
	 */
	@Override
	public Object findOne(String loginName, Class entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
