<%@page import="util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute(Constantes.NAME) == null) {
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librería-Inicio</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-theme.css">
	<link rel="stylesheet" href="css/bootstrapValidator.css">
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
	
	
		<%@ include file="snippet/nav.jsp" %>
		<br>
		<% String name = (String) session.getAttribute(Constantes.NAME); %>
		<% String lastname = (String) session.getAttribute(Constantes.LASTNAME); %>
		
		<div class="col-md-5">
			<h3>Bienvenido <%=name %> <%=lastname %></h3>
			<h2>Sistema de Gestión de Librería</h2>		
		</div>

		<div class="col-md-7">
		  <h2>Experiencias Formativas en Situaciones Reales de Trabajo III</h2>
		  <h2>Integrantes</h2>
		  <ul>
		  		<li>Rubio Guerrero, José Antonio</li>
		  		<li>Vallas Herencia, Leticia Elizabet</li>
		  		<li>Carrasco Castro, Segundo Vicente</li>
		  		
		  </ul>		
		</div>
	
	</div>

</body>
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
</html>