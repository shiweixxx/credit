/* sw
 * 2016-2016年4月29日-下午4:36:59
 * credit
 */
package apix.com.rules.alm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.entity.JD;
import com.mongodb.util.Hash;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import apix.com.rules.FeatureDesc;

/**
 * @author sw
 * 淘宝算法ContactAlgorithm
 */
public class JDAlgoritm {
	private JD jd;
	public JDAlgoritm(JD jd){
		this.jd = jd !=null?jd:new JD("","unknow", "unknow", "", "unknow",
				"unknow", "unknow", "unknow", "unknow");
	}
	/*最近一次登陆时间*/
	public FeatureDesc getLoginTimeScore(){
		String[] loginhis=this.jd.getLoginhistory().split("##\\*\\*\\*##");
		long day=100;
		Date td=null;
		SimpleDateFormat df=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String longintime="None";
		StringBuffer sb=new StringBuffer("");
		try {
			td=df.parse(df.format(new Date()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<loginhis.length;i++){
			String str=loginhis[i];
			if("".equals(str.split("###\\$\\$\\$")[0])){
				continue;
			}
			try {
				Date od=df.parse(str.split("###\\$\\$\\$")[0]);
				long diff=(td.getTime()-od.getTime())/(24*60*60*1000);
				day=Math.min(day, diff);
				if (diff==day){
					longintime=str.split("###\\$\\$\\$")[0];
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int score=0;
		if(day<30){
			score=100;
		}
		else if(day>=30 && day<60){
			score=70;
		}
		else if(day>=60 && day<=90){
			score=50;
		}
		else if(day>=90){
			score=20;
		}
		return new FeatureDesc("最近登陆时间是","最近一次登陆时间：\n\t"+longintime+
				"\n\t"+"时间间隔:"+day+"天", ""+score, "机器提取", "----");
	}
	/*实名认证*/
	public FeatureDesc validateNameScore(){
		String rs=this.jd.getValidRelName();
		int score=0;
		String str="京东抓取数据未知";
		if (rs.startsWith("验证通过")){
			score=100;
			str="验证通过";
		}
		else if(rs.startsWith("验证失败")){
			score=80;
			str="验证失败";
		}
		else if(rs.startsWith("未验证")){
			score=20;
			str="未验证";
		}
		return new FeatureDesc("是否实名认证",str,""+score,"人工提取", "----");
	}
	/*手机验证*/
	public FeatureDesc validatePhone(){
		String rs = this.jd.getValidPhone();
		int score=0;
		String str="京东抓取数据未知";
		if (rs.startsWith("验证通过")){
			score=100;
			str="验证通过";
		}
		else if(rs.startsWith("验证失败")){
			score=80;
			str="验证失败";
		}
		else if(rs.startsWith("未验证")){
			score=20;
			str="未验证";
		}
		return new FeatureDesc("手机验证", str, ""+score, "人工提取", "----");
	}
	/*三个月消费金额*/
	public FeatureDesc getconsumeMonthScore(){
		/*String[] customer=this.jd.getMonth_consume3().split("##\\*\\*\\*##");
		int count=0;
		StringBuffer sb = new StringBuffer("");
		for(String str:customer){
			String[] ss=str.split("###\\$\\$\\$");
			if("".equals(ss[0])){
				continue;
			}
			count+=Integer.parseInt(ss[3].replace("￥", ""));
			sb.append("订单号:"+ss[1]+":\n\t" +"消费时间:"+ss[0]+"\n\t"+"消费金额:"+ss[3]+"\n");
		}
		double avg_customer=count/3.0;
		int score=0;
		if (avg_customer<100){
			score=10;
		}
		else if(avg_customer>=100 && avg_customer<300){
			score=30;
		}
		else if(avg_customer>=300 && avg_customer<500){
			score=80;
		}
		else if(avg_customer>=500){
			score=100;
		}
		return new FeatureDesc("三个月平均消费金额", sb.toString(), ""+score, "看特征提取", "----");*/
		return new FeatureDesc("三个月平均消费金额","待定", ""+12, "人工", "----");
	}
	/*收货地址变动次数*/
	public FeatureDesc getChangeAdressChangeTimes(){
		String address=this.jd.getAddress().replaceAll("\\s+","").replaceAll("\t|\n|\r","");
		String[] addresslist=address.split("##\\*\\*\\*##");
		HashMap<String,Integer> cp=new HashMap<String,Integer>();
		for(int i=0;i<addresslist.length;i++)
		{
			if("".equals(addresslist[i]))
				continue;
			System.out.println(addresslist[i]);
			
			String[] strl=addresslist[i].split("\\$\\$\\$");
			if (strl.length<3){
				continue;
			}
			String str=strl[3].replace("###", "").split("区")[0];
			if(cp.get(str) == null){
				cp.put(str, 0);
			}
			System.out.println(cp.get(str));
			cp.put(str, cp.get(str)+1);
		}
		StringBuffer sb=new StringBuffer("");
		if(cp !=null){
			for (Map.Entry<String, Integer> entry : cp.entrySet()) {
				sb.append(entry.getKey()+":"+entry.getValue()+"\n");
			}
		}
		return new FeatureDesc("收货地址变动次数", sb.toString(), "34分", "看特征提取", "----");
	}
	/*会员级别*/
	public FeatureDesc getMembergrade(){
		String md=this.jd.getHuiyuanjibie();
		int score=0;
		if("钻石会员".equals(md)){
			score=100;
		}
		else if("金牌会员".equals(md)){
			score=70;
		}
		else if("银牌会员".equals(md)){
			score=40;
		}
		else{
			score=10;
		}
		return new FeatureDesc("京东会员等级",md, ""+score, "看特征提取", "----");
	}
}
