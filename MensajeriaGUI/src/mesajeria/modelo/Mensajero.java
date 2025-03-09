package mesajeria.modelo;

public class Mensajero {
	private static int contador=0;
	private int codigo;
	private String nombre;
	private double sueldo;
	private boolean libre=true;
	private int numMax;
	private Envio[] envios;
	private int indEnvio=0;
	
		
	public Mensajero (String nombre, double sueldo, int numMax) {
		codigo=contador++;
		this.nombre=nombre;
		this.sueldo=sueldo;
		this.numMax=numMax;
		envios=new Envio[numMax];
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public boolean isLibre() {
		return libre;
	}
	public void setLibre(boolean libre) {
		this.libre = libre;
	}
	public int getNumMax() {
		return numMax;
	}
	public void setNumMax(int numMax) {
		this.numMax = numMax;
	}
	
	public void asignarEnvio(Envio envio) {
		envios[indEnvio]=envio;
		indEnvio++;
	}
	
	public void borrarEnvio(Envio envio) {
		for (int i=0; i < indEnvio; i++) {
			if (envios[i]==envio) {
				envios[i]=envios[indEnvio-1];
				indEnvio--;
				break;
			}
		}
	}
	
	public void marcarOcupado() {
		if (indEnvio==numMax) {
			libre=false;
		}
	}
	
	
	
	
	@Override
	public String toString() {
		String resultado="";
		resultado="Mensajero número "+codigo+" Nombre "+nombre+" sueldo " +sueldo+" Esta libre? "+libre+" NumMax "+numMax;
		for (int i=0; i<indEnvio; i++) {
			resultado+="\n";
			resultado+=envios[i];
		}
		return resultado;
	}
	
} 

