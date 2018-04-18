package ch02._01_setter._01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
    Setter: 注入字串與基本型態
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ch02/_01_setter/_01/Beans.xml");
		
		IPerson emp = context.getBean("emp", IPerson.class);
		System.out.println(emp.getComment());
		
		IPerson man = context.getBean("man", IPerson.class);
		System.out.println(man.getComment());
		
		IPerson pre = context.getBean("pre", IPerson.class);
		System.out.println(pre.getComment());
		
		((ConfigurableApplicationContext)context).close();
	}
}
