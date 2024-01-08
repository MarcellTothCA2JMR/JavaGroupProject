<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Recept felírása</h1>

	<form:form modelAttribute="doctorPrescribeRequest" action="/make-prescription" >
		<form:hidden path="patientsToSelect"/>
		<form:hidden path="medicinesToSelect"/>

		<div>
			<form:label path="patient">Páciens:</form:label><br>
			<form:select path="patient">
				<form:option value="" label="-- select patient"/>
				<form:options items="${doctorPrescribeRequest.getPatientsToSelect()}" itemLabel="name" />
			</form:select><br>
			<form:errors path="patient" cssClass="error"/>
		</div>
		<div>
			<form:label path="medicine">Gyógyszer:</form:label><br>
			<form:select path="medicine">
				<form:option value="" label="-- select medicine"/>
				<form:options items="${doctorPrescribeRequest.getMedicinesToSelect()}" itemLabel="name" />
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
			<input type="submit" value="Felírás"/>
		</div>
		
	</form:form>
<%@include file="_footer.jsp" %>