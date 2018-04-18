package ch02Anno._07_annotation_autowired.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"\\ch02Anno\\_07_annotation_autowired\\property\\Beans.xml");

		Employee emplpyee = (Employee) context.getBean("emp");

		System.out.println(emplpyee.toString());
		((ConfigurableApplicationContext)context).close();
	}
}
