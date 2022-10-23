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
		
		<h1>Venta</h1>
		
		
		
		
		<div class="col-md-4 ">
			<div class="form-group">
				<div class="col-md-4">
					<label>Correlativo</label>
				</div>
				<div class="col-md-8">
					<input type="text" readonly class="form-control">
				</div>										
			</div>
			
				<br>
				
			<div class="form-group">
				<div class="col-md-4">
					<label>Fecha venta</label>
				</div>
				<div class="col-md-8">
					<input type="text" readonly class="form-control">
				</div>						
			</div>
			
				<br>
			
			<label>Datos del cliente</label>	
			<div class="form-group">
				<div class="col-md-8">
					<input type="text" placeholder="Código de Cliente "name="txtCodigoCliente" class="form-control">
				</div>
				<div class="col-md-4">
					<button class="btn">Buscar</button>
				</div>				
			</div>
			
				<br>
			
			<div class="form-group">
				<div class="col-md-12">
					<input placeholder="Nombre del cliente" class="form-control">
				</div>
			</div>
			
				<br>
				
			<label>Datos del producto</label>
			
			<div class="form-group">
				<div class="col-md-8">
					<input type="text" placeholder="Código de Producto "name="txtCodigoProducto" class="form-control">
				</div>
				<div class="col-md-4">
					<button class="btn">Buscar</button>
				</div>				
			</div>
			
				<br>
			
			<div class="form-group">
				<div class="col-md-12">
					<input placeholder="Nombre del Producto" class="form-control">
				</div>								
			</div>
			
				
			
			<div class="form-group ">
				<div class="col-md-6">
					<input placeholder="stock" class="form-control" readonly>
				</div>
				<div class="col-md-6">
					<input placeholder="precio" class="form-control" readonly>
				</div>

				
			</div>
			
			<div class="form-group">
				
				<div class="col-md-8">
					<input type="number" placeholder="cantidad pedida" class="form-control">
				</div>
				<div class="col-md-4">
					<button class="btn btn-info">Agregar</button>
				</div>
				
			</div>
		
		
		</div>
		
			
		
		
		
	
	</div>
	

</body>
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
</html>