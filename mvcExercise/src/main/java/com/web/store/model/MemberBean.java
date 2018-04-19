package com.web.store.model;

import java.io.*;
import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="seqNo")
	public Integer getPkey() {
		return pkey;
	}

	Integer pkey;
	String memberId;
	String name;	
	String password;
	String address;
	String email;
	String tel;
	String userType;
	Timestamp registerTime;
	Double totalAmt;
	Blob memberImage;
	Clob comment;
	String fileName;
	Double unpaid_order_amount;
	
	
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	@Column(name="memberImage")	
	public Blob getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}
	@Column(name="comments")
	public Clob getComment() {
		return comment;
	}

	public void setComment(Clob comment) {
		this.comment = comment;
	}
	@Column(name="fileName")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setTs(Timestamp ts) {
		this.registerTime = ts;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public MemberBean(
	Integer pKey, String memberId, String name, String password, String address, 
	String email, String tel, String userType, Timestamp registerTime, 
	Double totalAmt, Double unpaid_order_amount, Blob memberImage, String fileName) {
		super();
		this.pkey = pKey;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.userType = userType;
		this.registerTime = registerTime;
		this.totalAmt = totalAmt;
		this.unpaid_order_amount = unpaid_order_amount;
		this.fileName = fileName;
		this.memberImage = memberImage;
	}

	public MemberBean(String memberId, String name, String password, String address, String mail, String tel) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = mail;
		this.tel = tel;
	}

	public MemberBean() {
		super();
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}
	@Column(name="address")
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public String getName() {
		return name;
	}
	@Column(name="name")
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name="memberId")
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	

	public String getUserType() {
		return userType;
	}
	@Column(name="Register_date")
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	
	@Column(columnDefinition="decimal(12, 1)")
	public Double getTotalAmt() {
		return totalAmt;
	}
	
	@Column(columnDefinition="decimal(12, 1)")
	public Double getUnpaid_order_amount() {
		return unpaid_order_amount;
	}
	
	public void setUnpaid_order_amount(Double unpaid_order_amount) {
		this.unpaid_order_amount = unpaid_order_amount;
	}
	@Override
	public String toString() {
		return "MemberBean [pkey=" + pkey + ", memberId=" + memberId + ", name=" + name + ", password=" + password
				+ ", address=" + address + ", email=" + email + ", tel=" + tel + ", userType=" + userType
				+ ", registerTime=" + registerTime + ", totalAmt=" + totalAmt + ", memberImage=" + memberImage
				+ ", comment=" + comment + ", fileName=" + fileName + ", unpaid_order_amount=" + unpaid_order_amount
				+ "]";
	}
	
}
