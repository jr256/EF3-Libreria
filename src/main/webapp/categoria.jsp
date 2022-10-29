<%@page import="entidades.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categoria</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-theme.css">
	<link rel="stylesheet" href="css/bootstrapValidator.css">
</head>
<body>

	<div class="container">
	
		<% 
			Categoria categoriaForm = (Categoria) request.getAttribute("categoriadata");
		%>
	
			<div class="col-lg-4">
		
			<h3>Registrar Categoria</h3>
			
			<form action="CategoriaServlet" method="post" id="">
			
			<input type="hidden" name="type" value="register">
				<input type="hidden" name="Id" value="<%=(categoriaForm!=null)? categoriaForm.getId():""%>"> 
			
				<div class="form-group">
				<label>Nombre Categoria</label>
				<input class="form-control" type="text" name="txtNombre"  value="<%=(categoriaForm!=null)? categoriaForm.getCategoria():""%>">
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
			List<Categoria> listarCategoria = (List<Categoria>) request.getAttribute("data");
			
			if(listarCategoria != null){
				for(Categoria item: listarCategoria){
			%>
			
			<tr>
				<td><%=item.getId()%></td>
				<td><%=item.getCategoria()%></td>
				<td>
					<a href="CategoriaServlet?type=info&id=<%=item.getId()%>">
					<img alt="" src="img/ic_info.svg" width="20" height="20" title="Editar">
					</a>
					<a href="CategoriaServlet?type=delete&id=<%=item.getId()%>">
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