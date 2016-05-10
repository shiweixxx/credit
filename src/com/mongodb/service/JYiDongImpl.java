package com.mongodb.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mongodb.entity.JD;
import com.mongodb.entity.SpYidong;
import com.mongodb.dao.AbstractRepository;

@Service("ydService")
public class JYiDongImpl implements ISpYiDong {
   
	@Autowired
	private AbstractRepository dataManager;
	@Override
	public SpYidong findJYiDongOne(ObjectId id) {
		// TODO Auto-generated method stub
		return (SpYidong) dataManager.findOne(id, SpYidong.class);
	}
	@Override
	public List<SpYidong> findYDAll() {
		// TODO Auto-generated method stub
		return dataManager.findAll(SpYidong.class);
	}

 
   
	

}
