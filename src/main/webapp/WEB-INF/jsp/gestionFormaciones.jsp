<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Recursos Humanos</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
</head>
<body>
	<p id="rojo"> ${mensaje} </p>
	<h1> Lista de Formaciones</h1>
	<table border="1">
			<tr>
				<th>Id </th>
				<th>Descripcion </th>
				<th>Acciones</th>
		<c:forEach var="formacion" items="${formaciones}">
			<tr>
				<td> ${formacion.id_formacion}</td>
				<td> ${formacion.descripcion}</td>
				<td> <a href="${pageContext.request.contextPath}/formacion/deleteFormacion.html?id_formacion=${formacion.id_formacion}" id="enlBorrar" onclick="return confirmarBorrar()">Borrar</a> </td>
        		<td> <a href="${pageContext.request.contextPath}/formacion/getFormacion.html?id_formacion=${formacion.id_formacion}">Editar</a> </td>
			</tr>

		</c:forEach>

    <a href="${pageContext.request.contextPath}/formacion/newFormacion.html">Nueva Formacion</a>

    <br>
	
	</table>
	<a href="${pageContext.request.contextPath}/">Ir a Inicio</a>
</body>
</html>
