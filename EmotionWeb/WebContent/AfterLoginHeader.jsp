<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<title>Project Domain</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />


	<!-- script-for-nav -->
			<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script src="js/jquery.min.js"></script>
</head>
<body>
<!-- header -->
	<div class="header-top">
		<div class="container">
			<div class="phone">
				<h3><font color="#000000"><span>Phone</span> : 9284682941</font></h3>
			</div>
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" class="img-responsive" alt="" />Emotion Detection</a>
			</div>
			<div class="location">
				<h3><font color="#000000"><span>Location</span> :Pune</font></h3>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
	
		<div class="container">
			<div class="head-nav">
				<span class="menu"> </span>
				<ul>
					<li class="active"><a href="Portal.jsp"><font color="#3C91E6">View Graph</font></a></li>
					<li> <a href="Upload.jsp" class="green-text"><strong><font color="#3C91E6">Upload Video</font></strong></a></li>
					<li><a href="Changepassword.jsp"><font color="#3C91E6">Change Password</font></a></li>
					<li><a href="Login.jsp"><font color="#3C91E6">Logout</font></a></li>
					<div class="clearfix"> </div>
				</ul>
				</div>
						<div class="clearfix"> </div>
					<!-- script-for-nav -->
					<script>
						$( "span.menu" ).click(function() {
						  $( ".head-nav ul" ).slideToggle(300, function() {
							// Animation complete.
						  });
						});
					</script>
				<!-- script-for-nav -->
				
					
						<!-- FlexSlider -->
			</div>
		</div>	
<!-- header -->
</body>
</html>