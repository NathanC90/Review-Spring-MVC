package ch02._01_setter._04.pets;

public class Mouse implements Animal {
	String name;

	public Mouse() {
		super();
	}

	public Mouse(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getComment() {
		return String.format("小鼠: 名字:%-5s \n",	name);
	}
	
}
