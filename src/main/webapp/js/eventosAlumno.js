$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/alumno/gestionAlumnos.html?locale="+lang;
  });

  $("#linkStudentZone").on("click",function(){

	  $(this).attr("href",ctx+"/alumno/gestionAlumnos.html?locale="+lang);
	  $(this).click();
  });

  
  $("#linkNewAlumno").on("click",function(){

	  $(this).attr("href",ctx+"/alumno/newAlumno.html");
	  $(this).click();
  });

  $("#linkIndex").on("click",function(){

	  $(this).attr("href",ctx+"/");
	  $(this).click();
  });
  
  $("#linkES").on("click",function(){

	  $(this).attr("href",ctx+"/language/esp.html?locale=es");
	  $(this).click();
  });

  $("#linkEN").on("click",function(){

	  $(this).attr("href",ctx+"/language/eng.html?locale=en");
	  $(this).click();
  });

});

function obtenerAlumno(idAlumno){
	window.location=ctx+"/alumno/getAlumno.html?idAlumno="+idAlumno+"&locale="+lang;
}
function direccionarSalidaA(idAlumno){
    if(idAlumno === undefined){
      window.form.action=ctx+"/alumno/addAlumno.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/alumno/editAlumno.html?locale="+lang;
    }
    return true;
}

function confirmarBorrarAlumno(idAlumno){
  if(confirm(mensajeConfirmacion)){
	 
	  $.ajax({
		  url: ctx+"/alumno/deleteAlumnoAJAX.html?idAlumno="+idAlumno+"&locale="+lang,
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


