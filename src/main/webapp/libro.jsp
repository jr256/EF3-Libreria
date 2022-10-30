<%@page import="entidades.Estado"%>
<%@page import="entidades.Categoria"%>
<%@page import="entidades.Libro"%>
<%@page import="entidades.Editorial"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-theme.css">
	<link rel="stylesheet" href="css/bootstrapValidator.css">
</head>
<body>

	<div class="container">
	
		<%@ include file="snippet/nav.jsp" %>	
		<br>
		
		<h1>Libro</h1>
	
	</div>
	
		
		<% 
			List<Editorial> listarEditorial = (List<Editorial>) request.getAttribute("data");
			List<Categoria> listarCategoria = (List<Categoria>) request.getAttribute("dataCategoria");
			List<Estado> listarEstado = (List<Estado>) request.getAttribute("dataEstado");
			Libro LibroForm = (Libro) request.getAttribute("dataLibro");
		%>
		<form action="LibroServlet" method="post">
		
			<input type="hidden" name="type" value="register">
			<input type="hidden" name="Id" value="<%=(LibroForm!=null)? LibroForm.getId():""%>">
		
			<div class="form-group">
				<label>Titulo</label>
				<input class="form-control" type="text" name="txtTitulo" 
				value="<%=(LibroForm!=null)?LibroForm.getTitulo():"" %>">
			</div>
			
			<div class="form-group">
				<label>ISBN</label>
				<input class="form-control" type="text" name="txtIsbn" 
				value="<%=(LibroForm!=null)?LibroForm.getIsbn():"" %>">
			</div>
			
			<div class="form-group">
				<label>Autor/label>
				<input class="form-control" type="text" name="txtAutor" 
				value="<%=(LibroForm!=null)?LibroForm.getAutor():"" %>">
			</div>
			
			<div class="form-group">
				<label>Editorial</label>
				<select  class="form-control" name="cboEditorial">
				<%
				if (listarEditorial != null) {
					
					for (Editorial item: listarEditorial) {
				%>	
						<option value="<%=item.getId()%>" <%=((LibroForm!=null) && (item.getId().equals(LibroForm.getIdEditorial())))? "selected='selected'":"" %> ><%=item.getEditorial()%></option>
				<%		
					}
				}
				%>
				</select>
			</div>
			
			<div class="form-group">
				<label>Fecha de Publicación</label>
				<input class="form-control" type="text" name="txtFechaPublicacion" 
				value="<%=(LibroForm!=null)?LibroForm.getTitulo():"" %>">
			</div>
			
			<div class="form-group">
				<label>Precio</label>
				<input class="form-control" type="text" name="txtPrecio" 
				value="<%=(LibroForm!=null)?LibroForm.getTitulo():"" %>">
			</div>
			
			<div class="form-group">
				<label>Categoria</label>
				<select  class="form-control" name="cboCategoria">
				<%
				if (listarCategoria != null) {
					
					for (Categoria item: listarCategoria) {
				%>	
						<option value="<%=item.getId()%>" <%=((LibroForm!=null) && (item.getId().equals(LibroForm.getIdCategoria())))? "selected='selected'":"" %> ><%=item.getCategoria()%></option>
				<%
						
					}
				}
				%>
				</select>
				<br>
			</div>
			
			<div class="form-group">
				<label>Stock</label>
				<input class="form-control" type="text" name="txtStock" 
				value="<%=(LibroForm!=null)?LibroForm.getStock():"" %>">
			</div>
			
			<div class="form-group">
				<label>Estado</label>
				<select  class="form-control" name="cboEstado">
				<%
				if (listarEstado != null) {
					
					for (Estado item: listarEstado) {
				%>	
						<option value="<%=item.getId()%>" <%=((LibroForm!=null) && (item.getId().equals(LibroForm.getIdEstado())))? "selected='selected'":"" %> ><%=item.getEstado()%></option>
				<%
						
					}
				}
				%>
				</select>
				<br>
			</div>

			
			<input type="submit" class="btn btn-primary" value="Enviar Datos">
			
		</form>
		
	</div>

	<div class="col-lg-8">
		<h3>Tabla Libros</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Isbn</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>Fecha de Publicación</th>
					<th>Precio</th>
					<th>Categoria</th>
					<th>Stock</th>
					<th>Estado</th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			List<Libro> listarLibro = (List<Libro>) request.getAttribute("dataLibros");
			
			if (listarLibro != null) {
				
				for (Libro item: listarLibro) {	
			%>
			
			<tr>
				<td><%=item.getId() %></td>
				<td><%=item.getTitulo() %></td>
				<td><%=item.getIsbn() %></td>
				<td><%=item.getAutor() %></td>
				<td><%=item.getIdEditorial() %></td>
				<td><%=item.getFechaPublicacion() %></td>
				<td><%=item.getPrecio() %></td>
				<td><%=item.getIdCategoria() %></td>
				<td><%=item.getEditorial() %></td>
				<td>
					<a href="LibroServlet?type=info&id=<%=item.getId()%>">
						<img alt="" src="img/ic_info.svg" width="20" height="20" title="Editar">
					</a>
										
					<a href="LibroServlet?type=delete&id=<%=item.getId()%>">
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
	

</body>
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
</html>