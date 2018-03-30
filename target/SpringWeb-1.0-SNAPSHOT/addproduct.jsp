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
<h1>添加新商品</h1>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="insertproduct" method="post">
			    <div class="form-group">
					 <label for="exampleInputEmail1">商品ID</label><input class="form-control" name="product_id" id="exampleInputEmail1" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputEmail1">商品名称</label><input class="form-control" name="product_name" id="exampleInputEmail1" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">商品图片</label><input class="form-control" name="product_image" id="exampleInputPassword1" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword2">商品价格</label><input class="form-control" name="product_price" id="exampleInputPassword2" type="text" />
				</div>
				
		        <button class="btn btn-default" type="submit">添加新商品</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>