package ch02._01_setter._04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ch02/_01_setter/_04/CustomerBean.xml");
		CustomerBean cb = context.getBean(CustomerBean.class);
		System.out.println(cb.getMessage());
		((ConfigurableApplicationContext)context).close();
	}
}
