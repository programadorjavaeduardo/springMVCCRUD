	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	   		<nav class="navbar navbar-dark bg-dark">
  				<a class="navbar-brand" href="#">universidadonline.com</a>
  				<a class="nav-item nav-link active" href="#" id=linkLoginInstructor><spring:message code="header.instructores"></spring:message> <span class="sr-only">(current)</span></a>
      			<a class="nav-item nav-link" href="#" id="lingLoginAlumno"><spring:message code="header.alumnos"></spring:message></a>
      			<a class="nav-item nav-link" href="#" id="linkRegistrarAlumno"><spring:message code="header.registrar"></spring:message></a>
      			<a class="nav-item nav-link" id="linkES" href="#">ES</a>
           		<a class="nav-item nav-link" id="linkEN" href="#">EN</a>
           		<c:if test="${sessionScope['user']['nombre']!=null}">
           			<div class="dropdown">
  						<button type="button" class="btn btn-primary dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope['user']['nombre']}</button>
           				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    						<a class="dropdown-item" href="#" id="linkUnlogin">Cerrar Sesion</a>
    
  						</div>
  					</div>
           		</c:if>
    			
			</nav>
	   
	  
      
  


     



    
