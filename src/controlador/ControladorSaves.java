package controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JPanel;

import modelo.Inventario;
import modelo.Jugador;
import modelo.Tienda;

// cosas a guardar en los saves: Jugador.invenario, Jugador.oro, Tienda.stock
public class ControladorSaves {
	// atributos
	private ControladorVista controladorVista = new ControladorVista();
	private Path userData;
	private Jugador jugador;
	private Inventario inventario;
	private Tienda tienda;

	// constructor
	public ControladorSaves() {
		userData = Paths.get("data", "usuarios");
		try {
			Files.createDirectories(userData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// guardar partida
	public void guardarPartida() {

	}

	// cargar partida
	public void cargarPartida(JPanel panel) {
		try (var entries = Files.list(userData)) {
			if (entries.findAny().isEmpty()) {
				controladorVista.errorNoSaves(panel);
			} else {
				controladorVista.abrirSaves();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// continuar partida
	public void continuarPartida(JPanel panel) {
		try (var entries = Files.list(userData)) {
			if (entries.findAny().isEmpty()) {
				controladorVista.errorNoSaves(panel);
			} else {
				controladorVista.abrirSaves();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
