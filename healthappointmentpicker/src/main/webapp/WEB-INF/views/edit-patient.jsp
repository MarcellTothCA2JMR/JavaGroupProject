<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Adatok módosítása</h1>

	<form:form modelAttribute="editPatientRequest" action="/edit-patient" >
		<form:hidden path="id"/>
		<form:hidden path="email"/>
		<form:hidden path="role"/>
		

		<div>
			<form:label path="name">Név:</form:label><br>
			<form:input path="name" /><br>
			<form:errors path="name" cssClass="error"/>
		</div>
		<div>
			<form:label path="healthInsuranceNumber">TAJ-szám:</form:label><br>
			<form:input path="healthInsuranceNumber" /><br>
			<form:errors path="healthInsuranceNumber" cssClass="error"/>
		</div>
		<div>
			<form:label path="birthday">Születési idő:</form:label><br>
			<form:input type="date" path="birthday"/><br>
			<form:errors path="birthday" cssClass="error"/>
		</div>
		<div>
			<form:label path="birthLocation">Születési hely:</form:label><br>
			<form:select path="birthLocation">
				<form:option value="" label="-- select birth location"/>
				<form:options items="${birthLocations}" itemLabel="name" />
			</form:select><br>
			<form:errors path="birthLocation" cssClass="error"/>
		</div>
		<br><br>
		<div>
			<form:label path="password">Kérem, adja meg helyesen a jelszavát a változtatások mentéséhez:</form:label><br>
			<form:password path="password" /><br>
			<form:errors path="password" cssClass="error"/>
		</div>
		<br>
		<div>
			<input type="submit" value="Módosítás"/>
		</div>

	</form:form>
<%@include file="_footer.jsp" %>