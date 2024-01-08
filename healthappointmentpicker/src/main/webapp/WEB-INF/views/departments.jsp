<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@include file="_header.jsp" %>
	<h1>Szakosztályok</h1>
	<p>${message}</p>
	<table>
	<tr>
		<th>Emelet</th>
		<th>Kategória</th>
		<sec:authorize url="/doctors**">
			<th>Időpont kérése</th>
			<th>Recept igénylése</th>
		</sec:authorize>
	</tr>
	
	<c:forEach items="${departments}" var="department">
	<tr>
		<td>${department.floor}</td>
		<td>${department.category}</td>
		<sec:authorize url="/doctors**">
			<td><a href="doctors-${department.id}">Kiválasztás</a></td>
			<td><a href="request-prescription-${department.id}">Igénylés</a></td>
		</sec:authorize>
	</tr>
	</c:forEach>

	</table>
<%@include file="_footer.jsp" %>