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


document.addEventListener("DOMContentLoaded", function() {
	function visibilidadBotones() {
		fetch('permisos')
			.then(response => {
				return response.json();
			})
			.then(data => {
				const permiso = data.permiso;
				const id = data.id;

				const botonLogin = document.getElementById('sesion');
				const insertarProd = document.getElementById('productos');
				const insertarAdmin = document.getElementById('admin');
				const lista = document.getElementById('listar');
				const botonCerrar = document.getElementById('cerrar');


				if (id > 0) {
					console.log('Usuario logueado');
					botonLogin.style.display = 'none';
					botonCerrar.style.display = 'block';
					if (permiso >= 7) {
						insertarProd.style.display = 'block';
						insertarAdmin.style.display = 'block';
						lista.style.display = 'block';
					} else {
						insertarProd.style.display = 'none';
						insertarAdmin.style.display = 'none';
					}
				} else {
					console.log('Usuario no logueado');
					botonLogin.style.display = 'block';
					insertarProd.style.display = 'none';
					insertarAdmin.style.display = 'none';
					botonCerrar.style.display = 'none';
					lista.style.display = 'none';
				}


			})
			.catch(error => {
				console.error('Error', error);
			});
	}

	visibilidadBotones();

	document.getElementById('cerrar').addEventListener('click', function() {
		if (confirm("¿Seguro?")) {
			fetch('cerrarSesion')
				.then(response => {
					window.location.href = 'index.html';
				})
				.catch(error => {
					console.error('Error', error);
				});
		} else {
			console.log('Anulado');
		}
	});
});
