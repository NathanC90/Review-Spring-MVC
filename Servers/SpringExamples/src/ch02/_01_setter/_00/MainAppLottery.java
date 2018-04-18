package ch02._01_setter._00;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppLottery {
	public static void main(String[] args) {
//      傳統Java類別轉換為受Spring框架控管的Bean元件
//      Java程式碼: 
//		   ILottery lottery = new LotteryBeanNumberUnique();
//		   lottery.setLowerBound(1);   // setter，性質名稱為lowerBound
//		   lottery.setUpperBound(10);  // setter，性質名稱為upperBound
//		   lottery.setBallNumber(6);   // setter，性質名稱為ballNumber
//				
//  1. 將 new Java類別()轉換為<bean....>標籤，id屬性可以是物件名稱，class屬性就是
//     『Java類別的全名』。
//     <bean id="lottery" class="ch02._01_setter._00.LotteryBeanNumberUnique">
//  2. 將setter()方法轉換為<property....>標籤，setter方法所對應之性質名稱
//     就是name屬性的值，setter方法的參數值就是value/ref屬性的值。。
//     <property name="lowerBound" value="1"/>
//     <property name="upperBound" value="10"/>
//     <property name="ballNumber" value="6"/>
//  3. 這些<property>標籤會出現在<bean>標籤body內
//  4. 轉換結果
//     <bean id="lottery" class="ch01.adv01.LotteryBeanNumberUnique">
//         <property name="lowerBound" value="1"/>
//         <property name="upperBound" value="10"/>
//         <property name="ballNumber" value="6"/>
//     </bean>

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02/_01_setter/_00/Beans.xml");
		ILottery lottery = (ILottery) context.getBean("lottery");
		
		Collection<Integer> coll = lottery.getLuckyNumbers();
		System.out.println(coll);
		
		((ConfigurableApplicationContext)context).close();
	}
}