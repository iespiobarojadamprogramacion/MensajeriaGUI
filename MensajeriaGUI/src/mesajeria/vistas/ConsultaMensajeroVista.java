package mesajeria.vistas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mesajeria.controlador.ConsultaMensajeroControlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaMensajeroVista extends JPanel {
	
	private JTextField idTextField;
	private JLabel nombreRJLabel ;
	private JLabel sueldoRlabel ;
	
	public ConsultaMensajeroVista() {
		System.out.println("Vista consulta mensajero");
		this.setLayout(null);
		
		JLabel consultaMensajeroJLabel = new JLabel("Consulta Mensajero");
		consultaMensajeroJLabel.setBounds(92, 12, 136, 25);
		add(consultaMensajeroJLabel);
		
		JLabel idJlabel = new JLabel("ID:");
		idJlabel.setBounds(70, 59, 60, 17);
		add(idJlabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(114, 57, 114, 21);
		add(idTextField);
		idTextField.setColumns(10);
		
		JButton consultaButton = new JButton("Consulta\n");
		consultaButton.addActionListener(new ConsultaMensajeroControlador(this));
		consultaButton.setBounds(83, 102, 105, 27);
		add(consultaButton);
		
		JLabel nombreJLabel = new JLabel("Nombre:");
		nombreJLabel.setBounds(47, 160, 60, 17);
		add(nombreJLabel);
		
		nombreRJLabel = new JLabel("");
		nombreRJLabel.setBounds(129, 160, 129, 17);
		add(nombreRJLabel);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(47, 200, 60, 17);
		add(lblSueldo);
		
		sueldoRlabel = new JLabel("");
		sueldoRlabel.setBounds(128, 200, 60, 17);
		add(sueldoRlabel);

	}
	
	public int getId() {
		return Integer.parseInt(idTextField.getText());
	}
	
	public void setNombre(String nombre) {
		nombreRJLabel.setText(nombre);
	}
	
	public void setSueldo(double sueldo) {
		sueldoRlabel.setText(String.valueOf(sueldo));
	}

}
