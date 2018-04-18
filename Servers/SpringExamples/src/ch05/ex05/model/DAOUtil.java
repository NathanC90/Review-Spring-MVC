package ch05.ex05.model;

import ch05.ex05.model.MemberDAO;
import ch05.ex05.model.MemberHibernateDAO;

public class DAOUtil {
	public static MemberDAO getMemberDAO() {
		return new MemberHibernateDAO();
	}
}
