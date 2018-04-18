package ch05.ex10;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch05.ex09.model.Member;
import ch05.ex09.model.MemberDAO;
/*  
 * 本程式經由Hibernate來存取資料庫
 */
@WebServlet("/ch05/ex10/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
//		MemberDAO dao = DAOUtil.getMemberDAO();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberDAO dao = (MemberDAO)context.getBean("memberDAO0509");
		// 可以是Session的get()或load()方法
		//Member member = dao.getMember(ipk);
		Member member = dao.loadMember(ipk);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
