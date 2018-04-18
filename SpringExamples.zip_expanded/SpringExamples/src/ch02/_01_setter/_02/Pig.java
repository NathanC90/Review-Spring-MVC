package ch02._01_setter._02;

public class Pig implements IAnimal {
    String petName;

	@Override
	public void cry() {
		System.out.println(petName + "打針，Maeo~~...");
	}
	
	public void sleep() {
		System.out.println(petName + ":zzzZZZ...");
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

}