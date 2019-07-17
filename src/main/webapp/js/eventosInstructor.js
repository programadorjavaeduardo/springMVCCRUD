$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/instructor/gestionInstructores.html";
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
	  window.location=ctx+"/instructor/borrarInstructorAJAX.html?id_instructor="+idInstructor+"&locale="+lang;
    return true;
  }else{
    return false;
  }
}
