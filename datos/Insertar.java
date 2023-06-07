package datos;

import control.Alumnos;
import control.Transformar;
import usuario.PedirDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insertar {

	public static void insertarAlumnos() {

		Alumnos alum1;
		String sql = "";
		int resultado = 0;
		
		try {
			alum1 = PedirDatos.pedirAlumno();

			sql = Transformar.InsertarSQL(alum1);

			resultado = BaseDatos.ejecutarSQL(sql);

			System.out.println("Ha cambiado " + resultado + " filas");
			
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		}

	}
}
