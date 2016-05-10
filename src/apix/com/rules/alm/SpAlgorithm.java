/* sw
 * 2016-2016年4月29日-下午4:36:59
 * credit
 */
package apix.com.rules.alm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.python.antlr.ast.For;

import com.mongodb.entity.SpYidong;

import apix.com.rules.FeatureDesc;
import apix.com.utils.ExtApi;
import apix.com.utils.formatDate;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import test.mogodb.testpython;

/**
 * @author sw
 * 运营商ContactAlgorithm
 */
public class SpAlgorithm {
	static Logger log=Logger.getLogger(SpAlgorithm.class);
	private SpYidong sd;
	private ExtApi extApi;
	private HashMap<String,HashMap<String,Integer>> hp =new HashMap<String,HashMap<String,Integer>>();
	public SpAlgorithm(SpYidong sd,ExtApi extApi){
		this.sd = sd;
		this.extApi = extApi;
		this.init_hp();
	}
	public void init_hp(){
		Pattern p=Pattern.compile("(\\[.*\\])");
		Matcher m=p.matcher(this.sd.getRecharge());
		JSONArray recharge=null;
		SimpleDateFormat Formater=new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		if (m.find()){
			recharge=JSONArray.fromObject(m.group(0)); 
			if(recharge.size()>0){
				  int count=recharge.size(),totalmonth=0,amount=0;
				  int j=0,days=0;
				  for(int i=0;i<recharge.size();i++){
				    JSONObject job = recharge.getJSONObject(i);
					Integer money=job.getInt("payFee");
				    try {
				    	Date payDate=df.parse(job.getString("payDate"));
				    	Date payDateNxt=df.parse(recharge.getJSONObject(j).getString("payDate"));
				    	j=i;
				    	long diff=Math.abs((payDate.getTime()-payDateNxt.getTime())/(24*60*60*1000));
				    	days+=diff;
						String td=Formater.format(payDate);
						HashMap<String,Integer> tmp =null;
						if(this.hp.get(td) ==null){
							tmp = new HashMap<String,Integer>();
							tmp.put("money",0);
							tmp.put("times", 0);
							this.hp.put(td,tmp);
							totalmonth+=1;
						}
						Integer mny=this.hp.get(td).get("money")+money;
						int times=this.hp.get(td).get("times")+1;
						tmp=new HashMap<String,Integer>();
						tmp.put("money", mny);
						tmp.put("times", times);
						/*总金额*/
						amount+= money;
						this.hp.put(td,tmp);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
				  HashMap<String,Integer> avgmp=new HashMap<String,Integer>();
				  /*四舍五入*/
				  int t=count*1.0/totalmonth>count/totalmonth+0.5?count/totalmonth+1:count/totalmonth;
				  avgmp.put("avgtimes",t);
				  avgmp.put("avgmoney", amount/totalmonth);
				  avgmp.put("dayspertimes", days/count);
				  this.hp.put("avg",avgmp);
			}
		}
	}
	/*从当前月份向前推３个月*/
	public String[] getbeforeThreeMonth(){
	   Calendar cal = Calendar.getInstance();
	   int tday = cal.get(Calendar.DATE);
	   int tmonth = cal.get(Calendar.MONTH) + 1;
	   int tyear = cal.get(Calendar.YEAR);
	   if(tmonth==1){
		   tyear=tyear-1;
		   tmonth=12;
	   }
	   String month1=tmonth>10?tmonth+"":"0"+tmonth;
	   String month2=tmonth-1>10?tmonth-1+"":"0"+(tmonth-1);
	   String month3=tmonth-2>10?tmonth-2+"":"0"+(tmonth-2);
//	   return new String[]{tyear+"-"+month1,tyear+"-"+month2,tyear+"-"+month3};
	   return new String[]{"2016-05","2016-04","2016-03"};
	}
	/*历史信用记录*/
	public FeatureDesc creditHistoryScoreofTimes(){
		StringBuffer sb=new StringBuffer("");
		String[] keylist=this.getbeforeThreeMonth();
		int avgtimes=this.hp.get("avg").get("avgtimes");
		Integer m1 = this.hp.get(keylist[0]) ==null?avgtimes:this.hp.get(keylist[0]).get("times");
		Integer m2 = this.hp.get(keylist[1]) ==null?avgtimes:this.hp.get(keylist[1]).get("times");
		Integer m3 = this.hp.get(keylist[2]) ==null?avgtimes:this.hp.get(keylist[2]).get("times");
		sb.append("月份:"+keylist[0]+"\t次数:"+m1+"\n");
		sb.append("月份:"+keylist[1]+"\t次数:"+m2+"\n");
		sb.append("月份:"+keylist[2]+"\t次数:"+m3+"\n");
		int avg=(m1+m2+m3)/3;
		int score=0;
		if (avg<1){
			score=0;
		}
		else if(avg>=1 && avg<=3){
			score=70;
		}
		else if(avg>3){
			score=100;
		}
		return new FeatureDesc("近三个月的平均充值次数",sb.toString(), ""+score, "人工特征提取", "----");
	}
	public FeatureDesc creditHistoryScoreofduration(){
		int day = this.hp.get("avg").get("dayspertimes");
		int score=0;
		if(day<30){
			/*时间间隔小于30的用户不多*/
			score=80;
		}
		else if(day>=30 && day<=40){
			score=100;
		}
		else if(day>40 && day<=50){
			score=60;
		}
		else if (day>50){
			score = 20;
		}
		return new FeatureDesc("每次话费充值平均时间间隔",day+"天", score+"分", "人工提取", "----");
	}
	/*通信需求*/
	public FeatureDesc needsCallScoreofmomey(){
		StringBuffer sb=new StringBuffer("");
		String[] keylist=this.getbeforeThreeMonth();
		int avgmoney=this.hp.get("avg").get("avgmoney");
		Integer m1 = this.hp.get(keylist[0]) ==null?avgmoney:this.hp.get(keylist[0]).get("money");
		Integer m2 = this.hp.get(keylist[1]) ==null?avgmoney:this.hp.get(keylist[1]).get("money");
		Integer m3 = this.hp.get(keylist[2]) ==null?avgmoney:this.hp.get(keylist[2]).get("money");
		sb.append("月份:"+keylist[0]+"\t金额:"+m1+"\n");
		sb.append("月份:"+keylist[1]+"\t金额:"+m2+"\n");
		sb.append("月份:"+keylist[2]+"\t金额:"+m3+"\n");
		double avg=(m1+m2+m3)/3.0;
		int score=0;
		if(avg<30){
			score=20;
		}
		else if(avg>=30 && avg<=50){
			score=50;
		}
		else if(avg>50 && avg<=100){
			score=70;
		}
		else if(avg>100 && avg<=200){
			score=80;
		}
		else if(avg>200){
			score=100;
		}
		return new FeatureDesc("近三个月平均话费消费", sb.toString(),""+score, "人工提取", "----");		
	}
}
