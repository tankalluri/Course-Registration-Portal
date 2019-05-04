<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span> Course Search</h4>
		</div>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1 style="text-align:center; color:blue">${student.username}, you can search for your courses here</h1>
	<form method="get" action="/courseRegistration/closeSession"><input style="margin-left: 820px" class="btn btn-primary" type="submit" value="Logout"/></form>
<h3 style="margin-left:380px; color:brown">Search Classes by</h3><br>
<br>
<form method="post" action="/courseRegistration/courseResult">
<select name="search" style="margin-left:380px">
			<option value="coursename">Course Name</option>
			<option value="courseId">Course ID</option>
</select><br><br>
<div class="form-group">
<div class="col-sm-8">
<input style="margin-left:120px" type="text" name="searchBox" class="form-control"/><br><br><br>
<input style="margin-left:380px" type="submit" value="Search" class="btn btn-primary"/>
</div>
</div>
</form>
</body>
</html>