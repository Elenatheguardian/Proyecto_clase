package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoProducto;

/**
 * Esta clase define objetos Productos
 * @author Elena Alexandru
 * @version 4.2
 */

public class Producto {

	private int id;
	private String nombre;
	private String tipo;
	private String descripcion;
	private String foto;
	private int precio;

	public Producto() {

	}

	/**
	 * constructor con 4 parametros
	 * 
	 * @param nombre      nombre del producto
	 * @param tipo        tipo de producto
	 * @param descripcion descripcion del producto
	 * @parm precio precio del producto
	 */
	public Producto(String nombre, String tipo, String descripcion, int precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
	 * constructor con 5 parametros
	 * 
	 * @param id          id del producto
	 * @param nombre      nombre del producto
	 * @param tipo        tipo de producto
	 * @param descripcion descripcion del producto
	 * @param precio      precio del producto
	 */
	public Producto(int id, String nombre, String tipo, String descripcion, int precio) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
	 * constructor con 4 parametros
	 * 
	 * @param nombre      nombre del producto
	 * @param tipo        tipo de producto
	 * @param descripcion descripcion del producto
	 * @param foto        foto del producto
	 * @param precio      precio del producto
	 */
	public Producto(String nombre, String tipo, String descripcion, String foto, int precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
	}

	/**
	 * constructor con 6 parametros
	 * 
	 * @param id          id del producto
	 * @param nombre      nombre del producto
	 * @param tipo        tipo de producto
	 * @param descripcion descripcion del producto
	 * @param foto        foto del producto
	 * @param precio      precio del producto
	 */
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

	/**
	 * Este metodo llama a la clase DaoProducto para insertar un objeto en la bd
	 * 
	 * @throws SQLException
	 */

	public void insertar() throws SQLException {

		DaoProducto dao = new DaoProducto();
		dao.insertar(this);
	}

	/**
	 * Recupera los datos de un producto de la base de datos y establece los atributos 
	 * correspondientes del objeto actual basado en el ID del producto 
	 * @param id El ID del producto que se desea recuperar.
	 * @throws SQLException 
	 */

	public void datosBD(int id) throws SQLException {
		DaoProducto dao = new DaoProducto();
		Producto aux = dao.obtenerPorId(id);
		// System.out.println("hola333" + aux);
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setTipo(aux.getTipo());
		this.setDescripcion(aux.getDescripcion());
		this.setFoto(aux.getFoto());
		this.setPrecio(aux.getPrecio());
	}
	/**
	 * Edita los datos del producto en la base de datos utilizando los atributos 
	 * del objeto 
	 *
	 * @throws SQLException 
	 */

	public void editar() throws SQLException {
		DaoProducto dao = new DaoProducto();
		dao.productosEditar(this);
	}

	/**
	 * Borra un producto de la base de datos basado en el ID proporcionado.
	 * @param id  ID del producto que se desea borrar.
	 * @throws SQLException .
	 */
	public void borrar(int id) throws SQLException {
		DaoProducto dao = new DaoProducto();
		dao.productosBorrar(id);
	}

	/**
	 * Convierte el objeto actual a su representación en formato JSON.
	 * @return Una cadena de texto en formato JSON que representa el objeto actual.
	 */
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);
		return json;
	}

}
