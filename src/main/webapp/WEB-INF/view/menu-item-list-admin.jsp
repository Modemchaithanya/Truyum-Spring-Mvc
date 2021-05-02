<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="/css/style.css"> 
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"      
	    		rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<div>
	<header>
			<span id="title">truYum</span>
			<img src="/images/logo.jpeg">
			<a id="menu" href="#">Menu</a>
		
		</header>
</div>
<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Active</th>
					<th>Date of Launch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					<th>Action</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ menuAdmin}" var="menu">
				<tr>
					<td>${menu.name }</td>
					<td>${menu.price }</td>
					<td>${menu.active ? 'Yes' : 'No'}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${menu.dateOfLaunch}" /></td>
					<td>${menu.category}</td>
					<td>${menu.freeDelivery ? 'Yes' : 'No'}</td>
					<td><a href="/show-edit-menu-item?id=${menu.id }" class="btn btn-success">Edit</a></td>
				</tr>
				
				
				
		</c:forEach>
	</tbody>
		</table>
</div>
<footer>

<div>
			Copyright &copy;&nbsp;
			<script>
				document.write(new Date().getFullYear())
			</script>
			</div>
</footer>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>       
</body>
</html>