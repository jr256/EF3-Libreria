<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librería-Login</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet" href="css/styles.css">

</head>
<body>

<div class="container">
	<br>
	<br>
	<h1>Sistema de Gestión de Librería</h1>
	<br>
	<div class="col-md-6">
		<img alt="" src="img/portada.png" width="80%" height="280" title="Portada">
	</div>
	
	<div class="col-md-6">
		<form action="InicioSesionServlet" method="post" id="id_form">
			
			<input type="hidden" name="type" value="login">
			
			<h2>Iniciar sesión</h2>
			<br>
			<div class="form-group">
				<label>Correo Electrónico</label>
				<input class="form-control" type="text" name="txtCorreo">
			</div>
			
			<div class="form-group">
				<label>Contraseña</label>
				<input class="form-control" type="password" name="txtClave">
			</div>
			
			<input type="submit" class="btn btn-primary" name="validateBtn" value="Enviar Datos">
			
		</form>
		<br>
		
		<%
		String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null) {
		%>
			<div class="alert alert-danger">
				<strong>Error!</strong> <%=mensaje %>
			</div>
		<%	
		}
		%>		
		
		
	</div>
		

	
	
</div>

</body>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	$('#id_form').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			txtCorreo: {
				validators: {
					notEmpty: {
						message: "El campo correo electrónico es obligatorio"
					},
					emailAddress: {
						message: "El formato de correo electrónico es incorrecto"
					}
				}
			},
			txtClave: {
				validators: {
					notEmpty: {
						message: "El campo contraseña es obligatorio"
					}
				}
			}
		}
	});
	
	$('#validateBtn').click(function(){
		$('#id_form').bootstrapValidator('validate');
	});
	
});


</script>

</html>



