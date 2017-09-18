<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
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
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<title>Lost NHL Teams</title>
</head>
<body>
	<nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="home.do">Defunct NHL Teams</a>
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
				<li class="nav-item"><a class="nav-link" href="addTeam.do">Add
						Team</a></li>
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
	<div class="album text-muted">
	<div class="container">

			<div class="col-12 col-md-11">
				<h2 class="monoton">Dead and Relocated Teams</h2>
			</div>
			<div class="row justify-content-center">
			<c:choose>
				<c:when test="${! empty teamList}">
					<c:forEach var="team" items="${teamList}">
						<div class="card col-10 col-sm-6 col-md-4">
							<a href="GetTeamByName.do?teamName=<c:out value='${team.name}'/>">
							<img src="${team.logo}" class="img-fluid rounded"
								alt="A generic square placeholder image with rounded corners in a figure.">
							</a>
							<p class="card-text">${team.name}</p>
						</div>

					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>No team found</p>
				</c:otherwise>
			</c:choose>
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
