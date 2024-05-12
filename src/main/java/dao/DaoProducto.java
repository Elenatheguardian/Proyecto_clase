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
		
		String sql = "INSERT INTO productos (tipo, nombre,descripcion,precio,foto) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, p.getTipo());
		ps.setString(2, p.getNombre());
		ps.setString(3, p.getDescripcion());
		ps.setInt(4, p.getPrecio());
		ps.setString(5, p.getFoto());
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	 public ArrayList<Producto> listar() throws SQLException{
		PreparedStatement ps= con.prepareStatement("SELECT * FROM productos");
		
		 ResultSet pr = ps.executeQuery();
		 
		 ArrayList<Producto> producto = null;
		 
		 
		 while(pr.next());{
		
			 if(producto == null) {
				 producto= new ArrayList<>();
			 }
			 
		 producto.add(new Producto(pr.getInt("id"),pr.getString("nombre"), pr.getString("tipo"),pr.getString("descripcion"),pr.getString("foto"),pr.getInt("precio")));
			 
		 }
		 
		 
		 return producto;
	 }

	 public String listarJson() throws SQLException {
			
			String txtJSON = "";
			
			
			Gson gson = new Gson();
			
			txtJSON = gson.toJson(this.listar());
			
			
			return txtJSON;

	 }
	
	
	
}
