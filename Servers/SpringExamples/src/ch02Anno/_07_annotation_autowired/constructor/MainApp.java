package ch02Anno._07_annotation_autowired.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"\\ch02Anno\\_07_annotation_autowired\\constructor\\Beans.xml");
		Snake kaa = (Snake) context.getBean("kaa");

		System.out.println(kaa.toString());
		
		 ((ConfigurableApplicationContext)context).close();
	}
}