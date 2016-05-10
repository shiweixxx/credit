/* sw
 * 2016-2016年5月5日-上午10:26:40
 * credit
 */
package apix.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sw
 *
 */
public class formatDate {
	public Date df(Date d){
		SimpleDateFormat df=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		try {
			Date td=df.parse(df.format(d));
			return td;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
