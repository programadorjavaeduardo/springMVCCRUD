<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.detailAlumno"></spring:message></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap.bundle.min.js "></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventos.js"></script>

<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var lang = "${sessionScope['lang']}"</script>

</head>
<body>
	<div class="container">
    	<jsp:include page="../common/header.jsp" ></jsp:include>
    	
   
		<div style="height: 600px;" class="row">
			<div class="col">
				<h1 class="text-center"><spring:message code="header.welcomeMessage"></spring:message></h1>
				<hr class="mb-3">
				
				<h3 class="text-center"><spring:message code="header.mainMessage"></spring:message></h3>
			</div>
		</div>

		<jsp:include page="../common/footer.jsp" ></jsp:include>
	</div>

	
</body>
</html>
