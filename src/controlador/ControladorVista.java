package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.VentanaPrincipal;

public class ControladorVista {
	// metodos propios
	// funcion para entrar o cerrar en la escena de inicio
	public void escenaInicio(VentanaPrincipal ventanaPrincipal, KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_ENTER) {
			ventanaPrincipal.mostrarEscena("ESCENA_MENU");
		} else if (tecla == KeyEvent.VK_ESCAPE) {
			ventanaPrincipal.dispose();
		}
	}
	
	// funcion para entrar en la escena de introduccion
	public void escenaIntro(VentanaPrincipal ventanaPrincipal) {
		ventanaPrincipal.mostrarEscena("ESCENA_INTRO");
	}

	// funcion para entrar en la escena de saves
	public void entrarSaves(VentanaPrincipal ventanaPrincipal) {
		ventanaPrincipal.mostrarEscena("ESCENA_SAVES");
	}
	
	// funcion para entrar en la escena de menu
	public void volverSaves(VentanaPrincipal ventanaPrincipal) {
		ventanaPrincipal.mostrarEscena("ESCENA_MENU");
	}
	
	// funcion para entrar en la escena de creación de personaje
	public void entrarCreacion(VentanaPrincipal ventanaPrincipal) {
		ventanaPrincipal.mostrarEscena("ESCENA_CREACION");
	}

	// hover de los botones
	public void entrarHover(JPanel panel) {
		panel.setBackground(Color.decode("#C8C8C8"));
	}

	public void salirHover(JPanel panel) {
		panel.setBackground(Color.decode("#EEEEEE"));
	}

	// chapar ventana
	public void cerrarVentana(JFrame ventanaPrincipal) {
		ventanaPrincipal.dispose();
	}

	// JOptionPane que salta si vas a cargar o continuar partida y no tienes saves
	public void errorNoSaves(JPanel panel) {
		JOptionPane.showMessageDialog(panel, "No hay ninguna partida guardada!", null, JOptionPane.ERROR_MESSAGE);
	}
}
