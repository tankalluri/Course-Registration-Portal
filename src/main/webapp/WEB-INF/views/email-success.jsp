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
<script>
	var url="https://reqres.in/api/users";
	  function professorDetails(){
	    var xhttp= new XMLHttpRequest();
	    xhttp.onreadystatechange= function(){
	      if(this.readyState==4 && this.status==200){
	        var json= JSON.parse(this.response);
	        var content="";
	        for(var i=0;i<json.data.length;i++){
	          content+="<tr><td>"+json.data[i].first_name+"</td><td>"+json.data[i].last_name+"</td></tr>";

	        }
	        var userTable= document.getElementById("userTable");
	        userTable.tBodies[0].innerHTML = content;
	        userTable.style.display="block";
	      }
	    };
	    xhttp.open("GET", url, true);
	    xhttp.send();
}
</script>
<title>Northeastern University Course Registration Portal</title>
</head>
<body>
<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span>REGISTRATION CONFIRMATION</h4>
		</div>
		<a style="margin-left:860px" href="/courseRegistration/closeSession">Logout</a>
	<p style="margin-left:120px; color:red; font-size:20px">Email sent successfully to your registered email address. Your registration for the course is confirmed!</p>
	<form method="get" action="/courseRegistration/pdfView">
		<input type="submit" style="margin-left:420px" class="btn btn-primary" value="Get Billing Statement"/>
	</form><br><br>
	
	
<div class="container">   
  <table id="userTable" class="table">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
      </tr>
    </thead>
    <tbody>
      
    </tbody>
    <tfoot>
      <tr>
        <td colspan="2">
           <input type="button" style="margin-left:420px" class="btn btn-primary" value="Top Professors" onclick="professorDetails();"/>
        </td>
      </tr>
    </tfoot>
  </table>
</div>	
</body>
</html>