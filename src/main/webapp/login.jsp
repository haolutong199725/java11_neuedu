<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<form role="form" action="Login" method="get">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input class="form-control" name="username" id="exampleInputEmail1" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">密码</label><input class="form-control" name="password" id="exampleInputPassword1" type="password" />
				</div>
		        <button class="btn btn-default" type="submit">登陆</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>