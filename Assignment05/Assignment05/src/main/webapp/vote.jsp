<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>voting Status</h2>
	<jsp:useBean id="vb" class="com.sunbeam.Beans.VoteBean"/>
	<jsp:setProperty property="candId" name="vb" param="candidate"/>
	<jsp:setProperty property="userId" name="vb" value="${lb.user.id}"/>
	<c:choose>
		<c:when test="${lb.user.status ==0}">
			${vb.vote() }
			<c:choose>
				<c:when test="${vb.sucess}">
					<p>You have successfully voted!</p>
					${lb.user.setStatus(1) }
				</c:when>
				<c:otherwise>
					<p>Your voting attempt failed!</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>Your already voted</p>
		</c:otherwise>
	</c:choose>
	<p>
	<a href="logout.jsp">Sign Out</a>
	</p>		

</body>
</html>