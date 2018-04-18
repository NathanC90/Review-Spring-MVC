package ch05.ex00.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch05.ex00.SystemMessage;

@WebServlet("/ch05/ex00/HelloWebApp.do")
public class HelloWebApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		ApplicationContext context = WebApplicationContextUtils.
	                getWebApplicationContext(sc);
		SystemMessage sys = context.getBean(SystemMessage.class);
	    request.setAttribute("message", sys.getMessage());
	    RequestDispatcher  rd  = request.getRequestDispatcher("/ch05/ex00/ShowMessage.jsp");
	    rd.forward(request, response);
	    return;
	}
}
