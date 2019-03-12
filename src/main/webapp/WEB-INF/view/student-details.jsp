<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>

<head> 

	<title>Student Information Management</title> 

	<!-- reference our style sheet -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>
	
	<div id= "wrapper">
		<div id="header">
			<h2>Student Information Management</h2>
		</div>
	</div>
	
	<h3>Student Details</h3>

	<div id="wrapper">
		<form:form method="POST" modelAttribute="studentDetailView">
			
			<div class ="row" id="detail">
				<div class="column">
					<p>Student Number: ${studentDetailView.studentNum}</p>
					<p>First Name: ${studentDetailView.firstName}</p>
					<p>Last Name: ${studentDetailView.lastName}</p>
					<p>Email Address: ${studentDetailView.emailAddress}</p>
				</div>	
				
				<div class="column">
					<p>Address: ${studentDetailView.address}, ${studentDetailView.city}, ${studentDetailView.country} ${studentDetailView.postalCode}</p>
				</div>
			</div>
		</form:form>
	</div>
	
	<br>
	<div>
	    <input type="button" value="Enroll Classes"
			   onClick="window.location.href='showEnrollPage'; return false;"/>
		<input type="button" value="Back"
			   onClick="window.location.href='list'; return false;"/>
	</div>
	
</body>
</html>