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
<CENTER>
<H1>加入會員</H1>
<H3>(利用 Hibernate+Spring來進行資料庫存取)</H3>

<HR>
<Form Action="register0509.do" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT">
                <input	type="text" name="userId" value="${param.userId}" size="20">
                <font color='red' size='-3'>${error.userId}</font>
             </TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" >
                <input	type="password" name="pswd" value="${param.pswd}" size="20">
                <font color='red' size='-3'>${error.pswd}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" >
                <input	type="text" name="userName" value="${param.userName}"  size="30">
                <font color='red' size='-3'>${error.userName}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">eMail：</TD>
             <TD align="LEFT" >
                 <input type="text" name="eMail" value="${param.eMail}" size="40">
                 <font color='red' size='-3'>${error.eMail}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">電話號碼：</TD>
             <TD align="LEFT" > 
               <input type="text" name="tel" value="${param.tel}">
               <font color='red' size='-3'>${error.tel}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">使用Java經驗：</TD>
             <TD align="LEFT" > 
                <input type="text" name="experience" value="${param.experience}" size="3"> 年
                <font color='red' size='-3'>${error.experience}</font>
              </TD>
         </TR>    
        <TR>
            <TD colspan="2" align="center">      <input type="submit" value="提交"> </TD>
            </TR>
         </Table>
</Form>
</CENTER>
</body>
<jsp:include page="/commons/previousPage.jsp" />
</html>
