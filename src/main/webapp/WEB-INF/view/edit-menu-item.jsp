<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" type="text/css" href="/css/style.css"> 
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"      
	    		rel="stylesheet">
</head>
<body>
<div>
	<header>
			<span id="title">truYum</span>
			<img src="/images/logo.jpeg">
			<a id="menu" href="/show-menu-list-admin">Menu</a>
		
		</header>
</div>

<div>
			<p id="menu-head">Edit Menu Item</p>
			<form:form name="menuItemForm" method="post" action="edit-menu-item" modelAttribute="menuItem">
				<table class="table">
					<tr><td colspan="4"><form:label path="name" for="name" id="lname">Name</form:label></td></tr>
					<tr><td colspan="4"><form:input path="name" type="text" id="name" placeholder="Sandwich" size="100"/><br></td></tr>
					<tr><td colspan="4"><form:errors path="name" cssClass="error"/></td></tr>
					<tr>
						<td><form:label path="price" for="price">Price(Rs.)</form:label></td>
						<td><form:label path="active" for="yes">Active</form:label></td>
						<td><form:label path="dateOfLaunch" for="date">Date of Launch</form:label></td>
						<td><form:label path="category" for="category">Category</form:label></td>
					</tr>
					<tr>
						<td><form:input  path="price" id="price" placeholder="97"/>
						<form:input type="hidden" path="id" id="id"/></td>

						<td><form:radiobutton  path="active" value="true" id="yes" name="active"/>Yes
						<form:radiobutton  path="active" value="false" id="no" name="active"/>No</td>
						<td><form:input path="dateOfLaunch" id="date" placeholder="27/04/2022"/></td>
						
						<td><form:select path="category" id="category">
							<form:option value="starters">Starters</form:option>
							<form:option value="main">Main Course</form:option>
							<form:option value="desserts">Desserts</form:option>
							<form:option value="drinks">Drinks</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td ><form:errors path="price" cssClass="error"/></td>
						<td ></td>
						<td><form:errors path="dateOfLaunch" cssClass="error"/></td>
						<td></td>
					</tr> 
					
					<tr> 
						<td><form:checkbox path="freeDelivery" checked="true"/>Free Delivery<br><br><br></td>
					</tr>
					<tr>
						<td><input type="submit" id="save" value="Save"></td>
					</tr>
				</table>
			</form:form>
			
		</div>


<div>
<footer>
			Copyright &copy;&nbsp;
			<script>
				document.write(new Date().getFullYear())
			</script>
</footer>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>     
</body>
</html>