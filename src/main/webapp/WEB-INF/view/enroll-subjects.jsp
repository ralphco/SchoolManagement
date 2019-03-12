<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head> 

	<title>Student Information Management System</title> 

	<!-- reference our style sheet -->
	<link href="<c:url value="/resources/css/style.css" />"
          rel="stylesheet">

</head>

<body>
	
	<div id= "wrapper">
		<div id="header">
			<h2>Student Information Management System</h2>
		</div>
	</div>
	
	<h2>Available Courses</h2>
	
	<div id="content">
		<table>
			<tr>
				<th></th>
				<th>Course Code</th>
				<th>Course Title</th>
				<th>Unit</th>
				<th>Classroom</th>
				<th>Professor Id</th>
			</tr>
			
		<form:form action="enrollCourses" modelAttribute="course" method="POST" >
			<c:forEach var="availCourses" items="${Course}">
					<tr>
						<form:checkbox path="isChecked" value=""/>
						<td>${availCourses.courseCode}</td>
						<td>${availCourses.courseTitle}</td>
						<td>${availCourses.courseUnit}</td>
						<td>${availCourses.classroom}</td>
						<td>${availCourses.professorId}</td>
					</tr>
			</c:forEach>
		</form:form>		
		</table>
	</div>
</body>
</html>