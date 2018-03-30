<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
</script>
</head>

<body>
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<form role="form" action="updatevo" method="post">
			<table class="table">
				<thead>
					<tr>
		    <th>订单号</th>
			<th>订单总价</th>
			
			
			<th></th>
			<th >订单详情</th>
					</tr>
				</thead>
				<tbody>
		<c:forEach items="${pageModel}" var="address">
                 
			<tr>
				<td>1520499394166${address.id}</td>	
				<td>${address.payment}</td>
				<td></td>
				<td>商品名称</td>
				<td>商品图片</td>
				<td>商品数量</td>
			</tr>
			 <c:forEach items="${address.orderItems}"  var="items">
			<tr >
			<td></td>
			<td></td>
			<td></td>
			<td>${items.product_name}</td>
			<td>${items.product_image}</td>
			<td>${items.quantity}</td> 
			</tr>
             </c:forEach>
		</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>
</body>

</html>