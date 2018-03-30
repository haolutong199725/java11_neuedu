<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
 div{
   margin-left:0px
 }

</style>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel panel-default">
				<div class="panel-body">
					<h3 class="panel-title">
						商品操作
					</h3>
				</div>
				<div class="panel-footer">
					<a href="product.jsp?userid=${userid}" target="right">商品浏览</a>
				</div>
				<div class="panel-footer">
					<a href="findcart?userid=${userid}" target="right">购物车</a>
				</div>
				<div class="panel-footer">
				<a href="findallproduct" target="right">查询所有商品</a>
				</div>
				<div class="panel-footer">
				<a href="addproduct.jsp" target="right">添加新商品</a>
				</div>
				<div class="panel-footer">
				<a href="typeservice" target="right">查询所有商品种类</a>
				</div>
				<div class="panel-footer">
				<a href="typeadd.jsp" target="right">添加新种类</a>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<h3 class="panel-title">
						用户操作
					</h3>
				</div>
				<div class="panel-footer">
					<a href="userservlet" target="right">用户浏览</a>
				</div>
				<div class="panel-footer">
					<a href="findalladdress?userid=${userid}" target="right">地址管理</a>
				</div>
			</div>
			
			
			<div class="panel panel-default">
				<div class="panel-body">
					<h3 class="panel-title">
						订单操作
					</h3>
				</div>
				<div class="panel-footer">
					<a href="findov" target="right">订单总览</a>
				</div>
				<div class="panel-footer">
					<a href="findorderitem" target="right">订单详细查询</a>
				</div>
				<div class="panel-footer">
				<a href="#">关于我们</a>
				</div>
				<div class="panel-footer">
				<a href="#" >个人信息管理</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>