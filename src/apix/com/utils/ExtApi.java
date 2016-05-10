package apix.com.utils;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.mongodb.util.Hash;

import test.mogodb.connection;
public class ExtApi {
	private static final String IDCITY_FILE="/conf/IdCity.conf";
	private static final String TELPHONE_LOCATION="/conf/TelPhone.conf";
	private static final String PHONE_LOCATION="/conf/Phone.conf";
	
	private HashMap<String, HashMap<String, String>> PhoneMap=null;
	private HashMap<String, String> TelMap=null;
	private HashMap<String,String[]> IdCardMap=null;
	/*
	 * 读取配置conf下的配置文件
	 */
	private BufferedReader getReader(String filename){
		InputStream in = this.getClass().getResourceAsStream(filename); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		return reader;
	}
	private void init_IdCardMap(){
		BufferedReader rd=this.getReader(this.IDCITY_FILE);
		this.IdCardMap=new HashMap<String,String[]>();
		try {
			String line = rd.readLine();
			while (line!=null) {
	        	 String[] lcat=line.replace("\n","").split(" ");
	        	 this.IdCardMap.put(lcat[0],lcat);
	        	 line = rd.readLine(); 
	         }			
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	private void init_TelMap(){
		BufferedReader rd=this.getReader(this.TELPHONE_LOCATION);
		this.TelMap=new HashMap<String,String>();
		try {
			String line = rd.readLine();
			while(line!=null){
				String[] strl=line.replace("\n","").split(" ");
				if(strl.length>1){
					for(int i=0;i<strl.length;i+=2){
						
						this.TelMap.put(strl[i],strl[i+1]);
					}
				}
				line=rd.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void init_PhoneMap(){
		BufferedReader rd=this.getReader(this.PHONE_LOCATION);
		this.PhoneMap=new HashMap<String,HashMap<String, String>>();
		try {
			String line = rd.readLine();
			while(line!=null){
				String[] strl=line.replace("\n","").split(",");
				HashMap<String, String> citymap=new HashMap<String, String>();
				String key=strl[1].replace("\"", "");
				if (strl[2].split(" ").length>1){
					citymap.put("province", strl[2].split(" ")[0]);
					citymap.put("city",strl[2].split(" ")[1]);
				}
				else{
					citymap.put("province", strl[2]);
					citymap.put("city","none");
				}
				citymap.put("supplier",strl[3]);
				
				this.PhoneMap.put(key, citymap);
				line=rd.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public ExtApi(){
		this.init_IdCardMap();
		this.init_TelMap();
		this.init_PhoneMap();
	}
	/*
	 * 根据身份证id,解析出位置，出生年月，性别，家庭地址
	 */
	public HashMap<String, String> getLocationOfIDcard(String idcard)  {
		HashMap<String, String> locationMap=new HashMap<String,String>();
		if(idcard.length()<6){
			locationMap.put("province", "none");
			locationMap.put("city", "none");
			return locationMap;
		}
		String idflag=idcard.substring(0,6);
		String[] locationList=this.IdCardMap.get(idflag);
		locationMap.put("province", "none");
		locationMap.put("city", "none");
		if (locationList==null){
			return locationMap;
		}
		locationMap.put("province",locationList[1]);
		if (locationList.length>2){
			 locationMap.put("city",locationList[2]);
		}else{
			 locationMap.put("city","直辖市");
		}
		return locationMap;
	}
	/*
	 * 判断性别
	 */
	public HashMap<String, String> getSexByIDcard(String idcard){
		HashMap<String, String> sexmap=new HashMap<String,String>();
		if (idcard.length()==15){
			sexmap.put("birthday","19"+idcard.substring(6, 6+6));
			if (Integer.parseInt(idcard.substring(idcard.length()-1))%2==0){
				sexmap.put("sex", "女");
			}
			else{
				sexmap.put("sex","男");
			}
		}
	    else if(idcard.length()==18){
	    	sexmap.put("birthday",idcard.substring(6, 6+8));
			
	    	if (Integer.parseInt(idcard.substring(idcard.length()-2))%2==0){
	    		
				sexmap.put("sex", "女");
			}
			else{
				sexmap.put("sex","男");
			}	    	
	    }
	    else{
	    	sexmap.put("birthday", "unkown");
	    	sexmap.put("sex", "unkown");
	    }
		return sexmap;
	}
	/*
	 * 通讯录归属地查询
	 */
	public HashMap<String, String> getPhoneLocation(String phonenum){
		int phonelen=phonenum.length();
		HashMap<String, String> g=new HashMap<String,String>();
		g.put("province", "none");
		g.put("city", "none");
		g.put("sublier", "none");
		if(phonelen<3){
			return g;
		}
		if(phonelen==11 && phonenum.charAt(0)=='1'){
			String pp=phonenum.substring(0,7);
			if (this.PhoneMap.get(pp)!=null){
				g.put("province",this.PhoneMap.get(pp).get("province"));
				g.put("city",this.PhoneMap.get(pp).get("city"));	
				g.put("supplier",this.PhoneMap.get(pp).get("supplier"));
			}
		}
		else{
			//固话
			String n1=phonenum.substring(0,3);
			String n2=phonenum.substring(0,4);
			String[] ff=null;
			
			if(this.TelMap.get(n1)!=null){
				ff=this.TelMap.get(n1).split("-");
			}
			else if(this.TelMap.get(n2)!=null){
				ff=this.TelMap.get(n2).split("-");
			}
			if (ff !=null){
				g.put("province", ff[0]);
				g.put("city", ff[1]);
			}
		}
		return g;
	}
	/*
	 * 判断手机号是否正常
	 */
	public boolean isNormalPhone(String phonenum){
		int phonelen=phonenum.length();
		if (phonelen==0 || phonelen>12){
			return false;
		}
		else{
			if (phonelen==11 && phonenum.charAt(0)=='1' && phonenum.contains("3") || 
					phonenum.contains("4") || phonenum.contains("5") || 
					phonenum.contains("7") || phonenum.contains("8")){
				return true;
			}
			else{
				//(区号+号码)
				boolean s4=this.TelMap.get(phonenum.substring(0,4))==null?false:true;
				boolean s3=this.TelMap.get(phonenum.substring(0,3))==null?false:true;
				boolean phonenum_prefix_4=(s4 && phonelen==11) || phonelen==12;
				boolean phonenum_prefix_3=(s3 && phonelen==10) || phonelen==11;				
	            if (phonenum_prefix_4 || phonenum_prefix_3)
	                return true;
				return false;
			}
		}
	}
	/*
	 * apix.com.utils
	 * credit
	 * sw
	 * 2016年4月28日-下午6:46:55
	 */
	public static void main(String[] args) {
		HashMap<String, String> lmap = new ExtApi().getLocationOfIDcard("110105710923582");
		System.out.println(lmap.get("province"));
		System.out.println(lmap.get("city"));
		System.out.println(new ExtApi().isNormalPhone("15600300721"));
//		HashMap<String,String> lm=new ExtApi().getPhoneLocation("15600300721");
//		System.out.println(lm.get("province"));
//		System.out.println(lm.get("city"));
//		System.out.println(lm.get("supplier"));
	}
}
