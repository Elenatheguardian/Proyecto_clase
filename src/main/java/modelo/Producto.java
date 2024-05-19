package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoProducto;

public class Producto {

	private int id;
	private String nombre;
	private String tipo; 
	private String descripcion;
	private String foto;
	private int precio;
	
	public Producto() {
		
	}
	
	
	public Producto( String nombre, String tipo, String descripcion, int precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Producto(int id,  String nombre,String tipo, String descripcion, int precio) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Producto( String nombre, String tipo, String descripcion, String foto, int precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
	}


	public Producto(int id, String nombre, String tipo, String descripcion, String foto, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", tipo=\" + tipo + \", descripcion=" + descripcion
				+ ", foto=" + foto + ", precio=" + precio + "]";
	}
	
	public void insertar() throws SQLException {	
		
		DaoProducto dao = new DaoProducto();
		dao.insertar(this);
	}
	
	
	

	
public void datosBD(int id) throws SQLException {
	DaoProducto dao = new DaoProducto();
    Producto aux = dao.obtenerPorId(id);
    System.out.println("hola333"+aux);
    this.setId(aux.getId());
    this.setNombre(aux.getNombre());
    this.setTipo(aux.getTipo());
    this.setDescripcion(aux.getDescripcion());
    this.setFoto(aux.getFoto());
    this.setPrecio(aux.getPrecio());
}



public void editar() throws SQLException {
    DaoProducto dao = new DaoProducto();
    dao.productosEditar(this);
}

public void borrar(int id) throws SQLException {
    DaoProducto dao = new DaoProducto();
    dao.productosBorrar(id);
}

public String dameJson() {
    String json = "";
    Gson gson = new Gson();

    json = gson.toJson(this);
    return json;
}








}