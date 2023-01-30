<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1>Welcome back </html>

<div>
<h3>Page used count </h3>

<c:out  value="${renderCount}"  />
</h3>
</div>

<div>

<a href="/addproduct"> Add New Product </a>

<br>

<a href="/findproduct"> Find Product</a>

<br>
<a href="/allproducts" > See All Products </a>



</div>

</body>

</html>
