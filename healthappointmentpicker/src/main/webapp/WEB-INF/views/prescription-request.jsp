<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>

	<h1>Recept igénylése</h1>

	<form:form modelAttribute="addPrescriptionRequest" action="/request-prescription" >
		<form:hidden path="doctorsToSelect"/>
		<form:hidden path="medicinesToSelect"/>

		<div>
			<form:label path="doctor">Orvosok:</form:label><br>
			<form:select path="doctor">
				<form:option value="" label="-- select doctor"/>
				<form:options items="${addPrescriptionRequest.getDoctorsToSelect()}" itemLabel="name" />
			</form:select><br>
			<form:errors path="doctor" cssClass="error"/>
		</div>
		<div>
			<form:label path="medicine">Gyógyszer:</form:label><br>
			<form:select path="medicine">
				<form:option value="" label="-- select medicine"/>
				<form:options items="${addPrescriptionRequest.getMedicinesToSelect()}" itemLabel="name" />
			</form:select><br>
			<form:errors path="medicine" cssClass="error"/>
		</div>
		<div>
			<form:label path="justification">Indoklás:</form:label><br>
			<form:textarea path = "justification" rows = "10" cols = "50" /><br>
			<form:errors path="justification" cssClass="error"/>
		</div>
		<br><br>
		<div>
			<input type="submit" value="Igénylés"/>
		</div>
		
	</form:form>
<%@include file="_footer.jsp" %>