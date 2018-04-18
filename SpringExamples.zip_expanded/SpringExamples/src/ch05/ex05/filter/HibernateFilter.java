//package ch05.ex05.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import ch05.ex05.model.HibernateUtil;
//
///**
// * Servlet Filter implementation class HibernateFilter
// */
//@WebFilter(urlPatterns={"/*"})
//public class HibernateFilter implements Filter {
//    private SessionFactory factory = null;
//    private FilterConfig config = null;
//    
//    public HibernateFilter() {
//
//    }
//
//	public void destroy() {
//
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		Transaction tx = null;
//		try {
//			tx = factory.getCurrentSession().beginTransaction();
//			chain.doFilter(request, response);
//			tx.commit();
//		} catch(Exception ex){
//			System.out.println(ex.getMessage());
//			if (tx!=null){
//				tx.rollback();
//			}
//		}
//		
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//		this.config = fConfig;
//		factory = HibernateUtil.getSessionFactory();
//	}
//
//}
