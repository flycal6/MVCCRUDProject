<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add a Team</title>
</head>
<body>
	<h3>New Team</h3>
	<form action="CreateTeam.do" method="POST">
		Name:
		<input type="text" name="name" value="Puerto Rico Coasters"/><br/>
		First Year:
		<input type="text" name="firstYear" value="1900"/><br/>
		Last Year:
		<input type="text" name="lastYear" value="1905"/><br/>
		Where are they now: 
		<input type="text" name="relocatedTo" value="San Juan"/><br/>
		record:
		<input type="text" name="record" value="190-105-8-12"/><br/>
		Win Percentage:
		<input type="text" name="winPercent" value="0.498"/><br/>
		Playoff Appearances:
		<input type="text" name="playoffs" value="4"/><br/>
		Stanley Cups Won:
		<input type="text" name="stanleyCups" value="1"/><br/>
		Reason for relocating:
		<input type="text" name="reason" value="Ran out of money"/><br/>
		Logo URL:
		<input type="text" name="logo" value="https://media2.fdncms.com/metrotimes/imager/u/original/2398383/newdlogo.jpg"/><br/>
		
		
		<input type="submit" value="Add Team" />
	</form>
</body>
</html>