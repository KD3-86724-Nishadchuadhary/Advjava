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
	<jsp:useBean id="lb" class="com.sunbeam.Beans.UsrBean" scope="session"/>
	<jsp:setProperty property="email" name="lb" param="email" />
	<jsp:setProperty property="password" name="lb" param="password" />
	${lb.login() }
	
	
	
	<c:choose>
		<c:when test="${lb.user != null}">
			<c:choose>
				<c:when test="${lb.user.role == 'admin'}">
					<c:redirect url="result.jsp"/>
				</c:when>
				<c:otherwise>
					<c:redirect url="candlist.jsp"/>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h2>Login Failed</h2>
			<p>Invalid Email or Password</p>
			<p>
			<a href="index.jsp">Login Again</a>
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>