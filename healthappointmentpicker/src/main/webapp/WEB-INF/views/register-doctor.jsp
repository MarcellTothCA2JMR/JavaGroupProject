<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Orvos regisztrálása</h1>
	<form:form modelAttribute="addDoctorRequest" action="/register-doctor" >
		<div class="row">
			<div class="col">
				<div>
					<form:label path="name">Név:</form:label><br>
					<form:input path="name" /><br>
					<form:errors path="name" cssClass="error"/>
				</div>
				<div>
					<form:label path="email">E-mail:</form:label><br>
					<form:input path="email" /><br>
					<form:errors path="email" cssClass="error"/>
				</div>
				<div>
					<form:label path="yearOfGraduation">Végzés éve:</form:label><br>
					<form:input path="yearOfGraduation" /><br>
					<form:errors path="yearOfGraduation" cssClass="error"/>
				</div>
			</div>
			<div class="col column-right">
				<div>
					<form:label path="specialization">Szakterület:</form:label><br>
					<form:select path="specialization">
						<form:option value="" label="-- select specialization"/>
						<form:options items="${specializations}" itemLabel="name" />
					</form:select><br>
					<form:errors path="specialization" cssClass="error"/>
				</div>
				<div>
					<form:label path="password">Jelszó:</form:label><br>
					<form:password path="password" /><br>
					<form:errors path="password" cssClass="error"/>
				</div>
				<div>
					<form:label path="passwordAgain">Jelszó megerősítése:</form:label><br>
					<form:password path="passwordAgain" /><br>
					<form:errors path="passwordAgain" cssClass="error"/>
				</div>

				<c:if test="${!addDoctorRequest.getPassword().equals(addDoctorRequest.getPasswordAgain())}">
					<div class="error">
						A két jelszó nem egyezik meg!
					</div>
				</c:if>
			</div>
		<div class="doctor-register">
			<input type="submit" value="Regisztráció" class="register-button"/>
		</div>

	</form:form>
<%@include file="_footer.jsp" %>