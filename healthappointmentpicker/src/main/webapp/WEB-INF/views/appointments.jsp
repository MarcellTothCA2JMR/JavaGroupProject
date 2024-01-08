<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Időpontok</h1>
	<h3>Aktuális időpontok</h3>
	<c:if test="${actualAppointments.size() > 0}">
		<table>
			<tr>
				<th>Dátum és idő</th>
				<th>Szakosztály</th>
				<th>Szolgáltatás</th>
				<sec:authorize url="/make-prescription">
					<th>Páciens</th>
				</sec:authorize>
				<sec:authorize url="/remove-appointment**">
					<th>Orvos</th>
					<th>Törlés</th>
				</sec:authorize>
			</tr>

			<c:forEach items="${actualAppointments}" var="actualAppointment">
				<tr>
					<td>${actualAppointment.dateAndTime.toLocalDate()} ${actualAppointment.dateAndTime.toLocalTime()}</td>
					<td>${actualAppointment.department.category}</td>
					<td>${actualAppointment.attendance.name}</td>
					<sec:authorize url="/make-prescription">
						<td>${actualAppointment.patient.name}</td>
					</sec:authorize>
					<sec:authorize url="/remove-appointment**">
						<td>${actualAppointment.doctor.name}</td>
						<td><a href="remove-appointment-${actualAppointment.id}">Törlés</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<c:if test="${actualAppointments.size() == 0}">
		<p>Nincsenek aktuális időpontjaid.</p>
	</c:if>

	<br><br>
	<h3>Korábbi időpontok</h3>
	<c:if test="${pastAppointments.size() > 0}">
		<table>
			<tr>
				<th>Dátum és idő</th>
				<th>Szakosztály</th>
				<th>Szolgáltatás</th>
				<sec:authorize url="/make-prescription">
					<th>Páciens</th>
				</sec:authorize>
				<sec:authorize url="/remove-appointment**">
					<th>Orvos</th>
				</sec:authorize>
			</tr>

			<c:forEach items="${pastAppointments}" var="pastAppointment">
				<tr>
					<td>${pastAppointment.dateAndTime.toLocalDate()} ${pastAppointment.dateAndTime.toLocalTime()}</td>
					<td>${pastAppointment.department.category}</td>
					<td>${pastAppointment.attendance.name}</td>
					<sec:authorize url="/make-prescription">
						<td>${pastAppointment.patient.name}</td>
					</sec:authorize>
					<sec:authorize url="/remove-appointment**">
						<td>${pastAppointment.doctor.name}</td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<c:if test="${pastAppointments.size() == 0}">
		<p>Nincsenek korábbi időpontjaid.</p>
	</c:if>
<%@include file="_footer.jsp" %>

<c:if test="${pastAppointments.size() > 0}">

</c:if>