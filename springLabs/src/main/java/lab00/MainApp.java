package lab00;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {  //一般Java應用程式其組態檔的位置是相對於類別路徑(Classpath)的根目錄
		                                      //而Web應用程式其組態檔的位置是相對於/WEB-INF
		ApplicationContext context = new ClassPathXmlApplicationContext("lab00\\Beans.xml");
		Regard regard = (Regard) context.getBean("hello");
		regard.sayHello();
		//加.class不用進行型別轉換，視情況使用此寫法
		//Regard regard = context.getBean("hello", Regard.class); 
		((ConfigurableApplicationContext)context).close();
	}

}
