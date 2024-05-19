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




