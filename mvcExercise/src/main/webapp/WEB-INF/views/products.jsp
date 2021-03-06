<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<section>
	<div>
		<div class="container" style="text-align: center">
			<h1>產品清單</h1>
			<p>本購物商城所有產品資料</p>
		</div>
	</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<section class="contatiner">
	<div class="row">
	<c:forEach var='product' items='${products}'>
		<div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
			<div class="thumbnail" style="width: 320px; height: 340px">
				<img width='100' height='200' src="<c:url value='/getPicture/${product.bookId}' />" />
				<div class="caption">
					<p>
						<b style='font-size: 16px;'>${product.title}</b>
					</p>
					<p>${product.author}</p>
					<p>${product.companyBean.name}</p>
					<c:choose>
					<c:when test='${product.discount != 1.0 }'>
						<p>
							折扣: ${product.discountStr} &nbsp;&nbsp; 實售: <font color='red'>${product.price*product.discount}元</font>
						</p>
						
					</c:when>
					</c:choose>
					<p>庫存數量：<c:out value='${product.stock}' default='0'/>本</p>
					<p><a href="<spring:url value='product?id=${product.bookId}'/>" 
						class= "btn btn-primary"> <span 
						class="glyphicon-info-sigh glyphicon"></span>詳細資料
						</a>
						<a href="<spring:url value='product.xml?id=${product.bookId}'/>" 
						class= "btn btn-primary"> <span 
						class="glyphicon-info-sigh glyphicon"></span>XML
						</a>
						<a href="<spring:url value='product.json?id=${product.bookId}'/>" 
						class= "btn btn-primary"> <span 
						class="glyphicon-info-sigh glyphicon"></span>JSON
						</a>
					</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	</section>

</body>
</html>