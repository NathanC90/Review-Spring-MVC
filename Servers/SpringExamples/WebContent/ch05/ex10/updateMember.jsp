<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE HTML>
<html>
<head>
<style>
</style>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
<script type="text/javascript">
  function confirmDelete(userId){
	  var result = confirm("確定刪除此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "DELETE";
	      return true;
	  }
	  return false;
  }
  function confirmUpdate(userId){
	  var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "UPDATE";
	      return true;
	  }
	  return false;
  }
</script>
</head>
<body>
<H1 class='center'>更新會員資料</H1>
<H3 class='center'>OpenSessionInViewFilter版</H3>
<hr>
<p> 
<Form class='center' Action="updateMember.do" method="POST" >
    
    <input type="hidden" name="pk"     value="${param.pk}" >
    <input type="hidden" name="userId" value="${member.userId}${param.userId}" >
    <input type="hidden" name="pswd"   value="${member.password}${param.pswd}" >
    <input type="hidden" name="finalDecision" value="" > 
    <Table>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT">${member.userId}${param.userId}</TD>
         </TR>
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" >
                <input type="text" name="userName" value="${member.name}${param.userName}"  size="30">
                <font color='red' size='-3'>${error.userName}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">EMail：</TD>
             <TD align="LEFT" >
                <input type="text" name="eMail" value="${member.email}${param.eMail}" size="40">
                <font color='red' size='-3'>${error.eMail}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">電話號碼：</TD>
             <TD align="LEFT" > 
               <input type="text" name="tel" value="${member.tel}${param.tel}">
               <font color='red' size='-3'>${error.tel}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">使用Java經驗：</TD>
             <TD align="LEFT" > 
               <input type="text" name="experience" value="${member.experience}${param.experience}" size="3"> 年
               <font color='red' size='-3'>${error.experience}</font>
             </TD>
         </TR>    
        <TR>
            <TD colspan="2" align="center">     
            <input type="submit" value="更新" name='updateBtn' onclick="return confirmUpdate('${member.userId}');"> 
            <input type="submit" value="刪除" name='deleteBtn' onclick="return confirmDelete('${member.userId}');" >
            </TD>
            </TR>
         </Table>
         <c:if test="${not empty requestScope.modify}">   
           <c:remove var="member" scope="request" />       
         </c:if>
</Form>

</body>
<div class='center'>
<br>
<small>&lt;&lt;<a href="${pageContext.request.contextPath}/ch05/ex10/queryAllMembers.do">回上一頁</a>&gt;&gt;</small>
</div>
</html>
