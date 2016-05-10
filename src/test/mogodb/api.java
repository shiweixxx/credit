/* sw
 * 2016-2016年5月3日-下午2:27:53
 * credit
 */
package test.mogodb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;  
  
  
public class api {  
  
    public static void main(String[] args) {  
    	  try{
		    	   URL url=new URL("http://192.168.1.19:8080/credit/admin_api/");
		    	   BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
		    	   String s="";
		    	   StringBuffer sb=new StringBuffer("");
		    	   while((s=br.readLine())!=null)
		    	   {     
		    	    sb.append(s);    
		    	   }
		    	   br.close();
		    	   System.out.println(sb.toString());
		    	   System.out.println("end");
		    	   
		    	   /*mongodb*/
//		           Mongo m = new Mongo("182.92.71.136:27017", 27017);
//		           DB db = m.getDB("api_plus_plus");
//		           db.authenticate("test", "test".toCharArray());
//		           DBCollection dbCol = db.getCollection("rule_data");
//		           List<DBObject> dbList = new ArrayList<DBObject>();
//		           BasicDBObject doc1 = new BasicDBObject();
//		    	   doc1.put("raw", sb.toString());
//		    	   dbList.add(doc1);
//		    	   dbCol.insert(dbList);
		    	   System.out.println("success");
    	  }catch(Exception e){
    	   
    	  }  
    }  
}
