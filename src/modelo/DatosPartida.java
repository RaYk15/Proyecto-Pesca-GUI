package modelo;

public class DatosPartida {
	// atributos
	private Jugador jugador;
	private Tienda tienda;

	// constructor
	public DatosPartida(Jugador jugador, Tienda tienda) {
		this.jugador = jugador;
		this.tienda = tienda;
	}

	// getters y setters
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
}
