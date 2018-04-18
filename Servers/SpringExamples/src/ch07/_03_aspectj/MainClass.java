package ch07._03_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ch07/_03_aspectj/applicationContext.xml");
		
		ArithmeticCalculator arithmeticCalculator = 
				(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		int sum = arithmeticCalculator.add(3, 6);
		System.out.println("sum=" + sum);
		
		int div = arithmeticCalculator.div(8, 2);
		System.out.println("div=" + div);
		
		int abs = arithmeticCalculator.abs(-100);
		System.out.println("abs=" + abs);
	}

}
