


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
                const botonCerrar = document.getElementById('cerrar');


                if (id > 0) {
                    console.log('Usuario logueado');
                    botonLogin.style.display = 'none';
                    botonCerrar.style.display = 'block';
                    if (permiso >= 7) {
                        insertarProd.style.display = 'block';
                        insertarAdmin.style.display = 'block';
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

