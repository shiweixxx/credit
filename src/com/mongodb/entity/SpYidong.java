package com.mongodb.entity;


import javax.persistence.Column;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
//MongoDB数据表
@Document(collection="yidong")  
public class SpYidong {
	 public ObjectId _id;
	 public String base_info;
	 public String phone_no;
	 public String yue;
	 public String recharge;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getBase_info() {
		return base_info;
	}
	public void setBase_info(String base_info) {
		this.base_info = base_info;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getYue() {
		return yue;
	}
	public void setYue(String yue) {
		this.yue = yue;
	}
	public String getRecharge() {
		return recharge;
	}
	public void setRecharge(String recharge) {
		this.recharge = recharge;
	}
	 
}
