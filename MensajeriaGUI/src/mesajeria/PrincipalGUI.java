package mesajeria;

import javax.swing.JFrame;

public class PrincipalGUI {

	/**
	 * 
	 * @param args 1 - Ahora si con token!!!
	 * Con otro token
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana=new JFrame("Mensajeria");
		ventana.setVisible(true);
		ventana.setSize(400,500);
		
		MenuMensajeria menu=new MenuMensajeria(ventana);
	}

}
