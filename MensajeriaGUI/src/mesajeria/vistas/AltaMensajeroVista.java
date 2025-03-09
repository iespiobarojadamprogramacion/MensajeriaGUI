package mesajeria.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mesajeria.controlador.AltaMensajeroControlador;

public class AltaMensajeroVista extends JPanel{
	private JLabel nombreJLabel;
	private JLabel sueldoJLabel;
	private JTextField nombreJTextField;
	private JTextField sueldoJTextField;
	private JButton altaJButton;
	private JTextField nombretextField;
	private JTextField sueldoTextField;
	private JButton btnAlta;
	
	public AltaMensajeroVista() {
		System.out.println("Vista alta mensajero");
		this.setLayout(null);
		
		JLabel tituloJLabel = new JLabel("Alta Mensajero");
		tituloJLabel.setBounds(163, 26, 126, 17);
		add(tituloJLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(52, 69, 60, 17);
		add(lblNombre);
		
		nombretextField = new JTextField();
		nombretextField.setBounds(130, 67, 114, 21);
		add(nombretextField);
		nombretextField.setColumns(10);
		
		JLabel sueldoJLablel = new JLabel("Sueldo:");
		sueldoJLablel.setBounds(52, 99, 60, 17);
		add(sueldoJLablel);
		
		sueldoTextField = new JTextField();
		sueldoTextField.setText("0.0");
		sueldoTextField.setBounds(130, 97, 114, 21);
		add(sueldoTextField);
		sueldoTextField.setColumns(10);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(161, 149, 105, 27);
		add(btnAlta);

		AltaMensajeroControlador controlador=
				new AltaMensajeroControlador(this);		
		btnAlta.addActionListener(controlador);
		
	}
	
	public String getNombre() {
		return nombretextField.getText();
	}
	
	public double getSueldo() throws NumberFormatException{
		return Double.parseDouble(sueldoTextField.getText());
	}
	
	public void saltarAlertaError() {
		System.out.println("Error");
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(btnAlta),"Formato incorrecto");
	}
	
	public void saltarAlertaOK() {
		System.out.println("Alta correcta");
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(btnAlta),"Alta correcta");
		
	}
}
