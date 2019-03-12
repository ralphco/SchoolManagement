<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Custom Login Page</title>
	
	<style>
		.failed { color:red;
		          font-size: 80%;}
	</style>
</head>

<body>
	<h3> My Custom Login Page</h3>
	
	<form:form action="login"
	           method="POST">
	           	           
	 <p>
	 	User name: <input type="text" name="username" />
	 </p>
	 
	 <p>
	 	Password:  <input type="password" name="password" />
	 </p>
	 
	 <!-- Check for login error -->
	  <c:if test="${param.error != null}">   
	  	<i class="failed"> *Invalid username/password. </i>
	  </c:if>      
	 
	 <input type="Submit" value="Login" />

	</form:form>
	
</body>

</html>