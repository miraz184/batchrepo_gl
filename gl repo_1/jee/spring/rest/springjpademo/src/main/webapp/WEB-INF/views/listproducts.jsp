<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1> Listing Products </h1>

<ul>
<c:forEach items="${products}" var="product">
<li>

Product ID: <c:out  value="${product.id}"  />
,
Product Name: <c:out  value="${product.name}"  />
,
Product Price: <c:out  value="${product.price}"  />
,

<a href="/product?id=${product.id}">see complete details <a/>


</li>



</c:forEach>
</ul>

</body>

</html>
