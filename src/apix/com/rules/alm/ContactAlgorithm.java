/* sw
 * 2016-2016年4月29日-下午4:36:59
 * credit
 */
package apix.com.rules.alm;


import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.mongodb.entity.Contact;
import apix.com.rules.FeatureDesc;
import apix.com.utils.ExtApi;
import apix.com.utils.RelationShip;

/**
 * @author sw
 * 通讯录算法ContactAlgorithm
 */
class contactInfo{
	private List<Contact> cts;
	/*亲属列表*/
	private HashMap<String, HashMap<String,String>> rmp;
	
	/*关系*/
	private RelationShip rsp=null;
	/*api*/
	
	private ExtApi extApi;
	public contactInfo(List<Contact> contacts,ExtApi extApi){
		this.rsp=new RelationShip();
		this.extApi=extApi==null? new ExtApi():extApi;
		this.cts=contacts;
		this.rmp=new HashMap<String, HashMap<String,String>>();	
		this.initmp();
	}
	public HashMap<String, HashMap<String, String>> getRmp() {
		return rmp;
	}
	public void setRmp(HashMap<String, HashMap<String, String>> rmp) {
		this.rmp = rmp;
	}
	/*通讯录长度*/
	public int getContactlength(){
		return (this.cts!=null ?this.cts.size():0);
	}
	/*init map*/
	public void initmp(){
		int size=this.cts != null? this.cts.size():0;
		for(int i=0;i<size;i++){
			String phone=this.cts.get(i).getPhone();
			String uname=this.cts.get(i).getUsername();
			String key=null;
			/*父亲*/
			if (this.rsp.isFather(uname)){
				key="father";
			}
			/*母亲*/
			else if(this.rsp.isMather(uname)){
				key="mather";
			}
			/*家*/
			else if(this.rsp.isHome(uname)){
				key="home";
			}
			/*亲属*/
			else if(this.rsp.isRelative(uname)){
				key="relative";
			}
			/*配偶*/
			else if(this.rsp.isLover(uname)){
				key="lover";
			}
			if(key !=null){
				HashMap<String, String> pl = this.extApi.getPhoneLocation(phone);
				String str=phone+":"+uname+";\n\t手机归属地:"+pl.get("province")+
						"-"+pl.get("city")+"-"+pl.get("supplier");
				if (this.rmp.get(key) == null){
						HashMap<String,String> hp=new HashMap<String,String>();
						hp.put(phone, str);
						this.rmp.put(key, hp);
				}else{
						this.rmp.get(key).put(phone, str);
				}
			}
		}
	}
	/*
	 * apix.com.rules.alm
	 * credit
	 * sw
	 * 2016年5月2日-下午9:32:15
	 * 得到每个号的通话次数，通话时间
	 */
	public HashMap<String,HashMap<String,Object>> getCallInfoMapByPhone(){
		int size=this.cts !=null ?this.cts.size():0;
		Integer times=0;
		Integer duration=0;
		HashMap<String,HashMap<String,Object>> rsmap=new HashMap<String,HashMap<String,Object>>();
		for(int i=0;i<size;i++){
			String phone=this.cts.get(i).getPhone();
			HashMap<String,Object> mp=rsmap.get(phone);
			int diff=6;
			if (mp==null){
				mp=new HashMap<String,Object>();
				mp.put("times", new Integer(1));
				mp.put("duration", this.cts.get(i).getDuration());
//				mp.put("inter", (new HashMap<Integer,String>()).put(, value));
			}
			else{
				times = (Integer)mp.get("times")+1;
				duration=(Integer)mp.get("duration")+this.cts.get(i).getDuration();
				mp.put("times", times);
				mp.put("duration", duration);
			}
			rsmap.put(phone, mp);
		}
		return rsmap;
	}
	
	
}
public class ContactAlgorithm {
	private List<Contact> contacts=null;
	private contactInfo cinfo=null;
	public HashMap<String,HashMap<String,String>> callinfo = 
			new HashMap<String,HashMap<String,String>>();
	public ContactAlgorithm(List<Contact> c,ExtApi extApi){
		this.contacts=c;
		this.cinfo = new contactInfo(this.contacts,extApi);
		this.init_callinfo();
	}
	/*初始化*/
	public void init_callinfo(){
		HashMap<String, String> fmap = this.cinfo.getRmp().get("father");
		HashMap<String, String> mmap = this.cinfo.getRmp().get("mather");
		HashMap<String, String> hmap = this.cinfo.getRmp().get("home");
		HashMap<String, String> remap = this.cinfo.getRmp().get("relative");
		HashMap<String, HashMap<String, Object>> phonemp = this.cinfo.getCallInfoMapByPhone();
		Integer ft=0,mt=0,ht=0,fd=0,md=0,hd=0,rt=0,rd=0;
		/*每个号码的通话次数，累计时间,最近一次通话时间*/
		StringBuffer sb=new StringBuffer("");
		StringBuffer sbt=new StringBuffer("");
		if(fmap!=null){
			sb.append("Father:\n");
			sbt.append("Father:\n");
			for (Entry<String, String> entry : fmap.entrySet()) {
				String key=entry.getKey();
				Integer times = (Integer)phonemp.get(key).get("times");
				Integer duration = (Integer)phonemp.get(key).get("duration");
				sb.append(entry.getValue()+"\n\t"+"通话时间:"+duration+"\n");
				sbt.append(entry.getValue()+"\n\t"+"通话次数:"+times+"\n");
				ft+=times;
				fd+=duration;
			}
			HashMap<String, String> fatherCallInfoMap=new HashMap<String,String>();
			fatherCallInfoMap.put("times", ft+"");
			fatherCallInfoMap.put("duration", fd+"");
			this.callinfo.put("fmap", fatherCallInfoMap);
		}
		if(mmap !=null){
			sb.append("mather:\n");
			sbt.append("mather:\n");
			for (Entry<String, String> entry : mmap.entrySet()) {
				String key=entry.getKey();
				Integer times = (Integer)phonemp.get(key).get("times");
				Integer duration = (Integer)phonemp.get(key).get("duration");
				sb.append(entry.getValue()+"\n\t"+"通话时间:"+duration+"\n");
				sbt.append(entry.getValue()+"\n\t"+"通话次数:"+times+"\n");
				mt+=times;
				md+=duration;
			}
			HashMap<String, String> matherCallInfoMap=new HashMap<String,String>();
			matherCallInfoMap.put("times", ft+"");
			matherCallInfoMap.put("duration", fd+"");
			this.callinfo.put("mmap", matherCallInfoMap);
		}
		if(hmap !=null){
			sb.append("home:\n");
			sbt.append("home:\n");
			for (Entry<String, String> entry : hmap.entrySet()) {
				String key=entry.getKey();
				Integer times = (Integer)phonemp.get(key).get("times");
				Integer duration = (Integer)phonemp.get(key).get("duration");
				sb.append(entry.getValue()+"\n\t"+"通话时间:"+duration+"\n");
				sbt.append(entry.getValue()+"\n\t"+"通话次数:"+times+"\n");
				ht+=times;
				hd+=duration;
			}
			HashMap<String, String> homeCallInfoMap=new HashMap<String,String>();
			homeCallInfoMap.put("times", ht+"");
			homeCallInfoMap.put("duration", hd+"");
			this.callinfo.put("hmap", homeCallInfoMap);
		}
		/*亲属*/
		StringBuffer rsb=new StringBuffer("");
		StringBuffer rsbt=new StringBuffer("");
		if(remap !=null){
			for (Entry<String, String> entry : remap.entrySet()) {
				String key=entry.getKey();
				Integer times = (Integer)phonemp.get(key).get("times");
				Integer duration = (Integer)phonemp.get(key).get("duration");
				rsb.append(entry.getValue()+"\n\t"+"通话时长:"+duration+"\n");
				rsbt.append(entry.getValue()+"\n\t"+"通话次数:"+times+"\n");
				rt+=times;
				rd+=duration;
			}
			HashMap<String, String> rCallInfoMap=new HashMap<String,String>();
			rCallInfoMap.put("times", rt+"");
			rCallInfoMap.put("duration", rd+"");
			this.callinfo.put("rmap", rCallInfoMap);		
		}
		HashMap<String, String> sbmap=new HashMap<String,String>();
		sbmap.put("callinfo", sb.toString());
		sbmap.put("sbt", sbt.toString());
		sbmap.put("rcallinfo", rsb.toString());
		sbmap.put("rsbt", rsbt.toString());
		this.callinfo.put("info", sbmap);
	}
	
