$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/person/gestionPersonas.html?locale="+lang;
  });

  $("#linkPeopleZone").on("click",function(){

	  $(this).attr("href",ctx+"/person/gestionPersonas.html?locale="+lang);
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

  $("#linkNewPersona").on("click",function(){

	  $(this).attr("href",ctx+"/person/newPerson.html");
	  $(this).click();
  });

  $("#linkIndex").on("click",function(){

	  $(this).attr("href",ctx+"/");
	  $(this).click();
  });

});

function obtenerPersona(idPersona){
	window.location=ctx+"/person/getPerson.html?idPersona="+idPersona+"&locale="+lang;
}
function direccionarSalidaP(idPersona){
    if(idPersona === undefined){
      window.form.action=ctx+"/person/addPerson.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/person/editPerson.html?locale="+lang;
    }
    return true;
}

function confirmarBorrarPersona(idPersona){
  if(confirm(mensajeConfirmacion)){
	 window.location=ctx+"/person/deletePerson.html?idPersona="+idPersona+"&locale="+lang;
    return true;
  }else{
    return false;
  }
}
