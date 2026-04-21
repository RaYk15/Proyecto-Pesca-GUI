package controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JPanel;

import modelo.Jugador;
import modelo.Tienda;
import vista.VentanaPrincipal;

// cosas a guardar en los saves: Jugador.invenario, Jugador.oro, Tienda.stock
public class ControladorSaves {
	// atributos
	private Path userData;

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
	public void guardarPartida(Jugador jugador, Tienda tienda) {
		
	}

	// cargar partida
	public void cargarPartida(JPanel panel, VentanaPrincipal ventanaPrincipal) {
		try (var entries = Files.list(userData)) {
			if (entries.findAny().isEmpty()) {
				ControladorJuego.CONTROLADOR_VISTA.errorNoSaves(panel);
			} else {
				ControladorJuego.CONTROLADOR_VISTA.entrarSaves(ventanaPrincipal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// continuar partida
	public void continuarPartida(JPanel panel, VentanaPrincipal ventanaPrincipal) {
		try (var entries = Files.list(userData)) {
			if (entries.findAny().isEmpty()) {
				ControladorJuego.CONTROLADOR_VISTA.errorNoSaves(panel);
			} else {
				ControladorJuego.CONTROLADOR_VISTA.entrarSaves(ventanaPrincipal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
