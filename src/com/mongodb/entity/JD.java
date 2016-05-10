package com.mongodb.entity;


import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.Document;
//MongoDB数据表
@Document(collection="jingdong")  
public class JD {
	@Column(name="safe_priority")
	private String safe_priority; 
	private String chengzhangzhi;
	private String huiyuanjibie;
	private String loginhistory;
	private String address;
	private String jd_login_name;
	private String 实名认证;
	private String 手机验证;
	private String month_consume3;
	public JD(){
		
	}
	public JD(String safe_priority, String chengzhangzhi, String huiyuanjibie, String loginhistory, String address,
			String jd_login_name, String 实名认证, String 手机验证, String month_consume3) {
		super();
		this.safe_priority = safe_priority;
		this.chengzhangzhi = chengzhangzhi;
		this.huiyuanjibie = huiyuanjibie;
		this.loginhistory = loginhistory;
		this.address = address;
		this.jd_login_name = jd_login_name;
		this.实名认证 = 实名认证;
		this.手机验证 = 手机验证;
		this.month_consume3 = month_consume3;
	}
	public String getMonth_consume3() {
		return month_consume3;
	}
	public void setMonth_consume3(String month_consume3) {
		this.month_consume3 = month_consume3;
	}
	 
	public String getValidRelName() {
		return this.实名认证;
	}
	public void setValidRelName(String validRelName) {
		this.实名认证 = validRelName;
	}
	public String getSafe_priority() {
		return safe_priority;
	}
	public void setSafe_priority(String safe_priority) {
		this.safe_priority = safe_priority;
	}
	public String getChengzhangzhi() {
		return chengzhangzhi;
	}
	public void setChengzhangzhi(String chengzhangzhi) {
		this.chengzhangzhi = chengzhangzhi;
	}
	public String getHuiyuanjibie() {
		return huiyuanjibie;
	}
	public void setHuiyuanjibie(String huiyuanjibie) {
		this.huiyuanjibie = huiyuanjibie;
	}
	public String getLoginhistory() {
		return loginhistory;
	}
	public void setLoginhistory(String loginhistory) {
		this.loginhistory = loginhistory;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJd_login_name() {
		return jd_login_name;
	}
	public void setJd_login_name(String jd_login_name) {
		this.jd_login_name = jd_login_name;
	}
	 
	public String getValidPhone() {
		return this.手机验证;
	}
	public void setValidPhone(String ValidPhone) {
		this.手机验证 = ValidPhone;
	}
}
