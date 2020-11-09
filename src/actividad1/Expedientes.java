package actividad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Expedientes extends CRUD{
	
	///////////////////////////////////////
	//Atributos
	///////////////////////////////////////
	
	ArrayList<Paciente> lista;
	
	
	
	///////////////////////////////////////
	//Constructores
	///////////////////////////////////////
	
	public Expedientes() {
		this.lista = new ArrayList<Paciente>();
	}
	

	
	///////////////////////////////////////
	//Getters & Setters
	///////////////////////////////////////
	
	/**
	 * @return the lista
	 */
	public ArrayList<Paciente> getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(ArrayList<Paciente> lista) {
		this.lista = lista;
	}
	
	
	
	///////////////////////////////////////
	//Metodos
	///////////////////////////////////////
	
	public void mostrarPaciente(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del paciente:");
			String nombre = reader.readLine();
			System.out.println("Digite el apellido del paciente:");
			String apellido = reader.readLine();
			
			boolean encontrada = false;
			for (Paciente p : lista) {
				if (p.getNombre().toLowerCase().equals(nombre.toLowerCase()) && p.getApellido().toLowerCase().equals(apellido.toLowerCase())) {
					System.out.println(p.toString());
					encontrada = true;
		        }
			}
			if (!encontrada) {
				System.out.println("ERR: Paciente [" + nombre + "] no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void ordenarAsc(){
		Paciente temp;
		String anterior = lista.get(0).getNombre().toLowerCase();
		
		for (int i = 1; i < lista.size(); i++) {
			if (lista.get(i).getNombre().toLowerCase().compareTo(anterior)<0) {
				temp = lista.get(i);
	        	lista.set(i, lista.get(i-1));
	        	lista.set(i-1, temp);
	        	i = 1;
	        }
			anterior = lista.get(i).getNombre().toLowerCase();
		}
	}
	
	@Override
	public void create() {
		try {
			Paciente nuevoPaciente = new Paciente();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			String input = "";
					
			System.out.println("Digite el nombre del paciente:");
	        input = reader.readLine();
	        nuevoPaciente.setNombre(input);
	        
	        System.out.println("Digite el apellido del paciente:");
	        input = reader.readLine();
	        nuevoPaciente.setApellido(input);
	        
	        System.out.println("Digite el genero del paciente:");
	        input = reader.readLine();
	        nuevoPaciente.setGenero(input);
	        
	        System.out.println("Digite la direccion del paciente:");
	        input = reader.readLine();
	        nuevoPaciente.setDireccion(input);
	        
	        do {
	        	System.out.println("Digite un número de télefono de contacto o digite \"salir\" para terminar de agregar teléfonos:");
	            input = reader.readLine();
	            if (!input.equals("salir")) {
	            	nuevoPaciente.agregarTelefono(input);
	            }
	        } while (!input.equals("salir"));
	        
	        do {
	        	System.out.println("Digite el nombre de la enfermedad del paciente o digite \"salir\" para terminar de agregar enfermedades:");
	            input = reader.readLine();
	            if (!input.equals("salir")) {
	            	nuevoPaciente.agregarEnfermedad(input);
	            }
	        } while (!input.equals("salir"));
	        
			lista.add(nuevoPaciente);
			System.out.println("Paciente [" + nuevoPaciente.getApellido() + ", " + nuevoPaciente.getNombre()+ "] agregado!");
			ordenarAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void read() {
		ordenarAsc();
		for (Paciente p : lista) {
			System.out.println(p.toString());
			for (String e : p.getEnfermedades()) {
				System.out.println("\t\t" + e);
			}
		}
	}
	
	@Override
	public void update() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del paciente a actualizar:");
			String nombre = reader.readLine();
			System.out.println("Digite el apellido del paciente a actualizar:");
			String apellido = reader.readLine();
			
			int index = -1;
			for (int i=0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase()) && lista.get(i).getApellido().toLowerCase().equals(apellido.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				Paciente viejoPaciente = lista.get(index);
				Paciente nuevoPaciente = new Paciente();
				String input = "";
				
				System.out.println("Digite el nuevo nombre para [" + viejoPaciente.getNombre() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoPaciente.setNombre(viejoPaciente.getNombre());
		        } else {
		        	nuevoPaciente.setNombre(input);
		        }
		        
		        System.out.println("Digite el nuevo apellido para [" + viejoPaciente.getApellido() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoPaciente.setApellido(viejoPaciente.getApellido());
		        } else {
		        	nuevoPaciente.setApellido(input);
		        }
		        
		        System.out.println("Digite el nuevo genero para [" + viejoPaciente.getGenero() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoPaciente.setGenero(viejoPaciente.getGenero());
		        } else {
		        	nuevoPaciente.setGenero(input);
		        }
		        
		        System.out.println("Digite la nueva direccion  para [" + viejoPaciente.getDireccion() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoPaciente.setDireccion(viejoPaciente.getDireccion());
		        } else {
		        	nuevoPaciente.setDireccion(input);
		        }
		        
		        nuevoPaciente.setTelefonos(viejoPaciente.getTelefonos());
		        System.out.println("Telefonos:");
		        for (String telefono : nuevoPaciente.getTelefonos()) {
		        	System.out.println("\t" + telefono);
		        }
		        System.out.println("Digite el telefono que desea modificar o presione ENTER para no modificar los telefonos:");
		        input = reader.readLine();
		        String oldTelefono = input;
		        if (!input.isEmpty()) {
		        	System.out.println("Digite el nuevo numero de telefono:");
			        input = reader.readLine();
			        String newTelefono = input;
		        	nuevoPaciente.modificarTelefono(oldTelefono, newTelefono);
		        }
		        
		        nuevoPaciente.setEnfermedades(viejoPaciente.getEnfermedades());
		        System.out.println("Enfermedades:");
		        for (String enfermedad : nuevoPaciente.getEnfermedades()) {
		        	System.out.println("\t" + enfermedad);
		        }
		        System.out.println("Digite el nombre de la enfermedad del paciente que desea modificar o presione ENTER para no modificar las enfermedades:");
		        input = reader.readLine();
		        String oldEnfermedad = input;
		        if (!input.isEmpty()) {
		        	System.out.println("Digite el nombre de la nueva enfermedad:");
			        input = reader.readLine();
			        String newEnfermedad = input;
		        	nuevoPaciente.modificarEnfermedad(oldEnfermedad, newEnfermedad);
		        }
		        
		        
		        lista.set(index, nuevoPaciente);
		        System.out.println("Paciente [" + nuevoPaciente.getApellido() + ", " + nuevoPaciente.getNombre()+ "] actualizado!");
			} else {
				System.out.println("ERR: Paciente no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void delete() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del paciente a eliminar:");
			String nombre = reader.readLine();
			
			int index = -1;
			for (int i=0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				try {
					lista.remove(index);
					System.out.println("Paciente eliminado!");
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				System.out.println("ERR: Paciente no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}
