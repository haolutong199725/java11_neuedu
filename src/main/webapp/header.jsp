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
			<div class="alert alert-success alert-dismissable">
				 <button class="close" aria-hidden="true" type="button" data-dismiss="alert">×</button>
				<h4>

				</h4 > <strong>${username}！</strong> 欢迎您登陆后台管理系统！！！                       <span id=clock></span> <a class="alert-link" href="http://localhost:8080/Shop/loginout">      退出登陆</a>
			</div>
		</div>
	</div>
</div>
</body>
<script>setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",1000)</script>
</html>