package ch02._01_setter._03.mysql;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppSpringJDBC {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02/_01_setter/_03/mysql/Beans.xml");

		MemberJDBCTemplate memberJDBCTemplate = (MemberJDBCTemplate) 
				           context.getBean("memberJDBCTemplate");

		System.out.println("------ 新增記錄--------");
		Member m1 = new Member("kitty", "111", "周萍", "kitty123@gmail.com",
				"0919-112233", 0);
		memberJDBCTemplate.save(m1);
		m1 = new Member("micky", "222", "米奇潔", "micky456@gmail.com",
				"0929-445566", 1);
		memberJDBCTemplate.save(m1);
		m1 = new Member("snoopy", "333", "史努比", "snoopy789@gmail.com",
				"0939-778899", 5);
		memberJDBCTemplate.save(m1);

		System.out.println("------顯示多筆記錄 --------");
		List<Member> members = memberJDBCTemplate.getAll();
		for (Member member : members) {
			System.out.print("Account : " + member.getUserId());
			System.out.print(", Passwword : " + member.getPassword());
			System.out.print(", Name : " + member.getName());
			System.out.print(", Email : " + member.getEmail());
			System.out.print(", Tel : " + member.getTel());
			System.out.println(", Experience : " + member.getExperience());
		}

		
	}
}
