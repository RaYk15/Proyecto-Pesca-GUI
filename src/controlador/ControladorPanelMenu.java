package controlador;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControladorPanelMenu {
	public void entrarHover(JPanel panel) {
		panel.setBackground(Color.decode("#C8C8C8"));
	}

	public void salirHover(JPanel panel) {
		panel.setBackground(Color.decode("#EEEEEE"));
	}

	public void cerrarVentana(JFrame ventanaPrincipal) {
		ventanaPrincipal.dispose();
	}
}
