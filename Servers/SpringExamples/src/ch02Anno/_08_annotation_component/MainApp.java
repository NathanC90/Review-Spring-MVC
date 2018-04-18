package ch02Anno._08_annotation_component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02Anno\\_08_annotation_component\\Beans.xml");
		System.out.println("-------------------------------");
		Manager mary = (Manager) context.getBean("Mary");
		Manager marie = (Manager) context.getBean("Mary");
		System.out.println(" mary.hashCode(): " + mary.hashCode());
		System.out.println("marie.hashCode(): " + marie.hashCode());
		System.out.println(mary);
		System.out.println(marie);
		((ConfigurableApplicationContext)context).close();
		
	}

}
