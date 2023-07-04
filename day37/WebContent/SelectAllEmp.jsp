<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
<style type="text/css">
		
	#add{
		
		position: relative;
		left: 18%;
		text-decoration: none;
		
		border: 1px solid black;
	}
	
</style>

</head>
<body>

<a id ="add" href ="InsrtEmp.jsp">Add</a>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Mobile No.</th>
			<th>EmailId</th>
			<th>Password</th>
		</tr>
		<c:forEach var="data" items="${userList }">
			<tr>
				<td>${data.name }</td>
				<td>${data.mob }</td>
				<td> ${data.mail }</td>
				<td>${data.pass }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>