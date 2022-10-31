<%@page import="entidades.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librería-Categoría</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-theme.css">
	<link rel="stylesheet" href="css/bootstrapValidator.css">
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<div class="container">
	
		<%@ include file="snippet/nav.jsp" %>
	
		<br>
	
		<% 
			Categoria categoriaForm = (Categoria) request.getAttribute("categoriadata");
		%>
	
			<div class="col-md-4">
		
			<h3>Registrar Categoría</h3>
			
			<form action="CategoriaServlet" method="post" id="">
			
			<input type="hidden" name="type" value="register">
				<input type="hidden" name="Id" value="<%=(categoriaForm!=null)? categoriaForm.getId():""%>"> 
			
				<div class="form-group">
				<label>Nombre Categoría</label>
				<input class="form-control" type="text" name="txtNombre"  value="<%=(categoriaForm!=null)? categoriaForm.getCategoria():""%>">
				</div>
				
				<input type="submit" class="btn btn-primary" value="Enviar Datos">
				
			</form>
		</div>
		
		<div class="col-md-8">

		<h3>Mantenimiento de Categorías</h3>
			<table class="table" >
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre de la Categoría</th>
						<th>Acciones</th>
					</tr>
				</thead>
				
			<tbody>
			
			<%
			List<Categoria> listarCategoria = (List<Categoria>) request.getAttribute("data");
			
			if(listarCategoria != null){
				for(Categoria item: listarCategoria){
			%>
			
			<tr>
				<td><%=item.getId()%></td>
				<td><%=item.getCategoria()%></td>
				<td>
					<a href="CategoriaServlet?type=info&id=<%=item.getId()%>">
						<button class="btn btn-info">Editar</button>
					</a>
					<a href="CategoriaServlet?type=delete&id=<%=item.getId()%>">
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
</html>