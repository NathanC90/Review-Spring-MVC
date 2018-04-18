package ch03._02_scope;

public class MessageService implements Message {
    String message;
    public MessageService() {	
	  System.out.println("ch03._02_scope.MessageService類別已 new 為物件");
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    static {
	  System.out.println("ch03._02_scope.MessageService類別已載入");
    }
}