	/*通讯录得分*/
	public FeatureDesc getContactLenScore(){
		int clen=this.cinfo.getContactlength();
		int score=0;
		if (clen>30 && clen<60){
			score=10;
		}
		else if(clen>=60 && clen<90){
			score=15;
		}
		else if(clen>90 && clen<120){
			score=20;
		}
		else if(clen>150){
			score=25;
		}
		return new FeatureDesc("通讯录长度", clen+"", score+"", "人工", "----");
	}
	
	public FeatureDesc isAuthorContScore(){
		return new FeatureDesc("是否授权通讯录", "是", "20分", "看特征提取", "----");
	}
	/*父母得分*/
	public FeatureDesc getcallparentDurationScore(){
		HashMap<String,String> fmap=this.callinfo.get("fmap");
		HashMap<String,String> mmap=this.callinfo.get("mmap");
		HashMap<String,String> hmap=this.callinfo.get("hmap");
		int fd=fmap !=null? Integer.parseInt(fmap.get("duration")):0;
		int md=mmap !=null? Integer.parseInt(mmap.get("duration")):0;
		int hd=hmap !=null? Integer.parseInt(hmap.get("duration")):0;
		double fscore=this.getScoreByduration(fd)*0.3 ;//+this.getScoreBytimes(ft)*0.4+30*0.3;
		double mscore=this.getScoreByduration(md)*0.3 ;//+this.getScoreBytimes(mt)*0.4+30*0.3;
		double hscore=this.getScoreByduration(hd)*0.3 ;//+this.getScoreBytimes(ht)*0.4+30*0.3;
		double score=0.4*fscore+mscore*0.3+hscore*0.3;
		return new FeatureDesc("与父母通话时间",this.callinfo.get("info").get("callinfo"), score+"", "人工", "---");
	}
	public int  getScoreByduration(int duration){
		if (duration<10){
			return 20;
		}
		else if(duration>10 && duration<=30){
			return 30;
		}
		else if(duration>30 && duration<=60){
			return 35;
		}
		else{
			return 40;
		}
	}
	public int  getScoreBytimes(int times){
		if (times<10){
			return 10;
		}
		else if(times>10 && times<=30){
			return 20;
		}
		else if(times>30 && times<=60){
			return 25;
		}
		else{
			return 30;
		}
	}	
	/*double fscore=this.getScoreByduration(fd)*0.3 ;//+this.getScoreBytimes(ft)*0.4+30*0.3*/
	public FeatureDesc callparentTimesScore(){
		HashMap<String,String> fmap=this.callinfo.get("fmap");
		HashMap<String,String> mmap=this.callinfo.get("mmap");
		HashMap<String,String> hmap=this.callinfo.get("hmap");
		int ft=fmap !=null? Integer.parseInt(fmap.get("times")):0;
		int mt=mmap !=null? Integer.parseInt(mmap.get("times")):0;
		int ht=hmap !=null? Integer.parseInt(hmap.get("times")):0;
		double fscore=this.getScoreBytimes(ft)*0.4;
		double mscore=this.getScoreBytimes(mt)*0.4;
		double hscore=this.getScoreBytimes(ht)*0.4;
		double score=0.4*fscore+mscore*0.3+hscore*0.3;
		return new FeatureDesc("与父母通话次数",this.callinfo.get("info").get("sbt") , score+"", "看特征提取", "----");
	}
	
