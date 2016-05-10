/* sw
 * 2016-2016年4月29日-上午11:44:29
 * credit
 * 信用分值的计算
 */
package apix.com.rules;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mongodb.entity.Contact;
import com.mongodb.entity.JD;
import com.mongodb.entity.SpYidong;
import com.mongodb.service.IJD;
import com.mongodb.service.JDImpl;
import com.springmvc.entity.User;

import apix.com.rules.alm.ContactAlgorithm;
import apix.com.rules.alm.JDAlgoritm;
import apix.com.rules.alm.PersonInfoAlgorithm;
import apix.com.rules.alm.SpAlgorithm;
import apix.com.rules.alm.TaoBaoAlgoritm;
import apix.com.utils.ExtApi;
public class Calculation {
	private Rule rule;
	/*获取一些地址信息*/
	private ExtApi extapi;
	private List<Contact> contacts=null;
	private User u;
	private JD jd;
	private SpYidong spyd;
	public Calculation(List<Contact> contacts,User u,JD jd,SpYidong spyd,ExtApi extApi){
		this.contacts = contacts;
		this.u = u;
		this.rule=new Rule(
				new  ContactAlgorithm(contacts,extApi),
				new PersonInfoAlgorithm(extApi, u),
				new TaoBaoAlgoritm(),
				new JDAlgoritm(jd),
				new SpAlgorithm(spyd,extApi)
				);
	}
	/*个人信息*/
	public HashMap<String,HashMap<String,FeatureDesc>> scoreApi(){
		HashMap<String,HashMap<String,FeatureDesc>> hp=new 
				HashMap<String,HashMap<String,FeatureDesc>>();
		/*个人信息*/  
		hp.put("个人信息", rule.getPersonInfo());
		/*淘宝认证*/
		hp.put("淘宝认证", rule.getTaobao());
		/*京东认证*/
		hp.put("京东认证", rule.getJD());
		/*银行卡*/
		hp.put("银行卡",   rule.getBank());
		/*多平台借款*/
		hp.put("多平台借款", rule.getPlat());
		/*运营商数据*/
		hp.put("运营商", rule.getSp());
		/*通讯录*/
		hp.put("通讯录", rule.getContacts()); 
		return hp;
	}
	public static void main(String[] args) {
		List<Contact> listc=new ArrayList<Contact>();
		/*构造contacts*/
		listc.add(new Contact(1+"", "妈", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(2+"", "石头", "15600300721", new Date(2016,2,1), new Date(2016,4,5), 10,0));
		listc.add(new Contact(3+"", "王丽", "13156114610", new Date(2016,2,4), new Date(2016,4,7), 12,1));
		listc.add(new Contact(4+"", "刘哥", "131561146101", new Date(2016,3,4), new Date(2014,4,5), 32,1));
		listc.add(new Contact(5+"", "爸", "15600300801", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(6+"", "表哥", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(7+"", "王三", "15600300892", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(8+"", "李四", "15600300890", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(9+"", "王麻子", "1560033457", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(10+"", "张无", "1560345457", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(11+"", "王柳", "1325400897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(12+"", "万思", "14200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(13+"", "路路", "15700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(14+"", "老婆", "15900300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(15+"", "似懂", "15800300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(16+"", "张思", "15200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		listc.add(new Contact(17+"", "李毅", "15100300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(18+"", "王华", "18200300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(19+"", "兆谭", "188600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(20+"", "石头", "18600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(21+"", "上官", "18700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(22+"", "xx", "17606300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(23+"", "dfd", "12600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(24+"", "家", "111111", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		listc.add(new Contact(25+"", "刘伟", "19600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(26+"", "李伟", "10600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(27+"", "王丽诶", "15600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(28+"", "李艾", "15630300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(29+"", "哈哈", "15670340897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(30+"", "催收", "15690380897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(31+"", "信息", "16600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(32+"", "test", "17600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(33+"", "水电费", "19603300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(34+"", "得分", "134600300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(35+"", "得分的双方", "15000300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(36+"", "马建", "15900300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(37+"", "麻花", "1505000897", new Date(2016,3,4), new Date(2014,4,5), 34,1));
		listc.add(new Contact(39+"", "继父", "15700300897", new Date(2016,3,4), new Date(2014,4,5), 34,1));		
		 
		User u=new User(2,"sw","39","15600300721","622921199302170937",
				"大学", "", "互联网", "未婚");
//		Calculation c=new Calculation(listc,u,null,new ExtApi());
		/*System.out.println(111);

		HashMap<String,HashMap<String,FeatureDesc>> mp=c.scoreApi();
		 for (Map.Entry<String, HashMap<String, FeatureDesc>> entry : mp.entrySet()) { 
				System.out.println("Key = " + entry.getKey());
				for(Map.Entry<String, FeatureDesc> ff:entry.getValue().entrySet()){
					System.out.println("------"+
									ff.getValue().getFeatureList()+"\t"+
									ff.getValue().getIsOk()+"\t"+
									ff.getValue().getJudegLevel()+"\t"+
									ff.getValue().getScore());
				}
		 }*/
	}
}
