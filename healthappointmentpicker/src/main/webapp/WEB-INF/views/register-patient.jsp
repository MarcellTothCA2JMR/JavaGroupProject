<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>Egészségügyi Időpontfoglaló</title>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/h_a_p.css">
</head>
<body>
<div class="fixed-width container textbody register">
	<div class="brand-custom register-title">
		<h1>Egészségügyi <div>Időpontfoglaló</div></h1>
	</div>

	<form:form modelAttribute="addPatientRequest" action="/register-patient" >
	<div class="row">
		<div class="col column-left">
			<form:label path="name">Név:</form:label><br>
			<form:input path="name" /><br>
			<form:errors path="name" cssClass="error"/><br>

			<form:label path="email">E-mail:</form:label><br>
			<form:input path="email" /><br>
			<form:errors path="email" cssClass="error"/><br>

			<form:label path="password">Jelszó:</form:label><br>
			<form:password path="password" /><br>
			<form:errors path="password" cssClass="error"/><br>

			<form:label path="passwordAgain">Jelszó megerősítése:</form:label><br>
			<form:password path="passwordAgain" /><br>
			<form:errors path="passwordAgain" cssClass="error"/>
			<c:if test="${!addPatientRequest.getPassword().equals(addPatientRequest.getPasswordAgain())}">
				<div class="error">
					A két jelszó nem egyezik meg!
				</div>
			</c:if>
		</div>
		<div class="col column-right">
			<form:label path="healthInsuranceNumber">TAJ-szám:</form:label><br>
			<form:input path="healthInsuranceNumber" /><br>
			<form:errors path="healthInsuranceNumber" cssClass="error"/><br>

			<form:label path="birthday">Születési dátum:</form:label><br>
			<form:input type="date" path="birthday"/><br>
			<form:errors path="birthday" cssClass="error"/><br>

			<form:label path="birthLocation">Születési hely:</form:label><br>
			<form:select path="birthLocation">
				<form:option value="" label="-- select birth location"/>
				<form:options items="${birthLocations}" itemLabel="name" />
			</form:select><br>
			<form:errors path="birthLocation" cssClass="error"/>

		</div>
	</div>
		<div class="register-button">
			<input type="submit" value="Regisztráció"/>
		</div>
	</form:form>
</div>
</body>
</html>