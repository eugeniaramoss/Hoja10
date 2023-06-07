package control;

public class Transformar {

	public static String InsertarSQL(Alumnos alum1) {
		return "INSERT INTO Alumnos (nombre, dni, edad, telefono, matricula, media, grado) VALUES ('"
				+ alum1.getNombre() + "', '" + alum1.getDni() + "', " + alum1.getEdad() + ", " + alum1.getTelefono()
				+ ", " + alum1.getMatricula() + ", " + alum1.getMedia() + ", '" + alum1.getGrado() + "')";
	}

}
