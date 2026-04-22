package app;

import controlador.ControladorJuego;

public class App {
	public static void main(String[] args) {
		// atributo
		final ControladorJuego CONTROLADOR_JUEGO = new ControladorJuego();

		// iniciar el juego
		CONTROLADOR_JUEGO.comenzar();
	}
}
