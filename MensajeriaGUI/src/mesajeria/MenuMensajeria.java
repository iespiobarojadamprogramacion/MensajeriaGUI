package mesajeria;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mesajeria.vistas.AltaMensajeroVista;
import mesajeria.vistas.ConsultaMensajeroVista;

public class MenuMensajeria implements ActionListener {
	
	private JFrame ventana;
	private Container contenedor;
	
	private JMenuBar menuBar;
	private JMenu mensajeroJMenu;
	private JMenu enviosJMenu;
	private JMenuItem altaMensajeroJMenuItem;
	private JMenuItem consultaMensajeroJMenuItem;
	private JMenuItem modificacionMensajeroJMenuItem;
	private JMenuItem bajaMensajeroJMenuItem;
	
	
	public MenuMensajeria(JFrame ventana) {
		
		
		
		this.ventana=ventana;
		contenedor=this.ventana.getContentPane();

		menuBar=new JMenuBar();
		ventana.setJMenuBar(menuBar);
		
		// Menu mensajero
		mensajeroJMenu=new JMenu("Mensajero");
		menuBar.add(mensajeroJMenu);
		altaMensajeroJMenuItem=new JMenuItem("Alta mensajero");
		mensajeroJMenu.add(altaMensajeroJMenuItem);
		altaMensajeroJMenuItem.addActionListener(this);
		
		consultaMensajeroJMenuItem=new JMenuItem("Consulta mensajero");
		mensajeroJMenu.add(consultaMensajeroJMenuItem);
		consultaMensajeroJMenuItem.addActionListener(this);
		
		modificacionMensajeroJMenuItem=new JMenuItem("Modificacion mensajero");
		mensajeroJMenu.add(modificacionMensajeroJMenuItem);
		modificacionMensajeroJMenuItem.addActionListener(this);
		
		bajaMensajeroJMenuItem=new JMenuItem("Baja mensajero");
		mensajeroJMenu.add(bajaMensajeroJMenuItem);
		bajaMensajeroJMenuItem.addActionListener(this);
		
		// Menu envio
		enviosJMenu=new JMenu("Envio");
		menuBar.add(enviosJMenu);
		
		contenedor.setLayout(null);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==altaMensajeroJMenuItem) {
			System.out.println("Alta Mensajero");
			ventana.setContentPane(new AltaMensajeroVista());
			ventana.setVisible(true);

			
		}
		else if (e.getSource()==consultaMensajeroJMenuItem) {
			System.out.println("Consulta Mensajero");
			ventana.setContentPane(new ConsultaMensajeroVista());
			ventana.setVisible(true);

			
		}
		else if (e.getSource()==modificacionMensajeroJMenuItem) {
			System.out.println("Modificacion Mensajero");
		}
		else if (e.getSource()==bajaMensajeroJMenuItem) {
			System.out.println("Baja Mensajero");
		}
		else {
			System.out.println("Otro evento");
		}
	}
	
	
	

}
