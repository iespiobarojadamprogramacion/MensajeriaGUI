package mesajeria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mesajeria.modelo.APIMensajeria;
import mesajeria.vistas.ConsultaMensajeroVista;

public class ConsultaMensajeroControlador implements ActionListener {
		
	private ConsultaMensajeroVista vista;
	private APIMensajeria api=APIMensajeria.getInstance();
	
	public ConsultaMensajeroControlador(ConsultaMensajeroVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] resultado=api.consultaMensajero(vista.getId());
		vista.setNombre(resultado[0]);
		vista.setSueldo(Double.parseDouble(resultado[1]));
	}

}
