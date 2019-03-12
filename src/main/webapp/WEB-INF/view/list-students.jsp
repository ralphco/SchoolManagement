<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<html>

<head> 
	
	<title>LIST OF STUDENTS</title> 

	<!-- reference our style sheet -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>
	
	<div id= "wrapper">
		<div id="header">
			<h2>Student Information</h2>
		</div>
	</div>
	
	<div id = "container">
		<br>
		
		<div id = "menu">
		<input type="button" value="Register Student"
			   onClick="window.location.href='showAddStudent'; return false;"
			   class="add-button"
		/>
		</div>
		
		<div id="content">
			<!-- STUDENT INFO TABLE -->
			<table>
				<tr>			
					<th>Student Number</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					 <th>Action</th>
				</tr>
				
				<c:forEach var="tempStudent" items="${student}">
									
					<!-- construct an "Update" link with customer id -->
					<c:url var="viewLink" value="/student/showStudentDetails">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					
					<tr>	
						<td>${tempStudent.studentNumber}</td>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.emailAddress}</td>
						
						 <td>
							<a href="${viewLink}">View</a>
						</td>
					</tr>
				</c:forEach>			
			</table>
		</div>
	</div>
	
</body>
</html>