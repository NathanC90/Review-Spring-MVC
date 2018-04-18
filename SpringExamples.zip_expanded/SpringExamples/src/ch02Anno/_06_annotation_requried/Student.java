package ch02Anno._06_annotation_requried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
@Component 
public class Student {
    private Integer age;
    private String name;    
    @Required
    @Autowired
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    @Required
    @Autowired
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getDetails(){
    	return "學生: [age=" + age + ", name=" + name + "]";
    }
}
