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
			<img src="images\logo.jpeg" height="30" width="40">
			<a id="cart" href="/show-cart">Cart</a>
			<a id="menu" href="/show-menu-list-customer">Menu</a>
		
		</header>
		<div id="content">
			<p id="menu-head">Cart</p>
			<p id="empty">No items in cart.Use 'Add to Cart' option in <a href="/show-menu-list-customer">Menu Item List</a></p>
		</div>
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