<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BREA</title>
</head>
<body>
	<!-- script-for-nav -->
	<%@include file="Header.jsp"%>
	<div class="banner">
	<script>
						$( "span.menu" ).click(function() {
						  $( ".head-nav ul" ).slideToggle(300, function() {
							// Animation complete.
						  });
						});
						
					</script>
				<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<div class="banner-info">
										<h1><font color="#EAE8FF">Online Education</font></h1>
										<p><font color="#EAE8FF">Due to this Covid-19 pandemic situation our whole education system was shifted from offline mode of education to online mode.Students find it difficult to adapt to an online learning environment immediately after traditional classroom learning </font></p>	
									</div>
								</li>
								<li>
									<div class="banner-info">
										<h1><font color="#EAE8FF">Why Feedback?</font></h1>
										<p><font color="#EAE8FF">During our research and literature survey we found that many improvements were made in the online teaching format. But no significant work was done in analyzing or  getting the students natural feedback. As we have seen in the offline format of teaching direct supervision of lectures by instructors is the main reason behind student attentiveness in class.</font></p>	
									</div>
								</li>
								<li>	
									<div class="banner-info">
										<h1><font color="#EAE8FF">Our System</font></h1>
										<p><font color="#EAE8FF">Our system thus aims at providing the teachers with a cheaper, additional hardware free
and accurate emotion based feedback system. This project will be of great advantage to teachers to redefine the teaching plan or can repeat any lecture if emotion are dull. This will help students to achieve good marks.
										</font></p>	
									</div>
									<div class="clearfix"> </div>
								</li>
							</ul>
						</div>
					</section>
						<!-- FlexSlider -->
							  <script defer src="js/jquery.flexslider.js"></script>
							  <script type="text/javascript">
								$(function(){
								  SyntaxHighlighter.all();
								});
								$(window).load(function(){
								  $('.flexslider').flexslider({
									animation: "slide",
									start: function(slider){
									  $('body').removeClass('loading');
									}
								  });
								});
							  </script>
							  </div>
							  
							  
						<!-- FlexSlider -->
						<%@include file="Footer.jsp"%>
</body>
</html>