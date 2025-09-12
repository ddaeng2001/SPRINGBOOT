<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
페이지 지시자(isErrorPage="true")를 통해서 톰켓 내부로 가서
이 페이지는 에러페이지라는 것을 명시해줘야지 Exception이라는 error을 꺼내올 수 있음
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	/memo/ERROR PAGE
</h1>

EX : ${ex}
<hr/>

EXCEPTION : <%=exception %><br/>

</body>
</html>
