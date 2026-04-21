package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	// atributos
	private CardLayout cardLayout;
	private JPanel contenedor;

	public VentanaPrincipal() {
		// atributos de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		setResizable(false);
		setTitle("Cañones Y Fogones");

		cardLayout = new CardLayout();
		contenedor = new JPanel(cardLayout);

		// escenas
		PanelInicio escenaInicio = new PanelInicio(this);
		PanelMenu escenaMenu = new PanelMenu(this);
		PanelSaves escenaSaves = new PanelSaves(this);
		PanelIntroduccion escenaIntro = new PanelIntroduccion(this);
		PanelCreacion escenaCreacion = new PanelCreacion(this);

		contenedor.add(escenaInicio, "ESCENA_INICIO");
		contenedor.add(escenaMenu, "ESCENA_MENU");
		contenedor.add(escenaSaves, "ESCENA_SAVES");
		contenedor.add(escenaIntro, "ESCENA_INTRO");
		contenedor.add(escenaCreacion, "ESCENA_CREACION");

		add(contenedor);
		cardLayout.show(contenedor, "ESCENA_INICIO");
	}

	public void mostrarEscena(String nombre) {
		cardLayout.show(contenedor, nombre);
	}

}
