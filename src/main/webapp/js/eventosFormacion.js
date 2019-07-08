$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/formacion/gestionFormaciones.html";
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
  if(confirm("Realmente desea borrar la formacion seleccionada?")){
    return true;
  }else{
    return false;
  }
}

function abrirMenuGestionFormacion(){
	console.log(lang);
	window.location= ctx+"/formacion/gestionFormaciones.html?locale="+lang;
}

