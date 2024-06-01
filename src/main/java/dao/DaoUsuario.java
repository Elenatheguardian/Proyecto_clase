package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Producto;
import modelo.Usuario;
/**
 * Esta es la clase dao usuario
 * @author Elena Alexandru
 * @version 4.2
 */

public class DaoUsuario {

	public static Connection con = null;

	public DaoUsuario() throws SQLException {
		this.con = Conexion.getConexion();
	}
	
	private boolean existe(Usuario r) {
		return true;
	}

	/**
	 * Inserta un nuevo Usuario en la base de datos 
	 * @param p el usuario que se desea insertar en la base de datos.
	 * @throws SQLException 
	 */
	public void insertarUs(Usuario r) throws SQLException {

		String sql = "INSERT INTO usuarios(nombre, mail, direccion, tel, permisos) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getMail());
		ps.setString(3, r.getDireccion());
		ps.setInt(4, r.getTel());
		ps.setInt(5, r.getPermiso());

		int filas = ps.executeUpdate();
		ps.close();
	}

	/**
	 * Actualiza la contrasena de un usuario en la base de datos.
	 * @param r2 el objeto Usuario que contiene el nombre y correo electronico del usuario.
	 * @param pass la nueva contrasena que se asignara al usuario.
	 * @throws SQLException 
	 */
	
	public void guardarPass(Usuario r2, String pass) throws SQLException {

		String sql = "UPDATE usuarios SET contraseña = '" + pass + "' WHERE nombre = '" + r2.getNombre()
				+ "' AND mail = '" + r2.getMail() + "'";
		PreparedStatement ps = con.prepareStatement(sql);

		int filas = ps.executeUpdate();
		ps.close();

	}
	/**
	 * Actualiza los datos de un usuario en la base de datos.
	 *
	 * @param r el objeto Usuario que contiene los datos actualizados del usuario.
	 * @throws SQLException 
	 */
	public void editar(Usuario r) throws SQLException {
		String sql = "UPDATE usuarios SET nombre=?,mail=?,tel=?,direccion=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getMail());
		ps.setInt(3, r.getTel());
		ps.setString(4, r.getDireccion());
		ps.setInt(5, r.getId());
		int filas = ps.executeUpdate();
		ps.close();
	}
/**
 * Aqui esta la opcion para poder borrar al administrador con x id 
 * @param id
 * @throws SQLException
 */
	public void borrarAdmin(int id) throws SQLException {

		String sql = "DELETE FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	/**
	 * Elimina un usuario administrador de la base de datos por su ID.
	 *
	 * @param id el ID del usuario administrador que se va a eliminar.
	 * @throws SQLException 
	 */
	public Usuario recogerPorId(int id) throws SQLException {

		String sql = "SELECT id, nombre, mail, tel, direccion FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		rs.next();

		Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
		return u;
	}
	/**
	 * Recupera una lista de usuarios administradores de la base de datos.
	 *
	 * @return una lista de objetos Usuario que representan a los administradores.
	 * @throws SQLException 
	 */
	public ArrayList<Usuario> listarAdmin() throws SQLException {

		String sql = "SELECT id, nombre, mail, tel, direccion FROM usuarios WHERE permisos=7";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		ArrayList<Usuario> listarAdmin = null;

		while (rs.next()) {

			if (listarAdmin == null) {
				listarAdmin = new ArrayList<Usuario>();
			}

			listarAdmin.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
		}

		return listarAdmin;
	}
	/**
	 * Convierte la lista de usuarios administradores en formato JSON.
	 *
	 * @return una cadena JSON que representa la lista de usuarios administradores.
	 * @throws SQLException 
	 */
	public String listarJson() throws SQLException {

		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this.listarAdmin());

		return json;
	}
	/**
	 * Inicia sesion de un usuario verificando su correo y contrasena cifrada.
	 * @param u el objeto Usuario que contiene el correo del usuario.
	 * @param passcifrada la contrasena cifrada del usuario.
	 * @return un objeto Usuario que representa al usuario autenticado, o null si las credenciales no coinciden.
	 * @throws SQLException 
	 */
	public Usuario inicioSesion(Usuario u, String passcifrada) throws SQLException {

		String sql = "SELECT * FROM usuarios WHERE mail=? AND contraseña=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, u.getMail());
		ps.setString(2, passcifrada);

		ResultSet rs = ps.executeQuery();

		rs.next();

		Usuario aux = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getInt(6),
				rs.getString(7));
		return aux;

	}

}
