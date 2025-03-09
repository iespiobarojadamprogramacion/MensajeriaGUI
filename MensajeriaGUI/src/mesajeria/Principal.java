package mesajeria;

import java.util.Scanner;

import mesajeria.modelo.Mensajeria;
public class Principal {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		String menu="1-Alta Carta\n"+
				"2-Alta Paquete\n"+
				"3-Baja Envio\n"+
				"4-Mostrar envios en espera\n"+
				"5-Alta mensajero\n"+
				"6-Baja mensajero\n"+
				"7-Mostrar mensajeros\n"+
				"8-Asignar envio\n"+
				"9-Entrega envio\n"+
				"10-Salir\n";
		
		
		Mensajeria mensajeria= new Mensajeria();
		
		
		int opcion=0;
		
		String fecha;
		String direccionOrigen;
		String direccionDestino;
		float precio;
		float peso;
		float precioKilo;
		int codigo;
		String nombre;
		double sueldo;
		int numMax;
		
		do {
			System.out.println(menu);
			
			opcion=sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Dame la fecha: ");				
				fecha=sc.next();
				System.out.println("Dame la direccion de origen: ");
				direccionOrigen=sc.next();
				System.out.println("Dame la direccion de destino: ");
				direccionDestino=sc.next();
				System.out.println("Dame el precio ");
				precio=sc.nextFloat();
				
				mensajeria.altaCarta(fecha, direccionOrigen, direccionDestino, precio);
				break;
			case 2:
				System.out.println("Dame la fecha: ");
				fecha=sc.next();
				System.out.println("Dame la direccion de origen: ");
				direccionOrigen=sc.next();
				System.out.println("Dame la direccion de destino: ");
				direccionDestino=sc.next();
				System.out.println("Dame el peso: ");
				peso=sc.nextFloat();
				System.out.println("Dame el precio del kilo: ");
				precioKilo=sc.nextFloat();
				
				mensajeria.altaPaquete(fecha, direccionOrigen, direccionDestino, peso, precioKilo);
				break;
			case 3:
				System.out.println("Dame el codigo:  ");
				codigo=sc.nextInt();
				
				mensajeria.bajaEnvio(codigo);
			case 4:
				mensajeria.mostrarEnviosEspera();
				break;
			case 5:
				System.out.println("Dame el nombre:");
				nombre=sc.next();
				System.out.println("Dame el sueldo:");
				sueldo=sc.nextDouble();
				System.out.println("Dame el numero max. de envios:");
				numMax=sc.nextInt();
				mensajeria.altaMensajero(nombre, sueldo, numMax);
				break;
			case 6:
				System.out.println("Dame el codigo:  ");
				codigo=sc.nextInt();
				mensajeria.bajaMensajero(codigo);
				break;
			case 7:
				mensajeria.mostrarMensajero();
				break;
			case 8:
				System.out.println("Dame el codigo envio:  ");
				codigo=sc.nextInt();
				if (mensajeria.asignarMensajero(codigo) ) {
					System.out.println("Asignacion correcta");
				}
				break;
			case 9:
				System.out.println("Dame el codigo de envio:  ");
				codigo=sc.nextInt();
				if (mensajeria.entregaEnvio(codigo)) {
					System.out.println("Entrega correcta");
				}

				break;
			case 10:
				break;

			default: 
				System.out.println("Opcion incorrecta");
			}
		}while (opcion!=10);
	}
	

} 