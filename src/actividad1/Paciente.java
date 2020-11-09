package actividad1;

import java.util.ArrayList;

public class Paciente {
	
	///////////////////////////////////////
	//Atributos
	///////////////////////////////////////
	
	String nombre;
	String apellido;
	String genero;
	String direccion;
	ArrayList<String> telefonos = new ArrayList<String>();
	ArrayList<String> enfermedades = new ArrayList<String>();
	
	
	
	///////////////////////////////////////
	//Constructores
	///////////////////////////////////////
	
	public Paciente() {
	}

	public Paciente(String nombre, String apellido, String genero, String direccion, ArrayList<String> telefonos, ArrayList<String> enfermedades) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.direccion = direccion;
		this.telefonos = telefonos;
		this.enfermedades = enfermedades;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefonos
	 */
	public ArrayList<String> getTelefonos() {
		return telefonos;
	}

	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(ArrayList<String> telefonos) {
		this.telefonos = telefonos;
	}

	/**
	 * @return the enfermedades
	 */
	public ArrayList<String> getEnfermedades() {
		return enfermedades;
	}

	/**
	 * @param enfermedades the enfermedades to set
	 */
	public void setEnfermedades(ArrayList<String> enfermedades) {
		this.enfermedades = enfermedades;
	}
	
	
	
	///////////////////////////////////////
	//Metodos
	///////////////////////////////////////
	
	public void agregarTelefono(String newTelefono) {
		telefonos.add(newTelefono);
	}
	
	public void modificarTelefono(String oldTelefono, String newTelefono) {
		int index = telefonos.indexOf(oldTelefono);
		
		if (index != -1) {
			telefonos.set(index, newTelefono);
		} else {
			System.out.println("ERR: Telefono [" + oldTelefono + "] no encontrado!");
		}
	}
	
	public void eliminarTelefono(String telefono) {
		int index = telefonos.indexOf(telefono);
		if (index != -1) {
			telefonos.remove(index);
		} else {
			System.out.println("ERR: Telefono [" + telefono + "] no encontrado!");
		}
	}
	
	public void agregarEnfermedad(String newEnfermedad) {
		enfermedades.add(newEnfermedad);
	}
	
	public void modificarEnfermedad(String oldEnfermedad, String newEnfermedad) {
		int index = enfermedades.indexOf(oldEnfermedad);
		
		if (index != -1) {
			enfermedades.set(index, newEnfermedad);
		} else {
			System.out.println("ERR: Enfermedad [" + oldEnfermedad + "] no encontrada!");
		}
	}
	
	public void eliminarEnfermedad(String enfermedad) {
		int index = enfermedades.indexOf(enfermedad);
		if (index != -1) {
			enfermedades.remove(index);
		} else {
			System.out.println("ERR: Enfermedad [" + enfermedad + "] no encontrada!");
		}
	}

	@Override
	public String toString() {
		return "Paciente:\n\tnombre=" + nombre + "\n\tapellido=" + apellido + "\n\tgenero=" + genero + "\n\tdireccion="
				+ direccion + "\n\ttelefonos=" + telefonos + "\n\tLista de enfermedades:" ;
	}
	
	
}
