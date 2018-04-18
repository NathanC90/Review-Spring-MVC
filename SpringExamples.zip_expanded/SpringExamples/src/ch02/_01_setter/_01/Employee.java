package ch02._01_setter._01;

public class Employee implements IPerson {
    String name;
    Integer salary;
    Double weight;
    Boolean married;
    String code;
    
	public Employee() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Boolean isMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getComment() {
		return String.format("名字:%-6s 薪水=%3d 體重:%4.1f 已婚:%5s 代號:%s", 
				name, salary, weight, married, code);
	}
	
}
