package com.mongodb.entity;

import java.util.Date;
//MongoDB数据表
public class Contact {
	private String cid;
	private String username;
	private String phone;
	private Date createTime;
	private Date callTime;
	private int duration;
	private int type=0;/*1:呼入，0 呼出*/
	
	/**
	 * @param cid
	 * @param username
	 * @param phone
	 * @param createTime
	 * @param callTime
	 * @param duration
	 * @param type
	 */
	public Contact(String cid, String username, String phone, Date createTime, Date callTime, int duration, int type) {
		super();
		this.cid = cid;
		this.username = username;
		this.phone = phone;
		this.createTime = createTime;
		this.callTime = callTime;
		this.duration = duration;
		this.type = type;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCallTime() {
		return callTime;
	}
	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
