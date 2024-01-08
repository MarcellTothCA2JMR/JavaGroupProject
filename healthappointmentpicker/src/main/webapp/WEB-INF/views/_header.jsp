<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Egészségügyi Időpontfoglaló</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/h_a_p.css">
</head>
<body>
<div class="container">
<header>
    <nav class="navbar navbar-expand-lg navbar-light py-2 navbar-custom ">
        <a class="navbar-brand mb-0 brand-custom" href="homepage">Egészségügyi <div>Időpontfoglaló</div></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto nav-row">
              <li class="nav-item nav-customitem">
                <a class="nav-link nav-custom" href="departments">Szakosztályok</a>
              </li>
              
              <sec:authorize url="/appointments">
	              <li class="nav-item nav-customitem">
	                <a class="nav-link nav-custom" href="appointments">Foglalt időpontjaim</a>
	              </li>
              </sec:authorize>
              <sec:authorize url="/prescriptions">
	              <li class="nav-item nav-customitem">
	                <a class="nav-link nav-custom" href="prescriptions">Receptjeim</a>
	              </li>
              </sec:authorize>
              
              <sec:authorize url="/doctors**">
	              <li class="nav-item nav-customitem">
	                <a class="nav-link nav-custom" href="edit-patient">Profil módosítása</a>
	              </li>
              </sec:authorize>
              <sec:authorize url="/bookable-times**">
	              <li class="nav-item nav-customitem">
	                <a class="nav-link nav-custom" href="bookable-times">Szabad időpontjaim</a>
	              </li>
	              <li class="nav-item nav-customitem">
	                <a class="nav-link nav-custom" href="make-prescription">Recept felírása</a>
	              </li>
              </sec:authorize>
              <sec:authorize url="/register-doctor**">
	              <li class="nav-item nav-customitem">
	                <a class="nav-link nav-custom" href="register-doctor">Új orvos regisztrálása</a>
	              </li>
              </sec:authorize>
            </ul> 
        </div>
    </nav>
    
    <div>
		<form:form action="/logout">
			<input type="submit" value="Kijelentkezés"/>
		</form:form>
		<span>Felhasználó: <sec:authentication property="name"/></span>
	</div>

</header>
</div>

<div class="fixed-witdth container textbody">
    <section class="content">