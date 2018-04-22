<!DOCTYPE html>
<html lang="en">
<head>
  <title>TuxyDrive</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo"><img class ="header-img" src="../images/logo.png" alt="Logo">Welcome to TuxyDrive!</h1>
		</header>
	</div>
	<!-- Top Bar -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="../index.jsp">TuxyDrive</a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	    	<li><a href="api/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	    </ul>
	  </div>
	</nav>
	<div class="form-container">
			<form method="POST" enctype="multipart/form-data" action="LoginServlet">
				<div class="form-row">
					<label>Username:</label>
					<input class="form-control" type="text" placeholder="Enter your username" name="username" required />
				</div>
				<div class="form-row">
					<label>Password:</label>
					<input class="form-control" type="password" placeholder="Enter your password" name="pswd" required />
				</div>
				<button class="loginBtn button" type="submit">Log In</button>
			</form>
			<div class="error">
			</div>
	</div>
 </body>
</html>