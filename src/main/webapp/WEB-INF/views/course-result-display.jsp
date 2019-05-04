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
<title>Course Display</title>
</head>
<body>
<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span>COURSE INFORMATION</h4>
		</div>
	<a style="margin-left:830px" href="/courseRegistration/closeSession">Logout</a>
	<br><br><br>
	<div><c:out value="${sessionScope.cf}"></c:out></div>
	<table border="1" style="margin-left: 8px" class="table">
	<thead>
		<tr style="font-family:cursive; color: red">
		<td>Course ID</td>
		<td>Course Name</td>
		<td>Section</td>
		<td>Time</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var = "course" items= "${sessionScope.courselist}"> 
		<tr>
			<td><c:out value = "${course.getCourseId()}"></c:out></td>
			<td><a href="${contextPath}/courseRegistration/courseInfo?courseId=${course.getCourseId()}"><c:out value = "${course.getCourseName()}"></c:out></a></td>
			<td><c:out value= "${course.getSection()}"></c:out></td>
			<td><c:out value= "${course.getTime()}"></c:out></td>
		<tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>