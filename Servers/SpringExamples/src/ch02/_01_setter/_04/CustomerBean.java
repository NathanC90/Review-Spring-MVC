package ch02._01_setter._04;

import java.util.*;

import ch02._01_setter._04.pets.Animal;

public class CustomerBean implements ICustomerBean {
	private String name;
	private Date birthday;
	private List<String> hobby;
	private String[] talent;
	private Map<String, Animal> pet;
	private Long  nullObj;

	public CustomerBean() { }

	public CustomerBean(String name, Date birthday, 
			List<String> hobby, String[] talent,
			Map<String, Animal> pet) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.hobby = hobby;
		this.talent = talent;
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public String[] getTalent() {
		return talent;
	}

	public void setTalent(String[] talent) {
		this.talent = talent;
	}

	public Map<String, Animal> getPet() {
		return pet;
	}

	public void setPet(Map<String, Animal> pet) {
		this.pet = pet;
	}

	public Long getNullObj() {
		return nullObj;
	}

	public void setNullObj(Long nullObj) {
		this.nullObj = nullObj;
	}

	@Override
	public String getMessage() {
		StringBuffer message = new StringBuffer();
		message.append("name=" + name + ", birthday=" + birthday);
		message.append("  嗜好:[");
		if (hobby != null) {
			for (String s : hobby) {
				message.append(s + " ");
			}
		}
		message.append("]");
		message.append("  專長:[");
		if (talent != null) {
			for (String s : talent) {
				message.append(s + " ");
			}
		}
		message.append("]");
		message.append("\n  寵物:[");
		if (pet != null) {
			Set<String> set = pet.keySet();
			for (String s : set) {
				message.append(s + "->" + pet.get(s).getComment() + " ");
			}
		}
		message.append("]");
		message.append("\n");
		message.append("  請仔細觀察如何注入null:" + nullObj);
		return message.toString();
	}
}
