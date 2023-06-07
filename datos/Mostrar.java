package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mostrar {

	public static void MostrarAlumnos() {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String sql = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");

			sentenciaSQL = conexion.createStatement();

			sql = "SELECT * FROM `Alumnos`";

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {

				System.out.println("id: " + rs.getInt("id_alum") + " | Nombre: " + rs.getString("nombre") + " | DNI: "
						+ rs.getString("dni") + " | Edad: " + rs.getInt("edad") + " | Telefono: "
						+ rs.getInt("telefono") + " | Matricula: " + rs.getInt("matricula") + " | Media: "
						+ rs.getInt("media") + " | Grado: " + rs.getString("grado"));
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void MostrarAulas() {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String sql = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");

			sentenciaSQL = conexion.createStatement();

			sql = "SELECT * FROM `Aulas`";

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {

				System.out.println("id: " + rs.getInt("id_aula") + " | Planta: " + rs.getInt("planta"));
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void MostrarA_H_A() {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String sql = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");

			sentenciaSQL = conexion.createStatement();

			sql = "SELECT * FROM `Alumnos_has_Aulas`";

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {

				System.out.println("id Alumno: " + rs.getInt("Alumnos_id_alum") + " | id Aula: "
						+ rs.getInt("Aulas_id_aula") + " | Profesor: " + rs.getString("profesor") + " | Asignatura: "
						+ rs.getString("asignatura"));
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
