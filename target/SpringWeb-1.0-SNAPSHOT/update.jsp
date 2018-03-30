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
<h1>修改商品信息</h1>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="updateaddress" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">userid</label><input class="form-control" name="userid" id="exampleInputEmail1" type="text" value="${address.userid}"  readonly="readonly"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">收货人</label><input class="form-control" name="receivername" id="exampleInputPassword1" type="text" value="${address.receivername }"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword2">电话</label><input class="form-control" name="receiverphone" id="exampleInputPassword2" type="text" value="${address.receiverphone }"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword3">手机</label><input class="form-control" name="receivermobile" id="exampleInputPassword3" type="text" value="${address.receivermobile }"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword4">省份</label><input class="form-control" name="receiverprovince" id="exampleInputPassword4" type="text" value="${address.receiverprovince }"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword5">城市</label><input class="form-control" name="receivercity" id="exampleInputPassword5" type="text"  value="${address.receivercity }"/>
				</div>
				
		        <button class="btn btn-default" type="submit">修改地址</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>