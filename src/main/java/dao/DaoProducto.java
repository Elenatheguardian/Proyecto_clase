package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;

import modelo.Producto;

public class DaoProducto {

	public static Connection con = null;

	public DaoProducto() throws SQLException {

		this.con = Conexion.getConexion();

	}

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

	public String listarJson() throws SQLException {

		String txtJSON = "";

		Gson gson = new Gson();

		txtJSON = gson.toJson(this.listar());

		return txtJSON;

	}

	public ArrayList<Producto> papeleria() throws SQLException {
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

	public Producto obtenerPorId(int id) throws SQLException {

		String sql = "SELECT * FROM productos WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		rs.next();

		System.out.println("tutututrqwtreqt");
		Producto s = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getInt(6));
		System.out.println("holi" + s);
		return s;
	}

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

	public void productosBorrar(int id) throws SQLException {
		String sql = "DELETE FROM productos WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		int filas = ps.executeUpdate();
		ps.close();
	}

}
