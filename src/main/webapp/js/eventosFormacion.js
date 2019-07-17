$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/formacion/gestionFormaciones.html";
  });

  $("#linkZonaFormaciones").on("click",function(){

	  $(this).attr("href",ctx+"/formacion/gestionFormaciones.html?locale="+lang);
	  $(this).click();
  });

  $("#linkNuevaFormacion").on("click",function(){

	  $(this).attr("href",ctx+"/formacion/nuevaFormacion.html");
	  $(this).click();
  });

  $("#linkIndex").on("click",function(){

	  $(this).attr("href",ctx+"/");
	  $(this).click();
  });





});

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
	  window.location=ctx+"/formacion/borrarFormacionAJAX.html?id_formacion="+idFormacion+"&locale="+lang;
    return true;
  }else{
    return false;
  }
}
