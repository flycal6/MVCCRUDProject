<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Defunct NHL Teams</title>
</head>
<body>
	<%-- <p>STS says, "${data}"</p> --%>
	<p>app says " ${data}"</p>
	
	<h4>Find a team</h4>
	
	<form action="GetTeamByName.do" method="POST">
		<input type="text" name="teamName">
		<input type="submit" name="submit" value="Find Team">
	</form>
</body>
</html>