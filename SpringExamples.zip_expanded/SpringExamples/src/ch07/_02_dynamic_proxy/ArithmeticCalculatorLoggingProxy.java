package ch07._02_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import ch07._01_without_aop.interfaces.ArithmeticCalculator;

public class ArithmeticCalculatorLoggingProxy {
	
	// 要代理的物件為何? 
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getLoggingProxy(){
	   	ArithmeticCalculator proxy = null;
	    
	   	// 代理物件所屬類別由哪一個ClassLoader載入
	   	ClassLoader loader = target.getClass().getClassLoader();
	   	// 代理物件屬於類別要實作的介面，這些父代定義的方法都是
	   	// 代理物件可以使用的方法
	    Class[] interfaces = new Class[]{ArithmeticCalculator.class};
	    
	    // 當呼叫代理物件的方法時，要執行的程式碼
	    InvocationHandler h = new InvocationHandler() {
			@Override
			/**
			 * proxy	: 返回的代理物件, 這個代理物件將實作
			 * 
			 * method	: 呼叫的方法
			 * 
			 * args		: 傳入的參數
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
				Object o = null;
				
				try {
					// 前置通知
					o = method.invoke(target, args);
					// 返回通知，可以得到方法的傳回值
				} catch (Exception e) {
					e.printStackTrace();
					// 例外通知，可以得到方法丟出的例外
				}
                // 後置通知：由於方法可能丟出例外，因此無法得到方法的傳回值
				System.out.println("The method " + methodName + " ends with " + o);
				return o;	
			}
		};
	   	proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h); 
	   	System.out.println("proxy=" + proxy.getClass().getName());
	   	return proxy;
	}
}
