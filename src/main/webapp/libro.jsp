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
<title>Librería-Libro</title>
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
			<h3>Registrar Libro</h3>
			<% 
				List<Editorial> listarEditorial = (List<Editorial>) request.getAttribute("dataEditorial");
				List<Categoria> listarCategoria = (List<Categoria>) request.getAttribute("dataCategoria");
				List<Estado> listarEstado = (List<Estado>) request.getAttribute("dataEstado");
				Libro LibroForm = (Libro) request.getAttribute("dataLibro");
			%>
			<form action="LibroServlet" method="post">
			
			
				<input type="hidden" name="type" value="register">
				<input type="hidden" name="Id" value="<%=(LibroForm!=null)? LibroForm.getId():""%>">
			
			
				<div class="col-md-4">
				
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
						<label>Autor</label>
						<input class="form-control" type="text" name="txtAutor" 
						value="<%=(LibroForm!=null)?LibroForm.getAutor():"" %>">
					</div>				
				
				</div>
				
				<div class="col-md-4">
				
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
						<input class="form-control" type="text" placeholder="AAAA-MM-DD" name="txtFechaPublicacion" 
						value="<%=(LibroForm!=null)?LibroForm.getFechaPublicacion():"" %>">
					</div>
					
					<div class="form-group">
						<label>Precio S/</label>
						<input class="form-control" type="text" placeholder="0.00" name="txtPrecio" 
						value="<%=(LibroForm!=null)?LibroForm.getPrecio():"" %>">
					</div>
				
				</div>
				
				<div class="col-md-4">
				
					<div class="form-group">
					<label>Categoría</label>
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
					
					</div>
				
					<div class="form-group">
						<label>Stock</label>
						<input class="form-control" placeholder="0" type="text" name="txtStock" 
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
				
				
				</div>
				
						
				
				<input type="submit" class="btn btn-primary" value="Enviar Datos">
				
			</form>
			
		
		</div>
		
	
		<div class="col-md-12">
		
		<h3>Mantenimiento de Libros</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Isbn</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>Publicación</th>
					<th>Precio S/</th>
					<th>Categoría</th>
					<th>Stock</th>
					<th>Estado</th>
					<th>Acciones</th>
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
				<td><%=item.getEditorial() %></td>
				<td><%=item.getFechaPublicacion() %></td>
				<td><%=item.getPrecio() %></td>
				<td><%=item.getCategoria() %></td>
				<td><%=item.getStock() %></td>
				<td><%=item.getEstado() %></td>
				<td>
					<a href="LibroServlet?type=info&id=<%=item.getId()%>">
						<button class="btn btn-info">Editar</button>
					</a>
										
					<a href="LibroServlet?type=delete&id=<%=item.getId()%>">
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