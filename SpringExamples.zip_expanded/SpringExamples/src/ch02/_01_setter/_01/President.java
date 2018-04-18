package ch02._01_setter._01;

public class President extends Manager {
	private String dedicatedCarNo;

	public President() {
		
	}

	public String getDedicatedCarNo() {
		return dedicatedCarNo;
	}

	public void setDedicatedCarNo(String dedicatedCarNo) {
		this.dedicatedCarNo = dedicatedCarNo;
	}

	@Override
	public String getComment() {
		return super.getComment() +"  車號:" + dedicatedCarNo;
	}
	
}
