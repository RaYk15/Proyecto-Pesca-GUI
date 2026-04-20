package controlador;

import modelo.Jugador;
import vista.VentanaPrincipal;

public class ControladorJuego {
	// atributos
	private static final int FPS = 60;
	private static final long NS_POR_FRAME = 1000000000L / FPS;
	//private Jugador miJugador = new Jugador();
	private ControladorPesca controladorPesca = new ControladorPesca();
	private ControladorTienda controladorTienda = new ControladorTienda();
	private ControladorSaves controladorSaves;
	private VentanaPrincipal ventanaPrincipal;

	// metodos propios
	public void comenzar() {
		controladorSaves = new ControladorSaves();
		ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
	}
}
