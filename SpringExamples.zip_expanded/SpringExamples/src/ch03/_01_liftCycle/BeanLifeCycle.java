package ch03._01_liftCycle;
public class BeanLifeCycle implements Exam {
	private String message;
	
	public BeanLifeCycle() { 
		System.out.println("正在執行Bean元件的建構子，新建Bean元件");
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void test() {
		System.out.println(message);
	}
	public void init() {
		System.out.println("已經新建Bean元件，正在init-method屬性所指定的方法");
	}
	public void destroy() {
		System.out.println("準備銷毀Bean元件，正在destroy-method屬性所指定的方法");
	}
}
