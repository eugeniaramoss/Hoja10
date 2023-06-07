package control;

public class Alumnos {

	private int id_alum;
	private String nombre;
	private String dni;
	private int edad;
	private int telefono;
	private int matricula;
	private int media;
	private String grado;

	public Alumnos(String nombre, String dni, int edad, int telefono, int matricula, int media, String grado) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.telefono = telefono;
		this.matricula = matricula;
		this.media = media;
		this.grado = grado;
	}

	public Alumnos(int id_alum, String nombre, String dni, int edad, int telefono, int matricula, int media,
			String grado) {
		super();
		this.id_alum = id_alum;
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.telefono = telefono;
		this.matricula = matricula;
		this.media = media;
		this.grado = grado;
	}

	public int getId_alum() {
		return id_alum;
	}

	public void setId_alum(int id_alum) {
		this.id_alum = id_alum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "Alumnos [id_alum=" + id_alum + ", nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", telefono="
				+ telefono + ", matricula=" + matricula + ", media=" + media + ", grado=" + grado + "]";
	}

}
