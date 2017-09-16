<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Defunct NHL Teams</title>
</head>
<body>

	<a href="home.do"><button>Home</button></a>	
	<form action="RemoveTeam.do" method="POST">
		<input type="submit" value="Delete This Team">
	
	</form>
	<a href="EditTeam.do"><button>Edit Details</button></a>	
	
	<h4>${team.name}</h4>
	<c:choose>
		<c:when test="${! empty team}">
				<img style="height:300px;" src="${team.logo}"></img>
			<ul>
				<li>${team.firstYear} - ${team.lastYear}</li>
				<li>Current Location: ${team.relocatedTo}</li>
				<li>Record: ${team.record}</li>
				<li>Win%: ${team.winPercent}</li>
				<li>Play-Off Appearances: ${team.playoffs}</li>
				<li>Stanley Cups: ${team.stanleyCups}</li>
				<p>${team.reason}</p>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No team found</p>
		</c:otherwise>
	</c:choose>
	
	<form action="GetTeamByName.do" method="POST">
		<input type="text" name="teamName">
		<input type="submit" name="submit" value="Find Another Team">
	</form>
</body>
</html>