package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 此实体的定义应用了springmvc的注解，省去了传统的Hibernate跟数据库之间的映射配置文件
 * @author huoliming
 * 表名T_USER、实体类名User;以后的DAO具体SQL实现中，表名就用User代替了，还不是T_USER；
 */
@Entity  
@Table(name="t_user")  
public class User {  

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;  

	@Column(name="username",length=32)  
	private String userName;  

	@Column(name="age",length=32)  
	private String age; 
	
	@Column(name="telephone",length=32)
	private String Telephone;
	/*身份证*/
	private String IdCard;
	private String edulevel;
	private String residenza;
	private String profession;
	private String marrayType;

	
	
	/**
	 * @param id
	 * @param userName
	 * @param age
	 * @param telephone
	 * @param idCard
	 * @param edulevel
	 * @param residenza
	 * @param profession
	 * @param marrayType
	 */
	public User(int id, String userName, String age, String telephone, String idCard, String edulevel, String residenza,
			String profession, String marrayType) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		Telephone = telephone;
		IdCard = idCard;
		this.edulevel = edulevel;
		this.residenza = residenza;
		this.profession = profession;
		this.marrayType = marrayType;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public String getEdulevel() {
		return edulevel;
	}

	public void setEdulevel(String edulevel) {
		this.edulevel = edulevel;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	/***
	 * ID的属性
	 * @return
	 */
	public int getId() {  
		return id;  
	}  

	public void setId(int id) {  
		this.id = id;  
	}  

	/***
	 * UserName的属性；
	 * @return
	 */
	public String getUserName() {  
		return userName;  
	}  

	public void setUserName(String userName) {  
		this.userName = userName;  
	}  

	/**
	 * Age的属性；
	 * @return
	 */
	public String getAge() {  
		return age;  
	}  

	public void setAge(String age) {  
		this.age = age;  
	}
	
	/***
	 * Telephone属性
	 * @return
	 */
	public String getTelephone(){
		return Telephone;
	}
	public  void setTelephone(String phone){
		this.Telephone=phone;
	}

	/**
	 * @return the residenza
	 */
	public String getResidenza() {
		return residenza;
	}

	/**
	 * @param residenza the residenza to set
	 */
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	/**
	 * @return the marrayType
	 */
	public String getMarrayType() {
		return marrayType;
	}

	/**
	 * @param marrayType the marrayType to set
	 */
	public void setMarrayType(String marrayType) {
		this.marrayType = marrayType;
	}
}