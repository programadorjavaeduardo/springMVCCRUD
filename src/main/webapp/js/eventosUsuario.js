$(document)
		.ready(
				function() {
					$("#linkUserZone")
							.on(
									"click",
									function() {

										$(this)
												.attr(
														"href",
														ctx
																+ "/usuarioAcceso/gestionUsuarios.html?locale="
																+ lang);
										$(this).click();
									});

					$("#botonCancelar")
							.on(
									"click",
									function() {
										window.location = ctx
												+ "/usuarioAcceso/gestionUsuarios.html";
									});

					$("#linkNewUsuario")
							.on(
									"click",
									function() {

										$(this)
												.attr(
														"href",
														ctx
																+ "/usuarioAcceso/newUsuario.html?locale=" + lang);
										$(this).click();
									});

					$("#linkIndex").on("click", function() {

						$(this).attr("href", ctx + "/");
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

				});

function comprobarLogin() {
	window.form.action = ctx + "/usuarioAcceso/comprobarLogin.html";
}

function obtenerUsuario(idUsuario) {
	window.location = ctx + "/usuarioAcceso/getUsuario.html?id_usuario="
			+ idUsuario + "&locale=" + lang;
}

function direccionarSalidaU(idUsuario) {
	if (idUsuario === undefined || idUsuario == 0) {
		window.form.action = ctx + "/usuarioAcceso/addUsuario.html?locale="
				+ lang;
		$('#form').serializeArray();
	} else {
		window.form.action = ctx + "/usuarioAcceso/editUsuario.html?locale="
				+ lang;
	}
	return true;
}

function confirmarBorrarUsuario(idUsuario) {
	if (confirm(mensajeConfirmacion)) {
		window.location = ctx
				+ "/usuarioAcceso/deleteUsuario.html?id_usuario=" + idUsuario
				+ "&locale=" + lang;
		return true;
	} else {
		return false;
	}
}

function nuevoUsuario(idPersona){
	window.location= ctx+ "/usuarioAcceso/newUsuario.html?id_persona="+idPersona + "&locale=" + lang;
}
