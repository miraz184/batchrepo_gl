<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1> Profile Info </html>

<h3>
Userid: <c:out  value="${user.id}"  />
</h3>

<h3>
Username: <c:out  value="${user.name}"  />

</h3>


</body>

</html>
