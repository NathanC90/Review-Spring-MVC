package ch01.config;
  
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch01.config._01.JavaConfigInfo;
import ch01.xml.commons.IRegard;

public class MainAppJavaConfig {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext();
		context.register(JavaConfigInfo.class);
		context.scan("ch01.config");
		context.refresh();
		IRegard reg = (IRegard)context.getBean(IRegard.class);
		reg.sayHello();
		
		((ConfigurableApplicationContext)context).close();

	}    
}
