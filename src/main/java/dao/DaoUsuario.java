package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Usuario;

//Tas-Dao
public class DaoUsuario {

	public static Connection con= null;
	public DaoUsuario() throws SQLException{
		this.con = Conexion.getConexion();
	}
	private boolean existe(Usuario u) {
		return true;
	}
	
	/*public void insertar(Usuario u) throws SQLException {
		
		String sql = "INSERT INTO usuarios(nombre,mail,tel,permiso) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getMail());
		ps.setString(3, u.getTel());
		ps.setString(4, u.getPermiso());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public void actualizar(Usuario u) throws SQLException {
		String sql = "UPDATE usuarios SET nombre=?,mail=?,tel=?,permiso=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,u.getNombre());
		ps.setString(2,u.getMail());
		ps.setString(3,u.getTel());
		ps.setString(4,u.getPermiso());	
		ps.setString(5,u.getId());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public void borrar(int id) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		int filas = ps.execute();
		ps.close();
			
	}
	public Usuario obtenerID(int id) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE id==?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Usuario u = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

		return u;
	}
	
	public Usuario logeando(Usuario u, String pass) throws SQLException{
		
		String sql = "SELECT * FROM usuarios WHERE mail=? AND pass=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getMail());
		ps.setString(2,pass);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Usuario aux = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

		return aux;
	}
	public ArrayList<Usuario> listar () throws SQLException{
		String sql = "SELECT * FROM usuarios";
		PreparedStatement ps = con.prepareStatement(sql);	
		ResultSet rs = ps.executeQuery();
		ArrayList<Usuario> ls = null;
		
		while(rs.next()) {
			if(ls== null) {
				ls = new ArrayList<Usuario>();
			}
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		return ls;
	}

	public ArrayList<Usuario> listar(int tipo) throws SQLException{
		
		String sql = "SELECT * FROM usuarios WHERE permiso=?";
		PreparedStatement ps =  con.prerareStatment(sql);
		ps.setInt(1, tipo);
		Result rs = ps.executeQuery();
		
		ArrayList<Usuario>ls = null;
		while(rs.next()) {
			if(ls == null) {
				ls = new ArrayList<Usuario>();
			}
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		return ls;
	}
	public Usuario lister(String tel) throws SQLException{
		String sql = "SELECT * FROM usuarios WHERE tel=?";
		ps.setString(1, tel);
		ResultSet rs = ps.executeQuery();
		ArrayList<Usuario> ls = null;
		rs.next();
		Usuario u= new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
		
		return u;
	}
	public String listarJson() throws SQLException {
		
		String json ="";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}
	
	public String listarJson(int tipo) throws SQLException {
		
		String json ="";
		Gson Gson =new Gson();
		
		json = gson.toJson(this.listar(tipo));
		
		return json;
	}*/
	
	
	
	
	
}
