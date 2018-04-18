package ch07._03_aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
@Aspect
public class DataValidationAspect {
//    @Before("execution (* ch07._03_aspectj.*.*(..)) ")
    @Before("execution (public int ch07._03_aspectj.ArithmeticCalculator.*(int, int))" )
	public void validateAdvice(JoinPoint jp){
    	String methodName = jp.getSignature().getName();
    	Object[] args = jp.getArgs();
		System.out.println("在DataValidationAspect ,方法 " + methodName + " 開始執行，傳入的參數為 " 
				+ Arrays.asList(args));
	}
}
