package ch03._03_lazy_init;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("ch03/_03_lazy_init/Beans.xml");
        System.out.println("--------------容器初始化完畢---------------------");
        pause();
        System.out.println("-------開始取出Student物件-------");
        Student mary = (Student) context.getBean("student");
        System.out.println("Student: " + mary);
        ((ConfigurableApplicationContext)context).close();
    }
    private static void pause() {
        try {
            Thread.sleep(5000);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }    
}

