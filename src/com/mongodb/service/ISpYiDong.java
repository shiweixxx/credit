/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:40:40
 */
package com.mongodb.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.entity.SpYidong;

/**
 * TODO
 * @author xie
 * @version TODO
 */
public interface ISpYiDong {
	public SpYidong findJYiDongOne(ObjectId id);
	public List<SpYidong> findYDAll();
}
