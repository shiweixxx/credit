/* sw
 * 2016-2016年4月29日-下午2:16:16
 * credit
 */
package test.mogodb;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import apix.com.utils.formatDate;

/**
 * @author sw
 *
 */
import javax.script.*;  

import org.python.core.PyFunction;  
import org.python.core.PyInteger;  
import org.python.core.PyObject;  
import org.python.util.PythonInterpreter;  
 
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;  
public class testpython  
{  
	static Logger log=Logger.getLogger(testpython.class);
   public static void main(String args[]) throws IOException, InterruptedException, ParseException  
   {  
/*       PythonInterpreter interpreter = new PythonInterpreter();  
       interpreter.execfile("/home/sw/d/init.py");  
       PyFunction func = (PyFunction)interpreter.get("load_post_hander",PyFunction.class);  
 
       int a = 2010, b = 2 ;  
       PyObject pyobj = func.__call__();  
       System.out.println("anwser = " + pyobj.toString());*/  
/*	   
       try{  
           System.out.println("start");  
           Process pr = Runtime.getRuntime().exec("python /home/sw/d/ss.py");  
           pr.waitFor();  
           System.out.println("end");  
       	} catch (Exception e){  
               e.printStackTrace();  
       	}  
	   */
	   //时间截取
/*	    String regEx=".+((\\d{4})\\-(0\\d{1}|1[0-2])\\-(0\\d{1}|[12]\\d{1}|3[01]) (0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1}))*"; //表示a或f
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher("##***##2016-03-17 11:29:20###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-15 17:51:29###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-11 17:09:52###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-11 15:36:04###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-11 15:34:17###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 18:11:49###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:36:08###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:08:31###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:06:46###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:05:16###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:02:42###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:02:11###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:55:53###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:55:34###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:54:14###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:51:55###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:49:41###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:46:26###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:43:09###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:42:40###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##"); 
		m.find();
		System.out.println(m.group());
		String[] strlist="##***##2016-03-17 11:29:20###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-15 17:51:29###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-11 17:09:52###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-11 15:36:04###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-11 15:34:17###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 18:11:49###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:36:08###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:08:31###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:06:46###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:05:16###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:02:42###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 17:02:11###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:55:53###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:55:34###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:54:14###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:51:55###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:49:41###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:46:26###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:43:09###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##2016-03-10 16:42:40###$$$中国 河北省 廊坊市###$$$120.*.*.88###$$$PC端登录###$$$##***##".split("##\\*\\*\\*##");
		System.out.println(strlist.length);
		SimpleDateFormat df=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		System.out.println();
		Date td=df.parse(df.format(new Date()));.
		System.out.println((td.getTime()-od.getTime())/(24*60*60*1000));
		for(String str:strlist){
			if(str.split("###\\$\\$\\$")[0].equals("")){
				continue;
			}
			df.parse(str.split("###\\$\\$\\$")[0]);
			System.out.println(str.split("###\\$\\$\\$")[0]);
		}*/
	/*	String[] ss="2016-02-23 13:00:52###$$$12125027113###$$$-###$$$￥92.00###$$$订单12125027113完成增加消费额###$$$".split("###\\$\\$\\$");
		for(String s:ss){
			System.out.println(s);
		}*/
	   
	   
	   //db.jingdong.findOne({'jd_login_name': '15313349378'})
   
   }//main  
}  
