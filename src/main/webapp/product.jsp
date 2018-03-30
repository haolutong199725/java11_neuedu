<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
     
function openDeal(){
   var myurl1=document.getElementById("apple").value;//获取myurl1输入值 
   var baseUrl='http://localhost:8080/Shop/addcart?userid=${userid}';
   var a=1;
   window.location.href=baseUrl+'&productid='+a+'&quantity='+myurl1;//跳转链接
}
function openDeal1(){
	   var myurl1=document.getElementById("peach").value;//获取myurl1输入值   
	   var baseUrl='http://localhost:8080/Shop/addcart?userid=${userid}';
	   var a=2;
	   window.location.href=baseUrl+'&productid='+a+'&quantity='+myurl1;//跳转链接
	}
function openDeal2(){
	   var myurl1=document.getElementById("lanmei").value;//获取myurl1输入值 
	   var baseUrl='http://localhost:8080/Shop/addcart?userid=${userid}';
	   var a=3;
	   window.location.href=baseUrl+'&productid='+a+'&quantity='+myurl1;//跳转链接
	}
function openDeal3(){
	   var myurl1=document.getElementById("zha").value;//获取myurl1输入值
	   var baseUrl='http://localhost:8080/Shop/addcart?userid=${userid}';
	   var a=4;
	   window.location.href=baseUrl+'&productid='+a+'&quantity='+myurl1;//跳转链接
	}
function openDeal4(){
	   var myurl1=document.getElementById("liulian").value;//获取myurl1输入值  
	   var baseUrl='http://localhost:8080/Shop/addcart?userid=${userid}';
	   var a=5;
	   window.location.href=baseUrl+'&productid='+a+'&quantity='+myurl1;//跳转链接
	}
         
</script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
						<th>
							产品ID
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							数量
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							苹果
						</td>
						<td>
							01/04/2012
						</td>
						<td>
						<select id="apple"> 
                        
                          <option value="1"> 1 </option>
                          <option value="2"> 2</option>
                          <option value="3"> 3 </option>
                          <option value="4"> 4 </option>
                        </select>
						</td>
						<td>
						<input type="button" value="加入购物车" onclick="openDeal()">
						</td>
					</tr>
					<tr class="success">
						<td>
							2
						</td>
						<td>
							桃子
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<select id="peach"> 
                        
                          <option value="1"> 1 </option>
                          <option value="2"> 2</option>
                          <option value="3"> 3 </option>
                          <option value="4"> 4 </option>
                        </select>
						</td>
						<td>
						<input type="button" value="加入购物车" onclick="openDeal1()">
						</td>
					</tr>
					<tr class="error">
						<td>
							3
						</td>
						<td>
							蓝莓
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							<select id="lanmei"> 
                        
                          <option value="1"> 1 </option>
                          <option value="2"> 2</option>
                          <option value="3"> 3 </option>
                          <option value="4"> 4 </option>
                        </select>
						</td>
						<td>
						<input type="button" value="加入购物车" onclick="openDeal2()">
						</td>
					</tr>
					<tr class="warning">
						<td>
							4
						</td>
						<td>
							八月炸
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							<select id="zha"> 
                        
                          <option value="1"> 1 </option>
                          <option value="2"> 2</option>
                          <option value="3"> 3 </option>
                          <option value="4"> 4 </option>
                        </select>
						</td>
						<td>
						<input type="button" value="加入购物车" onclick="openDeal3()">
						</td>
					</tr>
					<tr class="info">
						<td>
							5
						</td>
						<td>
							猫山王
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							<select id="liulian"> 
                        
                          <option value="1"> 1 </option>
                          <option value="2"> 2</option>
                          <option value="3"> 3 </option>
                          <option value="4"> 4 </option>
                        </select>
						</td>
						<td>
						<input type="button" value="加入购物车" onclick="openDeal4()">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>
</html>