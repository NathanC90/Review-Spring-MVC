package ch02._01_setter._02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ch02/_01_setter/_02/Beans.xml");
		Veterinary v1 = (Veterinary)context.getBean("vet1");
		v1.vaccinate();
		
		Veterinary v2 = (Veterinary)context.getBean("vet2");
		v2.vaccinate();
		
		Veterinary v3 = (Veterinary)context.getBean("vet3");
		v3.vaccinate();
		
		((ConfigurableApplicationContext)context).close();
	}
}
