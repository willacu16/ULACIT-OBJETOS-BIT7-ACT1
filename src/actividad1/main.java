package actividad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
			
		//Enfermedades
		Enfermedad gripe = new Enfermedad("Gripe", new ArrayList<String>(Arrays.asList("Fiebre","Tos","Cansancio")), new ArrayList<String>(Arrays.asList("Tomar Fluidos", "Descanso")));
		Enfermedad bronquitis = new Enfermedad("Bronquitis", new ArrayList<String>(Arrays.asList("Dolor en el pecho","Dolor de cabeza leve","Dolor de garganta")), new ArrayList<String>(Arrays.asList("Antibióticos", "Descanso")));
		Enfermedad infeccionOido = new Enfermedad("Infección de Oído", new ArrayList<String>(Arrays.asList("Líquido que sale de los oídos","Problemas para dormir","Fiebre", "Dolor de cabeza")), new ArrayList<String>(Arrays.asList("Antibióticos")));
		Enfermedad still = new Enfermedad("Still", new ArrayList<String>(Arrays.asList("Erupción cutánea","Dolor muscular","Articulaciones doloridas e hinchadas","Fiebre")), new ArrayList<String>(Arrays.asList("Metotrexato")));
		Enfermedad gastritis = new Enfermedad("Gastritis", new ArrayList<String>(Arrays.asList("Dolor abdominal","Náuseas","Vómitos")), new ArrayList<String>(Arrays.asList("Eliminar agente causante", "antiácidos", "Esomeprazol")));

		//Pacientes
		Paciente john = new Paciente("John", "Doe", "M", "Dallas",new ArrayList<String>(Arrays.asList("+506 8999-11-11", "+1 (450) 111-78-65")),new ArrayList<String>(Arrays.asList("Gripe", "Gastritis")));
		Paciente ana = new Paciente("Ana", "Alfaro", "F", "Florida",new ArrayList<String>(Arrays.asList("+506 8999-22-22")),new ArrayList<String>(Arrays.asList("Still")));
		Paciente pedro = new Paciente("Pedro", "Perez", "M", "Miami",new ArrayList<String>(Arrays.asList("+506 8999-33-33", "+1 (789) 222-14-57")),new ArrayList<String>(Arrays.asList("Gripe", "Gastritis", "Bronquitis", "Still")));
		Paciente lucia = new Paciente("Lucia", "Lopez", "F", "Las Vegas",new ArrayList<String>(Arrays.asList("+506 8999-44-44", "+46 (4) 32-75-79", "+1 (666) 111-11-11")),new ArrayList<String>(Arrays.asList("Gastritis")));	
		Paciente danielle = new Paciente("Danielle", "Dinarte", "U", "Boston",new ArrayList<String>(Arrays.asList("+506 8999-55-55", "+57 888-88-66")),new ArrayList<String>(Arrays.asList("Infeccion de Oido")));
	
		
		//Expedientes
		Expedientes expedientes = new Expedientes();
		expedientes.lista.add(john);
		expedientes.lista.add(ana);
		expedientes.lista.add(pedro);
		expedientes.lista.add(lucia);
		expedientes.lista.add(danielle);
	
		//Enfermedades
		Enfermedades enfermedades = new Enfermedades();
		enfermedades.lista.add(gripe);
		enfermedades.lista.add(bronquitis);
		enfermedades.lista.add(infeccionOido);
		enfermedades.lista.add(still);
		enfermedades.lista.add(gastritis);
		

		
		///////////////////////////////////////
		//MENU
		///////////////////////////////////////
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String respuesta = "";
		do {
			try {
				System.out.println("\n-----------------------");
				System.out.println("----- CONSULTORIO -----");
				System.out.println("-----------------------");
				System.out.println("1) Mostrar Enfermedades");
				System.out.println("2) Buscar Enfermedad");
				System.out.println("3) Ingresar nueva Enfermedad");
				System.out.println("4) Actualizar Enfermedad");
				System.out.println("5) Eliminar Enfermedad");
				System.out.println("6) Mostrar Pacientes");
				System.out.println("7) Buscar Paciente");
				System.out.println("8) Ingresar nuevo Paciente");
				System.out.println("9) Actualizar Paciente");
				System.out.println("10) Eliminar Paciente");
				System.out.println("x) Salir\n");
				System.out.println("Digite una opción: ");
				respuesta = reader.readLine();
				
				switch (respuesta) {
					case "1":{
						enfermedades.read();
						break;
					}
					case "2":{
						enfermedades.mostrarEnfermedad();
						break;
					}
					case "3":{
						enfermedades.create();
						break;
					}
					case "4":{
						enfermedades.update();
						break;
					}
					case "5":{
						enfermedades.delete();
						break;
					}
					case "6":{
						expedientes.read();
						break;
					}
					case "7":{
						expedientes.mostrarPaciente();
						break;
					}
					case "8":{
						expedientes.create();
						break;
					}
					case "9":{
						expedientes.update();
						break;
					}
					case "10":{
						expedientes.delete();
						break;
					}
					case "x":{
						System.out.println("---- Gracias! ----");
						break;
					}
					default:{
						System.out.println("Opcion no válida!");
						break;
					}
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!respuesta.equals("x"));
		
		
	}

}
