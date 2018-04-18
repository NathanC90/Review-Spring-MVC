<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta charset="UTF-8">
<title>Spring在WebApplication的支援</title>
</head>
<body>
<h1>Spring在WebApplication的支援</h1>
<ol>
<li>在Web應用程式中，程式應採用WebApplicationContext介面而不要使用ApplicationContext介面，
因為WebApplicationContext介面具有下列方法:<p>
ServletContext	getServletContext()</p>
因此它可以與底層的Web Container直接溝通。
</li>
<li>要取得WebApplicationContext型別的物件必須經由Spring的幫助</li>
</ol>
</body>
</html>