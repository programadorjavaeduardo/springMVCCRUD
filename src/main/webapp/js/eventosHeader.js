$(document).ready(function(){

  
  $("#linkES").on("click",function(){

	  $(this).attr("href",ctx+"/lenguaje/esp.html?locale=es");
	  $(this).click();
  });

  $("#linkEN").on("click",function(){

	  $(this).attr("href",ctx+"/lenguaje/eng.html?locale=en");
	  $(this).click();
  });
  
  $("#linkLoginInstructor").on("click",function(){

	  $(this).attr("href",ctx+"/instructor/abrirVentanaLogin.html?locale="+lang);
	  $(this).click();
  });
  
  $("#lingLoginAlumno").on("click",function(){

	  $(this).attr("href",ctx+"/alumno/abrirVentanaLogin.html?locale="+lang);
	  $(this).click();
  });
  
  $("#linkRegistrarAlumno").on("click",function(){

	  $(this).attr("href",ctx+"/alumno/nuevoAlumno.html?locale="+lang);
	  $(this).click();
  });

});

function direccionarLogin(objetoLogin){
	if(objetoLogin === "alumno"){
		window.form.action=ctx+"/alumno/comprobarLogin.html?locale="+lang;
		
	}else if(objetoLogin == "instructor"){
		window.form.action=ctx+"/instructor/comprobarLogin.html?locale="+lang;
	}
	return true;
}




