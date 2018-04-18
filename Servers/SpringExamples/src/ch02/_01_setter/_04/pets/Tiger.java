package ch02._01_setter._04.pets;

public class Tiger implements Animal {
	String name;

	public Tiger() {
		super();
	}

	public Tiger(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return String.format("大貓: 名字:%-5s \n",	name);
	}
}
