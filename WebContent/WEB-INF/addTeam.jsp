<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
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
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>
