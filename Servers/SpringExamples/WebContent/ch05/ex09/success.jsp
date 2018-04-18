<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>



<body>
<div class='center'>
<h1>利用 Hibernate來進行資料庫存取</h1>
<h3>新增資料至資料庫時，如新增成功, 以success.jsp來顯示本畫面)</h3>
</div>
<Font color='blue' >親愛的${ userIdKey }您好，您的輸入資料已經處理完畢</font>
<p/>感謝您加入成為會員，請開始使用本系統<p/>
<div class='center'>
<a href="${pageContext.request.contextPath}/ch05/default.jsp" >回前頁</a>
</div>
</body>
</html>