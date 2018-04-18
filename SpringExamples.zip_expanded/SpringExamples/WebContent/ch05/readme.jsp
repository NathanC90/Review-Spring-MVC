<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OpenSessionInViewFilter</title>
</head>
<body>
使用Spring提供的OpenSessionInViewFilter來解決Lazy Loading問題的注意事項：
<ol>
<li>在/WEB-INF/applicationContext.xml檔案內定義：
    <ul>
    <li>dataSource的&lt;bean&gt;標籤(採用...jndi.JndiObjectFactoryBean類別)</li>
    <li>sessionFactory的&lt;bean&gt;標籤(採用....orm.hibernate4.LocalSessionFatoryBean)</li>
    	定義此標籤時要加一個非常重要的&lt;property&gt;標籤，如下：<br>
    	&lt;property name="configLocation" value="classpath:hibernate.cfg.xml"/&gt;
    	<br>此標籤通知Spring，Hibernate的組態檔的位置。由於我們已經定義了
    	dataSource標籤，所以該檔案內的連線資訊必須註解。
    <li>你設計之DAO類別的&lt;bean&gt;標籤，你的DAO類別必須注入前一項的 sessionFactory bean</li>
    </ul>
</li>
<li>在web.xml檔案內定義&lt;filter&gt;標籤如下：<br>
<c:set var='x'>
   <filter>
  <filter-name>HibernateFilter</filter-name>
  <filter-class>org.springframework.orm.hibernate4.support.OpenSessionInViewFilter</filter-class>
  <init-param>
     <param-name>sessionFactoryBeanName</param-name>
     <param-value>sessionFactory</param-value>
  </init-param>
  </filter>
  <filter-mapping>
  <filter-name>HibernateFilter</filter-name>
     <url-pattern>/ch05/ex09/*</url-pattern>
     <url-pattern>/ch05/ex10/*</url-pattern>
  </filter-mapping>
</c:set>
<pre>
<c:out value='${x}'/>
</pre>
其中的&lt;param-value&gt;標籤必須與前面的sessionFactory標籤的id屬性一致(sessionFactory)

</li>
<li>在web.xml檔案內要定義org.springframework.web.context.ContextLoaderListener，
    讓Spring在初始化之後能夠自動建立WebApplicationContext物件，同時讀入位於WEB-INF/applicationContext.xml組態檔
</li>
<li>修改DAO類別(1)加入public SessionFactory geSessionFactory() 與public void setSessionFactory(SessionFactory factory)
方法，(2)然後去除所有與Transaction有關，與例外有關的敘述。請參考ch05.ex09.model.MemberHibernateDAO.java
</li>
</ol>
</body>
</html>