package test;

import java.util.Properties;
import java.util.Set;

public class SystemPropertiesDemo {

	//�d�������ܼ�
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		Set<Object> set = prop.keySet();
		for(Object obj : set) {
			System.out.println(obj + "=" + prop.get(obj));
		}
		

	}

}
