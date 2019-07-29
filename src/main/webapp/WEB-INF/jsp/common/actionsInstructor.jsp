	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
      <div class="row">
	      <div class="col">
	          <ul class="nav">
	            <li class="nav-item">
	              <a id="linkGestionInstructores" href="" class="nav-link"><spring:message code="link.instructorZone"/></a>
	            </li>
	                  
	            <li class="nav-item">
	              <a onclick="verCursosImpartidos(${sessionScope['id']})" href="#" class="nav-link"><spring:message code="link.deliveredCourses"/>
	              	
	              </a>  	
	            </li> 
	            
	            <li class="nav-item">
	              <a onclick="verCursosRestantesInstructor();" href="#" class="nav-link"><spring:message code="link.otherCourses"/></a>
	            </li>
	            
	            <li class="nav-item">
            	  <a class="nav-link" href="#" onclick="generateXLS('instructor',${sessionScope['id']});"><spring:message code="button.generateXLSTaughtCourses"></spring:message></a>
          		</li>
	           
	          </ul>
	
	      </div> 
	  </div>



    
