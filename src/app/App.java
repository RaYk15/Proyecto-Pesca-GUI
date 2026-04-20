package app;

import controlador.ControladorJuego;

public class App {
	// atributos
	private static final ControladorJuego CONTROLADOR_JUEGO = new ControladorJuego();
	public static void main(String[] args) {
		CONTROLADOR_JUEGO.comenzar();
	}
}
