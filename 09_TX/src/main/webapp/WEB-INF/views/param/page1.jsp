<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	/param/page1
</h1>

DTO : ${dto}<br/>
    //표현식을 사용하여 Attribute에 있는 key값을 그대로 던져주면 됨

NAME : ${dto.name}<br/>
AGE : ${dto.age}<br/>
ADDR : ${dto.addr}<br/>
isLogin : ${isLogin}<br/>
//이렇게 쓰려면 dto에 getter, setter가 있어야 함
</body>
</html>
