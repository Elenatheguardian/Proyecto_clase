package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoUsuario;

/**
 * Servlet implementation class GestionUsuarios
 */
public class GestionUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String idstring = request.getParameter("id");
		int id = 0;
		String nombre = request.getParameter("nombre");
		String mail = request.getParameter("mail");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String direccion = request.getParameter("direccion");
		int permiso = Integer.parseInt(request.getParameter("permiso"));
		String pass = request.getParameter("pass");

		String passcifrada = Usuario.getMD5(pass);
		if (idstring != null && !idstring.isEmpty()) {
			id = Integer.parseInt(idstring);
		}

		try {
			Usuario ps = new Usuario(id, nombre, mail, tel, permiso, direccion);

			if (id == 0) {
				ps.insertarUs();
				ps.guardarPass(passcifrada);

			} else {
				ps.editar();
				ps.guardarPass(passcifrada);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("index.html");

	}

}
