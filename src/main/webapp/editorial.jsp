<%@page import="entidades.Editorial"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editorial</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-theme.css">
	<link rel="stylesheet" href="css/bootstrapValidator.css">
</head>
<body>

	<div class="container">
	
		<% 
			Editorial editorialForm = (Editorial) request.getAttribute("editorialdata");
		%>
	
			<div class="col-lg-4">
		
			<h3>Registrar Editorial</h3>
			
			<form action="EditorialServlet" method="post" id="">
			
			<input type="hidden" name="type" value="register">
				<input type="hidden" name="Id" value="<%=(editorialForm!=null)? editorialForm.getId():""%>"> 
			
				<div class="form-group">
				<label>Nombre Editorial</label>
				<input class="form-control" type="text" name="txtNombre"  value="<%=(editorialForm!=null)? editorialForm.getEditorial():""%>">
				</div>
				
				<input type="submit" class="btn btn-primary" value="Enviar Datos">
				
			</form>
		</div>
		
		<div class="col-lg-8">

		<h3>Editoriales Disponibles</h3>
			<table class="table" >
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre de la Editorial</th>
					</tr>
				</thead>
				
			<tbody>
			
			<%
			List<Editorial> listarEditorial = (List<Editorial>) request.getAttribute("data");
			
			if(listarEditorial != null){
				for(Editorial item: listarEditorial){
			%>
			
			<tr>
				<td><%=item.getId()%></td>
				<td><%=item.getEditorial() %></td>
				<td>
					<a href="EditorialServlet?type=info&id=<%=item.getId()%>">
					<img alt="" src="img/ic_info.svg" width="20" height="20" title="Editar">
					</a>
					<a href="EditorialServlet?type=delete&id=<%=item.getId()%>">
					<img alt="" src="img/ic_delete.svg" width="20" height="20" title="Eliminar">
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
</html>