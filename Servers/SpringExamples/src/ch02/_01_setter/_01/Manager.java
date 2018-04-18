package ch02._01_setter._01;

public class Manager extends Employee {
	private String dedicatedPhoneNo;
	public Manager() { 	
	}
	
	public String getDedicatedPhoneNo() {
		return dedicatedPhoneNo;
	}

	public void setDedicatedPhoneNo(String dedicatedPhoneNo) {
		this.dedicatedPhoneNo = dedicatedPhoneNo;
	}

	@Override
	public String getComment() {
		
		return super.getComment() + " 專線號碼:" + dedicatedPhoneNo;
	}
}
