function recoger(id) {
	if (id) {
		fetch('usuariosEditar?id=' + id)
			.then(response => response.json())
			.then(data => rellenarDatos(data))
	} else {
		console.log("No tenemos ID")
	}
}

function rellenarDatos(info) {
	document.getElementById("id").value = info.id;
	document.getElementById("nombre").value = info.nombre;
	document.getElementById("mail").value = info.mail;
	document.getElementById("tel").value = info.tel;
	document.getElementById("direccion").value = info.direccion;
}

function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}



window.addEventListener('DOMContentLoaded', function() {
	let id = getParameterByName('id');
	recoger(id);
});



function visibilidadBotones() {

	fetch('permisos')
		.then(response => response.json())
		.then(data => {
			const permiso = data.permisosesion;
			const id = data.idsesion;

			const botonLogin = document.getElementById('sesion');
			const insertarProd = document.getElementById('productos');
			const insertarAdmin = document.getElementById('admin');
			const botonCerrar = document.getElementById('cerrar');

			if (id > 0) {

				botonLogin.style.display = 'none';
				botonCerrar.style.display = 'block';
				insertarProd.style.display = permiso >= 7 ? 'block' : 'none';
				insertarAdmin.style.display = permiso >= 7 ? 'block' : 'none';
			} else {
				botonLogin.style.display = 'block';
				insertarProd.style.display = 'none';
				insertarAdmin.style.display = 'none';
				botonCerrar.style.display = 'none';
			}
		})
		.catch(error => {
			console.error('Error', error);
		});
}

window.addEventListener('DOMContentLoaded', visibilidadBotones);



document.getElementById('cerrar').addEventListener('click', function() {
	
    if (confirm("¿Seguro?")) {
        fetch('cerrarSesion')
        .then(response => {
            window.location.href = 'index.html'; 
        })

    } else {
        console.log('Anulado');
    }
});
