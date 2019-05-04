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
<title>Course Information</title>
</head>
<body>
<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span>DETAILED COURSE INFORMATION</h4>
		</div>
<form style="margin-left:830px" method="get" action="/courseRegistration/closeSession">
	<input type="submit" class="btn btn-primary" value="Logout">
</form>
<form method="post" action="/courseRegistration/registerForCourse?courseId=${course.getCourseId()}">
	<h3 style="margin-left:380px ;color:orange; font-family:cursive;">Professor Details</h3>
	<div style="margin-left:20px ;color:brown; font-family:sans-serif;">
	<p><c:out value="${professorDetails.getName()}"></c:out> completed his undergraduate degree at NYU in Telecommunications and then took a Master's degree from Northeastern University in Computer Systems Engineering. He is one of our most accomplished professors with research papers ranging from Algorithms, Machine Learning and Applied Mathematics. He is currently teaching this course, which was started in the year 2007. The course grew out of the industry demand to have more skilled and equipped professionals in this area.</p>
	<p>You can reach out to his throught email <c:out value="${professorDetails.getEmailId()}"> and also call him at 618-896-7546. His office is Dana 428.</c:out></p>
	</div>
	<h3 style="margin-left:380px ;color:orange; font-family:cursive;">Course Details</h3>
	<div style="margin-left:20px ;color:brown; font-family:sans-serif;">
	<p>This course, <c:out value="${course.getCourseName()}"></c:out> bearing the course ID <c:out value="${course.getCourseId()}"></c:out> covers a wide range of topics from beginning to advanced. Students who have taken this course and have done their assignments and projects diligently have bagged some of the top co-op job offers from Wayfair, American Tower etc.</p>
	<p>Program Director strongly recommends this course to all incoming students.</p>
	</div>
	<input type="submit" style="margin-left:380px" value="Add course" class="btn btn-primary">
	</form>
</body>
</html>