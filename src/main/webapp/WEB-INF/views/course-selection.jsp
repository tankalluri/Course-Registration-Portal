<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
    crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
    integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
    crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Northeastern Course Registration System</title>
</head>
<body>
<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span> SEMESTER SELECTION</h4>
		</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1 style="color: blue;text-align: center">Welcome ${student.username}</h1>
	<form method="get" action="/courseRegistration/closeSession"><input style="margin-left: 820px" class="btn btn-primary" type="submit" value="Logout"/></form>
	
	<form action="${contextPath}/showcourses" method="post">
	<h2  style="margin-left: 330px; color: orange"> Semesters available : </h2>	
		<select name="sem" class="dropdown" style="margin-left: 380px">
			<option value="Fall2018" class="dropdown-item">Fall 2018</option>
			<option value="Spring2019" class="dropdown-item">Spring 2019</option>
			<option value="Summer2019" class="dropdown-item">Summer 2019</option>
			<option value="Fall2019" class="dropdown-item">Fall 2019</option>
		</select>
		<br><br>
		<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
	<input type="submit" value="Choose Semester" class="btn btn-primary" />
	</div>
	</div>
	</form>
</body>
</html>