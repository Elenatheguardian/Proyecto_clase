package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Producto;

public class DaoProducto {

public static Connection con = null;
	
	public DaoProducto() throws SQLException {
		
		this.con = Conexion.getConexion();
 		
	}
	
	
	public void Insertar(Producto p) throws SQLException {
		
		String sql = "INSERT INTO productos (tipo, nombre,descripcion,precio) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, p.getTipo());
		ps.setString(2, p.getNombre());
		ps.setString(3, p.getDescripcion());
		ps.setFloat(4, p.getPrecio());
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	
	
	
	
	
}
