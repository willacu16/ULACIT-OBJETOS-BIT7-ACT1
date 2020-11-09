package actividad1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader; 

public class Enfermedades extends CRUD{

	///////////////////////////////////////
	//Atributos
	///////////////////////////////////////
	
	ArrayList<Enfermedad> lista;
	
	
	
	///////////////////////////////////////
	//Constructores
	///////////////////////////////////////
	
	public Enfermedades() {
		this.lista = new ArrayList<Enfermedad>();
	}
	
	
	
	///////////////////////////////////////
	//Getters & Setters
	///////////////////////////////////////
	
	/**
	 * @return the lista
	 */
	public ArrayList<Enfermedad> getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(ArrayList<Enfermedad> lista) {
		this.lista = lista;
	}
	
	
	
	///////////////////////////////////////
	//Metodos
	///////////////////////////////////////
	
	public void mostrarEnfermedad(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre de la enfermedad:");
			String nombre = reader.readLine();
			
			boolean encontrada = false;
			for (Enfermedad e : lista) {
				if (e.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					System.out.println(e.toString());
					encontrada = true;
		        }
			}
			if (!encontrada) {
				System.out.println("ERR: Enfermedad [" + nombre + "] no encontrada!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void ordenarAsc(){
		Enfermedad temp;
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
			Enfermedad nuevaEnfermedad = new Enfermedad();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			String input = "";
			
			System.out.println("Digite el nombre de la enfermedad:");
	        input = reader.readLine();
	        nuevaEnfermedad.setNombre(input);
	        
	        do {
	        	System.out.println("Digite un sintoma de la enfermedad o digite \"salir\" para terminar de agregar sintomas:");
	            input = reader.readLine();
	            if (!input.equals("salir")) {
	            	nuevaEnfermedad.agregarSintoma(input);
	            }
	        } while (!input.equals("salir"));
	        
	        do {
	        	System.out.println("Digite un tratamiento de la enfermedad o digite \"salir\" para terminar de agregar tratamientos:");
	            input = reader.readLine();
	            if (!input.equals("salir")) {
	            	nuevaEnfermedad.agregarTratamiento(input);
	            }
	        } while (!input.equals("salir"));
	        
			lista.add(nuevaEnfermedad);
			System.out.println("Enfermedad [" + nuevaEnfermedad.getNombre()+ "] agregada!");
			ordenarAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void read() {
		ordenarAsc();
		for (Enfermedad e : lista) {
			System.out.println(e.toString());
		}
	}
	
	@Override
	public void update() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del paciente a actualizar:");
			String nombre = reader.readLine();
			
			int index = -1;
			for (int i=0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				Enfermedad viejaEnfermedad = lista.get(index);
				Enfermedad nuevaEnfermedad = new Enfermedad(); 
				String input = "";
				
				System.out.println("Digite el nuevo nombre para [" + viejaEnfermedad.getNombre() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevaEnfermedad.setNombre(viejaEnfermedad.getNombre());
		        } else {
		        	nuevaEnfermedad.setNombre(input);
		        }
		        
		        nuevaEnfermedad.setSintomas(viejaEnfermedad.getSintomas());
		        System.out.println("Sintomas:");
		        for (String sintoma : nuevaEnfermedad.getSintomas()) {
		        	System.out.println("\t" + sintoma);
		        }
		        System.out.println("Digite el sintoma que desea modificar o presione ENTER para no modificar los sintomas:");
		        input = reader.readLine();
		        String oldSintoma = input;
		        if (!input.isEmpty()) {
		        	System.out.println("Digite el nuevo sintoma:");
			        input = reader.readLine();
			        String newSintoma = input;
		        	nuevaEnfermedad.modificarSintoma(oldSintoma, newSintoma);
		        }
		        
		        nuevaEnfermedad.setTratamientos(viejaEnfermedad.getTratamientos());
		        System.out.println("Tratamientos:");
		        for (String tratamiento : nuevaEnfermedad.getTratamientos()) {
		        	System.out.println("\t" + tratamiento);
		        }
		        System.out.println("Digite el tratamiento que desea modificar o presione ENTER para no modificar los tratamientos:");
		        input = reader.readLine();
		        String oldTratamiento = input;
		        if (!input.isEmpty()) {
		        	System.out.println("Digite el nuevo tratamiento:");
			        input = reader.readLine();
			        String newTratamiento = input;
		        	nuevaEnfermedad.modificarTratamiento(oldTratamiento, newTratamiento);
		        }
		        
		        lista.set(index, nuevaEnfermedad);
		        System.out.println("Enfermedad [" + nuevaEnfermedad.getNombre()+ "] actualizada!");
			} else {
				System.out.println("ERR: Enfermedad no encontrada!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void delete() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre de la enfermedad a eliminar:");
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
					System.out.println("Enfermedad eliminada!");
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				System.out.println("ERR: Enfermedad no encontrada!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
