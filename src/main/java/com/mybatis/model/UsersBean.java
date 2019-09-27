package com.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("users")
public class UsersBean {
	@TableId(type=IdType.AUTO)
	private Integer no;
	@TableField("uID")
	private String	userID;
	private Byte[]	pwd;
	@TableField("uName")
	private String	userName;
	
	public static enum column {
		no,uID,uName,pwd
	}
	
	@Override
	public String toString() {
		return "UsersBean [no=" + no + ", userID=" + userID + ", userName=" + userName + "]";
	}
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
//	@Column(name="uID",unique=true)
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Byte[] getPwd() {
		return pwd;
	}
	public void setPwd(Byte[] pwd) {
		this.pwd = pwd;
	}
	
	public void setPwd(String pwd) {
		byte[] bytePwd = pwd.getBytes();
		int length = bytePwd.length;
		
		Byte[] objBytePwd = new Byte[length];
		
		for(int i=0 ; i<length ; i++ ) {
			objBytePwd[i] = bytePwd[i];
		}
		
		this.pwd = objBytePwd;
	}
	
//	@Column(name="uName",unique=true)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
