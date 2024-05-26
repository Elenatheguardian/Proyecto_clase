package modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import com.google.gson.*;
import dao.DaoUsuario;

public class Usuario {

	private int id;
	private String nombre;
	private String mail;
	private int tel;
	private int permiso;
	private String direccion;

	public Usuario() {

	}

	public Usuario(int id, String nombre, String mail, int tel, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.direccion = direccion;
	}

	public Usuario(String nombre, String mail, int tel, String direccion) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.direccion = direccion;
	}

	public Usuario(String nombre, String mail, int tel, int permiso, String direccion) throws SQLException {
		this.nombre = nombre;
		this.mail = mail;
		this.tel = tel;
		this.permiso = permiso;
		this.direccion = direccion;
	}

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

	public void insertarUs() throws SQLException {

		DaoUsuario dao = new DaoUsuario();
		dao.insertarUs(this);
	}

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

	public void guardarPass(String pass) throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.guardarPass(this, pass);
	}

	public String dameJson() {
		String json = "";

		Gson gson = new Gson();

		json = gson.toJson(this);
		return json;
	}

	public void borrarAdmin(int id) throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.borrarAdmin(id);
	}

	public void recogerPorId(int id) throws SQLException {

		DaoUsuario dao = new DaoUsuario();
		Usuario aux = dao.recogerPorId(id);

		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setMail(aux.getMail());
		this.setTel(aux.getTel());
		this.setDireccion(aux.getDireccion());

	}

	public void editar() throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.editar(this);
	}

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
