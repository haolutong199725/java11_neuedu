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
function tijiao(){
	 var text=document.getElementsByTagName('input')[0].value;
	 alert(text)
	 window.location.href="findorderlike?serach="+text;
}
</script>

<style>

.button {
                background-color: #008CBA; /* blue */
    			border: none;
    			color: white;
    			padding: 4px 8px;
     			text-align: center;
    			text-decoration: none;
    			display: inline-block;
     			font-size: 16px;
     			border-radius: 8px;
     			border: 2px solid #008CBA;
     			-webkit-transition-duration: 0.4s; /* Safari */
    			transition-duration: 0.4s;
			}
			.button:hover {
    			background-color: white; /* Green */
    			color: black;
			} 
</style>
</head>
<body>
<!-- select u.user username,uo.order_no,uo.user_id,
uo.shipping_id,uo.payment,uo.payment_type,uo.postage,
uo.status,uo.create_time,uo.update_time  -->

    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<form role="form" action="updatevo" method="post">
		
		  <div   style="margin-left:500px">
		  <input type="text"  id="input1"  />
		  <input     type="button" class="button" value="搜索"   onclick="tijiao()"/>
		  </div>
			<table class="table">
				<thead>
					<tr>
			<th></th>
		    <th>订单号</th>
		    <th>用户名</th>
			<th>价格</th>
			<th>付款状态</th>
			<th>邮费</th>
			<th>订单状态</th>
			<th>创建时间</th>
			<th>修改时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageModel}" var="address">

			<tr>
			    <td><input type="checkbox"  name="items" value="${address.id}"></td>
				<td>${address.order_no}</td>	
				<td>${address.user.username}</td>			
				<td>${address.payment}</td>		
				<td>${address.payment_type}</td>
				<td>${address.postage}</td>	
				<td>${address.status}</td>
				<td>${address.create_time}</td>
				<td>${address.update_time}</td>				
				<td><a href="deleteaddress">删除</a> 
			</tr>
            
		</c:forEach>
		<tr>

							<input  type="button" name="checkall" id="checkall" value="全选" onclick="openDeal()">
							<input style="margin-left:10px"  type="button" name="checkall" id="checkNo" value="全不选" onclick="openDeal1()">
							<input style="margin-left:10px" type="button" name="checkall" id="checkReverse" value="反选" onclick="openDeal2()">
		</tr>
		<tr>
					<td>
                    <select name="checked"> 
                          <option value="0"> 已经取消</option>
                          <option value="10"> 未付款</option>
                          <option value="20"> 已付款</option>
                          <option value="40"> 已发货</option>
                          <option value="50"> 交易成功</option>
                          <option value="60"> 交易失败</option>
                    </select></td>
                    <td><input type="submit" value="修改状态"></td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>