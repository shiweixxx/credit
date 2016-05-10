package com.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mongodb.entity.Company;
import com.mongodb.dao.AbstractRepository;

@Service("companyService")
public class CompanyImpl implements ICompany {

	@Override
	public List<Company> findCompanys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findCompany(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCompany(Company entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCompany(Company entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCompany(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company searchCompanyByUrl(String ip) {
		// TODO Auto-generated method stub
		return null;
	}
   
	/*@Autowired
	private AbstractRepository dataManager;
    
	@Override
	public List<Company> findCompanys() {
		return (List<Company>) dataManager.findAll(Company.class);
	}

	@Override
	public Company findCompany(String id) {
		return dataManager.findOne(id,Company.class);
	}
	@Override
	public void updateCompany(Company entity) {
		 dataManager.updateEntity(entity);
	}

	@Override
	public void addCompany(Company entity) {
		dataManager.insert(entity);
	}

	@Override
	public void delCompany(String id) {
		dataManager.removeOne(id, Company.class);
	}
	@Override
	public Company searchCompanyByUrl(String ip){
		Company company=dataManager.findEntityByCriteria(Criteria.where("ip").ne(ip), Company.class);
		return company;
	}
   */
	

}
