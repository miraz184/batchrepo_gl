<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1>Find Product by id </h1>

<div>

<form method="get" action="/product">


<label> Enter Id </label>
<input name="id"  >

    <br>
<input type="submit" value="Find Product">


</form>


</div>


</body>

</html>