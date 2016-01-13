<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				function addStudentToTable(element, index, array) {
					$('#studentTbl tbody').append(
							'<tr> 	<td>' + element['contactNo'] + '</td> <td>'
									+ element['firstName'] + '</td> <td>'
									+ element['lastName'] + '</td> <td>'
									+ element['dateOfBirth'] + '</td>	</tr>');
				}

				$.ajax({
					url : "/LOGIN/StudentDetails",
					success : function(students) {
						var studentsArr = JSON.stringify(students);
						students.forEach(addStudentToTable);
						$('#studentTbl').DataTable();
					}
				});				
				
			});
</script>


<title>User Home</title>
</head>
<body>


	<table id="studentTbl" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Contact Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

<center><button id="back" value="Back" onclick="location.href='Login.html'">Back</button></center>
</body>
</html>