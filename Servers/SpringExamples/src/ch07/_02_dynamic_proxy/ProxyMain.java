package ch07._02_dynamic_proxy;

import ch07._01_without_aop.impl.ArithmeticCalculatorImpl;
import ch07._01_without_aop.interfaces.ArithmeticCalculator;

public class ProxyMain {

	public static void main(String[] args) {
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = 
				new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		int result = proxy.add(1, 2);
		System.out.println("-->" + result);
		result = proxy.div(4, 2);
		System.out.println("-->" + result);
	}
}
