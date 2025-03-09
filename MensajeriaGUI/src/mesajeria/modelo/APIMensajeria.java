package mesajeria.modelo;

public class APIMensajeria {
	
	private static APIMensajeria instance;
	private Mensajeria mensajeria;
	
	private APIMensajeria() {
		mensajeria=new Mensajeria();
	}
	
	public static APIMensajeria getInstance() {
		if (instance==null) {
			instance=new APIMensajeria();
		}
		return instance;
	}
	
	public void altaMensajeria(String nombre, double sueldo) {
		mensajeria.altaMensajero(nombre, sueldo, 5);
	}
	
	public String[] consultaMensajero(int codigo) {
		String[] resultado=new String[2];
		Mensajero m=mensajeria.buscarMensajeroPorCodigo(codigo);
		resultado[0]=m.getNombre();
		resultado[1]=String.valueOf(m.getSueldo());
		return resultado;
	}

}
