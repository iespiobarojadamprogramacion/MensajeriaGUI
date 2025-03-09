package mesajeria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mesajeria.modelo.APIMensajeria;
import mesajeria.vistas.AltaMensajeroVista;

public class AltaMensajeroControlador implements ActionListener {
	
	private AltaMensajeroVista vista;
	private APIMensajeria api=APIMensajeria.getInstance();

	
	public AltaMensajeroControlador(AltaMensajeroVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Nombre: "+vista.getNombre());
			System.out.println("Sueldo: "+vista.getSueldo());
			api.altaMensajeria(vista.getNombre(), vista.getSueldo());
			vista.saltarAlertaOK();
		}
		catch (NumberFormatException nfe) {
			vista.saltarAlertaError();
			
		}
	}
	

	


}
