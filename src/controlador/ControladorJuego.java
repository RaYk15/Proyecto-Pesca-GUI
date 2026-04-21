package controlador;

import modelo.Jugador;
import modelo.NPC;
import modelo.Tienda;
import vista.VentanaPrincipal;

public class ControladorJuego {
	// atributos
	private static final int FPS = 60;
	private static final long NS_POR_FRAME = 1000000000L / FPS;
	// elementos del juego
	private Jugador jugador;
	private Tienda tienda;
	// controladores
	public static final ControladorVista CONTROLADOR_VISTA = new ControladorVista();
	private ControladorPesca controladorPesca;
	private ControladorTienda controladorTienda;
	private ControladorSaves controladorSaves;
	// ventana
	private VentanaPrincipal ventanaPrincipal;

	// metodos propios
	public void comenzar() {
		tienda = new Tienda();
		controladorPesca = new ControladorPesca();
		controladorTienda = new ControladorTienda();
		controladorSaves = new ControladorSaves();
		ventanaPrincipal = new VentanaPrincipal(controladorSaves, this);
		ventanaPrincipal.setVisible(true);
	}

	public void crearJugador(String nombreCap, String[] tripulantes) {
		NPC[] tripulacion = new NPC[4];
		for (int i = 0; i < 4; i++) {
			NPC tripulante = new NPC(tripulantes[i]);
			tripulacion[i] = tripulante;
		}
		jugador = new Jugador(nombreCap, tripulacion);
		controladorSaves.guardarPartida(jugador, tienda);
	}
}
