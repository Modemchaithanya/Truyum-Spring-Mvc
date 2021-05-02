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
				Cart
				<c:if test="${removeCartItemStatus}">
					<p class="message">Item removed from Cart successfully</p>
				</c:if>
			</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Free Delivery</th>
					<th>Price</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ cart.menuItemList}" var="menu">
				<tr>
					<td>${menu.name }</td>
					<td>${menu.freeDelivery ? 'Yes' : 'No'}</td>
					<td>Rs. ${menu.price }</td>
			
					
					<td><a href="/remove-cart-item?id=${menu.id }" class="btn btn-danger">Delete</a></td>
				
				</tr>
		</c:forEach>
		<tr>
			<th></th>
			<th>Total</th>
			<th>Rs. ${cart.total}</th>
		
		
		</tr>
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