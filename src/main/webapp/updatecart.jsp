<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>修改产品数量</h1>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="updatequantity" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">userid</label><input class="form-control" name="userid" id="exampleInputEmail1" type="text" value="${cart.userid}"  readonly="readonly"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">商品id</label><input class="form-control" name="productid" id="exampleInputPassword1" type="text" value="${cart.productid }" readonly="readonly"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword2">数量</label><input class="form-control" name="quantity" id="exampleInputPassword2" type="text" value="${cart.quantity }"/>
				</div>
				
		        <button class="btn btn-default" type="submit">修改数量</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>