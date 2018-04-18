<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta charset="UTF-8">
<title>Spring 對Web Application的支援</title>
</head>
<body>
<h1>Spring 對Web Application的支援</h1>
<a href='ex00/HelloWebApp.do'>顯示訊息</a><p/>
<a href='ex01/form.jsp'>新增會員資料(直接使用JdbcTemplate類別)</a><p/>
<a href='ex02/queryAllMembers.do'>查詢會員資料(直接使用JdbcTemplate類別)</a><p/>
<p/>
<a href='ex03/form.jsp'>新增會員資料(JdbcDAOSupport類別)</a><p/>
<a href='ex04/queryAllMembers.do'>查詢會員資料(JdbcDAOSupport類別)</a><p/>
<p/>
<a href='default.jsp'>Open Session in View(Hibernate與Spring的結合)</a><p/>
</body>
</html>