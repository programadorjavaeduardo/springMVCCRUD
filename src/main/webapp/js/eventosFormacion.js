$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/formacion/gestionFormaciones.html";
  });




});


function direccionar(textoBoton){
    if(textoBoton === "Agregar"){
      window.form.action=ctx+"/formacion/addFormacion.html";
      $('#form').serializeArray();
    }else if(textoBoton === "Editar"){
      window.form.action=ctx+"/formacion/editFormacion.html";
    }
    return true;
}

function confirmarBorrar(){
  if(confirm("Realmente desea borrar la formacion seleccionada?")){
    return true;
  }else{
    return false;
  }
}

