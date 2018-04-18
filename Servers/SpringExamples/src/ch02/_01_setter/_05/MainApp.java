package ch02._01_setter._05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ch02/_01_setter/_05/Beans.xml");
		IMovie m1 = (IMovie)context.getBean("godFather");
		System.out.println(m1.getComment());
		
		((ConfigurableApplicationContext)context).close();
	}
}
