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
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>
