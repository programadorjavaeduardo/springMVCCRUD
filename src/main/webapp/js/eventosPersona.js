$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/person/gestionPersonas.html?locale="+lang;
  });

  $("#linkPeopleZone").on("click",function(){

	  $(this).attr("href",ctx+"/person/gestionPersonas.html?locale="+lang);
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
	 
	  $.ajax({
		  url: ctx+"/person/deletePersonAJAX.html?idPersona="+idPersona+"&locale="+lang,
		  dataType: 'json',
		  success: function(data){
			  alert(data);
			  alert(data.realizado);
			  if(data.realizado===true){
				  alert("Persona borrada correctamente");
				  
				  $("table #tr_"+idPersona).remove();
			  }else{
				  alert("La persona no se ha borrado");
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
