$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/formacion/gestionFormaciones.html";
  });
  
  $("#linkFormationZone").on("click",function(){
	 
	  $(this).attr("href",ctx+"/formacion/gestionFormaciones.html?locale="+lang);
	  $(this).click();
  });




});


function direccionarSalidaF(idFormacion){
    if(idFormacion === undefined || idFormacion==0){
      window.form.action=ctx+"/formacion/addFormacion.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/formacion/editFormacion.html?locale="+lang;
    }
    return true;
}

function confirmarBorrarFormacion(){
  if(confirm(mensajeConfirmacion)){
    return true;
  }else{
    return false;
  }
}




