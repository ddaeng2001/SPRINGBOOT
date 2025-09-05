<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
기본옵션인 session="false"(session을 비활성화시키겠다)
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	/param/page3
</h1>

<EL 표현식>
DTO : ${dto}<br/>
NAME : ${dto.name}<br/>
AGE : ${dto.age}<br/>
ADDR : ${dto.addr}<br/>

</body>
</html>
