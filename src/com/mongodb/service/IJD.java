/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:40:40
 */
package com.mongodb.service;

import java.util.List;

import com.mongodb.entity.Company;
import com.mongodb.entity.JD;

/**
 * TODO
 * @author xie
 * @version TODO
 */
public interface IJD {
	public List<JD> findJD();
}
