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
  
  $("#linkZonaFormaciones").on("click",function(){

	  $(this).attr("href",ctx+"/formacion/gestionFormaciones.html?locale="+lang);
	  $(this).click();
  });

  $("#linkNuevaFormacion").on("click",function(){

	  $(this).attr("href",ctx+"/formacion/nuevaFormacion.html");
	  $(this).click();
  });

  
  
  $("#linkZonaAlumnos").on("click",function(){

	  $(this).attr("href",ctx+"/alumno/gestionAlumnos.html?locale="+lang);
	  $(this).click();
  });

  
  $("#linkNuevoAlumno").on("click",function(){

	  $(this).attr("href",ctx+"/alumno/nuevoAlumno.html");
	  $(this).click();
  });

  $("#linkIndice").on("click",function(){

	  $(this).attr("href",ctx+"/");
	  $(this).click();
  });
  
  $("#linkInstructorZone").on("click",function(){

	  $(this).attr("href",ctx+"/instructor/gestionInstructores.html?locale="+lang);
	  $(this).click();
  });

  $("#linkNuevoInstructor").on("click",function(){

	  $(this).attr("href",ctx+"/instructor/nuevoInstructor.html");
	  $(this).click();
  });

  $("#linkIndex").on("click",function(){

	  $(this).attr("href",ctx+"/");
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

function obtenerFormacion(idFormacion){
	window.location=ctx+"/formacion/obtenerFormacion.html?id_formacion="+idFormacion+"&locale="+lang;
}

function direccionarSalidaF(idFormacion){
    if(idFormacion === undefined || idFormacion==0){
      window.form.action=ctx+"/formacion/insertarFormacion.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/formacion/editarFormacion.html?locale="+lang;
    }
    return true;
}

function confirmarBorrarFormacion(idFormacion){
	if(confirm(mensajeConfirmacion)){
		$.ajax({
			  url: ctx+"/formacion/borrarFormacionAJAX.html?id_formacion="+idFormacion+"&locale="+lang,
			  dataType: 'json',
			  success: function(data){
				  
				  if(data.realizado===true){
					  alert("Formacion borrada correctamente");
					  
					  $("table #tr_"+idFormacion).remove();
				  }else{
					  alert("La formacion no se ha borrado");
				  }
				  
				  
			  },
			  error: function(){
				  alert("No se ha podido obtener la informacion AJAX");
			  }
		  		
		  })
	}
}

function obtenerAlumno(idAlumno){
	window.location=ctx+"/alumno/obtenerAlumno.html?idAlumno="+idAlumno+"&locale="+lang;
}
function direccionarSalidaA(idAlumno){
    if(idAlumno === undefined){
      window.form.action=ctx+"/alumno/insertarAlumno.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/alumno/editarAlumno.html?locale="+lang;
    }
    return true;
}

function confirmarBorrarAlumno(idAlumno){
  if(confirm(mensajeConfirmacion)){
	 
	  $.ajax({
		  url: ctx+"/alumno/borrarAlumnoAJAX.html?idAlumno="+idAlumno+"&locale="+lang,
		  dataType: 'json',
		  success: function(data){
			  
			  if(data.realizado===true){
				  alert("Alumno borrado correctamente");
				  
				  $("table #tr_"+idAlumno).remove();
			  }else{
				  alert("El Alumno no se ha borrado");
			  }
			  
			  
		  },
		  error: function(){
			  alert("No se ha podido obtener la informacion AJAX");
		  }
	  		
	  })
	  
	  
    return true;
  }else{
    return false;
  }
}

function obtenerInstructor(idInstructor){
	window.location=ctx+"/instructor/obtenerInstructor.html?id_instructor="+idInstructor+"&locale="+lang;
}

function direccionarSalidaI(idInstructor){
    if(idInstructor === undefined || idInstructor==0){
      window.form.action=ctx+"/instructor/insertarInstructor.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/instructor/editarInstructor.html?locale="+lang;
    }
    return true;
}

function confirmarBorrarInstructor(idInstructor){
	if(confirm(mensajeConfirmacion)){
		$.ajax({
			  url: ctx+"/instructor/borrarInstructorAJAX.html?id_instructor="+idInstructor+"&locale="+lang,
			  dataType: 'json',
			  success: function(data){
				  
				  if(data.realizado===true){
					  alert("Instructor borrado correctamente");
					  
					  $("table #tr_"+idInstructor).remove();
				  }else{
					  alert("El Instructor no se ha borrado");
				  }
				  
				  
			  },
			  error: function(){
				  alert("No se ha podido obtener la informacion AJAX");
			  }
		  		
		  })
	}
}




