/* sw
 * 2016-2016年4月29日-下午4:36:59
 * credit
 */
package apix.com.rules.alm;

import com.sun.org.apache.xalan.internal.utils.FeatureManager.Feature;

import apix.com.rules.FeatureDesc;

/**
 * @author sw
 * 淘宝算法ContactAlgorithm
 */
public class TaoBaoAlgoritm {
	
	public FeatureDesc getLoginTimeScore(){
		return new FeatureDesc("最近登陆时间间隔", "是", "34分", "机器提取", "----");
	}
	public FeatureDesc getconsumeMonthScore(){
		return new FeatureDesc("月平均消费金额", "是", "3２分", "看特征提取", "----");
	}
	public FeatureDesc getisAuthoriedPhoneScore(){
		return new FeatureDesc("是否验证手机号", "是", "34分", "看特征提取", "----");
	}
	public FeatureDesc getChangeAdressChangeTimes(){
		return new FeatureDesc("收货地址变动次数", "是", "34分", "看特征提取", "----");
	}

}
