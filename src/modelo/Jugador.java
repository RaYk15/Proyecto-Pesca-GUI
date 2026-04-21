package modelo;

public class Jugador {
	// atributos
	/**
	 * Nombre del jugador
	 */
	private String nombre;
	
	private NPC[]tripulantes;
	/**
	 * Inventario del jugador
	 */
	private Inventario inventario = new Inventario();
	/**
	 * Oro del jugador (moneda del juego)
	 */
	private int oro;

	// constructor
	/**
	 * Contructor de jugador
	 * 
	 * @param nombre     Nombre del jugador
	 * @param opcionModo Modo de juego (Debug o normal)
	 */
	public Jugador(String nombre, NPC[]tripulantes) {
		this.nombre = nombre;
		this.tripulantes = tripulantes;
		
		Item canaBase = new CanaPescar("Caña de pescar básica", "cana_base", 5, 10);
		oro = 10;
		inventario.anadirItem(canaBase);
	}

	// getters y setters
	/**
	 * Getter del Inventario del jugador
	 * 
	 * @return El inventario del jugador
	 */
	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	/**
	 * Getter del oro del jugador
	 * 
	 * @return El oro del jugador
	 */
	public int getOro() {
		return oro;
	}

	/**
	 * Setter del oro del jugador
	 * 
	 * @param oro Nueva cantidad de oro para el jugador
	 */
	public void setOro(int oro) {
		this.oro = oro;
	}

	/**
	 * Getter del nombre del jugador
	 * 
	 * @return Nombre del jugador
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public NPC[] getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(NPC[] tripulantes) {
		this.tripulantes = tripulantes;
	}

	// metodos propios
	/**
	 * Metodo para sumar oro al jugador
	 * 
	 * @param cantidad Cantidad de oro a sumar
	 */
	public void sumarOro(int cantidad) {
		oro = oro += cantidad;
	}

	/**
	 * Metodo para restar oro al jugador
	 * 
	 * @param cantidad Cantidad de oro a restar
	 */
	public void restarOro(int cantidad) {
		oro = oro -= cantidad;
	}
}
