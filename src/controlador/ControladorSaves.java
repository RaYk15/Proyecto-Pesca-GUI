package controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.DatosPartida;
import modelo.NPC;
import vista.VentanaPrincipal;

// cosas a guardar en los saves: Jugador.invenario, Jugador.oro, Tienda.stock
public class ControladorSaves {
	// atributos
	private Path userData;
	private DefaultListModel<String> modelo;

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
	public void guardarPartida(DatosPartida datosPartida) {
		// crear el nombre de la partida
		LocalDateTime diaHora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String stringDiaHora = diaHora.format(formatter);
		String nombrePartida = "cyf_save_" + stringDiaHora + ".json";

		// instanciar el gson y escribir el json
		String json;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(datosPartida);

		// guardar el fichero json en la carpeta data/usuarios
		try {
			Files.writeString(Path.of("data", "usuarios", nombrePartida), json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// cargar partida
	public void cargarPartida(JPanel panel, VentanaPrincipal ventanaPrincipal) {
		try (var entries = Files.list(userData)) {
			if (entries.findAny().isEmpty()) {
				ControladorJuego.CONTROLADOR_VISTA.errorNoSaves(panel);
			} else {
				recuperarListaSaves(modelo);
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

	// crea una lista con todos los arcihvos en la carpeta de data/usuarios, filtra
	// que el archivo sea .json y le pasa esa lista a la JList en PanelSaves
	public void recuperarListaSaves(DefaultListModel<String> modelo) {
		this.modelo = modelo;
		ArrayList<String> listaSaves = new ArrayList<>();
		try {
			modelo.clear();
			Files.list(userData).forEach(p -> listaSaves.add(p.getFileName().toString()));
			for (int i = 0; i < listaSaves.size(); i++) {
				if (listaSaves.get(i).matches(".*\\.json$")) {
					modelo.add(i, listaSaves.get(i));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// recupera los datos del archivo .json que se seleccione en la JList de
	// PanelSaves y los muestra en lblDatosPartida, tambien en PanelSaves
	public void mostrarDatosPartida(String nombreSave, JLabel lblDatosPartida) {
		String nombreCap;
		NPC[] tripulantes;
		try {
			String json = Files.readString(Path.of("data", "usuarios", nombreSave));
			Gson gson = new Gson();
			DatosPartida datosPartida = gson.fromJson(json, DatosPartida.class);
			nombreCap = datosPartida.getJugador().getNombre();
			tripulantes = datosPartida.getJugador().getTripulantes();
			String trip1 = tripulantes[0].getNombre();
			String trip2 = tripulantes[1].getNombre();
			String trip3 = tripulantes[2].getNombre();
			String trip4 = tripulantes[3].getNombre();
			lblDatosPartida.setText("<html><body><p>Capitán:</p><ul><li>" + nombreCap
					+ "</li></ul><p>Tripulantes:</p><ul><li>" + trip1 + "</li><li>" + trip2 + "</li><li>" + trip3
					+ "</li><li>" + trip4 + "</li></ul></body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void borrarPartida(String nombreSave, VentanaPrincipal ventanaPrincipal) {
		try {
			Files.delete(Path.of("data", "usuarios", nombreSave));
			var entries = Files.list(userData);
			if (entries.findAny().isEmpty()) {
				ControladorJuego.CONTROLADOR_VISTA.volverSaves(ventanaPrincipal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
