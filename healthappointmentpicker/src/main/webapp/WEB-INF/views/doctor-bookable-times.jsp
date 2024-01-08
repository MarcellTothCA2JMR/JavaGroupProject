<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Foglalható időpontok</h1>


	<c:if test="${bookableTimes.size() == 0}">
		<p>Nincsenek foglalható időpontjaid.</p>
	</c:if>

	<c:if test="${bookableTimes.size() > 0}">
		<table>
			<tr>
				<th>Dátum és idő</th>
				<sec:authorize url="/bookable-times**">
					<th>Eltávolítás</th>
				</sec:authorize>
			</tr>

			<c:forEach items="${bookableTimes}" var="bookableTime">
				<tr>
					<td>${bookableTime.toLocalDate()} ${bookableTime.toLocalTime()}</td>
					<sec:authorize url="/bookable-times**">
						<td><a href="bookable-times-remove-${bookableTimes.indexOf(bookableTime)}">Törlés</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>

		</table>
	</c:if>

	<br><br><br><br>

	<h1>Új időpont hozzáadása</h1>

	<form:form modelAttribute="addBookableTimeRequest" action="/add-bookable-time" >
		<div>
			<form:label path="dateAndTime">Dátum és idő:</form:label><br>
			<form:input type="datetime-local" path="dateAndTime"/><br>
			<form:errors path="dateAndTime" cssClass="error"/>
		</div>
		<br>
		<div>
			<input type="submit" value="Mentés"/>
		</div>
		
	</form:form>

	<p>${message}</p>
<%@include file="_footer.jsp" %>