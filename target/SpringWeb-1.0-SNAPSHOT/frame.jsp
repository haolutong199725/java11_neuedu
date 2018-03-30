<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="20%,80%" frameborder="0">
<frame src="header.jsp?username=${username}"/>
     <frameset cols="20%,*">
        <frame src="operation.jsp?userid=${userid}"/>
        <frame src="product.jsp?userid=${userid}"  name="right"/>
     </frameset> 
</frameset>
<body>

</body>
</html>