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
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mongodb.common.Util;
import com.mongodb.entity.Contact;
import com.mongodb.entity.SpYidong;
import com.mongodb.service.IJD;
import com.mongodb.service.ISpYiDong;
import com.springmvc.entity.User;

import apix.com.rules.Calculation;
import apix.com.rules.FeatureDesc;
import apix.com.utils.ExtApi;


@Controller
@RequestMapping("/yd")
public class SpYiDongController  {
	private static Log log = LogFactory.getLog(SpYiDongController.class.getName());
	@Autowired
	private  ISpYiDong ydService;
	
	@RequestMapping("/yds")  
	public ModelAndView  companys(){
		System.out.println("这里是移动");
		SpYidong d=ydService.findJYiDongOne(new ObjectId("56f21d5e4050ff1c0fbbe043"));
		System.out.println(d.getBase_info());
		System.out.println(d.getRecharge());
		System.out.println(d.getYue());
		System.out.println(111);
		return null;

	}

}
