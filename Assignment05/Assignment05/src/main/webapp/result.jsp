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
	<h2>Voting Result</h2>
	<jsp:useBean id="rb" class="com.sunbeam.Beans.ResultBean"/>
	${rb.fetchCandidates()}
	<form method="post" action="vote">
		<table border=1>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
			<c:forEach var="cl" items="${rb.candList}">
				<tr>
					<td>${cl.id}</td>
					<td>${cl.name}</td>
					<td>${cl.party}</td>
					<td>${cl.votes}</td>
					<td>
					<a href='editcand.jsp?id=${cl.id}'><image src='images/edit.png' alt='Edit' width='24' height='24'/></a>
					<a href='delcand.jsp?id=${cl.id}'><image src='images/Delete.png' alt='Edit' width='24' height='24'/></a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<p>${param.msg}</p>
		<p>
			<a href="logout.jsp">Sign Out</a>	
	</form>

</body>
</html>