<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add the products</title>
</head>
<body>
<h1>Search By ID</h1>
<form:form action="/searchbyId">
<table>
<tr><td>Product Id to Search:</td><td><form:input path="productId"/></td></tr>
<tr><td>Product Name:</td><td><form:input path="productName"/></td></tr>
<tr><td>Product In Hand:</td><td><form:input path="quantityOnHand"/></td></tr>
<tr><td>Product Price:</td><td><form:input path="price"/></td></tr>
<tr><td><input type="submit" value="Fetch"></td>
<td><input type="submit" value="Reset" formaction="searchProductById"></td>
<td><input type="submit" value="Delete" formaction="deleteByID">
</tr>
</table>
</form:form>
${msg}
</body>
</html>

