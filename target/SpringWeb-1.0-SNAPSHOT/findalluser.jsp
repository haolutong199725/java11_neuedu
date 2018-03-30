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
		    <th>用户ID</th>
		    <th>用户名</th>
			<th>密码</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${user}" var="address">

			<tr>
				<td>${address.userid}</td>
				<td><a href="findalladdress?userid=${address.userid}">${address.username}</a></td>		
				<td>${address.password}</td>							
				<td><a href="#">删除</a> <a
					href="#">修改</a></td>
			</tr>

		</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>