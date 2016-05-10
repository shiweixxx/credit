/* sw
 * 2016-2016年4月29日-下午4:36:59
 * credit
 */
package apix.com.rules.alm;

import com.springmvc.entity.User;

import apix.com.rules.FeatureDesc;
import apix.com.utils.ExtApi;

/**
 * @author sw
 * 个人信息算法ContactAlgorithm
 */
public class PersonInfoAlgorithm {
	private ExtApi extApi;
	private User u;
	public PersonInfoAlgorithm(ExtApi extApi,User u){
		this.extApi=extApi;
		this.u = u !=null?u:new  User(-1,"","0","unkown","","unkown", "unkown", "unkown", "unkown");
	}
	/*年龄*/
	public FeatureDesc getAgeScore(){
		int age=Integer.parseInt(this.u.getAge());//this.extApi.getSexByIDcard(this.u.getAgeByIdCard());
		int score=0;
		if (age<=23){
			score=50;
		}
		else if(age>23 && age<=35){
			score=100;
		}
		else if(age>35 && age<=60){
			score=80;
		}
		else if(age>60){
			score=70;
		}
		return new FeatureDesc("年龄", age+"", ""+score, "看特征提取", "----");
	}
	/*性别得分*/
	public FeatureDesc getSexScore(){
		String sex=this.extApi.getSexByIDcard(this.u.getIdCard()).get("sex");
		int score=0;
		if ("男".equals(sex)){
			score=80;
		}
		else{
			score=100;
		}
		return new FeatureDesc("性别", sex, score+"", "看特征提取", "----");
	}
	/*婚姻* 1:结婚，２：未结婚*/
	public FeatureDesc getMarrayScore(){
		String mstus=this.u.getMarrayType();
		int score=0;
		if ("1".equals(mstus)){
			score=100;
		}
		else if("2".equals(mstus)){
			score=70;
		}
		return new FeatureDesc("婚姻状况", mstus, ""+score, "看特征提取", "----");
	}
	/*职业*/
	public FeatureDesc getProfessionScore(){
		String profession=this.u.getProfession();
		return new FeatureDesc("行业类别", profession, ""+30, "看特征提取", "----");
	}
	/*文化程度*/
	public FeatureDesc getEudLevel(){
		String edu = this.u.getEdulevel();
		int score=0;
		if ("初中".equals(edu)){
			score=20;
		}
		else if("高中".equals(edu)){
			score=50;
		}
		else if("大学".equals(edu)){
			score=80;
		}
		return new FeatureDesc("文化程度", edu, ""+score, "看特征提取", "----");
	}
	/*户口性质*/
	public FeatureDesc getresidenza(){
		String cityname=this.extApi.getLocationOfIDcard(this.u.getIdCard()).get("city");
		int score=0;
		if (cityname.startsWith("县")){
			score=50;
		}else{
			score=70;
		}
		return new FeatureDesc("户口性质", cityname, ""+score, "看特征提取", "----");
	}
	/*照片是否一样*/
	public FeatureDesc getIsSamePhone(){
		return new FeatureDesc("身份证照片比对是否一样", "是", "34分", "看特征提取", "----");
	}
}
