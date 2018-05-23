<!DOCTYPE html>
<html lang="en">
<head>
  <title>TuxyDrive</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/style2.css">
</head>
<body>
	<!-- Header -->
	<div class="header">
		<header>
			<h1 class="logo"><img class ="header-img" src="../images/logo.png" alt="Logo">Welcome to TuxyDrive!</h1>
		</header>
	</div>
	<!-- End header -->
	
	<!-- Top navBar -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand glyphicon glyphicon-home" href="../index.jsp"></a>
	    </div>
	    <ul class="nav navbar-nav navbar-right">
	    	<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- End top navBar -->
	
	<!-- Register form -->
	<div class="form-container register-form">	
		<form method="POST" enctype="multipart/form-data" action="../RegisterServlet">
			<div style="width: 50%; float:left; background-color:#fefefe; height: 300px;">
				<div class="form-row">
					<label>First name</label>
					<input class="form-control" type="text" placeholder="Enter your first name" name="Rfname" required />
				</div>
				<div class="form-row">
					<label>Last name</label>
					<input class="form-control" type="text" placeholder="Enter your last name" name="RlName" required />
				</div>
				<div class="form-row">
					<label>Username</label>
					<input class="form-control" type="text" placeholder="Enter your username" name="Rusername" required />
				</div>
				<div class="form-row">
					<label>Age</label>
					<input class="form-control" type="text" placeholder="Enter your age" name="Rage" required />
				</div>
			</div>
			<div style="width: 50%; float:right; background-color:#fefefe; height: 300px; padding-left: 15px">
				<div class="form-row">
					<label>Email</label>
					<input class="form-control" type="email" placeholder="Enter your email" name="Remail" required />
				</div>
				<div class="form-row">
					<label>Password</label>
					<input class="form-control" type="password" placeholder="Enter your password" name="Rpswd" required />
				</div>
				<div class="form-row">
					<label>Confirm Password</label>
					<input class="form-control" type="password" placeholder="Enter your password" name="RCpswd" required />
				</div>
			</div>
					<button class="loginBtn button" type="submit">Sign Up</button>
		</form>
	</div>
	<!-- End register form -->
</body>
</html>