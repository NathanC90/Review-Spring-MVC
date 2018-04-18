package ch02Anno._01;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
       本範例說明如何對Setter使用@Autowired與@Resource
*/                                            
public class MainApp {  
	public static void main(String[] args) {
	    
		ApplicationContext context = 
			new ClassPathXmlApplicationContext("ch02Anno/_01/Beans.xml");
		Event event = (Event)context.getBean("toFile");
		event.writeLog();
	
		((ConfigurableApplicationContext)context).close();

	}    
}
