// 設計程式SendMessageToConsole.java，此類別實作Regard介面。
// SendMessageToConsole類別有一個實例變數message、與此變數對應的Getter/Setter、預設建構子與
// Regard介面定義的方法: public void sayHello()。

package ch01.xml._01;

import ch01.xml.commons.IRegard;

public class SendMessageToConsole implements IRegard {
	private String message;
	public SendMessageToConsole() { }
	
	public SendMessageToConsole(String message) {
		this.message = message;
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
