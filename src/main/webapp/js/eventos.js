$(document).ready(function(){

  $("#botonCancelar").on("click",function(){
    window.location=ctx+"/person/personList.html";
  });




});


function direccionar(textoBoton){
    if(textoBoton === "Agregar"){
      window.form.action=ctx+"/person/addPerson.html";
      $('#form').serializeArray();
    }else if(textoBoton === "Editar"){
      window.form.action=ctx+"/person/editPerson.html";
    }
    return true;
}

function confirmarBorrar(){
  if(confirm("Realmente desea borrar la persona seleccionada?")){
    return true;
  }else{
    return false;
  }
}

