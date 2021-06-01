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
        <li><a href="viewAllProducts">Products</a></li>
        <li><a href="addproduct">Add Products</a></li>
        <li><a href="#">Stores</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
	  
	  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a>
        <ul class="dropdown-menu">
          <li><a href="#">Profile View</a></li>
          <li><a href="/logout">Logout</a></li>
         </ul>
	  <li><a href="cart/mycart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>
	<h3>product List</h3>
	
	
	<table class="table table-hover">
	 <thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Name</th>
			<th scope="col">Price</th>
			<th scope="col">Quantity</th>
			<th scope="col">ADD to Cart</th>
		</tr>
		</thead>
		<c:forEach var="product" items="${Products }">
			<tr>
			<form:form  method="POST" action="cart/saveCart" modelAttribute="Products">
				<td><input type="hidden" name="productId"  value="${product.productId}"/>${product.productId}</td>
				<td><input type="hidden"  name="productName" value="${product.productName }"/>${product.productName }</td>
				<td><input type="hidden"  name="price" id=product.price${product.productId } value="${product.price }"  />${product.price }</td>
				<td><input type="hidden"   id=product.quantityOnHand${product.productId} value="${product.quantityOnHand }" >
				<input type="text" name="quantityOnHand" placeholder="${product.quantityOnHand }" required></td>
				<td><input type="submit" class="fadeIn fourth" value="Add to Cart"></td>
</form:form>
			</tr>
		</c:forEach>
		
	</table>
	${msg}

</body>
</html>