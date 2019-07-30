	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


      <div class="row">
	      <div class="col">
	          <ul class="nav">
	          
	            
	             
	            <c:choose>
	            	<c:when test="${sessionScope['objetoLogin']=='alumno'}">
	            	
	            		<!--ALUMNOS  -->
	            			
	            		
	            		<li class="nav-item">
	              			<a onclick="verCursosMatriculados(${sessionScope['id']});" href="#" class="nav-link"><spring:message code="link.matriculatedCourses"/></a>
	            		</li>
	            		<li class="nav-item">
	              			<a onclick="verCursosRestantesAlumno(${sessionScope['id']});" href="#" class="nav-link"><spring:message code="link.otherCourses"/></a>
	            		</li>
	            
	            		<li class="nav-item">
            	  			<a class="nav-link" href="#" onclick="generateXLS('alumno',${sessionScope['id']});"><spring:message code="button.generateXLSMatriculatedCourses"></spring:message></a>
          				</li>
	            
	            	</c:when>
	            	
	            	<c:when test="${sessionScope['objetoLogin']=='instructor'}">
	            	
	            		<!-- INSTRUCTORES -->
          		
          		 		
	                  
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
          			</c:when>
          		
          			<c:when test="${sessionScope['objetoLogin']=='admin'}">
          				
          				<!-- ADMIN -->
          				
          				<li class="nav-item">
	              			<a id="linkGestionAlumnos" href="#" class="nav-link"><spring:message code="link.studentZone"/></a>
	            		</li>
	            		
	            		<li class="nav-item">
	              			<a id="linkGestionFormaciones" href="#" class="nav-link"><spring:message code="link.formationZone"/></a>
	            		</li>
	            		
	            		<li class="nav-item">
	              			<a id="linkGestionInstructores" href="" class="nav-link"><spring:message code="link.instructorZone"/></a>
	            		</li>
	            	
	            	</c:when>	
	          </c:choose>
	            
	          </ul>
	
	      </div> 
	  </div>



    
