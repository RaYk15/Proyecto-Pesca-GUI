package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.VentanaPrincipal;
import vista.VentanaSaves;

public class ControladorVista {
	// atributos
	VentanaSaves ventanaSaves = new VentanaSaves();

	// metodos propios
	// funcion para la escena de inicio
	public void escenaInicio(VentanaPrincipal ventanaPrincipal, KeyEvent e) {
		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_ENTER) {
			ventanaPrincipal.mostrarEscena("ESCENA_MENU");
		} else if (tecla == KeyEvent.VK_ESCAPE) {
			ventanaPrincipal.dispose();
		}
	}

	// funciones generales de menu
	public void entrarHover(JPanel panel) {
		panel.setBackground(Color.decode("#C8C8C8"));
	}

	public void salirHover(JPanel panel) {
		panel.setBackground(Color.decode("#EEEEEE"));
	}

	public void cerrarVentana(JFrame ventanaPrincipal) {
		ventanaPrincipal.dispose();
	}

	public void errorNoSaves(JPanel panel) {
		JOptionPane.showMessageDialog(panel, "No hay ninguna partida guardada!", null, JOptionPane.ERROR_MESSAGE);
	}

	public void abrirSaves() {
		ventanaSaves.setVisible(true);
	}
}
