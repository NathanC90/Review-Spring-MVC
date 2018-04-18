package ch02Config._00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ch02Config._00.model.Book;

// 本檔案的內容相當於一個xml組態檔

@Configuration
public class BookConfig {
	@Value("快樂學Spring")
	String title;
	@Value("500")
	int price;
	@Value("18")
	int stock;

	@Bean
	// @Scope("singleton")
	@Scope("prototype")
	// 本方法等同於一個<bean>標籤，方法名稱就是bean的name屬性值，傳回值的型態就是bean的class屬性值。
	// Spring容器會依下列定義產生一個Book物件(singleton)或多個Book物件(prototype)
	// 程式使用"noname"來取出本物件
	public Book noname() {
		return new Book();
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	// @Scope("singleton")
	@Scope("prototype")
	// 本方法等同於一個<bean>標籤，方法名稱就是bean的name屬性值，傳回值的型態就是class屬性值。
	// Spring容器會依下列定義產生一個Book物件(singleton)或多個Book物件(prototype)
	// 程式使用"spring"來取出本物件
	@Autowired
	public Book spring() {
		return new Book(title, price, stock);
	}
}
