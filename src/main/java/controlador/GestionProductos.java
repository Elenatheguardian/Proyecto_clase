package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class GestionProductos
 */
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		String tipo = request.getParameter("Tipo");
		String nombre = request.getParameter("Nombre");
		String descripcion = request.getParameter("Descripcion");
		float precio = Float.parseFloat(request.getParameter("Precio"));
		
		Producto p1= new Producto(tipo,nombre,descripcion,precio);
		//System.out.println(p1.toString());
		
		try {
			p1.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("anadirproductos.html");
		
	}
	
	
}
