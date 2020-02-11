<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
input{
display:block
}
</style>
<body>
<h3>login</h3>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="/login" method="POST">
	<input type="text" name="username">
	<input type="password" name="password">
	<input type="submit" name="Login">
</form>

</body>
</html>