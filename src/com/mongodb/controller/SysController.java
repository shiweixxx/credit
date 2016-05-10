package com.mongodb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * ϵͳ��������
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
				//ת��companys������ʾ���ݣ�
				return "redirect:/company/companys"; 
			}
		}catch(Exception e){
			log.error(e);
		}
		//����Ĳ��ԣ�һֱҪ�����룻���·���������һ��û�н����
		return "redirect:/error.jsp";
	}

}
