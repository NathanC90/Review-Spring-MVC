package ch02Anno._02;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
       本範例說明如何對屬性使用@Autowired與@Resource
*/                                            
public class MainApp {  
	public static void main(String[] args) {
	    
		ApplicationContext context = 
			new ClassPathXmlApplicationContext("ch02Anno/_02/Beans.xml");
		IRegard reg = (IRegard)context.getBean("messageToFile");
		reg.sayHello();
	
		((ConfigurableApplicationContext)context).close();

	}    
}
