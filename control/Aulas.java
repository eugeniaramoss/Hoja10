package control;

public class Aulas {

	private int id_aula;
	private int planta;

	public Aulas(int id_aula, int planta) {
		super();
		this.id_aula = id_aula;
		this.planta = planta;
	}

	public int getId_aula() {
		return id_aula;
	}

	public void setId_aula(int id_aula) {
		this.id_aula = id_aula;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	@Override
	public String toString() {
		return "Aulas [id_aula=" + id_aula + ", planta=" + planta + "]";
	}

}
