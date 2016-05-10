package com.mongodb.controller;

import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mongodb.entity.Company;
import com.mongodb.common.Util;
import com.mongodb.service.ICompany;


@Controller
@RequestMapping("/company")
public class CompanyController  {
	private static Log log = LogFactory.getLog(CompanyController.class.getName());
	@Autowired
	private  ICompany companyService;
	public void insert(){
		//User p=new User("cuiran",27);
		//dataManager.insert(p);
		 log.debug("��ӳɹ�");
	}
	
	@RequestMapping("/companys")  
	public ModelAndView  companys(){
		List<Company> list=companyService.findCompanys();
		DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.ENGLISH);
		for(Company c:list){
			try {
				Date d=df.parse(c.getCreateTime().toString());
				System.out.println(c.getCompanyName()+'\t'+c.getId()+'\t'+d.toLocaleString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/companys");
//		mav.addObject("users", list);
//		return  mav;
	}
	@RequestMapping("/toUpdateCompany")  
	public ModelAndView toUpdateCompany(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/company_update");
		mav.addObject("company", companyService.findCompany(id));
		return  mav;
	}
	
	@RequestMapping("/updateCompany")  
	public String  updateCompany(@ModelAttribute Company company){
		
		try{
			company.setUpdateTime(new Date());
			companyService.updateCompany(company);
		}catch(Exception e){
			log.error(e);
		}
		return companyList();
	}
	@RequestMapping("/toAddCompany")  
	public ModelAndView toAddCompany(){
		return  returnUrl("/company_add");
	}
	
	/***
	 * ���URL�л��û����棻
	 * @param url
	 * @return
	 */
	public ModelAndView returnUrl(String url){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(url);
		return mav;
	}
	
 
	@RequestMapping("/addCompany")  
	public String addCompany(@ModelAttribute Company company){
		company.setCreateTime(new Date());
		company.setUpdateTime(new Date());
		companyService.addCompany(company);
		return companyList();
	}
	@RequestMapping("/delCompany") 
	public String delCompany(@RequestParam("id") String id){
		companyService.delCompany(id);
		return companyList();
	}
	public String companyList(){
		return "redirect:/company/companys";
	}
	
	
	@RequestMapping("/checkCompany") 
	public String checkCompany(HttpServletResponse response,HttpServletRequest request){
		try{
		    String ip=Util.getIpAddr(request);
		    Company company=companyService.searchCompanyByUrl(ip);
		    response.getWriter().print(company==null?"0":"1");
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}

}
