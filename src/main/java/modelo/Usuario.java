package modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import com.google.gson.*;
import dao.DaoUsuario;

/**
 * Esta clase es para crear los objetos Usuarios.
 * @author Elena Alexandru 
 * @version 4.2
 */

public class Usuario {

	private int id;
	private String nombre;
	private String mail;
	private int tel;
	private int permiso;
	private String direccion;

	public Usuario() {

	}

	/**
	 * constructor con 5 parametros
	 * 
	 * @param id        id del usuario
	 * @param nombre    nombre del usuario
	 * @param mail      mail del usuario
	 * @param tel       telefono del usuario
	 * @param direccion direccion del usuario
	 */
	public Usuario(int id, String nombre, String mail, int tel, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.direccion = direccion;
	}

	/**
	 * constructor con 4 parametros
	 * 
	 * @param nombre    nombre del usuario
	 * @param mail      mail del usuario
	 * @param tel       telefono del usuario
	 * @param direccion direccion del usuario
	 */
	public Usuario(String nombre, String mail, int tel, String direccion) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.direccion = direccion;
	}

	/**
	 * constructor con 5 parametros
	 * 
	 * @param nombre    nombre del usuario
	 * @param mail      mail del usuario
	 * @param tel       telefono del usuario
	 * @param permiso   permiso del usuario
	 * @param direccion direccion del usuario
	 */
	public Usuario(String nombre, String mail, int tel, int permiso, String direccion) throws SQLException {
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.permiso = permiso;
		this.direccion = direccion;
	}

	/**
	 * constructor con 6 parametros
	 * 
	 * @param id        id del usuario
	 * @param nombre    nombre del usuario
	 * @param mail      mail del usuario
	 * @param tel       telefono del usuario
	 * @param permiso   permiso del usuario
	 * @param direccion direccion del usuario
	 */
	public Usuario(int id, String nombre, String mail, int tel, int permiso, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.permiso = permiso;
		this.direccion = direccion;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", mail=" + mail + ", tel=" + tel + ", permiso=" + permiso
				+ ", direccion=" + direccion + "]";
	}

	/**
	 * Este metodo llama a la clase DaoUsuario para insertar un usuario en la bd
	 * @throws SQLException
	 */
	public void insertarUs() throws SQLException {

		DaoUsuario dao = new DaoUsuario();
		dao.insertarUs(this);
	}

	/**
	 * Este metodo es para encriptar la contrasena
	 * 
	 * @param input input de la contrasena
	 * @return return de la contrasena
	 */
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Guarda una nueva contrasena para el usuario en la base de datos
	 * @param pass La nueva contrasena que se desea guardar.
	 * @throws SQLException
	 */
	
	public void guardarPass(String pass) throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.guardarPass(this, pass);
	}

	/**
	 * Convierte el objeto actual a su representacion en formato JSON.
	 * @return Una cadena de texto en formato JSON que representa el objeto actual.
	 */
	public String dameJson() {
		String json = "";

		Gson gson = new Gson();

		json = gson.toJson(this);
		return json;
	}
	/**
	 * Borra un administrador de la base de datos basado en el ID proporcionado.
	 *
	 * @param id ID del administrador que se desea borrar.
	 * @throws SQLException 
	 */
	
	public void borrarAdmin(int id) throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.borrarAdmin(id);
	}

	/**
	 * Metodo para recoger informacion por id al que pide informacion al dao
	 * 
	 * @param id id del usuario
	 * @throws SQLException
	 */
	public void recogerPorId(int id) throws SQLException {

		DaoUsuario dao = new DaoUsuario();
		Usuario aux = dao.recogerPorId(id);

		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setMail(aux.getMail());
		this.setTel(aux.getTel());
		this.setDireccion(aux.getDireccion());

	}

	/**
	 * Edita los datos del usuario en la base de datos utilizando los atributos 
	 * del objeto 
	 *
	 * @throws SQLException 
	 */
	public void editar() throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.editar(this);
	}
	/**
	 * Verifica el inicio de sesión del usuario con la contrasena cifrada proporcionada.
	 *
	 * @param passcifrada La contrasena cifrada que se desea verificar.
	 * @return  si el inicio de sesión es exitoso devuelve un true, de lo contrario devuelve un false 
	 * @throws SQLException 
	 */
	
	public boolean inicioSesion(String passcifrada) throws SQLException {

		boolean bien = false;

		DaoUsuario dao = new DaoUsuario();
		Usuario aux = dao.inicioSesion(this, passcifrada);
		if (aux != null) {
			bien = true;
			this.setId(aux.getId());
			this.setNombre(aux.getNombre());
			this.setMail(aux.getMail());
			this.setPermiso(aux.getPermiso());

		}

		return bien;

	}

}
