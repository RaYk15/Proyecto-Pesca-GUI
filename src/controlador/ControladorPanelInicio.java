package controlador;

import java.awt.event.KeyEvent;

import vista.VentanaPrincipal;

public class ControladorPanelInicio {
	public void cambiarEscena(VentanaPrincipal ventanaPrincipal, KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_ENTER) {
			ventanaPrincipal.mostrarEscena("ESCENA_MENU");
		} else if (tecla == KeyEvent.VK_ESCAPE) {
			ventanaPrincipal.dispose();
		}
	}
}
