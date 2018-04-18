package ch01.anno;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch01.xml.commons.IRegard;

public class MainAppAnno {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	    // Spring框架讓我們能夠以更穩健、更輕鬆的方式來變更程式的功能
		String toConsole = "ch01\\anno\\_01\\Beans.xml";
		String toFile = "ch01\\anno\\_02\\BeansToFile.xml";
		ApplicationContext context = 
			new ClassPathXmlApplicationContext(toFile);
		IRegard reg = (IRegard)context.getBean(IRegard.class);
		reg.sayHello();
		
		((ConfigurableApplicationContext)context).close();

	}    
}
