<%@page import="entidades.Cliente"%>
<%@page import="entidades.Estado"%>
<%@page import="entidades.TipoDocumento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librería-Cliente</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet" href="css/styles.css">

</head>
<body>

<div class="container">
	
	<%@ include file="snippet/nav.jsp" %>
	
	<br>
	
	<div class="col-md-12">
	
		<h3>Registrar Clientes</h3>
		
		<% 
			List<TipoDocumento> listaDocumentos = (List<TipoDocumento>) request.getAttribute("dataTipoDocumentos");
			List<Estado> listaEstados = (List<Estado>) request.getAttribute("dataEstados");
			Cliente clienteForm = (Cliente) request.getAttribute("dataCliente");
		%>
		<form action="ClienteServlet" method="post" id="id_form">
		
			<input type="hidden" name="type" value="register">
			<input type="hidden" name="idCliente" value="<%=(clienteForm!=null)? clienteForm.getId():""%>">
			
			<div class="col-md-4">
			
			<div class="form-group">
					<label>Documento</label>
					<select  class="form-control" name="cboTipoDocumento">
					<%
					if (listaDocumentos != null) {
						
						for (TipoDocumento item: listaDocumentos) {
					%>	
							<option value="<%=item.getId()%>" <%=((clienteForm!=null) && (item.getId().equals(clienteForm.getIdTipoDocumento())))? "selected='selected'":"" %> ><%=item.getDocumento()%></option>
					<%
							
						}
					}
					%>
					</select>
					<br>
					<label>Número documento</label>
					
					<input class="form-control" type="text" name="txtNumeroDocumento" 
					value="<%=(clienteForm!=null)?clienteForm.getNumeroDocumento():"" %>">
				</div>
				
			
			</div>
			
			
			<div class="col-md-4">
			
				<div class="form-group">
				<label>Cliente</label>
				<input class="form-control" type="text" name="txtNombreCliente" 
				value="<%=(clienteForm!=null)?clienteForm.getNombreCliente():"" %>">
				</div>
				
				<div class="form-group">
					<label>Estado</label>
					<select  class="form-control" name="cboEstado">
					<%
					if (listaEstados != null) {
						
						for (Estado item: listaEstados) {
					%>	
							<option value="<%=item.getId()%>" <%=((clienteForm!=null) && (item.getId().equals(clienteForm.getIdEstado())))? "selected='selected'":"" %> ><%=item.getEstado()%></option>
					<%
							
						}
					}
					%>
					</select>
					
				
				</div>
			
			
			</div>
			
			<div class="col-md-4">
								
				<div class="form-group">
					<label>Direccion</label>
					<input class="form-control" type="text" name="txtDireccion" 
					value="<%=(clienteForm!=null)?clienteForm.getDireccion():"" %>">
				</div>
				<br>
			
						
			
			</div>
			
			<div class="col-md-12">
				<input type="submit" class="btn btn-primary" value="Enviar Datos">
			</div>			
			
					
			
		</form>
		
	</div>

	<div class="col-md-12">
		<h3>Mantenedor Clientes</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>					
					<th>Documento</th>
					<th>N° Documento</th>
					<th>Cliente</th>					
					<th>Estado</th>
					<th>Dirección</th>
					<th>Acciones</th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("dataClientes");
			
			if (listaClientes != null) {
				
				for (Cliente item: listaClientes) {	
			%>
			
			<tr>
				<td><%=item.getId() %></td>
				<td><%=item.getTipoDocumento() %></td>
				<td><%=item.getNumeroDocumento() %></td>
				<td><%=item.getNombreCliente() %></td>
				<td><%=item.getEstado() %></td>
				<td><%=item.getDireccion() %></td>
				
				<td>
					<a href="ClienteServlet?type=info&id=<%=item.getId()%>">
						<button class="btn btn-info">Editar</button>
					</a>
										
					<a href="ClienteServlet?type=delete&id=<%=item.getId()%>">
						<button class="btn btn-danger">Eliminar</button>
					</a>
					
				</td>
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
			txtNumeroDocumento: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
					stringLength: {
		                min: 4,
		                max: 25,
		                message: 'El nombre debe ser entre 5 hasta 25 caracteres'
		            }
					
				}
			},
			
			txtNombreCliente: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
					stringLength: {
		                min: 4,
		                max: 45,
		                message: 'El apellido debe ser entre 4 hasta 45 caracteres'
		            }
				}
			},
						
				
			txtDireccion: {
				validators: {
					notEmpty: {
						message: "El campo es obligatorio"
					},
					stringLength: {
		                min: 4,
		                max: 100,
		                message: 'El apellido debe ser entre 4 hasta 100 caracteres'
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