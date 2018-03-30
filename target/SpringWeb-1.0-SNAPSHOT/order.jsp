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
		    <th>订单编号</th>
		    <th>用户ID</th>
			<th>地址</th>
			<th>订单总价</th>
			<th>支付方式</th>
			<th>邮费</th>
			<th>订单状态</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>用户操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageModel.data}" var="order">

			<tr>
				<td>${order.order_no}</td>
				<td>${order.user.username}</td>		
				<td>${order.shipping_id}</td>		
				<td>${order.payment}</td>		
				<td>${order.payment_type}</td>		
				<td>${order.postage}</td>
				<td>${order.status}</td>
				<td>${order.create_time}</td>
				<td>${order.update_time}</td>						
				<td><a href="deleteaddress?userid=${address.userid}&receivercity=${address.receivercity}">删除</a> <a
					href="updateaddress?userid=${address.userid}&receivercity=${address.receivercity}">修改</a></td>
			</tr>

		</c:forEach>
				</tbody>
			</table>
			<c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">
     
      <a href="findorderservlet?pageNo=${pageNo}">${pageNo}</a>
     
    </c:forEach>
		</div>
	</div>
</div>
</body>
</html>