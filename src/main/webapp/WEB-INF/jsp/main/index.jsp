<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventos.js"></script>
<title><spring:message code="header.welcome" /></title>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var lang = "${sessionScope['lang']}"</script>
</head>
<body>

	<div class="container">
   
    	<jsp:include page="main.jsp" ></jsp:include>
    	

    </div>

  

</body>
</html>
