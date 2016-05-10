package com.mongodb.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.entity.Contact;
import com.mongodb.entity.SpYidong;
import com.mongodb.service.IJD;
import com.mongodb.service.ISpYiDong;
import com.springmvc.entity.User;

import apix.com.rules.Calculation;
import apix.com.rules.FeatureDesc;
import apix.com.utils.ExtApi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Controller
public class AdminController {
	@Autowired
	private  IJD jdService;
	@Autowired
	private  ISpYiDong ydService;
	@RequestMapping("/admin_index")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView models = new ModelAndView("index");
		
		return models;
	}
	@RequestMapping("/admin_charts")
	public ModelAndView charts()
	{
		ModelAndView models = new ModelAndView("charts");
		return models;
	}
	@RequestMapping("/admin_dataVisualization")
	public ModelAndView dataVisualization(){
		ModelAndView models = new ModelAndView("statdata");
		return models;
	}
	@RequestMapping("/admin_maps")
	public ModelAndView maps(){
		ModelAndView models = new ModelAndView("feturesinfo");
		return models;
	}
	@RequestMapping("/admin_users")
	public ModelAndView managesUsers(){
		ModelAndView models =new ModelAndView("models");
		return models;
	}
	@RequestMapping("/admin_preferences")
	public ModelAndView preference(){
		ModelAndView models =new ModelAndView("preferences");
		return models;
	}
	@RequestMapping("/admin_login")
	public ModelAndView login(){
		ModelAndView models=new ModelAndView("login");
		return models;
	}
	@RequestMapping("/admin_personinfo")
	public ModelAndView personinfo(){
		ModelAndView models=new ModelAndView("personinfo");
		List<Contact> listc=new ArrayList<Contact>();
		/*构造contacts*/
		listc.add(new Contact(1+"", "妈", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(2+"", "石头", "15600300721", new Date(2016,2,1), new Date(2016,4,5), 10,0));
		listc.add(new Contact(3+"", "王丽", "13156114610", new Date(2016,2,4), new Date(2016,4,7), 12,1));
		listc.add(new Contact(4+"", "刘哥", "131561146101", new Date(2016,3,4), new Date(2014,4,5), 32,1));
		listc.add(new Contact(5+"", "爸", "15600300801", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(6+"", "表哥", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(7+"", "王三", "15600300892", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(8+"", "李四", "15600300890", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(9+"", "王麻子", "1560033457", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(10+"", "张无", "1560345457", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(11+"", "王柳", "1325400897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(12+"", "万思", "14200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(13+"", "路路", "15700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(14+"", "老婆", "15900300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(15+"", "似懂", "15800300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(16+"", "张思", "15200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		listc.add(new Contact(17+"", "李毅", "15100300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(18+"", "王华", "18200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(19+"", "兆谭", "188600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(20+"", "石头", "18600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(21+"", "上官", "18700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(22+"", "xx", "17606300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(23+"", "dfd", "12600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(24+"", "家", "111111", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		listc.add(new Contact(25+"", "刘伟jdService", "19600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(26+"", "李伟", "10600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(27+"", "王丽诶", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(28+"", "李艾", "15630300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(29+"", "哈哈", "15670340897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(30+"", "催收", "15690380897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(31+"", "信息", "16600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(32+"", "test", "17600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(33+"", "水电费", "19603300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(34+"", "得分", "134600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(35+"", "得分的双方", "15000300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(36+"", "马建", "15900300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(37+"", "麻花", "1505000897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(39+"", "继父", "15700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		User u=new User(2,"sw","39","15600300721","622921199302170937",
				"大学", "", "互联网", "已婚");
	    List<com.mongodb.entity.JD> list=jdService.findJD();
		com.mongodb.entity.JD jd=list.get(0);
		SpYidong spyd=ydService.findJYiDongOne(new ObjectId("56f21d5e4050ff1c0fbbe043"));
		Calculation c=new Calculation(listc,
				u,
				list.get(1),
				spyd,
				new ExtApi()
			);
		HashMap<String,HashMap<String,FeatureDesc>> mp=c.scoreApi();
		return models.addObject("map",mp);
	}
	
	@RequestMapping(value="/admin_api",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String api(){
		ModelAndView models=new ModelAndView("personinfo");
		List<Contact> listc=new ArrayList<Contact>();
		/*构造contacts*/
		listc.add(new Contact(1+"", "妈", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(2+"", "石头", "15600300721", new Date(2016,2,1), new Date(2016,4,5), 10,0));
		listc.add(new Contact(3+"", "王丽", "13156114610", new Date(2016,2,4), new Date(2016,4,7), 12,1));
		listc.add(new Contact(4+"", "刘哥", "131561146101", new Date(2016,3,4), new Date(2014,4,5), 32,1));
		listc.add(new Contact(5+"", "爸", "15600300801", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(6+"", "表哥", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(7+"", "王三", "15600300892", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(8+"", "李四", "15600300890", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(9+"", "王麻子", "1560033457", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(10+"", "张无", "1560345457", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(11+"", "王柳", "1325400897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(12+"", "万思", "14200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(13+"", "路路", "15700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(14+"", "老婆", "15900300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(15+"", "似懂", "15800300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(16+"", "张思", "15200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		listc.add(new Contact(17+"", "李毅", "15100300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(18+"", "王华", "18200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(19+"", "兆谭", "188600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(20+"", "石头", "18600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(21+"", "上官", "18700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(22+"", "xx", "17606300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(23+"", "dfd", "12600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(24+"", "家", "111111", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		listc.add(new Contact(25+"", "刘伟", "19600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(26+"", "李伟", "10600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(27+"", "王丽诶", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(28+"", "李艾", "15630300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(29+"", "哈哈", "15670340897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(30+"", "催收", "15690380897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(31+"", "信息", "16600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(32+"", "test", "17600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(33+"", "水电费", "19603300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(34+"", "得分", "134600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(35+"", "得分的双方", "15000300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(36+"", "马建", "15900300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(37+"", "麻花", "1505000897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(39+"", "继父", "15700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		User u=new User(2,"sw","39","15600300721","622921199302170937",
				"大学", "", "互联网", "已婚");
		List<com.mongodb.entity.JD> list=jdService.findJD();
		com.mongodb.entity.JD jd=list.get(0);
		SpYidong spyd=ydService.findJYiDongOne(new ObjectId("56f21d5e4050ff1c0fbbe043"));
		Calculation c=new Calculation(listc,
				u,
				list.get(1),
				spyd,
				new ExtApi()
			);
		HashMap<String,HashMap<String,FeatureDesc>> mp=c.scoreApi();
		JSONObject jsonObject = JSONObject.fromObject(mp);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
	
}
