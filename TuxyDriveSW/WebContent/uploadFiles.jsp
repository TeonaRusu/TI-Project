<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
</html><!DOCTYPE html>
<html lang="en">
<head>
  <title>TuxyDrive</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style2.css">
  <script src="js/myscript.js"></script>
</head>
<body onload=;>
	<div class="header">
		<header>
			<h1 class="logo"><img class ="header-img" src="images/logo.png" alt="Logo">My TuxyDrive</h1>
		</header>
	</div>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand glyphicon glyphicon-home" href="home.jsp"></a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- End top navBar -->

	 <div class="date-form">
	    <div class="header-sec">
	      <h3 style="font-size:2em;"><strong>UPLOAD YOUR FILES</strong></h3>
	    </div>
	    <form class="form-container">
	         <div class="form-row">
	            <label>File Name</label>
	            <input id="fileName" class="form-control" type="text" name="column" required /> 
	          </div>
	          <div class="form-row-file">
	            <input type="file" name="file" id="file"/>
	          </div>
	          <button class="uploadBtn button" value="uploadBtn" onclick="">UPLOAD</button>
	    </form>
	</div> 
</body>
</html>