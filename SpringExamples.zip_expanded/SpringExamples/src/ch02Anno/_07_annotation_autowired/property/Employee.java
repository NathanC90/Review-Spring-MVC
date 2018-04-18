package ch02Anno._07_annotation_autowired.property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {
	@Autowired
	private Integer age;
	@Autowired
	private Double salary;
	@Autowired
	private String name;
	@Autowired
	private PetHouse pethouse	;
	
	public Employee(){}
	
	public String toString(){
		return "姓名: " + name + "\n" +
			   "年齡: " + age + "\n" + 
			   "薪水: " + salary + "\n" +
			   "Pethouse: " + pethouse.size + "\n" ;
	}
	
}
