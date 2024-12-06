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
	<jsp:setProperty property="firstName" name="user"  param="firstName" />
	<jsp:setProperty property="lastName" name="user" param = "lastName"/>
	<jsp:setProperty property="email" name="user" param = "email"/>
	<jsp:setProperty property="password" name="user" param="password"/>
	<jsp:setProperty property="birth" name="user" param="birth"/>
	${user.register()}
	
	<c:set var="cnt" value="${user.count}"/>
	
	<c:choose>
		<c:when test="${cnt == 1}">
			<h4>Successfully Registered a new User!</h4>
		</c:when>
		<c:otherwise>
			<h4>Registration failed!</h4>
		</c:otherwise>
	</c:choose>
	
	<a href="index.jsp">Login Again</a>

</body>
</html>