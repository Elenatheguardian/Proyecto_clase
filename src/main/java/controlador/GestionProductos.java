package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Producto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;




/**
 * Servlet implementation class GestionProductos
 */
@MultipartConfig
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles = "F:\\eclipse java\\proyectos\\Proyecto_clase\\src\\main\\webapp\\fotos_productos";
	private File upload = new File(pathFiles);

    /**
     * Default constructor. 
     */
    public GestionProductos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.insertar(request, response);
	}
		
		
		private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("Tipo");
		String nombre = request.getParameter("Nombre");
		String descripcion = request.getParameter("Descripcion");
		int precio = Integer.parseInt(request.getParameter("Precio"));
		
		Part part = request.getPart("foto");	
		Path path = Paths.get(part.getSubmittedFileName());
		String fileName = path.getFileName().toString();
		InputStream input = part.getInputStream();
		
		File file = new File(upload, fileName);
		

		Files.copy(input,file.toPath());
		
		
		Producto p1= new Producto(tipo, nombre, descripcion, fileName, precio);
		
		try {
			p1.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("anadirproductos.html");
		
	}
	
}

