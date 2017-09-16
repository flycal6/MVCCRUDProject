<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Edit Team Details</title>
</head>
<body>
	<h3>Edit Team Details</h3>
	<form action="UpdateTeam.do" method="POST">
		Name:
		<input type="text" name="name" value="${team.name}"/><br/>
		First Year:
		<input type="text" name="firstYear" value="${team.firstYear}"/><br/>
		Last Year:
		<input type="text" name="lastYear" value="${team.lastYear}"/><br/>
		Where are they now: 
		<input type="text" name="relocatedTo" value="${team.relocatedTo}"/><br/>
		Number of seasons played: 
		<input type="text" name="seasons" value="${team.seasons}"/><br/>
		record:
		<input type="text" name="record" value="${team.record}"/><br/>
		Win Percentage:
		<input type="text" name="winPercent" value="${team.winPercent}"/><br/>
		Playoff Appearances:
		<input type="text" name="playoffs" value="${team.playoffs}"/><br/>
		Stanley Cups Won:
		<input type="text" name="stanleyCups" value="${team.stanleyCups}"/><br/>
		Reason for relocating:
		<input type="text" name="reason" value="${team.reason}"/><br/>
		Logo URL:
		<input type="text" name="logo" value="${team.logo}"/><br/>
		
		<input type="submit" value="Update Team Details" />
	</form>
</body>
</html>