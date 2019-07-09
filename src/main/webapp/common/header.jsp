	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<div class="row">
		
       <div class="col-10 align-self-start">
            <div class="jumbotron">
              <h1><spring:message code="header.welcome" /></h1>
            </div>
        </div>
				<div class="col-2 align-self-center">
           <a id="linkES" href="">ES</a>
           <a id="linkEN" href="">EN</a>
        </div>

    </div>


     <div class="row">
      <div class="col">
          <ul class="nav">
            <li class="nav-item">
              <a id="linkPeopleZone" href="" class="nav-link"><spring:message code="link.peopleZone"/></a>
            </li>
            <li class="nav-item">
              <a id="linkFormationZone" href="" class="nav-link"><spring:message code="link.formationZone"/></a>
            </li>
          </ul>

      </div>



    </div>
