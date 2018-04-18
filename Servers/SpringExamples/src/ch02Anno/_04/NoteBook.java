package ch02Anno._04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component("notebook")
@PropertySource("/ch02Anno/_04/propertyFile.properties")
public class NoteBook implements Computer {
	
	// 使用SpEL的語法取出定義在propertyFile.properties中，key為 brandname 所對應的值
	// 會被注入到String brand來
	@Value("${brandname}") 
	String brand;
	
	@Value("${price}") 
    Integer price;
	
	@Value("${weight}") 
    Double weight;
	
	@Value("${size}")
	Double size;
	
	public NoteBook() { 	
	}
	
	@Override
	public String getDescription() {
		return String.format("廠牌:%-6s 價格=%6d 重量:%5.1f公斤  尺寸:%5.1f寸 \n", 
				brand, price, weight, size);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("in @PostConstruct方法中");
	}
	
	@PreDestroy      
	public void destroy() {
		System.out.println("in @PreDestroy方法中");
	}
}
