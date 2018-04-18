package ch04.sqlserver._00;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
      本程式單憑Spring組態檔就可以建立一個表格。
      優點：快速、簡潔、
      缺點：無法顯示錯誤訊息
*/

public class TableInitMainApp01_SQLServer {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"\\ch04\\sqlserver\\_00\\Beans_SQLServer.xml");
		// 沒有其它的程式碼，但是可以Drop與Create Table，關鍵就在組態檔
		Object o =context.getBean("exec0");
		//o.getClass().getName():傳回存放在變數o內之物件所屬類別全名
		System.out.println(o.getClass().getName() + "-->" + o);
        ((ConfigurableApplicationContext)context).close();       		
	}

}
