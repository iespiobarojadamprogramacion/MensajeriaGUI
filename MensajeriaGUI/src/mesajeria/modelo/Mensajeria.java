package mesajeria.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mensajeria {
	// Estructura estatica
	private final int MAXIMO_ENVIOS = 1000;
	private final int MAXIMO_MENSAJEROS = 100;
	
	private Envio[] envios = new Envio[MAXIMO_ENVIOS];
	private Mensajero[] mensajeros=new Mensajero[MAXIMO_MENSAJEROS];
	
	private int indicador = 0;
	private int indicadorM=0;
	
	// Estructura dinamica
	private ArrayList<Envio> enviosA=new ArrayList<Envio>();
	private ArrayList<Mensajero> mensajerosA=new ArrayList<>();
	
	
	public void altaCarta(String fecha, String direccionOrigen, String direccionDestino, float precio){
		Carta carta = new Carta(fecha, direccionOrigen, direccionDestino, precio);		
//		envios[indicador] = carta;
//		indicador ++;	
		enviosA.add(carta);
	}
	
	public void altaPaquete(String fecha, String direccionOrigen, String direccionDestino,
			float peso, float precioKilo)  {
		Paquete paquete = new Paquete(fecha,direccionOrigen,direccionDestino,
				peso,precioKilo);		
//		envios[indicador] = paquete;
//		indicador ++;	
		enviosA.add(paquete);
	}
	
	public void bajaEnvio(int codigo) {
		Iterator<Envio> it=enviosA.iterator();
		Envio e;
		while(it.hasNext()) {
			e=it.next();
			if (e.getCodigo()==codigo && e.getEstado()!=TipoEstado.ASIGNADO) {
				it.remove();
				break;
			}
		}
		
//		for(int i = 0; i < indicador; i++) {
//			if(envios[i].getCodigo() == codigo && 
//					envios[i].getEstado()!=TipoEstado.ASIGNADO) {
//				envios[i] = envios[indicador - 1];
//				indicador --;
//			}
//			
//		}		
	} 
	
	public void mostrarEnviosEspera() {
		for (Envio  e: enviosA) {
			if (e.getEstado()==TipoEstado.EN_ESPERA) {
				System.out.println(e);
			}
		}
//		for(int i =0; i<indicador; i++) {
//			if(envios[i].getEstado()==TipoEstado.EN_ESPERA) {
//				System.out.println(envios[i]);
//		 }
//		}
	}
	
	public void altaMensajero(String nombre, double sueldo, int numMax) {
		Mensajero mensajero=new Mensajero(nombre,sueldo,numMax);
//		mensajeros[indicadorM]=mensajero;
//		indicadorM++;
		mensajerosA.add(mensajero);
	}
	
	public void bajaMensajero(int codigo) {
		Iterator<Mensajero> it=mensajerosA.iterator();
		while(it.hasNext()) {
			if (it.next().getCodigo()==codigo) {
				it.remove();
				break;
			}
		}
		
		
//		for (int i=0; i<indicadorM; i++) {
//			if (mensajeros[i].getCodigo()==codigo) {
//				mensajeros[i]=mensajeros[indicadorM-1];
//				mensajeros[indicadorM-1]=null;
//				indicadorM--;
//				break;
//			}
//		}
	}
	
	public void mostrarMensajero() {
		for (Mensajero m: mensajerosA) {
			System.out.println(m);
		}
//		for (int i=0; i<indicadorM; i++) {
//			System.out.println(mensajeros[i]);
//		}
	}
	
	private Envio buscarEnvio(int codigo) {
		for (Envio e: enviosA) {
			if (e.getCodigo()==codigo) {
				return e;
			}
		}
//		for (int i=0; i<indicador; i++) {
//			if (envios[i].getCodigo()==codigo ) {
//				return envios[i]; 
//			}
//		}
		return null;
	}
	
	private Mensajero buscarMensajeroLibre() {
		for (Mensajero m: mensajerosA) {
			if (m.isLibre()) {
				return m;
			}
		}
//		for (int i=0; i<indicadorM; i++) {
//			if (mensajeros[i].isLibre()) {
//				return mensajeros[i];
//			}
//		}
		return null;
	}
	
	
	
	public boolean asignarMensajero(int codigo) {
		Envio envio=buscarEnvio(codigo);
		if (envio==null) {
			System.out.println("Envio no encontrado");
			return false;
		}
		if (envio.getEstado()!=TipoEstado.EN_ESPERA) {
			System.out.println("Envio con estado incorrecto");
			return false;
		}
		Mensajero mensajero=buscarMensajeroLibre();
		if (mensajero==null) {
			System.out.println("No hay mensajeros libres");
			return false;
		}
		mensajero.asignarEnvio(envio);
		mensajero.marcarOcupado();
		envio.asignarMensajero(mensajero);
		envio.cambiarEstado(TipoEstado.ASIGNADO);
		
		return true;
	}
	
	public boolean entregaEnvio(int codigo) {
		Envio envio=buscarEnvio(codigo);
		if (envio==null) {
			System.out.println("Envio no encontrado");
			return false;
		}
		if (envio.getEstado()!=TipoEstado.ASIGNADO) {
			System.out.println("Estado incorrecto");
			return false;
		}
		Mensajero mensajero=envio.getMensajero();
		mensajero.borrarEnvio(envio);
		mensajero.setLibre(true);
		
		envio.cambiarEstado(TipoEstado.ENTREGADO);
		
		return true;
	}
	
	public Mensajero buscarMensajeroPorCodigo(int codigo) {
		for (Mensajero m: mensajerosA) {
			if (m.getCodigo()==codigo) {
				return m;
			}
		}
		return null;
	}
	
}