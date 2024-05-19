package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Sesion;

import java.io.IOException;

import com.google.gson.Gson;

/**
 * Servlet implementation class permisos
 */
public class permisos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sesion;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public permisos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idsesion = 0; 
        int permisosesion = 0; 
		
		
		
        HttpSession sesion = request.getSession(false); 

        if (sesion != null && sesion.getAttribute("id") != null) {
        	
            idsesion = (int) sesion.getAttribute("id"); 
            
            permisosesion = sesion.getAttribute("permiso") != null ? (int) sesion.getAttribute("permiso") : 0;
        }

        Sesion datos = new Sesion(idsesion, permisosesion);
        
        Gson gson = new Gson();
        
        response.setContentType("application/json");
        
        response.getWriter().write(gson.toJson(datos));
       
        
    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
