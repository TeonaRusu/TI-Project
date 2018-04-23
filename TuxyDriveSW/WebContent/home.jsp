<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>TuxyDrive</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style.css">
  <script src="js/myscript.js"></script>
</head>
<body onload="welcomeDisplay()">

	<!-- Header -->
	<div class="header">
		<header>
			<h1 class="logo"><img class ="header-img" src="images/logo.png" alt="Logo">My TuxyDrive</h1>
		</header>
	</div>
	<!-- End header -->
	
	<!-- Top navBar -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand glyphicon glyphicon-home" href="index.jsp"></a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="#">Add</a></li>
   		</ul>
	    <form class="navbar-form navbar-left" action="">
	      <div class="input-group">
	        <input type="text" class="form-control" placeholder="Search" name="search">
	        <div class="input-group-btn">
	          <button class="btn btn-default" type="submit">
	            <i class="glyphicon glyphicon-search"></i>
	          </button>
	        </div>
	      </div>
	    </form>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="api/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- End top navBar -->
  
  	<!-- Main container -->
	<div class="container">
		<h2 id="welcome">Welcome!</h2>
		<h2>My TuxyDrive</h2>
		<p>
			HOME!
		</p>
	</div>
	<!-- End main container -->
</body>
</html>
