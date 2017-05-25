<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Welcome to contacts organizer</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet"
	type="text/css">

<style>
</style>
</head>
<body>
	<header>
		Welcome! <br /> Please login with Username and Password
	</header>
	<c:url var="loginAction" value="/login"></c:url>
	<form:form action="${loginAction}" name='loginForm' method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'>
					<input name="submit" type="submit" value="submit" /></td>
			</tr>
			<tr>
				<td colspan='2'><input id="remember_me" name="remember_me"
					type="checkbox" /></td>
			</tr>
		</table>
			
	</form:form>

</body>
</html>
