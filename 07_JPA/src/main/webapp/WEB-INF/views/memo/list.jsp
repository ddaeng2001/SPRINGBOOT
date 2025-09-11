<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
    <h1>
	    /memo/list PAGE
    </h1>


    <div class="page_info">
        <div>"현재 페이지 번호: "${page.Number(page.number)}</div>
        <div>"한 페이지에 표시할 건수 : "${page.Size()}</div>
        <div>"총 게시물 개수 : "${page.TotalElements())}</div>
        <div>"총 페이지 개수 : "${page.TotalPages()}</div>
        <div>"첫 번째 페이지인지 여부: "${page.isFirst()}</div>
        <div>"다음페이지가 있는지 여부 : " ${page.Next()}</div>
        <div>"이전페이지가 있는지 여부 : "${page.Previous()}</div>
    </div>

        System.out.println("현재 페이지 번호: "+page.getNumber());
        System.out.println("한 페이지에 표시할 건수 : " + page.getSize());
        System.out.println("총 게시물 개수 : " +page.getTotalElements());
        System.out.println("총 페이지 개수 : " + page.getTotalPages());
        System.out.println("첫 번째 페이지인지 여부: " +page.isFirst());
        System.out.println("다음페이지가 있는지 여부 : " +page.hasNext()); //다음 페이지 버튼 활성화
        System.out.println("이전페이지가 있는지 여부 : " +page.hasPrevious()); //이전 페이지 버튼 활성화

    <div>
    <c:forEach var="memo" items="${lists}">
            <div>
                ${memo}
            </div>
        </c:forEach>

    </div>
</body>
</html>
