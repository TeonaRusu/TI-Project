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
</head>
<body>
	<!-- Header -->
	<div class="header">
		<header>
			<h1 class="logo"><img class ="header-img" src="images/logo.png" alt="Logo">Welcome to TuxyDrive!</h1>
		</header>
	</div>
	<!--End Header -->
	
	<!-- Top  navBar -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand glyphicon glyphicon-home" href="#"></a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	    	<li><a href="api/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <li><a href="api/register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- End top navBar -->
  
   <!-- Main container -->
	<div class="container">
		<div class="row">
    		<div class="col-sm-6">
   				 <img src="images/index-img.png" class="img-rounded" alt="Index-img"> 
    		</div>
    		<div class="col-sm-6">
    			<p><strong>TuxyDrive </strong>is a web application for our Internet Technologies course which allows users to store files, synchronize files across devices and manage them in a very simple way.<br>
				This repository hosts the source code and documentation of TuxyDrive application.
				</p>
    		</div>
  		</div>
	</div>
	<!-- End main container -->
</body>
</html>
