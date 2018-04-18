package ch05.ex05.model;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer pk;
	String userId;
	String password;
	String name;
	String email;
	String tel; 
	int experience;
	public Member(int pk, String userId, String password, String name, String mail,
			String tel, int experience) {
		this.pk = pk;
		this.userId = userId;
		this.password = password;
		this.name = name;
		email = mail;
		this.tel = tel;
		this.experience = experience;
	}
	public Member(String userId, String password, String name, String mail,
			String tel, int experience) {
		
		this.userId = userId;
		this.password = password;
		this.name = name;
		email = mail;
		this.tel = tel;
		this.experience = experience;
	}
	public Member(Integer pk) {
		this.pk = pk;
	}
	public Member() { }

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer  getPk() {
		return pk;
	}

	public void setPk(Integer  pk) {
		this.pk = pk;
	}
}
