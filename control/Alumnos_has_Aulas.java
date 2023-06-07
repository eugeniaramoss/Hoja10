package control;

public class Alumnos_has_Aulas {

	private int Alumnos_id_alum;
	private int Aulas_id_aula;
	private String profesor;
	private String asignatura;

	public Alumnos_has_Aulas(int alumnos_id_alum, int aulas_id_aula, String profesor, String asignatura) {
		super();
		Alumnos_id_alum = alumnos_id_alum;
		Aulas_id_aula = aulas_id_aula;
		this.profesor = profesor;
		this.asignatura = asignatura;
	}

	public int getAlumnos_id_alum() {
		return Alumnos_id_alum;
	}

	public void setAlumnos_id_alum(int alumnos_id_alum) {
		Alumnos_id_alum = alumnos_id_alum;
	}

	public int getAulas_id_aula() {
		return Aulas_id_aula;
	}

	public void setAulas_id_aula(int aulas_id_aula) {
		Aulas_id_aula = aulas_id_aula;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public String toString() {
		return "Alumnos_has_Aulas [Alumnos_id_alum=" + Alumnos_id_alum + ", Aulas_id_aula=" + Aulas_id_aula
				+ ", profesor=" + profesor + ", asignatura=" + asignatura + "]";
	}

}
