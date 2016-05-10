package com.mongodb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


import com.mongodb.common.Util;
import com.mongodb.entity.Contact;
import com.mongodb.service.IJD;
import com.springmvc.entity.User;

import apix.com.rules.Calculation;
import apix.com.rules.FeatureDesc;
import apix.com.utils.ExtApi;


@Controller
@RequestMapping("/jd")
public class JD  {
	private static Log log = LogFactory.getLog(JD.class.getName());
	@Autowired
	private  IJD jdService;
	public void insert(){
		 log.debug("��ӳɹ�");
	}
	
	@RequestMapping("/jds")  
	public ModelAndView  companys(){
		System.out.println("这里是京东");
		List<com.mongodb.entity.JD> list=jdService.findJD();
 		for(com.mongodb.entity.JD c:list){
			 System.out.println(c.getJd_login_name()+"\n------------"+c.getAddress());
			}
		
 		return null;
	}

}
