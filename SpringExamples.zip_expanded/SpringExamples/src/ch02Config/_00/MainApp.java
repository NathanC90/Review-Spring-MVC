package ch02Config._00;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		
		context.register(BookConfig.class);
		context.scan("ch02Config._00");

		context.refresh();
        System.out.println("----------------------------");
		IProduct noname = (IProduct)context.getBean("noname");
		System.out.println("書籍資料: " + noname.getDescription());
		System.out.println("============================");
		IProduct spring = (IProduct)context.getBean("spring");
		System.out.println("書籍資料: " + spring.getDescription());
		System.out.println("****************************");

		((ConfigurableApplicationContext) context).close();

	}
}
