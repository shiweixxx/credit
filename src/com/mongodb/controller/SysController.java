package com.mongodb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * 系统控制器；
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/sys")
public class SysController  {
	private static Log log = LogFactory.getLog(SysController.class.getName());

	@RequestMapping("/login")  
	public String login(@RequestParam("userName") String userName,@RequestParam("userPwd") String userPwd){
		try{
			if(userName.equals("admin")&&userPwd.equals("123")){
				//转到companys界面显示内容；
				return "redirect:/company/companys"; 
			}
		}catch(Exception e){
			log.error(e);
		}
		//输入的不对，一直要求输入；这个路径如何设置一下没有解决？
		return "redirect:/error.jsp";
	}

}
