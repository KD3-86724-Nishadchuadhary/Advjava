<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.sunbeam.Beans.UsrBean"/>
	<jsp:setProperty property="email" name="user" param="email" />
	<jsp:setProperty property="password" name="user" param="password" />
	${user.login() }
	
	<c:set var="role" value="${user.role}" />
	
	<c:choose>
		<c:when test="${role == 'voter'}">
			<c:redirect url="candlist.jsp"/>
		</c:when>
		<c:otherwise>
			<h4>Login Failed</h4>
			<a href="index.jsp">Login Again</a>
		</c:otherwise>
	</c:choose>
</body>
</html>