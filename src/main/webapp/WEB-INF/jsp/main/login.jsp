	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titulo}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosHeader.js"></script>

<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var lang = "${sessionScope['lang']}"</script>

</head>
<body>
  <div class="container">
  	<jsp:include page="../common/header.jsp" />
    
      <div class="row">
        <div class="col">
          <p id="rojo"> ${mensaje} </p>
        </div>

      </div>	
   
	  <div class="row">
	  	
	    <div class="col">
	      	
	      <h3>${titulo}</h3>	
	      	
	      <form action="" name="form" id="form" method="post" onsubmit="return direccionarLogin('${objetoLogin}');">
	      	
	      	
	        <div class="form-group">
	          <label for="email"><spring:message code="alumno.header.email"></spring:message></label>
	          <input class="form-control" type="text" name="email" id="email" />
	          
	        </div>
	
	        <div class="form-group">
	          <label for="password"><spring:message code="alumno.header.password"></spring:message></label>
	          <input class="form-control" type="password" name="password" id="password"/>
	          
	        </div>
	
	        
	
	        <div class="form-group">
	
	            <input type="submit" name="botonEnviar" value="<spring:message code="button.login"></spring:message>" class="btn btn-primary mr-3">
	            <input type="button" id="botonCancelar" name="botonCancelar" value="<spring:message code="actions.cancel"></spring:message>" class="btn btn-danger mr-4">
	
	        </div>
	       
	      </form>
	    </div>
	  </div>
		<jsp:include page="../common/footer.jsp" />

</div>


</body>
</html>
