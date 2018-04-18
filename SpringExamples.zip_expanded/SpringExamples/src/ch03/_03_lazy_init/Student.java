package ch03._03_lazy_init;

public class Student {
	String name;
	Address address;
	
	public Student() {	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + "]";
	}

	static {
		System.out.println("in Student類別的靜態區塊，Student類別被載入");
	}
}
