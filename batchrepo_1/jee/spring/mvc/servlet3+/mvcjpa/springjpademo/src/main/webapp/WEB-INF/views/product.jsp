<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1> Prduct Details </html>

<h3>
Product id: <c:out  value="${product.id}"  />
</h3>

<h3>
Product name: <c:out  value="${product.name}"  />

</h3>


<h3>
Product Price: <c:out  value="${product.price}"  />

</h3>
</body>

</html>
