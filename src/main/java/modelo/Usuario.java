package modelo;

import java.sql.SQLException;
import com.google.gson.*;
import dao.DaoUsuario;
public class Usuario {
	
	private int id;
	private String nombre;
	private String mail;
	private String tel;
	private int permiso;
	private String direccion;
	
	


	public Usuario() {
		
		
	}
	 
	public Usuario( String nombre, String mail, String tel, int permiso, String direccion) throws SQLException {
	this.nombre = nombre;
	this.mail = mail;
	this.tel = tel;
	this.permiso = permiso;
	this.direccion = direccion;
	}
	
	public Usuario(int id, String nombre, String mail, String tel, int permiso, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.permiso = permiso;
		this.direccion = direccion;
		
	}

	public int getid() {
		return id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre =nombre;
	
	}
	public String getMail() {
		return mail;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public int getPermiso(int permiso) {
		return permiso;
		
	}
	public void setPermiso(int permiso) {
		this.permiso =permiso;
	}
	public String setDireccion() {
		return direccion;
	}
	
	public int getDireccion(int direccion) {
		return direccion;
	}
	/*public void obtenerPorId(int id) throws SQLException {
		
		DaoUsuario dao = new DaoUsuario();
		Usuario aux= dao.obtenerPorID(id);
		
		this.setId(aux getId());
		this.setNombre(aux.getNombre());
		this.setTel(aux.getMail());
		this.setPermiso(aux.getPermiso());
	}
	
	public boolean logeo(String pass) throws SQLException{
		boolean ok = false;
		DaoUsuario dao = new DaoUsuario();
		Usuario aux= dao.logeando(this, pass); // db
		
		if(aux != null) {
			ok=true;
			this.setId(aux.getId());
			this.setNombre(aux.getNombre());
			this.setTel(aux.getTel());
			this.setMail(aux.getMail());
			this.setPermiso(aux.getPermiso());
		}
			return ok;
		}
	public String dameJson() {
		String json = "";
		
		Gson gson= new Gson();
		
		json = gson.toJson(this);
		
		return json;
			
	}
	public void borrar(int id) throws SQLException{
		DaoUsuario dao = new DaoUsuario();
		dao.borrar(id);
		
	}
	public String toString() {
		return "Usuario [id=" +id +", nombre="+ nombre +", mail=" +mail+", permiso=" +permiso +"]";
		
	}*/
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	