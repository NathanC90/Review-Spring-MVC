package ch05.ex02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch05.ex00.model.Member;
import ch05.ex00.model.MemberDAO;


@WebServlet("/ch05/ex02/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession hsession = request.getSession();
		Map<String, String>  errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberDAO dao = (MemberDAO)context.getBean("memberDAOJdbcTemplate");
		int count = 0 ;
		
		if (modify.equalsIgnoreCase("DELETE")) {
			count = dao.delete(ipk);
			if (count == 1){
				hsession.setAttribute("modify", "刪除成功");
			} else {
				hsession.setAttribute("modify", "刪除時發生異常");
			}
		} else if (modify.equalsIgnoreCase("UPDATE")) {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("userName");
			String mail = request.getParameter("eMail");
			String birthday = request.getParameter("birthday");
			String expericnceStr = request.getParameter("experience");
			
			// 2. 進行必要的資料轉換
			int experience = 0;
			try {
				experience = Integer.parseInt(expericnceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("experience", "使用Java經驗格式錯誤，應該為整數");
			}
			// 3. 檢查使用者輸入資料
			if (userId == null || userId.trim().length() == 0) {
				errorMsg.put("userId", "帳號欄必須輸入");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("pswd", "密碼欄必須輸入");
			}
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("userName", "姓名欄必須輸入");
			}
			if (mail == null || mail.trim().length() == 0) {
				errorMsg.put("eMail", "EMail欄必須輸入");
			}
			java.sql.Date bday = null; 
			if (birthday == null || birthday.trim().length() == 0) {
				errorMsg.put("birthday","生日欄必須輸入");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				try {
					bday = new java.sql.Date(sdf.parse(birthday.trim()).getTime());
				} catch(Exception ex){
					errorMsg.put("birthday","生日欄格式錯誤");
				}
			}
			if (experience < 0) {
				errorMsg.put("experience", "使用Java經驗應該為正整數或 0 ");
			}
			if (experience > 99) {
				errorMsg.put("experience", "使用Java經驗不應該超過99");
			}
			System.out.println("password:" + password);
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("ex02/updateMember.jsp");
				rd.forward(request, response);
				return;
			}
			
			Member m = new Member(userId, password, name, mail, bday, experience);
			m.setPk(ipk);
			count = dao.update(m);
			if (count == 1){
				hsession.setAttribute("modify", "修改成功");
			} else {
				hsession.setAttribute("modify", "修改時發生異常");
			}
		} 		
		response.sendRedirect(request.getContextPath() + "/ch05/ex02/queryAllMembers.do");
	}
}
