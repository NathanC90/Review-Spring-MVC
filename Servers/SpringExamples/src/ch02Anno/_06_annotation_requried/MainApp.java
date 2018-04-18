package ch02Anno._06_annotation_requried;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext
                ("\\ch02Anno\\_06_annotation_requried\\Beans.xml");
                  
        Student c = context.getBean(Student.class);
        System.out.println(c.getDetails());
        
        ((ConfigurableApplicationContext)context).close();
    }    
}

