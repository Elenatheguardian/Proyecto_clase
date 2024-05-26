package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 * Servlet implementation class usuariosEditar
 */
public class usuariosEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public usuariosEditar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String idString = request.getParameter("id");
		Usuario u = new Usuario();
		if (idString != null) {
			try {
				int idAdmin = Integer.parseInt(idString);

				u.recogerPorId(idAdmin);
				out.print(u.dameJson());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String mail = request.getParameter("mail");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String direccion = request.getParameter("direccion");

		Usuario u = new Usuario(id, nombre, mail, tel, direccion);

		try {
			u.editar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
