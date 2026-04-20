package modelo;

public class Tienda {
	// atributos
	/**
	 * Stock de items que tiene disponible la tienda
	 */
	private Inventario stock;
	/**
	 * NPC a cargo de la tienda
	 */
	private final NPC TENDERO = new NPC("Alexander el Tendero",
			"Alexander el Tendero: 'Echa un ojo si quieres, pero si no vas a comprar nada no me hagas perder el tiempo.'");

	/**
	 * Constructor de la tienda
	 * 
	 * @param tendero NPC a cargo de la tienda
	 * @param item1   Item disponnible en la tienda
	 * @param item2   Item disponnible en la tienda
	 * @param item3   Item disponnible en la tienda
	 * @param item4   Item disponnible en la tienda
	 * @param item5   Item disponnible en la tienda
	 */
	public Tienda(NPC tendero, CanaPescar item1, CanaPescar item2, CanaPescar item3, Item item4, Item item5) {
		stock = new Inventario();
		stock.anadirItem(new CanaPescar("Caña de pescar flexible", "cana_flexi", 75, 15));
		stock.anadirItem(new CanaPescar("Caña de pescar reforzada", "cana_reforz", 150, 20));
		stock.anadirItem(new CanaPescar("Caña maestra", "cana_maestra", 300, 25));
		stock.anadirItem(new Item("Cebo bueno", "cebo_m", 20));
		stock.anadirItem(new Item("Cebo excelente", "cebo_l", 50));
		for (String i : stock.getItems().keySet()) {
			if (stock.getItems().get(i) instanceof CanaPescar) {
				stock.getItems().get(i).setCantidad(1);
			} else {
				stock.getItems().get(i).setCantidad(5);
			}
		}
	}

	// getters y setters
	/**
	 * Getter del Inventario Stock
	 * 
	 * @return Inventario de items a la venta
	 */
	public Inventario getStock() {
		return stock;
	}

	/**
	 * Setter de stock
	 * 
	 * @param stock Nuevo Inventario de items para la tienda
	 */
	public void setStock(Inventario stock) {
		this.stock = stock;
	}

	/**
	 * Getter de tendero
	 * 
	 * @return NPC tendero
	 */
	public NPC getTendero() {
		return TENDERO;
	}
}
