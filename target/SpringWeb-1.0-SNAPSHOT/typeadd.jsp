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
<h1>添加新种类</h1>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="typeadd" method="post">
			    <div class="form-group">
					 <label for="exampleInputEmail1">种类ID</label><input class="form-control" name="id" id="exampleInputEmail1" type="text" />
				</div>
				<div class="form-group">
				   <label for="exampleInputEmail1">父类ID</label>
					 <select name="parent_id">
					 <option value="abc">abc</option>
					 <option value="bde">bde</option>
					 <option value="bcd">bcd</option>
					 <option value="no parentid">无父类ID</option>
					 </select>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">类型</label><input class="form-control" name="type" id="exampleInputPassword1" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword2">状态</label><input class="form-control" name="statu" id="exampleInputPassword2" type="text" />
				</div>
				
		        <button class="btn btn-default" type="submit">添加新种类</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>