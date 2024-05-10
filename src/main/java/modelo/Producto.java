package modelo;

public class Producto {

	private int id;
	private String clase; 
	private String color;
	private String descripcion;
	private String foto;
	private String estado;
	
public Producto () {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getClase() {
	return clase;
}

public void setClase(String clase) {
	this.clase = clase;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
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

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

@Override
public String toString() {
	return "Producto [id=" + id + ", clase=" + clase + ", color=" + color + ", descripcion=" + descripcion + ", foto="
			+ foto + ", estado=" + estado + "]";
}
	
	
}
