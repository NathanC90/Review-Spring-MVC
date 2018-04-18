package ch05.ex05.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ch05.ex05.model.HibernateUtil;


@WebListener
public class HibernateListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtil.getSessionFactory();
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	HibernateUtil.shutdown();
    }
	
}
