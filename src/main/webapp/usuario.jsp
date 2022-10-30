<%@page import="entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librería</title>


<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">

</head>
<body>

<div class="container">

	<%@ include file="snippet/nav.jsp" %>
	
	<br>
	
	<div class="col-md-4">
	
		<h3>Registrar Usuarios</h3>
		
		<form action="UsuarioServlet" method="post" id="id_form">
		
			<input type="hidden" name="type" value="registrar">
			
		
			<div class="form-group">
			<label>Nombres </label>
			<input class="form-control" type="text" name="txtNombres" value="">
			</div>
			
			<div class="form-group">
				<label>Apellidos</label>
				<input class="form-control" type="text" name="txtApellidos" value="">
			</div>
			
			<div class="form-group">
				<label>Correo Electrónico</label>
				<input class="form-control" type="text" name="txtCorreo" value="">
			</div>
			
			<div class="form-group">
				<label>Contraseña</label>
				<input class="form-control" type="text" name="txtClave" value="">
			</div>
			
						
			<input type="submit" class="btn btn-primary" value="Enviar Datos">
			
		</form>
		
	</div>

	<div class="col-md-8">
		<h3>Listado de Usuarios</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Correo</th>										
				</tr>
			</thead>
			
			<tbody>
			
			<%			
			List<Usuario> listadoUsuarios = (List<Usuario>) request.getAttribute("data");			
			if (listadoUsuarios != null) {				
				for (Usuario item: listadoUsuarios) {					
			%>
			
			<tr>
				<td><%=item.getIdUsuario() %></td>
				<td><%=item.getNombres() %></td>
				<td><%=item.getApellidos() %></td>
				<td><%=item.getCorreo() %></td>				
			</tr>
					
			<%					
				}				
			}			
			%>
			
			</tbody>
		</table>
		
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
			txtNombre: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
					stringLength: {
		                min: 4,
		                max: 60,
		                message: 'El nombre debe ser entre 4 hasta 60 caracteres'
		            }
					
				}
			},
			
			txtApellidos: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
					stringLength: {
		                min: 4,
		                max: 60,
		                message: 'El apellido debe ser entre 4 hasta 60 caracteres'
		            }
				}
			},
			
			txtFechaNacimiento: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
				    date: {
	                        format: 'DD-MM-YYYY',
	                        message: 'El formato de fecha debe ser DD-MM-YYYY'
	                }
				}
			},
			
			txtCorreo: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
					emailAddress: {
						message: "El formato de correo electrónico es incorrecto"
					}
					
				}
			},
			
				
			txtClave: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
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