	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<div class="row">
       <div class="col-10">
            <div class="jumbotron">
              <h1><spring:message code="header.welcome" /></h1>
            </div>
        </div>
        <div class="col-2">
           <a href="${pageContext.request.contextPath}/language/esp.html?locale=es">ES</a>
           <a href="${pageContext.request.contextPath}/language/eng.html?locale=en">EN</a>
        </div>

    </div>

 
     <div class="row">
      <div class="col">
          <ul class="nav">
            <li class="nav-item">
              <a onclick="abrirMenuGestionPersonas();" class="nav-link"><spring:message code="link.peopleZone"/></a>
            </li>
            <li class="nav-item">
              <a onclick="abrirMenuGestionFormacion();" class="nav-link"><spring:message code="link.formationZone"/></a>
            </li>
          </ul>

      </div>

     

    </div>
