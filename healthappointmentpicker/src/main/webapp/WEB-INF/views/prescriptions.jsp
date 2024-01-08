<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Receptek</h1>
	<h3>Igényelt receptek</h3>
	<c:if test="${reqPrescriptions.size() == 0}">
		<p>Nincsenek igényelt receptjeid.</p>
	</c:if>
	<c:if test="${reqPrescriptions.size() > 0}">
		<table>
			<tr>
				<th>Dátum és idő</th>
				<th>Indoklás</th>
				<th>Státusz</th>
				<th>Gyógyszer</th>
				<sec:authorize url="/doctors**">
					<th>Orvos</th>
				</sec:authorize>
				<sec:authorize url="/prescriptions-**">
					<th>Páciens</th>
					<th>Jóváhagyás</th>
					<th>Elutasítás</th>
				</sec:authorize>
			</tr>

			<c:forEach items="${reqPrescriptions}" var="reqprescription">
				<tr>
					<td>${reqprescription.dateAndTime.toLocalDate()} ${reqprescription.dateAndTime.toLocalTime()}</td>
					<td>${reqprescription.justification}</td>
					<td>${reqprescription.status}</td>
					<td>${reqprescription.medicine.name}</td>
					<sec:authorize url="/doctors**">
						<td>${reqprescription.doctor.name}</td>
					</sec:authorize>
					<sec:authorize url="/prescriptions-**">
						<td>${reqprescription.patient.name}</td>
						<td><a href="prescriptions-${reqprescription.id}-0">Jóváhagyás</a></td>
						<td><a href="prescriptions-${reqprescription.id}-1">Elutasítás</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</c:if>

	<br><br>
	
	<h3>Elbírált receptek</h3>
	<c:if test="${evaPrescriptions.size() == 0}">
		<p>Nincsenek elbírált receptjeid.</p>
	</c:if>
	<c:if test="${evaPrescriptions.size() > 0}">
		<table>
			<tr>
				<th>Dátum és idő</th>
				<th>Indoklás</th>
				<th>Státusz</th>
				<th>Gyógyszer</th>
				<sec:authorize url="/doctors**">
					<th>Orvos</th>
				</sec:authorize>
				<sec:authorize url="/prescriptions-**">
					<th>Páciens</th>
				</sec:authorize>
			</tr>

			<c:forEach items="${evaPrescriptions}" var="evaprescription">
				<tr>
					<td>${evaprescription.dateAndTime.toLocalDate()} ${evaprescription.dateAndTime.toLocalTime()}</td>
					<td>${evaprescription.justification}</td>
					<td>${evaprescription.status}</td>
					<td>${evaprescription.medicine.name}</td>
					<sec:authorize url="/doctors**">
						<td>${evaprescription.doctor.name}</td>
					</sec:authorize>
					<sec:authorize url="/prescriptions-**">
						<td>${evaprescription.patient.name}</td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</c:if>
<%@include file="_footer.jsp" %>