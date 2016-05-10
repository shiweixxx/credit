/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:40:40
 */
package com.mongodb.service;

import java.util.List;

import com.mongodb.entity.Company;

/**
 * TODO
 * @author xie
 * @version TODO
 */
public interface ICompany {
	public List<Company> findCompanys();
	public Company findCompany(String id);
	public void updateCompany(Company entity);
	public void addCompany(Company entity);
	public void delCompany(String id);
	public Company searchCompanyByUrl(String ip);
}
