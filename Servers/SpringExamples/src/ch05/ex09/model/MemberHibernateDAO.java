package ch05.ex09.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//本範例之Session使用方式為Session-per-Request，一個Http請求所包含之所有資料庫
//的操作如新增、刪除、查詢、修改等全部組成一個Transaction，放在一個Session內。
//修改的步驟如下：
//(1)組態檔hibernate.cfg.xml內的hibernate.current_session_context_class屬性要
//設為thread：
// <property name="hibernate.current_session_context_class">thread</property>
//(2)新建一個Filter類別，在init()方法內取出SessionFactory物件，放入實例變數
//   factory內：
//   在doFilter()方法內編寫下列程式碼：
/*
 Transaction tx = null;
 try {
 tx = factory.getCurrentSession().beginTransaction();
 chain.doFilter(request, response);
 tx.commit();
 } catch(Exception ex){
 System.out.println(ex.getMessage());
 if (tx!=null){
 tx.rollback();
 }
 }
 */
//(3)DAO類別內的每個方法取出Session物件的方式要改為: 
//   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//   並刪除所有與交易有關的敘述與try-catch-finally區塊，只保留try區塊內的敘述
//
//


import ch05.ex09.model.Member;
import ch05.ex09.model.MemberDAO;

public class MemberHibernateDAO implements MemberDAO {
	SessionFactory factory;

	public MemberHibernateDAO() {
	}

	public SessionFactory geSessionFactory() {
		return factory;
	}

	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public boolean idExists(String id) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		List<?> list = session.createQuery("from Member where userId = ?")
				.setString(0, id).list();
		if (list.size() > 0) {
			exist = true;
		}
		return exist;
	}

	// 新增一筆Member物件到資料庫
	public int saveMember(Member mem) {
		Session session = factory.getCurrentSession();
		int updateCount = 0;
		session.save(mem);
		updateCount = 1;
		session.flush();
		return updateCount;
	}
	//
	// 經由Session介面的load()查詢資料庫內的紀錄
	// ch05.ex10.controller.FindMemberServlet會呼叫本方法
	public Member loadMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		Integer ipk = Integer.valueOf(pk);
		member = (Member) session.load(Member.class, ipk);
		System.out.println("Lazy Loading OK");
		session.flush();
		return member;
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	// ch05.ex10.controller.FindMemberServlet會呼叫本方法
	public Member getMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		Integer ipk = Integer.valueOf(pk);
		member = (Member) session.get(Member.class, ipk);
		return member;
	}

	// 更新紀錄
	public int updateMember(Member mem) {
		int count = 0;
		Member member = null;
		Session session = factory.getCurrentSession();
		// // 更新方法一
		member = (Member) session.get(Member.class, mem.getPk());
		member.setEmail(mem.getEmail());
		member.setExperience(mem.getExperience());
		member.setName(mem.getName());
		member.setTel(mem.getTel());
		session.update(member);
		session.flush();
		count++;
		return count;
	}

	// 刪除紀錄
	public int deleteMember(String pk) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Integer ipk = Integer.valueOf(pk);
		Member mem = new Member(ipk);
		session.delete(mem);
		session.flush();
		count++;
		return count;
	}

	// 查詢所有紀錄
	@SuppressWarnings("unchecked")
	public Collection<Member> getAllMembers() {
		List<Member> allMembers = new ArrayList<Member>();
		Session session = factory.getCurrentSession();
		allMembers = session.createQuery("from Member").list();
		return allMembers;
	}
}
