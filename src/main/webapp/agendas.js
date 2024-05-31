

function productos() {
	let prod;
	let xhr = new XMLHttpRequest();
	xhr.onload = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				try {
					prod = JSON.parse(xhr.responseText);
					console.log(prod);
				} catch (e) {

				}
			}
		}
	};

	xhr.open("GET", "ListarProductos", false);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send();

	return prod;
}

window.addEventListener("DOMContentLoaded", productos())

var datosProductos = productos();

function listarprod(producto) {

	var section = document.getElementById("sectioncat");
	if (section) {

		var div = document.createElement('div');
		div.className = 'productos';

		div.innerHTML = '<img class="fotos1" src="fotos_productos/' + producto.foto + '"> <span class="titulo">' + producto.titulo + '</span><p class="descripcion">' + producto.descripcion + '</p><span class="precio">' + producto.precio + '</span><button id="editar"><a href="anadirproductos.html?id=' + producto.id + '">Editar</a></button><button id ="borrar"><a href="javascript:borrar(' + producto.id + ')">Borrar</a></button>';

		section.insertBefore(div, section.firstChild);
	} else {
	}
}


if (datosProductos) {
	datosProductos.forEach(function(producto) {
		listarprod(producto);
	})
} else {
	console.error("Ha habido un fallo con la agenda")
}


function borrarProducto(id) {
	if (confirm("¿Estás seguro?")) {
		fetch('ProductosBorrar?id=' + id)
		window.location.reload();
	}
}






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


