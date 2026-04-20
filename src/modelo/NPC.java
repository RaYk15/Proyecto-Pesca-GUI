package modelo;

public class NPC {
	// atributos
	/**
	 * Nombre de la persona
	 */
	protected String nombre;

	/**
	 * Primera frase de esa persona
	 */
	protected String primeraFrase;

	// constructor para los tenderos, clientes u otros NPCs sin pistas ni tantas
	// interacciones
	/**
	 * Constructor para npc sin dialogos
	 * 
	 * @param nombre       Nombre del npc
	 * @param primeraFrase Primera frase
	 */
	public NPC(String nombre, String primeraFrase) {
		this.nombre = nombre;
		this.primeraFrase = primeraFrase;
	}

	// getters y setters
	/**
	 * Getter del nombre
	 * 
	 * @return Nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del nombre
	 * 
	 * @param nombre Nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter de la primera frase
	 * 
	 * @return La primera frase de la persona
	 */
	public String getPrimeraFrase() {
		return primeraFrase;
	}

	/**
	 * Setter de la primera frase
	 * 
	 * @param primeraFrase Nueva primera frase
	 */
	public void setPrimeraFrase(String primeraFrase) {
		this.primeraFrase = primeraFrase;
	}
}
