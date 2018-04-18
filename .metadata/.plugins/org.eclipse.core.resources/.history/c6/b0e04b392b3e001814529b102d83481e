package ch01.model;

import java.util.List;

public class MemberService {

	public boolean isDup(String id) {
		//MemberHibernateDAO dao = new MemberHibernateDAO();
		MemberDAO dao = new MemberJDBCDAO();
		return dao.isDup(id);
	}

	public int save(MemberBean mb) {
		//MemberHibernateDAO dao  = new MemberHibernateDAO();
		MemberDAO dao = new MemberJDBCDAO();
		return dao.save(mb);
		
	}

	public List<MemberBean> getAllMembers() {
		//MemberHibernateDAO dao  = new MemberHibernateDAO();
		MemberDAO dao = new MemberJDBCDAO();
		return dao.getAllMembers();
	}

	public MemberBean getMember(int pk) {
		//MemberHibernateDAO dao  = new MemberHibernateDAO();
		MemberDAO dao = new MemberJDBCDAO();
		return dao.getMember(pk);
	}

	public int deleteMember(int ipk) {
		//MemberHibernateDAO dao  = new MemberHibernateDAO();
		MemberDAO dao = new MemberJDBCDAO();
		return dao.deleteMember(ipk);
	}

	public int updateMember(MemberBean mb) {
		//MemberHibernateDAO dao  = new MemberHibernateDAO();
		MemberDAO dao = new MemberJDBCDAO();
		return dao.updateMember(mb);
	}

}
