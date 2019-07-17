$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/alumno/gestionAlumnos.html?locale="+lang;
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
  

});

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




