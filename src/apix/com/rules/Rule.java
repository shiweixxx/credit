/* sw
 * 2016-2016年4月29日-上午11:26:10
 * credit
 */
package apix.com.rules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.mongodb.entity.Contact;

import apix.com.rules.alm.ContactAlgorithm;
import apix.com.rules.alm.JDAlgoritm;
import apix.com.rules.alm.PersonInfoAlgorithm;
import apix.com.rules.alm.SpAlgorithm;
import apix.com.rules.alm.TaoBaoAlgoritm;

/**
 * @author sw
 * 包含个人信息，淘宝，京东信息认证,银行卡，多平台借款，运营商数据等
 */
public class Rule {
	private ContactAlgorithm conAlm;
	private PersonInfoAlgorithm psonInfo;
	private TaoBaoAlgoritm tb;
	private JDAlgoritm jd;
	private SpAlgorithm sp;
	public Rule(ContactAlgorithm conAlm,PersonInfoAlgorithm psonInfo,
			TaoBaoAlgoritm tb,JDAlgoritm jd,SpAlgorithm sp){
		this.conAlm= conAlm;
		this.psonInfo = psonInfo;
		this.tb = tb;
		this.jd = jd;
		this.sp = sp;
	}
	/*通讯录*/
	public HashMap<String,FeatureDesc> getContacts(){
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();

		hp.put("contactlen", conAlm.getContactLenScore());/*通讯录长度*/
		hp.put("isAuthorCont", conAlm.isAuthorContScore());/*是否授权*/
		hp.put("callparentDate", conAlm.getcallparentDurationScore());/*与父母通话时间*/
		hp.put("callparentTimesScore", conAlm.callparentTimesScore());/*与父母通话次数*/
		hp.put("callparentGrp", conAlm.callparentGrpScore());/*与父母最近通话间隔*/
		hp.put("callrelativeDate", conAlm.callrelativeDurationScore());/*与亲属通话时间*/
		hp.put("callrelativeTimes", conAlm.callrelativeTimesScore());/*与亲属通话次数*/
		hp.put("callrelativeGrp", conAlm.callrelativeGrpScore());/*与亲属最近通话间隔*/		
		return hp;
	}
	/*运营商数据
	 * 
	 * 根据用户的手机号类型，联通，移动，电信带入相应的模型计算
	 */
	public HashMap<String,FeatureDesc> getSp(){
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();
		hp.put("creditHistoryOfTimes",this.sp.creditHistoryScoreofTimes());
		hp.put("creditHistoryOfduration",this.sp.creditHistoryScoreofduration());
		hp.put("needsCallmoney", this.sp.needsCallScoreofmomey());
		return hp;
	}	
	/*银行卡信息*/
	public HashMap<String,FeatureDesc> getBank(){
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();
		hp.put("bankId", new FeatureDesc("卡号", "是", "34分", "看特征提取", "----"));
		hp.put("money", new FeatureDesc("存款", "是", "34分", "看特征提取", "----"));
		hp.put("isHavaDebt", new FeatureDesc("欠债", "是", "34分", "看特征提取", "----"));
		hp.put("isDuned", new FeatureDesc("被催收", "是", "34分", "看特征提取", "----"));
		return hp;		
	}	
	/*多平台借款信息*/
	public HashMap<String,FeatureDesc> getPlat(){
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();
		hp.put("isSameBankIdTimes", new FeatureDesc("同一银行卡在多平台借款次数", "是", "34分", "看特征提取", "----"));
		hp.put("isSamePhoneTimes", new FeatureDesc("同一手机号在多平台借款次数", "是", "34分", "看特征提取", "----"));
		hp.put("isSameCardIdTimes", new FeatureDesc("统一身份证在多平台借款次数", "是", "34分", "看特征提取", "----"));
		return hp;
	}
	
	/*个人信息*/
	public HashMap<String,FeatureDesc> getPersonInfo(){
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();
		hp.put("age", this.psonInfo.getAgeScore());
		hp.put("sex", this.psonInfo.getSexScore());
		hp.put("MarrayStat", this.psonInfo.getMarrayScore());
		hp.put("eduLevel", this.psonInfo.getEudLevel());
		hp.put("residenza", this.psonInfo.getresidenza());
		hp.put("profession", this.psonInfo.getProfessionScore());
		hp.put("isEqualPhone",this.psonInfo.getIsSamePhone());
		return hp;		
	}
	/*淘宝数据*/
	public HashMap<String,FeatureDesc> getTaobao(){
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();
		hp.put("lasterLoginTime", this.tb.getLoginTimeScore());
		hp.put("consumeMonth", this.tb.getconsumeMonthScore());
		hp.put("isAuthoriedPhone", this.tb.getisAuthoriedPhoneScore());
		hp.put("ChangeAdrTimes",this.tb.getChangeAdressChangeTimes());
		return hp;
	}
	/*京东数据*/
	public HashMap<String,FeatureDesc> getJD(){	
		HashMap<String,FeatureDesc> hp=new HashMap<String,FeatureDesc>();
		hp.put("lasterLoginTime", this.jd.getLoginTimeScore());
		hp.put("consumeMonth", this.jd.getconsumeMonthScore());
		hp.put("ChangeAdrTimes", this.jd.getChangeAdressChangeTimes());
		hp.put("validateName", this.jd.validateNameScore());
		hp.put("validatePhone", this.jd.validatePhone());
		hp.put("membergrade", this.jd.getMembergrade());
		return hp;
	}
	
}
