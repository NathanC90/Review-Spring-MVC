package ch02Anno._04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
      常數字串檔案化
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ch02Anno/_04/Beans.xml");
		
		Computer computer = (Computer)context.getBean("notebook");
		System.out.println(computer.getDescription());
		
		((ConfigurableApplicationContext)context).close();
	}
}
