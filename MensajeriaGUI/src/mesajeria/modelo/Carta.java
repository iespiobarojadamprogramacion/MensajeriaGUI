package mesajeria.modelo;

public class Carta extends Envio {

	private float precio;
	
	public Carta(String fecha, String direccionOrigen, String direccionDestino,float precio) {
		super(fecha, direccionOrigen, direccionDestino);
		this.precio=precio;
	
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return super.toString()+ "Carta [precio=" + precio + "]";
	}
	

} 