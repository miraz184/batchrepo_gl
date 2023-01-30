<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1>Find Product by id </h1>

<div>

<form method="get" action="/processAddProduct">

<div>

<label> Enter Name </label>
<input name="name"  >

</div>


<div>

<label> Enter Price </label>
<input name="price" type="number" >

</div>


 <input type="submit" value="Add Product">
</form>


</div>


</body>

</html>