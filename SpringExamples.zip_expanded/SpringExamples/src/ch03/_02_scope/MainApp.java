package ch03._02_scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * Scope: Singleton表示容器對同一個Bean元件只建構一個物件。在容器執行的過程中，
 * 無論執行context.getBean("msg")多少次，得到的是同一物件。
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext
                                   ("ch03/_02_scope/Beans.xml");
        System.out.println("--------------容器初始化完畢---------------------");
        
        Message msg1 = (Message) context.getBean("msg");
        Message msg2 = (Message) context.getBean("msg");
        msg1.setMessage("我是Message元件");
        System.out.println("透過msg1.getMessage()印出訊息:" + msg1.getMessage() 
                 + ", toString():" +  msg1.toString());
        System.out.println("透過msg2.getMessage()印出訊息:" + msg2.getMessage() 
                 + ", toString():" +  msg2.toString());
        ((ConfigurableApplicationContext)context).close();
    }
}
