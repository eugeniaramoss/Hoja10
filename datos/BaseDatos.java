package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {

	public static int ejecutarSQL(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "eugenia", "123456");

			sentenciaSQL = conexion.createStatement();

			resultado = sentenciaSQL.executeUpdate(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return resultado;
	}

}