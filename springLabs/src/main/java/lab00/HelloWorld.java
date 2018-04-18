package lab00;

public class HelloWorld implements Regard {
	private String message;	

	public HelloWorld() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		System.out.println(message);
	}

}
