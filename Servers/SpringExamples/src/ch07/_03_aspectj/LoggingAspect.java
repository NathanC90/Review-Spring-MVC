package ch07._03_aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect; // 需要 aspectjrt.jar
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 設計Aspect切面的步驟: 
// 步驟一：將此類別宣告為一個切面：必須加入兩個註釋 @Component與 @Aspect
// 步驟二：通知IoC容器，哪些類別的那些方法被執行之前或之後，本切面的哪個方法需要執行
//		  @Before, @After, @.....  		
// 步驟三：於組態檔要加入<aop:aspectj-autoproxy/>，目的在開啟切面類別中的註釋功能，
// 為匹配的類別自動產生代理物件

@Order(0)
@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution (public int ch07._03_aspectj.ArithmeticCalculator.*(int, int))")
	public void dummy() {
		
	}
//	@Before說明本通知為一個前置通知：在監控(即目標)方法開始執行之前，先執行此通知
//	注意：在@Before內之Pointcut Expression，不可以寫出方法的形式參數名稱，即不要寫參數的名稱，即(int, int)
//   	
//	
//	@Before("execution (public int ch07._03_aspectj.ArithmeticCalculator.*(int, int))")
//	public void beforeMethod(JoinPoint joinPoint) {
//		String methodName = joinPoint.getSignature().getName();
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		System.out.println("方法 " + methodName + " 開始執行，傳入的參數為 " + args);
//	}
//
//	JoinPoint: 可得到與被監控方法有關的細節，如被監控方法的方法名稱與參數：
//  被監控方法的名稱：JoinPoint#getSignature().getName();
//  被監控方法的參數：JoinPoint#getArgs();	
//		
	
//	@After說明本通知為一個後置通知：在監控(即目標)方法開始執行之後，執行此通知。
//	無論是否丟出例外，都要執行本通知。
//	注意：在後置通知中無法得到目標方的傳回值，因為目標方法也許丟出例外而沒有傳回值。
//	傳回值必須在返回通知內取得。
// 	
	@After("dummy()")
//	@After("execution (public int ch07._03_aspectj.ArithmeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("方法 " + methodName + " 結束執行");
	}

//	@AfterReturning說明本方法為一個返回通知：在監控(即目標)方法正常結束之後，執行此通知。
//	若監控方法丟出例外，則不會執行本通知。
//	注意：返回通知可取得方法的傳回值。

//	@AfterReturning()有兩個屬性：value與returning。returning屬性定義一個可以傳入方法傳回值的參數給advice。
//	因此返回通知可以定義兩個參數：
//	(1)JoinPoint，參數名稱自定
//	(2)代表傳回值的 Object， 參數名稱必須為returning屬性定義的屬性值
//	
//	@AfterReturning(
//      	value = "execution (public int ch07._03_aspectj.ArithmeticCalculator.*(..))", 
//			returning = "result")
//	
//	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
//		String methodName = joinPoint.getSignature().getName();
//	    System.out.println("方法 " + methodName + " 結束執行，傳回值為" + result);
//	}
//
//	@AfterThrowing 說明本方法為一個例外通知，在監控(即目標)方法丟出例外後，執行此通知。若監控方法未丟出例外，則不會執行本通知。
//	 可以得到方法丟出的例外物件。
//	我們可以指定參數ex的型態(如 NullPointException)來篩選程式有興趣的例外
//
//	@AfterThrowing(value = "execution (public int ch07._03_aspectj.ArithmeticCalculator.*(..))", 
//			throwing = "ex")
//  @AfterThrowing()有兩個屬性: value與throwing。throwing屬性定義一個可以傳入方法發生之例外的參數給advice。
//	因此例外通知可以定義兩個參數：
//	(1)JoinPoint，參數名稱自定
//	(2)代表例外物件的 Throwable， 參數名稱必須為throwing屬性定義的屬性值，
//	
//	我們可以更換參數ex的型態(如 NullPointException)來篩選程式有興趣的例外。當出現
//  特定的例外時才執行此通知。	
	public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("方法 " + methodName + " 丟出例外: " + ex);
		System.out.println("---------------------------------");
	}
//	
// @Around說明本方法為一個環繞通知，環繞通知必須定義ProceedingJoinPoint型態的參數 ，
// 	此參數可決定是否要執行目標方法。環繞通知一定需要定義傳回值，此傳回值即為目標方法的
//	傳回值。
// 
//	環繞通知可取代前面四個通知，功能最強，但除非同時需要處理四種通知，否則不一定需要使用此種類型的通知
//	
//	@Around(value = "execution (public int ch07._03_aspectj.ArithmeticCalculator.*(..))")
//
//	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
//		Object result = null;
//		String methodName = pjp.getSignature().getName();
//		List<Object> args = Arrays.asList(pjp.getArgs());
//		try {
//			// 此處的程式碼地位等同於前置通知
//			System.out.println("方法 " + methodName + " 開始執行(Around)，傳入的參數為 " + args);
//			result = pjp.proceed();  // 執行目標方法
//			// 此處的程式碼地位等同於返回通知，返回通知可以取得方法的傳回值，除非方法丟出例外。
//			System.out.println("方法 " + methodName + " 結束執行(Around)，傳回值為" + result);
//		} catch (Throwable ex) {
//			// 此處的程式碼地位等同於例外通知，可以得到方法丟出的例外
//			ex.printStackTrace();
//			System.out.println("方法 " + methodName + " 丟出例外(Around): " + ex);
//		}
//		// 此處的程式碼地位等同於後置通知
//		// 由於監控方法可能丟出例外，因此後置通知無法取得傳回值
//		System.out.println("方法 " + methodName + " 結束執行(Around)");
//		return result;
//	}
	// 指定切面之執行的優先順序(Advice execution precedence)：
	// 在切面之前使用 @Order(一個整數，正數、負數與零皆可)來指定執行的優先順序，值越小，
	// 越先執行。數值相同，
	//
	
	// 重複使用切點(Pointcut)運算式：
	// 當多個通知使用相同的切點(Pointcut)運算式時：
	// 1. 定義一個方法(Dummy)，它僅用來定義切點(Pointcut)運算式，方法的Body保持
	// 空白即可。
	// 2. 在它之前使用@Pointcut註釋來定義切點運算式，定義的方式與一般的定義方式相同。
	// 
	
}
