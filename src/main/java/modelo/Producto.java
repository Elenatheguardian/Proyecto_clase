package modelo;

import java.sql.SQLException;

import dao.DaoProducto;

public class Producto {

	private int id;
	private String tipo; 
	private String nombre;
	private String descripcion;
	private String foto;
	private int precio;
	
	public Producto() {
		
	}
	
	
	public Producto(String tipo, String nombre, String descripcion, int precio) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Producto(int id, String tipo, String nombre, String descripcion, int precio) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Producto(String tipo, String nombre, String descripcion, String foto, int precio) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
	}


	public Producto(int id, String tipo, String nombre, String descripcion, String foto, int precio) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", foto=" + foto + ", precio=" + precio + "]";
	}
	
	public void insertar() throws SQLException {	
		
		DaoProducto dao = new DaoProducto();
		dao.Insertar(this);
	}
	
	
	
}
	
