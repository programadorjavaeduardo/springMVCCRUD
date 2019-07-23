<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titulo}</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap.bundle.min.js "></script>
<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var mensajeConfirmacion="${mensajeConfirmacion}"</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventos.js"></script>


</head>
<body>
  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <div class="row mt-5">
      <div class="col">
          <h3> ${titulo}</h3>
      </div>
    </div>


    <div class="row">
        <div class="col">
          <p id="rojo"> ${mensaje} </p>
        </div>

    </div>

    <div class="row mt-5">
      <div class="col">
      	<c:choose>
      		<c:when test="${fn:length(cursos)>0}">
		        <table class="table table-bordered table-hover">
		          <thead>
		            <tr>
		      				<th>Id </th>
		      				<th><spring:message code="course.header.name"></spring:message></th>
		      				<th><spring:message code="course.header.description"></spring:message></th>
		      				<th><spring:message code="course.header.price"></spring:message></th>
		      				<th><spring:message code="alumno.header.actions"></spring:message></th>
		            </tr>
		          </thead>
		          <tbody>
		            <c:forEach var="curso" items="${cursos}">
		              <tr id="tr_${curso.id_curso}">
		                <td> ${curso.id_curso}</td>
		                <td> ${curso.nombre}</td>
		                <td> ${curso.descripcion}</td>
		                <td> ${curso.precio}</td>
		                <td>${curso.instructor.id_instructor}</td>
		                <c:choose>
		                	<c:when test="${curso.instructor.id_instructor==null}">
		                		<td> <a href="#" onclick="impartirCurso(${sessionScope['user']['id_instructor']},${curso.id_curso});"><spring:message code="actions.provide"></spring:message></a> </td>
		                	</c:when>
		                	<c:otherwise>
		                		<td> <a href="#" onclick="return confirmarDejarDeImpartir(${sessionScope['user']['id_instructor']},${curso.id_curso});"><spring:message code="actions.stopProviding"></spring:message></a> </td>
		                	</c:otherwise>
		                
		                </c:choose>
		                
		              </tr>
		
		            </c:forEach>
		          </tbody>
		        </table>
			</c:when>
			<c:otherwise>
			   <spring:message code="noData.cursos"></spring:message>
			</c:otherwise> 
	  </c:choose>   	
     </div>
    </div>

    <div class="row">
      <div class="col">
        <ul class="nav flex-column">
          
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="history.back();"><spring:message code="actions.index"></spring:message></a>
          </li>
        </ul>

      </div>
    </div>
      <jsp:include page="../common/footer.jsp" />
  </div>

</body>
</html>
