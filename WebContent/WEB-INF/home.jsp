<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<title>Lost NHL Teams</title>
</head>
<body>
	<h2 class="monoton">Defunct NHL Teams</h2>
	
	<a href="addTeam.do"><button>Add a Team &emsp;</button></a>
	
	<form class="findTeam" action="GetTeamByName.do" method="POST">
		<input type="text" name="teamName">
		<input type="submit" name="submit" value="Find Team">
	</form>
	<c:choose>
		<c:when test="${! empty teamList}">
		<c:forEach var="team" items="${teamList}">
		<a href="GetTeamByName.do?teamName=<c:out value='${team.name}'/>">
			<div class="teamDiv">
				<img src="${team.logo}" />
				<p class="monoton">${team.name}</p>
			</div></a>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No team found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>