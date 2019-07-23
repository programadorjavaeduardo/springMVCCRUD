	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	id:${sessionScope['user']['id_instructor']}
      <div class="row">
	      <div class="col">
	          <ul class="nav">
	            <li class="nav-item">
	              <a id="linkGestionInstructores" href="" class="nav-link"><spring:message code="link.instructorZone"/></a>
	            </li>
	                  
	            <li class="nav-item">
	              <a onclick="verCursosImpartidos(${sessionScope['user']['id_instructor']})" href="#" class="nav-link"><spring:message code="link.deliveredCourses"/>
	              	
	              </a>  	
	            </li> 
	            
	            <li class="nav-item">
	              <a onclick="verCursosRestantes(${sessionScope['user']['id_instructor']})" href="#" class="nav-link"><spring:message code="link.otherCourses"/></a>
	            </li>
	           
	          </ul>
	
	      </div> 
	  </div>



    
