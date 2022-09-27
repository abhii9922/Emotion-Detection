<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<%String var =(String)request.getAttribute("message"); %>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
<%@include file="Header.jsp"%>
	 <div class="contact-data"> 
			<div class="container">
		       <h2>Registration Page</h2>
		       
		          <div class="contact-form">
					     <form method="post" action="<%=request.getContextPath()%>/RegServlet"  class="left_form">
					     <%if(var != null){ %>
						<label style="color: white"> <%=var %></label>
						<%}%>
					    	<div>
						    	<span><label>FIRST NAME</label></span>
						    	<span><input  id="FNAME" type="text" placeholder="First Name *" name="FirstName" required="required" data-validation-required-message="Please enter your name." maxlength="15" required="required" onblur="firstname()" class="textbox"></span>
						    	<label id="FNAMEERROR"></label>
						    </div>
						    <div>
						    	<span><label>LAST NAME</label></span>
						    	<span><input  id="LNAME" type="text" placeholder="Last Name *" name="LastName" required="required" data-validation-required-message="Please enter your name." maxlength="15" required="required" onblur="lastname()"></span>
						    <label id="LNAMEERROR"></label>
						    </div>
						    
						    <div>
						    	<span><label>E-MAIL</label></span>
						    	<span><input id="email" type="email" placeholder="Your Email *" name="E-mail Id" required="required" data-validation-required-message="Please enter your email address." class="textbox"></span>
						    </div>
						       <div>
						    	<span><label>MOBILE NO</label></span>
						    	<span><input  id="MNO" type="text" placeholder="Your Phone *" name="Mobileno"  required="required" data-validation-required-message="Please enter your phone number."  maxlength="15" required="required" onblur="mobilenumber()" class="textbox"></span>
						    </div>
					    
					        <div>					    	
						    	<span><label>Address</label></span>
						    	<span><textarea id="ADDRESS" name="Address" placeholder="Your Address*" maxlength="50"  required="required" data-validation-required-message="Please enter a Address." onkeyup="checklength()"></textarea></span>
						    	<label style="color:black;">	Left :</label><label id="ADDRESSMSG" style="color:red"> 50</label>
						    </div>
						   <div>
						   		<input type="submit" value="Submit" class="myButton" >
						   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		<input type="reset" value="Clear All" class="myButton">
						  </div>
						  <input type="hidden" value="registration"name = "action">
						  
						  
					    </form>
					    <div class="clear"></div>
				  </div>
				  <form class="right_form">
				  <div class="content_bottom">
				
				       <div class="contact_info map" >
    	 				<h2>Find Us Here</h2>
					    	  
							   	 <div id="map1" class="map"></div>
							  </div>
      				     </div>
				      <div class="clear"></div>
	                </div>
		 	  </div>
			</div>		
		<!-- contact -->
<%@include file="Footer.jsp"%>
	<script
			src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyCeq9acroDtMHrtMbYgQpcn2V9Qw9BE8EE"></script>

		<script type="text/javascript">
			jQuery(function($) {
				function init_map1() {
					var myLocation = new google.maps.LatLng(18.7288, 73.6645);
					var mapOptions = {
						center : myLocation,
						zoom : 16
					};
					var marker = new google.maps.Marker({
						position : myLocation,
						title : "Property Location"
					});
					var map = new google.maps.Map(document
							.getElementById("map1"), mapOptions);
					marker.setMap(map);
				}
				init_map1();
			});
		</script>

		<style>
.map {
	min-width: 300px;
	min-height: 300px;
	width: 100%;
	height: 100%;
}

.header {
	background-color: #F5F5F5;
	color: #36A0FF;
	height: 70px;
	font-size: 27px;
	padding: 10px;
}
</style>

		<!-- Contact with Map - END -->


</body>
</html>