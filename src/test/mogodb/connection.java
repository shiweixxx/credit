package test.mogodb;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class connection {
	static Logger log=Logger.getLogger(connection.class);
    public static void main(String[] args) throws Exception {
        Mongo m = new Mongo("182.92.71.136:27017", 27017);

        DB db = m.getDB("api_plus_plus");
        db.authenticate("test", "test".toCharArray());
      	 Set<String> dd = db.getCollectionNames();
           for( Iterator   it = dd.iterator(); it.hasNext(); )
           {            
        	   String its=it.next().toString();
        	            System.out.println("value="+its);  
        	            log.info(its+"  读取成功");
           }
    }
}
