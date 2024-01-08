<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Orvosok</h1>
	<table>
	<tr>
		<th>Név</th>
		<th>E-mail</th>
		<th>Végzés éve</th>
		<th>Kiválasztás</th>
	</tr>
	
	<c:forEach items="${doctors}" var="doctor">
	<tr>
		<td>${doctor.name}</td>
		<td>${doctor.email}</td>
		<td>${doctor.yearOfGraduation}</td>		
		<td><a href="add-appointment-${departmentid}-${doctor.id}">Kiválasztás</a></td>
	</tr>
	</c:forEach>

	</table>
<%@include file="_footer.jsp" %>