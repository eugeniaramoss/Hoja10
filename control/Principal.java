package control;

import java.util.Scanner;

import datos.Consultas;
import datos.Eliminar;
import datos.Insertar;
import datos.Modificar;
import datos.Mostrar;
import usuario.PedirDatos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion;
		int opcion2;
		int opcion3;
		int opcion4;
		int opcion5;
		int id_aula = 0;
		int id_alum = 0;
		int opcion6;
		Scanner lector = new Scanner(System.in);

		do {
			System.out.println(" ");
			System.out.println("1 - Mostrar");
			System.out.println("2 - Insertar");
			System.out.println("3 - Modificar");
			System.out.println("4 - Eliminar");
			System.out.println("5 - Consultas");
			System.out.println("6 - Salir");
			System.out.println(" ");
			opcion = lector.nextInt();
			lector.nextLine();

			switch (opcion) {
			case 1:
				System.out.println(" ");
				System.out.println("MOSTRAR");
				System.out.println("1 - Tabla de alumnos");
				System.out.println("2 - Tabla de aulas");
				System.out.println("3 - Tabla de alumnos_has_aulas");
				System.out.println(" ");
				opcion2 = lector.nextInt();
				lector.nextLine();

				switch (opcion2) {
				case 1:
					Mostrar.MostrarAlumnos();
					break;

				case 2:
					Mostrar.MostrarAulas();
					break;

				case 3:
					Mostrar.MostrarA_H_A();
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}
				break;

			case 2:
				System.out.println(" ");
				System.out.println("INSERTAR");
				System.out.println("1 - Insertar en la entidad T1");
				System.out.println("2 - Insertar en la entidad T2 asociada a la T1");
				System.out.println(" ");
				opcion3 = lector.nextInt();
				;
				lector.nextLine();

				switch (opcion3) {
				case 1:
					Insertar.insertarAlumnos();
					break;

				case 2:
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}
				break;

			case 3:
				System.out.println(" ");
				System.out.println("MODIFICAR");
				System.out.println("1 - Modificar alumnos");
				System.out.println("2 - Modificar aulas");
				System.out.println(" ");
				opcion6 = lector.nextInt();
				;
				lector.nextLine();

				switch (opcion6) {
				case 1:
					Modificar.modificarAlumno();
					break;
				case 2:
					Modificar.modificarAula();
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}

				break;

			case 4:
				System.out.println(" ");
				System.out.println("ELIMINAR");
				System.out.println("1 - De la T2 directamente");
				System.out.println("2 - De la T1, por lo que se borra de la T12");
				System.out.println(" ");
				opcion5 = lector.nextInt();
				lector.nextLine();

				switch (opcion5) {
				case 1:
					Eliminar.eliminarDatosT2(id_aula);
					break;

				case 2:
					Eliminar.eliminarAlumno(id_alum);
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}
				break;

			case 5:
				System.out.println(" ");
				System.out.println("CONSULTAS");
				System.out.println("1 - Dado un alumno muestra en que aula esta");
				System.out.println("2 - Dada un aula muestra los alumnos que hay en ella");
				System.out.println("3 - ¿Cuántas aulas hay?");
				System.out.println("4 - Aula con más alumnos");
				System.out.println("5 - Aulas sin alumnos");
				System.out.println(" ");
				opcion4 = lector.nextInt();
				lector.nextLine();

				switch (opcion4) {
				case 1:
					PedirDatos.pedirNombre();
					break;

				case 2:
					PedirDatos.pedirAula();
					break;

				case 3:
					Consultas.consulta3();
					break;

				case 4:
					Consultas.consulta4();
					break;

				case 5:
					Consultas.consulta5();
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}
				break;

			case 6:
				System.out.println("FIN");
				break;

			default:
				System.out.println("Opción no válida");
				break;
			}

		} while (opcion != 6);

		lector.close();

	}

}
