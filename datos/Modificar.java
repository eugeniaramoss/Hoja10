package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Modificar {

	public static void modificarAlumno() {

		int id_alumno;
		String nombre;
		String dni;
		int edad;
		int telefono;
		int matricula;
		int media;
		String grado;
		
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce el ID del alumno a actualizar:");
		id_alumno = lector.nextInt();
		lector.nextLine();

		System.out.println("Introduce el nuevo nombre del alumno:");
		nombre = lector.nextLine();

		System.out.println("Introduce el nuevo DNI del alumno:");
		dni = lector.nextLine();

		System.out.println("Introduce la nueva edad del alumno:");
		edad = lector.nextInt();
		lector.nextLine();

		System.out.println("Introduce el nuevo teléfono del alumno:");
		telefono = lector.nextInt();
		lector.nextLine();

		System.out.println("Introduce la nueva matrícula del alumno:");
		matricula = lector.nextInt();
		lector.nextLine();

		System.out.println("Introduce la nueva media del alumno:");
		media = lector.nextInt();
		lector.nextLine();

		System.out.println("Introduce el nuevo grado del alumno:");
		grado = lector.nextLine();

		// Actualizar datos del alumno en la tabla Alumnos
		Connection conexion = null;
		Statement sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			String consulta = "UPDATE Alumnos SET nombre='" + nombre + "', dni='" + dni + "', edad=" + edad
					+ ", telefono='" + telefono + "', matricula=" + matricula + ", media=" + media + ", grado='" + grado
					+ "' WHERE id_alum=" + id_alumno;
			int filasAfectadas = sentenciaSQL.executeUpdate(consulta);

			if (filasAfectadas == 1) {
				System.out.println("Datos del alumno actualizados correctamente en la tabla Alumnos");
			} else {
				System.out.println("Error al actualizar los datos del alumno en la tabla Alumnos");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// Actualizar datos del alumno en la tabla Alumnos_has_Aulas
		conexion = null;
		sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			String consulta = "UPDATE Alumnos_has_Aulas SET Alumnos_id_alum=" + id_alumno + " WHERE Alumnos_id_alum="
					+ id_alumno;
			int filasAfectadas = sentenciaSQL.executeUpdate(consulta);

			if (filasAfectadas >= 1) {
				System.out.println("Datos del alumno actualizados correctamente en la tabla Alumnos_has_Aulas");
			} else {
				System.out.println("Error al actualizar los datos del alumno en la tabla Alumnos_has_Aulas");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public static void modificarAula() {

		int id_aula;
		int planta;

		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce el ID del aula a actualizar:");
		id_aula = lector.nextInt();
		lector.nextLine();

		System.out.println("Introduce la nueva planta del aula:");
		planta = lector.nextInt();
		lector.nextLine();

		// Actualizar datos del aula en la tabla Aulas
		Connection conexion = null;
		Statement sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			String consulta = "UPDATE Aulas SET planta='" + planta + "' WHERE id_aula=" + id_aula;

			int filasAfectadas = sentenciaSQL.executeUpdate(consulta);

			if (filasAfectadas == 1) {
				System.out.println("Datos del aula actualizados correctamente en la tabla Aulas");
			} else {
				System.out.println("Error al actualizar los datos del aula en la tabla Aulas");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// Actualizar datos del aula en la tabla Alumnos_has_Aulas
		conexion = null;
		sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			String consulta = "UPDATE Alumnos_has_Aulas SET Aulas_id_aula=" + id_aula + " WHERE Aulas_id_aula="
					+ id_aula;
			int filasAfectadas = sentenciaSQL.executeUpdate(consulta);

			if (filasAfectadas >= 1) {
				System.out.println("Datos del aula actualizados correctamente en la tabla Alumnos_has_Aulas");
			} else {
				System.out.println("Error al actualizar los datos del aula en la tabla Alumnos_has_Aulas");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
