package ch02._01_setter._02;

public class Horse implements IAnimal {
	String petName;
	@Override
	public void cry() {
		System.out.println(petName + "打針，WouWouuu...");
	}
	public void run() {
		System.out.println(petName + ": DeeDaDeeDa...");
	}
	
	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
}
