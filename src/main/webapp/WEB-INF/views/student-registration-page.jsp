<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
    crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
    integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
    crossorigin="anonymous">
<!-- <meta charset="ISO-8859-1"> -->
<title>Student Registration</title>
</head>
<body>
<div class="container">

		<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span> Registration Form</h4>
		</div>

		<div class="row">
			<form:form modelAttribute="student"
				class="form-horizontal">
				
				<div class="form-group">
					<label for="first" class="col-sm-4 control-label">First
						Name: </label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="firstname"
							path="firstname" placeholder="First Name" required="required" />
							<font color="red"><form:errors path="firstname"></form:errors></font>
					</div>
				</div>

				 <div class="form-group">
					<label for="last" class="col-sm-4 control-label">Last Name:</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="lastname" path="lastname"
							placeholder="Last Name" required="required" />
							<font color="red"><form:errors path="lastname"></form:errors></font>
					</div>
				</div>

				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Email:</label>
					<div class="col-sm-8">
								<form:input type="text" class="form-control" path="email"
									id="email" placeholder="Email" required="required" />
					<font color="red"><form:errors path="email"></form:errors></font>
					</div>
				</div>
				<c:out value="${message}"></c:out>
				<div class="form-group">
					<label for="username" class="col-sm-4 control-label">Username:</label>
					<div class="col-sm-8">
								<form:input type="text" class="form-control" path="username"
									id="username" placeholder="Username" required="required" />
									<font color="red"><form:errors path="username"></form:errors></font>
					</div>
				</div>
				
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Password:</label>
					<div class="col-sm-8">
								<form:input type="password" class="form-control" path="password"
									id="username" placeholder="Password" required="required" />
									<font color="red"><form:errors path="password"></form:errors></font>
					</div>
				</div>

				<div class="form-group">
					<label for="nuid" class="col-sm-4 control-label">NUID: </label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="nuid" path="nuid"
							placeholder="NUID" required="required" />
							<font color="red"><form:errors path="nuid"></form:errors></font>
					</div>
				</div>

				<div class="form-group">
					<label for="entrance" class="col-sm-4 control-label">Role </label>
					<div class="col-sm-8">
						<form:select path="role" id="role" class="form-control">
							<form:option value="Student">Student</form:option>
						</form:select>
					</div>
				</div>
				
				<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
								<input type="submit" name="submit" class="btn btn-primary"
									value="Submit" />
				</div>
				</div> 
			</form:form>
		</div>
	</div>
</body>
</html>