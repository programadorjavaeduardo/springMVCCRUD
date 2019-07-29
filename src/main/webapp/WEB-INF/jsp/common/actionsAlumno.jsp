	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	


      <div class="row">
	      <div class="col">
	          <ul class="nav">
	            <li class="nav-item">
	              <a id="linkGestionAlumnos" href="#" class="nav-link"><spring:message code="link.studentZone"/></a>
	            </li>
	            <li class="nav-item">
	              <a id="linkGestionFormaciones" href="#" class="nav-link"><spring:message code="link.formationZone"/></a>
	            </li>
	            <li class="nav-item">
	              <a onclick="verCursosMatriculados(${sessionScope['id']});" href="#" class="nav-link"><spring:message code="link.matriculatedCourses"/></a>
	            </li>
	            <li class="nav-item">
	              <a onclick="verCursosRestantesAlumno(${sessionScope['id']});" href="#" class="nav-link"><spring:message code="link.otherCourses"/></a>
	            </li>
	            
	            <li class="nav-item">
            	  <a class="nav-link" href="#" onclick="generateXLS('alumno',${sessionScope['id']});"><spring:message code="button.generateXLSMatriculatedCourses"></spring:message></a>
          		</li>
	            
	          </ul>
	
	      </div> 
	  </div>



    
