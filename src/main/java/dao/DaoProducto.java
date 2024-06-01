package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;

import modelo.Producto;
/**
 * Esta es la clase dao producto
 * @author Elena Alexandru
 * @version 4.2
 */

public class DaoProducto {

	public static Connection con = null;

	public DaoProducto() throws SQLException {

		this.con = Conexion.getConexion();

	}
	/**
	 * Inserta un nuevo producto en la base de datos con los detalles proporcionados.
	 *
	 * @param p El producto que se desea insertar en la base de datos.
	 * @throws SQLException 
	 */
	public void insertar(Producto p) throws SQLException {

		String sql = "INSERT INTO productos (nombre, tipo, precio, descripcion,foto) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, p.getNombre());
		ps.setString(2, p.getTipo());
		ps.setInt(3, p.getPrecio());
		ps.setString(4, p.getDescripcion());
		ps.setString(5, p.getFoto());

		int filas = ps.executeUpdate();
		ps.close();

	}
	
	/**
	 * Recupera una lista de todos los productos de la base de datos.
	 *
	 * @return Una lista de objetos que representa todos los productos en la base de datos.
	 * @throws SQLException 
	 */
	
	public ArrayList<Producto> listar() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM productos");

		ResultSet pr = ps.executeQuery();

		ArrayList<Producto> producto = null;

		while (pr.next()) {

			if (producto == null) {
				producto = new ArrayList<>();
			}

			producto.add(new Producto(pr.getInt("id"), pr.getString("nombre"), pr.getString("tipo"),
					pr.getString("descripcion"), pr.getString("foto"), pr.getInt("precio")));

		}

		return producto;
	}
	/**
	 * Recupera una lista de todos los productos de la base de datos y la convierte a formato JSON.
	 *
	 * @return Una cadena de texto en formato JSON que representa la lista de todos los productos.
	 * @throws SQLException 
	 */
	public String listarJson() throws SQLException {

		String txtJSON = "";

		Gson gson = new Gson();

		txtJSON = gson.toJson(this.listar());

		return txtJSON;

	}
	/**
	 * Recupera un objeto agenda  de la base de datos y la convierte a formato JSON.
	 *
	 * @return Una cadena de texto en formato JSON 
	 * @throws SQLException 
	 */
	public String agendaJson() throws SQLException {

		String txtJSON = "";

		Gson gson = new Gson();

		txtJSON = gson.toJson(this.agenda());

		return txtJSON;

	}
	/**
	 * Recupera un objeto papeleria  de la base de datos y la convierte a formato JSON.
	 *
	 * @return Una cadena de texto en formato JSON 
	 * @throws SQLException 
	 */
	public String papeleriaJson() throws SQLException {

		String txtJSON = "";

		Gson gson = new Gson();

		txtJSON = gson.toJson(this.papeleria());

		return txtJSON;

	}
	/**
	 * Recupera una lista de productos de la categoria 'papeleria' de la base de datos.
	 *
	 * @return Una lista de objetos  que representa todos los productos de la categoria 'papeleria'.
	 * @throws SQLException
	 */
	public ArrayList<Producto> papeleria() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM productos WHERE tipo = 'papeleria'");

		ResultSet pr = ps.executeQuery();

		ArrayList<Producto> papeleria = null;

		while (pr.next()) {

			if (papeleria == null) {
				papeleria = new ArrayList<>();
			}

			papeleria.add(new Producto(pr.getInt("id"), pr.getString("nombre"), pr.getString("tipo"),
					pr.getString("descripcion"), pr.getString("foto"), pr.getInt("precio")));

		}

		return papeleria;
	}

	/**
	 * Recupera una lista de productos de la categoria 'agenda' de la base de datos.
	 *
	 * @return Una lista de objetos  que representa todos los productos de la categoria 'agenda'.
	 * @throws SQLException 
	 */
	public ArrayList<Producto> agenda() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM productos WHERE tipo = 'agenda'");

		ResultSet pr = ps.executeQuery();

		ArrayList<Producto> agenda = null;

		while (pr.next()) {

			if (agenda == null) {
				agenda = new ArrayList<>();
			}

			agenda.add(new Producto(pr.getInt("id"), pr.getString("nombre"), pr.getString("tipo"),
					pr.getString("descripcion"), pr.getString("foto"), pr.getInt("precio")));

		}

		return agenda;
	}
	/**
	 * Recupera un producto de la base de datos basado en el ID proporcionado.
	 *
	 * @param id El ID del producto que se desea recuperar.
	 * @return Un objeto que el ID es el indicador
	 * @throws SQLException 
	 */
	public Producto obtenerPorId(int id) throws SQLException {

		String sql = "SELECT * FROM productos WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		rs.next();

		//System.out.println("tutututrqwtreqt");
		Producto s = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getInt(6));
		//System.out.println("holi" + s);
		return s;
	}
	/**
	 * Actualiza los datos de un producto en la base de datos.
	 *
	 * @param s el objeto Producto que contiene los nuevos datos a actualizar.
	 * @throws SQLException
	 */

	public void productosEditar(Producto s) throws SQLException {
		String sql = "UPDATE productos SET nombre = ?, tipo = ?, descripcion = ?, foto = ?, precio = ?  WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, s.getNombre());
		ps.setString(2, s.getTipo());
		ps.setString(3, s.getDescripcion());
		ps.setString(4, s.getFoto());
		ps.setInt(5, s.getPrecio());
		ps.setInt(6, s.getId());

		int filas = ps.executeUpdate();
		ps.close();
	}
/**
	 * Borra un producto de la base de datos basado en el ID proporcionado.
	 * @param id  ID del producto que se desea borrar.
	 * @throws SQLException .
	 */
	public void productosBorrar(int id) throws SQLException {
		String sql = "DELETE FROM productos WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		int filas = ps.executeUpdate();
		ps.close();
	}

}
