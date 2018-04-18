<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
<h1 class='center'>會員資料新增成功</h1>
<H3 class='center'>經由JdbcDaoSupport類別間接使用JdbcTemplate類別來簡化DAO類別的設計</H3>
<Font color='blue' >親愛的${ userIdKey }您好，您的輸入資料已經處理完畢</font>
<p/>感謝您加入成為會員，請開始使用本系統<p/>

<div class='center'>
<br>
<small>&lt;&lt;<a href="${pageContext.request.contextPath}/ch05/index.jsp">回第五章首頁</a>&gt;&gt;</small>
</div>

</body>
</html>