package actividad1;

import java.util.ArrayList;

public class Enfermedad{

	///////////////////////////////////////
	//Atributos
	///////////////////////////////////////
	
	String nombre;
	ArrayList<String> sintomas = new ArrayList<String>();
	ArrayList<String> tratamientos = new ArrayList<String>();

	
	
	///////////////////////////////////////
	//Constructores
	///////////////////////////////////////
	
	public Enfermedad() {
	}
		
	public Enfermedad(String nombre, ArrayList<String> sintomas, ArrayList<String> tratamientos) {
		super();
		this.nombre = nombre;
		this.sintomas = sintomas;
		this.tratamientos = tratamientos;
	}

	///////////////////////////////////////
	//Getters & Setters
	///////////////////////////////////////
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the sintomas
	 */
	public ArrayList<String> getSintomas() {
		return sintomas;
	}

	/**
	 * @param sintomas the sintomas to set
	 */
	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}

	/**
	 * @return the tratamientos
	 */
	public ArrayList<String> getTratamientos() {
		return tratamientos;
	}

	/**
	 * @param tratamientos the tratamientos to set
	 */
	public void setTratamientos(ArrayList<String> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
	
	
	///////////////////////////////////////
	//Metodos
	///////////////////////////////////////

	public void agregarSintoma(String newSintoma) {
		sintomas.add(newSintoma);
	}
	
	public void modificarSintoma(String oldSintoma, String newSintoma) {
		int index = sintomas.indexOf(oldSintoma);
		
		if (index != -1) {
			sintomas.set(index, newSintoma);
		} else {
			System.out.println("ERR: Sintoma [" + oldSintoma + "] no encontrado!");
		}
	}
	
	public void eliminarSintoma(String sintoma) {
		int index = sintomas.indexOf(sintoma);
		if (index != -1) {
			sintomas.remove(index);
		} else {
			System.out.println("ERR: Sintoma [" + sintoma + "] no encontrado!");
		}
	}

	public void agregarTratamiento(String newTratamiento) {
		tratamientos.add(newTratamiento);
	}
	
	public void modificarTratamiento(String oldTratamiento, String newTratamiento) {
		int index = tratamientos.indexOf(oldTratamiento);
		
		if (index != -1) {
			tratamientos.set(index, newTratamiento);
		} else {
			System.out.println("ERR: Tratamiento [" + oldTratamiento + "] no encontrado!");
		}
	}
	
	public void eliminarTratamiento(String tratamiento) {
		int index = tratamientos.indexOf(tratamiento);
		if (index != -1) {
			tratamientos.remove(index);
		} else {
			System.out.println("ERR: Tratamiento [" + tratamiento + "] no encontrado!");
		}
	}

	@Override
	public String toString() {
		return "Enfermedad:\n\tnombre=" + nombre + "\n\tsintomas=" + sintomas + "\n\ttratamientos=" + tratamientos + "\n";
	}
	
	
}
