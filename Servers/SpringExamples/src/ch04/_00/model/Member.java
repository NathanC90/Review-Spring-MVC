package ch04._00.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer pk;
	String userId;
	String password;
	String name;
	String email;
	Date birthday;
	Timestamp regDate;
	Integer experience;
	public Member(Integer pk, String userId, String password, String name, String mail,
			Date birthday, Timestamp regDate, Integer experience) {
		this.pk = pk;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = mail;
		this.birthday = birthday;
		this.regDate = regDate;
		this.experience = experience;
	}
	public Member(String userId, String password, String name, String mail,
			Date birthday, Timestamp regDate, int experience) {
		
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = mail;
		this.birthday = birthday;
		this.regDate = regDate;
		this.experience = experience;
	}
	
	public Member(String userId, String password, String name, String mail,
			Date birthday, Integer experience) {
		
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = mail;
		this.birthday = birthday;
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

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
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