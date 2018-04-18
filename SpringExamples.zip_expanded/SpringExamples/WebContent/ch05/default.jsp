<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<title>MVC架構</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />
<h2 align="center">OpenSessionInViewFilter</h2>
<div align="center">
<table border="1">
  <!-- ================================ -->
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex09/ch05_ex09_form.jsp">新增會員資料(Hibernate+Spring)</a><BR>
      <font face="verdana" size="-2">
      webapp/ch05/ex09/*.jsp<BR>
      ch05.ex09.*.java
      </font>
    </td>
    <td  width="350"><p align="left">
      <a href="ex10/queryAllMembers.do">查詢會員資料(Hibernate+Spring)</a><BR>
      <font face="verdana" size="-2" color='red'>
               採用OpenSessionInViewFilter來解決Lazy Loading的問題
      </font><br>
      <font face="verdana" size="-2">
      webapp/ch05/ex10/*.jsp, ch05.ex10.*.java
      </font>
    </td>
  </tr>
  <!-- ================================ -->
  
</table>
</div>
<hr>
<div class='center'>
<br>
<small>&lt;&lt;<a href="${pageContext.request.contextPath}/ch05/index.jsp">回第五章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>
