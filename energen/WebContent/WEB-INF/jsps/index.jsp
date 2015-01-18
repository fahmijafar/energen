<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple login application using spring mvc</title>
</head>
<body>
${message}
	<form action="Login.spring" method="post">
		Username : <input type="text" name="userName" /> <br />
		Password : <input type="password" name="password" /> <br />
		<input type="submit" />
	</form>
</body>
</html>