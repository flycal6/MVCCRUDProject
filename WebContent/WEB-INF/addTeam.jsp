<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link href="https://fonts.googleapis.com/css?family=Monoton"
	rel="stylesheet">
<title>Add a Team</title>
</head>
<body>
	<nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
	<a class="navbar-brand" href="home.do">Adding A Team</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.do">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link disabled"
				href="addTeam.do">Add Team</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Edit
					Team</a></li>
			<!-- <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li> -->
		</ul>
		<form class="form-inline my-2 my-lg-0 findTeam"
			action="GetTeamByName.do" method="POST">
			<input class="form-control mr-sm-2" type="text" name="teamName"
				placeholder="Find Team" aria-label="Find Team">
			<button class="btn btn-outline-success my-2 my-sm-0" name="submit"
				type="submit">Search</button>
		</form>
	</div>
	</nav>

	<div class="container">
		<div class="main row justify-content-center">
			<div class="col-12 col-md-8">
				<h3>New Team</h3>
				<form action="CreateTeam.do" method="POST">
					<%-- <input type="hidden" class="form-control mr-sm-2"  name="id" value="${team.id}"/> --%>
					Name: 
					<input type="text" name="name" class="form-control mr-sm-2" value="Puerto Rico Coasters" /><br />
					First Year: 
					<input type="text" class="form-control mr-sm-2" name="firstYear" value="1900" /><br />
					Last Year: 
					<input type="text" class="form-control mr-sm-2" name="lastYear" value="1905" /><br />
					Where are they now: 
					<input type="text" name="relocatedTo" class="form-control mr-sm-2" value="San Juan" /><br /> 
					record: 
					<input type="text" name="record" class="form-control mr-sm-2" value="190-105-8-12" /><br /> 
					Win Percentage: 
					<input type="text" class="form-control mr-sm-2" name="winPercent" value="0.498" /><br /> 
					Playoff Appearances: 
					<input type="text" class="form-control mr-sm-2" name="playoffs" value="4" /><br /> 
					Stanley Cups Won: 
					<input type="text" class="form-control mr-sm-2" name="stanleyCups" value="1" /><br /> 
					Reason for relocating: 
					<input type="text" name="reason" class="form-control mr-sm-2" value="Ran out of money" /><br /> 
					Logo URL: 
					<input type="text" name="logo" class="form-control mr-sm-2" value="https://media2.fdncms.com/metrotimes/imager/u/original/2398383/newdlogo.jpg" /><br />

					<input type="submit" class="btn my-2 my-sm-0" value="Add Team" />
				</form>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>

</body>
</html>
