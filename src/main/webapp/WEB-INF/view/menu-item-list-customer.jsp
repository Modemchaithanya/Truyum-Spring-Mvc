<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<a id="cart" href="/show-cart">Cart</a>
			<a id="menu" href="/show-menu-list-customer">Menu</a>
			
		
		</header>
</div>

<div class="container">
		<table class="table">
		<caption>
			Menu Items
			<c:if test="${addCartStatus}">
				<p class="message">Item added to Cart successfully</p>
			</c:if>
			</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Free Delivery</th>
					<th>Price</th>
					<th>Category</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ menuCustomer}" var="menu">
				<tr>
					<td>${menu.name }</td>
					<td>${menu.freeDelivery ? 'Yes' : 'No'}</td>
					<td>${menu.price }</td>
					<td>${menu.category}</td>
					
					<td><a href="/add-to-cart?id=${menu.id }" class="btn btn-success">Add to Cart</a></td>
				
				</tr>
		</c:forEach>
	</tbody>
		</table>
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