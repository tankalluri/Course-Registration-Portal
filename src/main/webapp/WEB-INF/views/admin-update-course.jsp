<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title></title>
</head>
<body>
	<div class="container">

		<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span> Update Course</h4>
		</div>
		<div class="row">
	<form action="/courseRegistration/adminUpdateCourseDetails" method="get">
	<div class="form-group">
			<label class="col-sm-4 control-label">Course ID to be updated:</label>
			<div class="col-sm-8">
	<input type="text" name="crsId" class="form-control"/>
	</div>
	</div>
	<br><br>
	<div class="form-group">
			<label class="col-sm-4 control-label">Course Name:</label>
			<div class="col-sm-8">
	<input type="text" name="crsName" class="form-control"/>
	<br><br>
	<input type="submit" value="Update Course" class="btn btn-primary"/>
	</div>
	</div>
</form>	
</div>
</div>
</body>
</html>