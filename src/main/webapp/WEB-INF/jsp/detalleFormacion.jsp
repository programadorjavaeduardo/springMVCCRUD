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
<script>var ctx = "${pageContext.request.contextPath}"</script>
</head>
<body>

	<h1>${titulo}</h1>
	<form action="" name="form" id="form" method="post" onsubmit="return direccionar('${textoBoton}')">
    <label for="descripcion">Descripcion:</label>
    <br>
    <input type="text" name="descripcion" id="descripcion" value="${formacion.descripcion}">
    <br>
    
    <br/>
    <input type="submit" name="botonEnviar" value="${textoBoton}">
    <input type="button" id="botonCancelar" name="botonCancelar" value="Cancelar">
    <input type="hidden" name="id_formacion" value="${formacion.id_formacion}">
  </form>
</body>
</html>
