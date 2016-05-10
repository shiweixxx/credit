package com.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.springmvc.entity.User;
import com.springmvc.service.UserManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Spring 2.5 ��Ϊ Spring MVC ������ע�����ܡ������������� Controller �̳��κνӿڣ�
 * ������ XML �����ļ��ж�������� Controller ��ӳ���ϵ������ʹ��ע��Ϳ�����һ�� POJO 
 * ���� Controller �ľ�󲿷ֹ��ܡ�
 * ����һ��������userController,�������ӳ��Ϊ/user;
*/
@Controller  
@RequestMapping("/user")  
public class UserController {  

	@Resource(name="userManager")  
	private UserManager userManager;  

	@RequestMapping("/getAllUser")  
	public String getAllUser(HttpServletRequest request){  
		
		System.out.println("这是users");
		List<User> ul =userManager.getAllUser();
		
		if (ul==null){
			System.out.println("这是空的");
		}
		for(User u:ul){
			System.out.println(u.getId()+"\t"+u.getUserName());
		}
		return null;
//		request.setAttribute("userList", userManager.getAllUser()); 
//		System.out.println("��ʾȫ����¼");
//		return "/Index";  
	}  

	//�༭�û�
	@RequestMapping("/getUser")  
	public String getUser(String id,HttpServletRequest request){  
		request.setAttribute("user", userManager.getUser(Integer.parseInt(id))); 
		System.out.println("������¼�ѱ��༭!");
		return "/editUser";  
	}  

	//��ʾ��ӽ��棻
	@RequestMapping("/toAddUser")  
	public String toAddUser(){  
		return "/addUser";  
	}  

	//ִ������û�ʱ�ķ����� 
	@RequestMapping("/addUser")  
	public String addUser(User user,HttpServletRequest request){  
		System.out.println("�û���======"+user.getUserName());  
		userManager.addUser(user);  
		return "redirect:/user/getAllUser";  
	}  

	//ɾ��������JSON�ĸ�ʽ�ش�״̬��
	@RequestMapping("/delUser")  
	public void delUser(String id,HttpServletResponse response){  
		String result = "{\"result\":\"error\"}";  
		//ɾ��ɹ�
		if(userManager.delUser(id)){  
			result = "{\"result\":\"success\"}";
			
		} 
		//ֱ�ӻ؂������ client ��
		response.setContentType("application/json");  
		try {  
			PrintWriter out = response.getWriter();  
			out.write(result);  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		
	}  

	//���£�
	@RequestMapping("/updateUser")  
	public String updateUser(User user,HttpServletRequest request){  
		if(userManager.updateUser(user)){  
			user = userManager.getUser(user.getId());  
			request.setAttribute("user", user);  
			return "redirect:/user/getAllUser";  
		}else{  
			return "/error";  
		}  
	}  
}
