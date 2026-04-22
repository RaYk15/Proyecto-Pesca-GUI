package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControladorJuego;
import controlador.ControladorSaves;

public class PanelSaves extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	private VentanaPrincipal ventanaPrincipal;
	private ControladorSaves controladorSaves;
	private JPanel panelCargar;
	private JPanel panelBorrar;
	private JPanel panelVolver;
	private JLabel lblDatosPartida;
	private JList<String> listaSaves;

	// constructor
	public PanelSaves(VentanaPrincipal ventanaPrincipal, ControladorSaves controladorSaves) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.controladorSaves = controladorSaves;
		inicializarPanel();
		inicializarComponentes();
		inicializarLogica();
	}

	private void inicializarPanel() {
		setBorder(new EmptyBorder(30, 16, 30, 16));
		setLayout(new BorderLayout(16, 16));
	}

	private void inicializarComponentes() {
		// norte para el titulo
		JLabel lblTitulo = new JLabel("Partidas guardadas");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo, BorderLayout.NORTH);

		// oeste para las opciones
		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		panelCargar = crearOpcionMenu("Cargar partida");
		panelBorrar = crearOpcionMenu("Borrar partida");
		panelVolver = crearOpcionMenu("Volver");
		crearEspaciado(panelOpciones, panelCargar, 30);
		crearEspaciado(panelOpciones, panelBorrar, 30);
		crearEspaciado(panelOpciones, panelVolver, 30);

		JPanel panelDatosPartida = new JPanel();
		panelDatosPartida.setLayout(new BorderLayout(16, 16));
		panelDatosPartida.setBorder(new EmptyBorder(6, 6, 6, 6));
		panelDatosPartida.setOpaque(true);
		panelDatosPartida.setBackground(Color.decode("#FFFFFF"));
		lblDatosPartida = new JLabel();
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDatosPartida.add(lblDatosPartida);
		crearEspaciado(panelOpciones, panelDatosPartida, 0);
		add(panelOpciones, BorderLayout.WEST);

		// centro para la lista
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaSaves = new JList<>(modelo);
		JScrollPane scroll = new JScrollPane(listaSaves);
		controladorSaves.recuperarListaSaves(modelo);
		add(scroll, BorderLayout.CENTER);
	}

	// envolver los JLabel en JPanel para hacerlos interactuables y poder hacer el
	// bg de cada panel opaco (efecto del hover)
	private JPanel crearOpcionMenu(String texto) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(16, 16));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setBorder(new EmptyBorder(6, 20, 6, 20));
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#EEEEEE"));

		JLabel label = new JLabel(texto);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.salirHover(panel);
			}
		});

		return panel;
	}

	// crear espaciado entre los elementos y añadirlo al panel
	private void crearEspaciado(JPanel panel, JComponent componente, int espacio) {
		panel.add(componente);
		panel.add(Box.createRigidArea(new Dimension(0, espacio)));
	}

	// inicializar la lógica de cada opción del menu WIP
	private void inicializarLogica() {
		panelCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		panelBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		panelVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.volverSaves(ventanaPrincipal);
			}
		});
		
		listaSaves.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				String seleccionado = listaSaves.getSelectedValue();
				controladorSaves.mostrarDatosPartida(seleccionado, lblDatosPartida);
			}
		});
	}

}
