<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>

	<form:form modelAttribute="addAppointmentRequest" action="/add-appointment" >
		<form:hidden path="attendancesToSelect"/>
		<form:hidden path="dateAndTimesToSelect"/>
		<form:hidden path="patient"/>
		<form:hidden path="department"/>
		<form:hidden path="medicalAttendant"/>

		<div>
			<form:label path="attendance">Szolgáltatások:</form:label><br>
			<form:select path="attendance">
				<form:option value="" label="-- select attendance"/>
				<form:options items="${addAppointmentRequest.getAttendancesToSelect()}" itemLabel="name" />
			</form:select><br>
			<form:errors path="attendance" cssClass="error"/>
		</div>

		<c:if test="${levelForbidden}">
			<div class="error">
				A választott kezelés nem felvehető, előfeltétele eggyel alacsonyabb szintű kezelés!
			</div>
		</c:if>

		<div>
			<form:label path="dateAndTime">Dátum és idő:</form:label><br>
			<form:select path="dateAndTime">
				<form:option value="" label="-- select dateAndTime"/>
				<form:options items="${addAppointmentRequest.getDateAndTimesToSelect()}" />
			</form:select><br>
			<form:errors path="dateAndTime" cssClass="error"/>
		</div>
		<br><br>
		<div>
			<input type="submit" value="Mentés"/>
		</div>
		
	</form:form>
<%@include file="_footer.jsp" %>