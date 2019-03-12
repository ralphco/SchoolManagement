<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head> 

	<title>LIST OF STUDENTS</title> 
      
</head>

<body>
	
	<div id= "wrapper">
		<div id="header">
			<h2>Student Information Management System awdawdawd</h2>
		</div>
	</div>
	
	<div id = "content">
		<h3>Register Student Information</h3>
		
		<form:form action="saveStudent" modelAttribute="student" method="POST">
			
			<table>
				<tr>
					<td><label> First Name: </label></td>
					<td><form:input path="firstName" />
					<form:errors path="firstName" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label> Last Name: </label></td>
					<td><form:input path="lastName" />
					<form:errors path="lastName" cssClass="error" /></td>
				</tr>
			
				<tr>
					<td><label> Email Address: </label></td>
					<td><form:input path="emailAddress" />
					<form:errors path="emailAddress" cssClass="error" /></td>
				</tr>
				
				<!-- STUDENT ADDRESS DETAILS -->
				<div id = "details">
					<form:form modelAttribute="studentAddress" method="POST">
					
					<tr>
						<td><label> Address: </label></td>
						<td><form:input path="address" /></td>
					</tr>
					
					<tr>
						<td><label> City: </label></td>
						<td><form:input path="city" /></td>
					</tr>
					
					<tr>
						<td><label> Country: </label></td>
						<td><form:input path="country" /></td>
					</tr>
					
					<tr>
						<td><label> Postal Code: </label></td>
						<td><form:input path="postal_code" />
						<form:errors path="postal_code" cssClass="error" /></td>
						
					</tr>
					
					</form:form>
				</div>
			
			</table>
			
				<div id="buttonBar">	
					<input type="submit" value="Save" class="save" />
					<input type="button" value="Back" onClick="window.location.href='list'; return false;"/>
				</div>	
		</form:form>		
	</div>
	
</body>

</html>