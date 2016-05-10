package com.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mongodb.entity.Company;
import com.mongodb.entity.JD;
import com.mongodb.dao.AbstractRepository;

@Service("jdService")
public class JDImpl implements IJD {
   
	@Autowired
	private AbstractRepository dataManager;
 
	@Override
	public List<JD> findJD() {
		// TODO Auto-generated method stub
		return (List<JD>) dataManager.findAll(JD.class);
	}
   
	

}
