function recoger() {
	fetch('ListarUsuarios')
		.then(response => response.json())
		.then(data => Listar(data))
}

function Listar(datos) {
	let html = '<table class="listarAdministradores">';

	for (let u = 0; u < datos.length; u++) {

		html += "<tr><td>" + datos[u].nombre + "</td>";
		html += "<td>" + datos[u].mail + "</td>";
		html += "<td>" + datos[u].tel + "</td>";
		html += "<td>" + datos[u].direccion + "</td>";
		html += "<td><a href='registroUsuario.html?id=" + datos[u].id + "'>Editar</a></td><td><a href='javascript:BorrarAdministrador(" + datos[u].id + ")'>Borrar</a></td>";
		html += "</tr>";


	}
	html += "</table>";
	document.getElementById("Listar").innerHTML = html;
}



window.addEventListener("DOMContentLoaded", recoger)



function BorrarAdministrador(id) {

	if (confirm("Estás seguro")) {
		fetch('BorrarAdministrador?id=' + id)
		window.location.reload();
	} else {
	}

}

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