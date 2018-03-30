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
function openDeal(){
  {
	  var checkElements=document.getElementsByName('items');
	  for(var i=0;i<checkElements.length;i++){
		var checkElement=checkElements[i];
		checkElement.checked="checked";
	  }
	  }
  }
function openDeal1(){
	  {
		  var checkElements=document.getElementsByName('items');
		  for(var i=0;i<checkElements.length;i++){
			var checkElement=checkElements[i];
			checkElement.checked=null;
		  }
		  }
	  }
function openDeal2(){
	  {
		  var checkElements=document.getElementsByName('items');
		  for(var i=0;i<checkElements.length;i++){
			var checkElement=checkElements[i];
			if(checkElement.checked){
			checkElement.checked=null;
			}else{
				checkElement.checked="checked";
			}
		  }
		  }
	  }
</script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<form role="form" action="checkedcart" method="post">
			<table class="table">
				<thead>
					<tr>
					    <th>
							<input type="button" name="checkall" id="checkall" value="全选" onclick="openDeal()">
							<input type="button" name="checkall" id="checkNo" value="全不选" onclick="openDeal1()">
							<input type="button" name="checkall" id="checkReverse" value="反选" onclick="openDeal2()">
						</th>
						<th>
							userid
						</th>
						<th>
							商品id
						</th>
						<th>
							数量
						</th>
						<th>
							checked
						</th>
						<th>
						创建时间
						</th>
						<th>
						更新时间
						</th>
						<th>
						操作
						</th>>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${cart}" var="cart" varStatus="status">
					<tr>
				<td><input type="checkbox"  name="items" value="${cart.productid}"></td>
				<td>${cart.userid}</td>
				<td>${cart.productid}</td>		
				<td>${cart.quantity}</td>		
				<td>${cart.checked}</td>		
				<td>${cart.createtime}</td>		
				<td>${cart.updatetime}</td>
				<td>
				<a href="deletecart?userid=${cart.userid}&productid=${cart.productid}">删除</a> 
				<a href="updatequantity?userid=${cart.userid}&productid=${cart.productid}">修改</a>
				</td>
				
					</tr>
					</c:forEach>
					<tr>
					<td>
                    <select name="checked"> 
                        
                          <option value="0"> 0</option>
                          <option value="1"> 1</option>
                    </select>
                    <input type="submit" value="修改状态"></td>
					</tr>
				</tbody>
			</table>
			<a   href="empty.jsp"><input type="button" value="下单"></a>
			</form>
		</div>
	</div>
</div>

</body>
</html>