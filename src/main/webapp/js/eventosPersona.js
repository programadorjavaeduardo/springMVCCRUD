$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/person/gestionPersonas.html?locale="+lang;
  });


});

function obtenerPersona(idPersona){
	window.location=ctx+"/person/getPerson.html?idPersona="+idPersona+"&locale="+lang;
}
function direccionar(idPersona){
    if(idPersona === undefined){
      window.form.action=ctx+"/person/addPerson.html?locale="+lang;
      $('#form').serializeArray();
    }else{
      window.form.action=ctx+"/person/editPerson.html?locale="+lang;
    }
    return true;
}

function confirmarBorrar(idPersona){
  if(confirm("Realmente desea borrar la persona seleccionada?")){
	 window.location=ctx+"/person/deletePerson.html?idPersona="+idPersona+"&locale="+lang; 
    return true;
  }else{
    return false;
  }
}

function abrirMenuGestionPersonas(){
	console.log(lang);
	window.location= ctx+"/person/gestionPersonas.html?locale="+lang;
}

