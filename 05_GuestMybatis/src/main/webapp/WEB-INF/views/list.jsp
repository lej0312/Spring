<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>List</h3>
<c:forEach items="${guestlist }" var="guest">
번호 : ${guest.num}<br/>
이름 : ${guest.name }<br/>
내용 : ${guest.content }<br/>
평가 : ${guest.grade }<hr/>
</c:forEach>

</body>
</html>