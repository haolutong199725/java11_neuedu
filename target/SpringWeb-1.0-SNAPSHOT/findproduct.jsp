<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
		    <th>商品ID</th>
		    <th>商品名称</th>
			<th>商品图片</th>
			<th>价格</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${product}" var="address">

			<tr>
				<td>${address.product_id}</td>
				<td>${address.product_name}</td>		
				<td>${address.product_image}</td>		
				<td>${address.product_price}</td>							
				<td><a href="deleteaddress">删除</a> <a
					href="updateaddress">修改</a></td>
			</tr>

		</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</body>
</html>