package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorJuego;
import controlador.ControladorSaves;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	// atributos
	private CardLayout cardLayout;
	private JPanel contenedor;
	private ControladorSaves controladorSaves;
	private ControladorJuego controladorJuego;
	private PanelInicio escenaInicio;
	private PanelMenu escenaMenu;
	private PanelSaves escenaSaves;
	private PanelIntroduccion escenaIntro;
	private PanelCreacion escenaCreacion;

	// constructor
	public VentanaPrincipal(ControladorSaves controladorSaves, ControladorJuego controladorJuego) {
		this.controladorJuego = controladorJuego;
		this.controladorSaves = controladorSaves;
		inicializarVentana();
		inicializarEscenas();

	}

	// metodos propios
	private void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		setResizable(false);
		setTitle("Cañones Y Fogones");
	}

	private void inicializarEscenas() {
		cardLayout = new CardLayout();
		contenedor = new JPanel(cardLayout);

		// escenas
		escenaInicio = new PanelInicio(this);
		escenaMenu = new PanelMenu(this, controladorSaves);
		escenaSaves = new PanelSaves(this, controladorSaves);
		escenaIntro = new PanelIntroduccion(this);
		escenaCreacion = new PanelCreacion(this, controladorJuego);

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

	// getters y setters
	public PanelInicio getEscenaInicio() {
		return escenaInicio;
	}

	public void setEscenaInicio(PanelInicio escenaInicio) {
		this.escenaInicio = escenaInicio;
	}

	public PanelMenu getEscenaMenu() {
		return escenaMenu;
	}

	public void setEscenaMenu(PanelMenu escenaMenu) {
		this.escenaMenu = escenaMenu;
	}

	public PanelSaves getEscenaSaves() {
		return escenaSaves;
	}

	public void setEscenaSaves(PanelSaves escenaSaves) {
		this.escenaSaves = escenaSaves;
	}

	public PanelIntroduccion getEscenaIntro() {
		return escenaIntro;
	}

	public void setEscenaIntro(PanelIntroduccion escenaIntro) {
		this.escenaIntro = escenaIntro;
	}

	public PanelCreacion getEscenaCreacion() {
		return escenaCreacion;
	}

	public void setEscenaCreacion(PanelCreacion escenaCreacion) {
		this.escenaCreacion = escenaCreacion;
	}

}
