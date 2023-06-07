package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

	public static ResultSet consulta1(String nombre) {

		// dado un alumno me dice en que aula esta

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(
					"SELECT Aulas.id_aula, Aulas.planta FROM Alumnos_has_Aulas INNER JOIN Alumnos ON Alumnos_has_Aulas.Alumnos_id_alum = Alumnos.id_alum INNER JOIN Aulas ON Alumnos_has_Aulas.Aulas_id_aula = Aulas.id_aula WHERE Alumnos.nombre ='"
							+ nombre + "'");

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();

		}
		return rs;

	}

	public static ResultSet consulta2(int id_aula) {

		// pido un aula y me dice que alumnos tiene

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			rs = sentenciaSQL.executeQuery(
					"SELECT Alumnos.nombre FROM Alumnos_has_Aulas INNER JOIN Alumnos ON Alumnos_has_Aulas.Alumnos_id_alum = Alumnos.id_alum WHERE Alumnos_has_Aulas.Aulas_id_aula ='"
							+ id_aula + "'");

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();

		}
		return rs;

	}

	public static void consulta3() {

		// cuantas aulas hay

		Connection conexion = null;
		Statement sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			ResultSet rs = sentenciaSQL.executeQuery("SELECT COUNT(*) FROM Aulas");

			while (rs.next()) {
				System.out.println("Hay " + rs.getInt(1) + " aulas");
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

	public static void consulta4() {
		// aula mas usada

		Connection conexion = null;
		Statement sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			ResultSet rs = sentenciaSQL.executeQuery(
					"SELECT Aulas.id_aula, COUNT(*) AS cantidad_alumnos FROM Alumnos_has_Aulas INNER JOIN Aulas ON Alumnos_has_Aulas.Aulas_id_aula = Aulas.id_aula GROUP BY Aulas.id_aula ORDER BY cantidad_alumnos DESC LIMIT 1");

			while (rs.next()) {
				int id_aula = rs.getInt("id_aula");
				int cantidad_alumnos = rs.getInt("cantidad_alumnos");
				System.out
						.println("El aula con más alumnos es la " + id_aula + " con " + cantidad_alumnos + " alumnos");
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

	public static void consulta5() {
		// aulas sin alumnos
		Connection conexion = null;
		Statement sentenciaSQL = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			ResultSet rs = sentenciaSQL.executeQuery("SELECT Aulas.id_aula, Aulas.planta "
					+ "FROM Aulas LEFT JOIN Alumnos_has_Aulas ON Aulas.id_aula = Alumnos_has_Aulas.Aulas_id_aula WHERE Alumnos_has_Aulas.Aulas_id_aula IS NULL");

			while (rs.next()) {
				System.out
						.println("Aula sin alumnos: " + rs.getInt("id_aula") + " en la planta " + rs.getInt("planta"));
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
