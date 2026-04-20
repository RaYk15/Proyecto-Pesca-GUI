package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVista;

public class PanelSaves extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	private VentanaPrincipal ventanaPrincipal;
	private JPanel panelCargar;
	private JPanel panelBorrar;
	private JPanel panelVolver;
	private ControladorVista controladorVista = new ControladorVista();

	// constructor
	public PanelSaves(JFrame ventanaPrincipal) {
		this.ventanaPrincipal = (VentanaPrincipal) ventanaPrincipal;
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
		add(panelOpciones, BorderLayout.WEST);

		// centro para la lista
		DefaultListModel<String> modelo = new DefaultListModel<>();
		JList<String> listaSaves = new JList<>(modelo);
		JScrollPane scroll = new JScrollPane(listaSaves);
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
				controladorVista.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controladorVista.salirHover(panel);
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
				ventanaPrincipal.mostrarEscena("ESCENA_MENU");
			}
		});
	}

}
