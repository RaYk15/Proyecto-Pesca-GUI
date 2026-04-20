package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSaves;
import controlador.ControladorVista;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class PanelMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	VentanaPrincipal ventanaPrincipal;
	ControladorVista controlador = new ControladorVista();
	ControladorSaves controladorSaves = new ControladorSaves();
	private JPanel panelNueva;
	private JPanel panelContinuar;
	private JPanel panelCargar;
	private JPanel panelSalir;

	// constructor
	public PanelMenu(JFrame ventanaPrincipal) {
		this.ventanaPrincipal = (VentanaPrincipal) ventanaPrincipal;
		inicializarPanel();
		inicializarComponentes();
		inicializarLogica();
	}

	// inicializar panel
	private void inicializarPanel() {
		this.setBorder(new EmptyBorder(55, 16, 55, 16));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	// inicializar componentes
	private void inicializarComponentes() {
		// lbl para el titulo, no tiene interacciones
		JLabel lblTitulo = new JLabel("Cañones Y Fogones");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setAlignmentY(0.0f);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 40));
		crearEspaciado(this, lblTitulo, 30);

		// paneles para las opciones, son interactuables
		panelNueva = crearOpcionMenu("Nueva partida");
		panelContinuar = crearOpcionMenu("Continuar partida");
		panelCargar = crearOpcionMenu("Cargar partida");
		panelSalir = crearOpcionMenu("Salir");
		crearEspaciado(this, panelNueva, 30);
		crearEspaciado(this, panelContinuar, 30);
		crearEspaciado(this, panelCargar, 30);
		crearEspaciado(this, panelSalir, 30);
	}

	// crear espaciado entre los elementos
	private void crearEspaciado(JPanel panel, JComponent componente, int espacio) {
		panel.add(componente);
		panel.add(Box.createRigidArea(new Dimension(0, espacio)));
	}

	// envolver los JLabel en JPanel para hacerlos interactuables y poder hacer el
	// bg de cada panel opaco (efecto del hover)
	private JPanel crearOpcionMenu(String texto) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setBorder(new EmptyBorder(6, 20, 6, 20));
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#EEEEEE"));

		JLabel label = new JLabel(texto);
		label.setFont(new Font("Dialog", Font.BOLD, 21));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				controlador.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controlador.salirHover(panel);
			}
		});

		return panel;
	}

	// inicializar la lógica de cada opción del menu
	private void inicializarLogica() {
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarVentana(ventanaPrincipal);
			}
		});

		panelCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controladorSaves.cargarPartida(panelCargar);
			}
		});

		panelContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controladorSaves.continuarPartida(panelContinuar);
			}
		});
	}
}
