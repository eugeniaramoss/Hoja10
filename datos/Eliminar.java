package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import usuario.PedirDatos;

public class Eliminar {

	public static void eliminarDatosT2(int id_aula) {

		// poder borrar de la t2 directamente

		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado;
		String sql = "";

		int idborrar = PedirDatos.pedirIdAula();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");

			sentenciaSQL = conexion.createStatement();

			sql = "DELETE FROM `Aulas` WHERE `id_aula`=" + idborrar;

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Aula eliminada con éxito.");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();

		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	public static void eliminarAlumno(int id_alumno) {

		// si borro de la t1 implica que se borra de la t1t2

		Connection conexion = null;
		Statement sentenciaSQL = null;

		int idAlumno = PedirDatos.pedirIdAlumno();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");
			sentenciaSQL = conexion.createStatement();

			String query1 = "DELETE FROM alumnos_has_aulas WHERE Alumnos_id_alum=" + idAlumno;
			sentenciaSQL.executeUpdate(query1);

			String query2 = "DELETE FROM alumnos WHERE id_alum=" + idAlumno;
			sentenciaSQL.executeUpdate(query2);

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (sentenciaSQL != null) {
					sentenciaSQL.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
