package ch02Anno._05;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppLottery {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02Anno/_05/Beans.xml");

		ILottery lotteryUNI = (ILottery) context.getBean("uni");
		Collection<Integer> collUNI = lotteryUNI.getLuckyNumbers();
		System.out.println(collUNI);

		ILottery lotteryDUP = (ILottery) context.getBean("dup");
		Collection<Integer> collDUP = lotteryDUP.getLuckyNumbers();
		System.out.println(collDUP);
		
		((ConfigurableApplicationContext)context).close();
	}
}