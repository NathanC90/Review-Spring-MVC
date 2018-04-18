package ch07._01_without_aop;

import ch07._01_without_aop.impl.ArithmeticCalculatorLoggingImpl;
import ch07._01_without_aop.interfaces.ArithmeticCalculator;

public class ArithMainClass {

	public static void main(String[] args) {
		ArithmeticCalculator ac = new ArithmeticCalculatorLoggingImpl();
		int result = ac.add(1, 2);
		System.out.println("-->" + result);
		result = ac.div(4, 2);
		System.out.println("-->" + result);

	}

}
