<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Enter User Details: </h2> <br/> <br/>
	<form method="post" action="register.jsp">
		First Name: <input type="text" name="firstName"><br/> <br/>
		Last Name: <input type="text" name="lastName"><br/> <br/>
		Email: <input type="email" name="email"><br/> <br/>
		Password <input type="text" name="password"><br/> <br/>
		Birth Date: <input type="date" name="birth"><br/> <br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>