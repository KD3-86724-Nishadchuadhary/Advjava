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
	<jsp:useBean id="ucb" class="com.sunbeam.Beans.UpdateCandBean"/>
	<jsp:setProperty property="*" name="ucb"/>
	${ucb.updateCandidate() }
	
	<c:choose>
		<c:when test="${ucb.count==1 }">
			<jsp:forward page="result.jsp">
				<jsp:param value="Candidate Updated Successfully!" name="msg"/>
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param value="Candidate Update Failed" name="msg"/>
			</jsp:forward>
		</c:otherwise>
	</c:choose>
	

</body>
</html>