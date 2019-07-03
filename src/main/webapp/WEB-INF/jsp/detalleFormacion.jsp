<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Recursos Humanos</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
</head>
<body>
  <div class="container">
    <jsp:include page="../../common/header.jsp" />
    <div class="row mt-5">
      <div class="col">
        <h1>${titulo}</h1>
      </div>
    </div>

    <div class="row">
      <div class="col">
        <form action="" name="form" id="form" method="post" onsubmit="return direccionar('${textoBoton}')">
          <div class="form-group">
            <label for="descripcion">Descripcion:</label>
            <input class="form-control" type="text" name="descripcion" id="descripcion" value="${formacion.descripcion}">
          </div>
          <div class="form-group">
            <input type="submit" name="botonEnviar" value="${textoBoton}" class="btn btn-primary mr-3">
            <input type="button" id="botonCancelar" name="botonCancelar" value="Cancelar" class="btn btn-danger mr-3">
            <input type="hidden" name="id_formacion" value="${formacion.id_formacion}">
          </div>
        </form>
      </div>
    </div>
    <jsp:include page="../../common/footer.jsp" />
  </div>


</body>
</html>