	public FeatureDesc callparentGrpScore(){
		return new FeatureDesc("与父母最近通话间隔", "是", "14分", "看特征提取", "----"); 
	}
	/*亲属*/
	public FeatureDesc callrelativeDurationScore(){
		HashMap<String,String> rmap=this.callinfo.get("rmap");
		int rd= rmap!=null?Integer.parseInt(rmap.get("duration")):0;
		double rscore=this.getRelativeScoreByduration(rd)*0.3;
		return new FeatureDesc("与亲属通话时间", this.callinfo.get("info").get("rcallinfo"), rscore+"", "看特征提取", "----");		
	}
	public FeatureDesc callrelativeTimesScore(){
		HashMap<String,String> rmap=this.callinfo.get("rmap");
		int rt= rmap!=null?Integer.parseInt(rmap.get("times")):0;
		double rscore=this.getRelativeScoreBytimes(rt)*0.4;
		return new FeatureDesc("与亲属通话次数", this.callinfo.get("info").get("rsbt"), rscore+"", "看特征提取", "----");	
	}
	public FeatureDesc callrelativeGrpScore(){
		return new FeatureDesc("与亲属最近通话间隔", "是", "24分", "看特征提取", "----"); 
	}
	/*通话时间得分*/
	public int  getRelativeScoreByduration(int duration){
		if (duration<10){
			return 20;
		}
		else if(duration>10 && duration<=30){
			return 30;
		}
		else if(duration>30 && duration<=60){
			return 35;
		}
		else{
			return 40;
		}
	}
	/*次数得分*/
	public int  getRelativeScoreBytimes(int times){
		if (times<10){
			return 10;
		}
		else if(times>10 && times<=30){
			return 20;
		}
		else if(times>30 && times<=60){
			return 25;
		}
		else{
			return 30;
		}
	}
}
