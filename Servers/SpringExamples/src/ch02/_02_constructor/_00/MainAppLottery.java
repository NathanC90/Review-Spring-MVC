package ch02._02_constructor._00;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppLottery {
	public static void main(String[] args) {
/*		
  傳統Java類別轉換為受Spring框架控管的Bean元件
       對應的Java程式碼
   ILottery lottery = new LotteryBeanNumberDuplicated(1,10, 6);
   
   Constructor Injection轉換步驟 : 
 1. 將 new Java類別(參數1, 參數2, ...)轉換為<bean....>標籤，id屬性可以是物件名稱，class屬性就是
    『Java類別的全名』。
     <bean id="lottery" class="cch02._02_constructor._00.LotteryBeanNumberUnique">
 2. 將建構子內每個參數分別轉換為<constructor-arg index='參數的編號' value='參數的值' />標籤，
    <constructor-arg index='0' value='1'/>
    <constructor-arg index='1' value='16'/>
	<constructor-arg index='2' value='5'/>
 3. 這些<constructor-arg>標籤會出現在<bean>標籤body內
 4. 轉換結果
    <bean id="lottery" class="ch02._02_constructor._00.LotteryBeanNumberUnique">
       <constructor-arg index='0' value='1'/>
	   <constructor-arg index='1' value='16'/>
	   <constructor-arg index='2' value='5'/>
	</bean>
		
*/		
//		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02/_02_constructor/_00/Beans.xml");
		ILottery lottery = (ILottery) context.getBean("lottery");
		Collection<Integer> coll = lottery.getLuckyNumbers();
		System.out.println(coll);
		
		((ConfigurableApplicationContext)context).close();
	}
}