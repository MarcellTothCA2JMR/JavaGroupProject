<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Egészségügyi Időpontfoglaló</title>
		<meta charset="UTF-8">
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    	<link rel="stylesheet" type="text/css" href="css/h_a_p.css">
	</head>

	<body>
	<div class="fixed-width container textbody login">
		<div class="brand-custom login-title">
			<h1>Egészségügyi <div>Időpontfoglaló</div></h1>
		</div>
		
		<c:if test="${param.error != null}">
		<div class="error">
			Helytelen felhasználónév vagy jelszó!
		</div>
		</c:if>
		
		<c:if test="${param.logout != null}">
		<div>
			Sikeresen kijelentkezett!
		</div>
		</c:if>
		<p>${message}</p>
		
		<form:form action="login" method="POST">
			<label>E-mail cím</label><br>
			<input type="text" name="username"/><br>
			<label>Jelszó</label><br>
			<input type="password" name="password"/><br>
			<input type="submit" name="login" value="Bejelentkezés"/>
		</form:form>

		<p>Nincs még fiókja? Itt tud <a href="register-patient">regisztrálni.</a></p>
			
	</div>
	</body>
</html>