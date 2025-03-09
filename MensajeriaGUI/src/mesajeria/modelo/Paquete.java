package mesajeria.modelo;

public class Paquete extends Envio{
	
	private float peso;
	private float precioKilo;
	
	public Paquete(String fecha, String direccionOrigen, String direccionDestino,float peso,float precioKilo) {
		super(fecha, direccionOrigen, direccionDestino);
		this.peso=peso;
		this.precioKilo=precioKilo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(float precioKilo) {
		this.precioKilo = precioKilo;
	}

	@Override
	public String toString() {
		return super.toString()+"Paquete [peso=" + peso + ", precioKilo=" + precioKilo + "]";
	}

} 

