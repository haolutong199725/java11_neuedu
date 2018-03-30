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
<a href="insertaddress">添加地址</a>
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
		    <th>用户ID</th>
		    <th>收货人</th>
			<th>电话</th>
			<th>手机</th>
			<th>省份</th>
			<th>城市</th>
			<th>操作地址</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageModel.data}" var="address">

			<tr>
				<td>${address.userid}</td>
				<td>${address.receivername}</td>		
				<td>${address.receiverphone}</td>		
				<td>${address.receivermobile}</td>		
				<td>${address.receiverprovince}</td>		
				<td>${address.receivercity}</td>					
				<td><a href="deleteaddress?userid=${address.userid}&receivercity=${address.receivercity}">删除</a> <a
					href="updateaddress?userid=${address.userid}&receivercity=${address.receivercity}">修改</a></td>
			</tr>

		</c:forEach>
				</tbody>
			</table>
			<c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="findalladdress?page=${pageNo}">${pageNo}</a>
     
    </c:forEach>
		</div>
	</div>
</div>
</body>
</html>