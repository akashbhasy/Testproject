<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>OnlineStore</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
  </style>
  <script>
function myFunction() {
  alert("All product Send to Your Address");
}
</script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index">Home</a></li>
        <li><a href="/viewAllProducts">Products</a></li>
        <li><a href="/addproduct">Add Products</a></li>
        <li><a href="#">Stores</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
	  
	  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a>
        <ul class="dropdown-menu">
          <li><a href="#">Profile View</a></li>
          <li><a href="/logout">Logout</a></li>
         </ul>
	  <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>
	<h3>Cart List</h3>
	
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Name</th>
			<th scope="col">Price</th>
			<th scope="col">Quantity</th>
			<th scope="col">Update Cart</th>
			<th scope="col">Delete Cart</th>
		</tr>
		</thead>
		<c:set var="total" value="${0}"/>
		<c:forEach var="cart" items="${Carts }">
			<tr>
			<form:form  modelAttribute="Carts">
				<td><input type="hidden" name="cart_ID"  value="${cart.cart_ID}"/>${cart.cart_ID }</td>
				<td><input type="hidden"  name="item_Name" value="${cart.item_Name }"/>${cart.item_Name }</td>
				<td><input type="hidden"  name="item_Price" value="${cart.item_Price }"  />${cart.item_Price }</td>
				<td><input type="hidden"   value="${cart.item_Quantity }" >
				<input type="text" name="item_Quantity" placeholder="${cart.item_Quantity }" value="${cart.item_Quantity }" ></td>
				<td><input type="submit" class="fadeIn fourth" value="Update Cart" formaction="updateCart"></td>
				<td><input type="submit" class="fadeIn fourth" value="Delete Cart" formaction="deleteCart"></td>
				 <c:set var="total" value="${total +cart.item_Price}" />
</form:form>
			</tr>
			
		</c:forEach>
		<tr><td>Total Price: "${total}"  </td> <td><button onclick="myFunction()">BUY</button> </td></tr>
	</table>
	
	
</body>
</html>