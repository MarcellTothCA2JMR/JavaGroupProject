<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/h_a_p.css">
</head>
<body>
	<h1>Hibaoldal</h1>
	<div class="error">
		<c:if test="${not empty errorMessage}">
			${errorMessage}
		</c:if>
		<c:if test="${empty errorMessage}">
			System error.
		</c:if>
	</div>
</body>
</html>