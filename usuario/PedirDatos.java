package usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Alumnos;
import datos.Consultas;

public class PedirDatos {

	public static Alumnos pedirAlumno() {

		String nombre = "";
		String dni = "";
		int edad = 0;
		int telefono = 0;
		int matricula = 0;
		int media = 0;
		String grado = "";

		Scanner lector = new Scanner(System.in);

		try {

			System.out.println("Introduzca el nombre del alumno: ");
			nombre = lector.nextLine();

			System.out.println("Introduzca el dni del alumno " + nombre + ":");
			dni = lector.nextLine();

			System.out.println("Introduzca la edad del alumno " + nombre + ":");
			edad = lector.nextInt();
			lector.nextLine();

			System.out.println("Introduzca el teléfono del alumno " + nombre + ":");
			telefono = lector.nextInt();
			lector.nextLine();

			System.out.println("Introduzca la matrícula del alumno " + nombre + ":");
			matricula = lector.nextInt();
			lector.nextLine();

			System.out.println("Introduzca la media del alumno " + nombre + ":");
			media = lector.nextInt();
			lector.nextLine();

			System.out.println("Introduzca el grado que esta realizando el alumno " + nombre + ":");
			grado = lector.nextLine();

			// Verificación de entrada: edad, matrícula y media no deben ser negativos
			if (edad < 0 || matricula < 0 || media < 0) {
				throw new IllegalArgumentException("La edad, la matrícula y la media deben ser valores positivos.");
			}

		} catch (Exception e) {
			System.out.println("Error");
		}

		return new Alumnos(nombre, dni, edad, telefono, matricula, media, grado);
	}

	public static void pedirNombre() {

		String nombre;
		int id_aula;
		int planta;

		Scanner lector = new Scanner(System.in);

		System.out.println("Nombre del alumno del que quiere saber el aula:");
		nombre = lector.nextLine();

		ResultSet rs = Consultas.consulta1(nombre);

		try {
			while (rs.next()) {

				id_aula = rs.getInt("id_aula");
				planta = rs.getInt("planta");

				System.out.println(
						"El aula del alumno es la " + rs.getInt("id_aula") + " en la planta " + rs.getInt("planta"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void pedirAula() {

		String nombre;
		int id_aula;

		Scanner lector = new Scanner(System.in);

		System.out.println("Digame el numero del aula para sacar los alumnos:");
		id_aula = lector.nextInt();
		lector.nextLine();

		ResultSet rs = Consultas.consulta2(id_aula);

		try {
			while (rs.next()) {

				nombre = rs.getString("nombre");

				System.out.println("El alumno perteneciente a esa clase es " + rs.getString("nombre"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int pedirIdAula() {

		int id_aula = 0;

		Scanner lector = new Scanner(System.in);

		try {
			System.out.println("Introduzca el id del aula que quiere eliminar: ");
			id_aula = lector.nextInt();
			lector.nextLine();

		} catch (Exception e) {
			System.out.println("Error");
		}

		return id_aula;
	}

	public static int pedirIdAlumno() {

		int id_alumno = 0;

		Scanner lector = new Scanner(System.in);

		try {
			System.out.println("Introduzca el id del alumnos que quiere eliminar: ");
			id_alumno = lector.nextInt();
			lector.nextLine();

		} catch (Exception e) {
			System.out.println("Error");
		}

		return id_alumno;
	}

}
