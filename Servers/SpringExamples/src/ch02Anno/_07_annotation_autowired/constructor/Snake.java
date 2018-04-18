package ch02Anno._07_annotation_autowired.constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("kaa")
public class Snake {
	private Integer age;
	private Double length;
	private String name;
	private PetHouse pethouse	;
	@Autowired
	public Snake(Integer age, String name, PetHouse pethouse, Double salary) {
		super();
		this.age = age;
		this.name = name;
		this.pethouse = pethouse;
		this.length = salary;
	}	

	public String toString(){
		return "姓名: " + name + "\n" +
			   "年齡: " + age + "\n" + 
			   "長度: " + length + "公分\n" +
			   "Pethouse: " + pethouse.size + "\n" ;
	}
	
}
