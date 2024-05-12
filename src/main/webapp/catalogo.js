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

function listarprod(productos) {

	var section = document.getElementById("sectioncat");
	if (section) {

		var div = document.createElement('div');
		div.className = 'productos';

		div.innerHTML = '<img class="fotos1">'+ productos.fotos1 + '<span class="titulo">' + productos.titulo +  '<p class="descripcion">' +productos.descripcion + '<span class="precio">'+ productos.precio;   

		section.insertBefore(div, section.firstChild);
	} else {
	}
}
if(datosProductos){
	datosProductos.forEach(function(productos){
		generarnoticias(productos);
	})
}else{
	console.error("No se pudo obtener el producto")
}