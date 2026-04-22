package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ControladorJuego;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class PanelCreacion extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	private VentanaPrincipal ventanaPrincipal;
	private ControladorJuego controladorJuego;
	private JPanel panelFinalizar;
	private JTextField txtNombre;
	private JTextField txtTrip1;
	private JTextField txtTrip2;
	private JTextField txtTrip3;
	private JTextField txtTrip4;

	// constructor
	public PanelCreacion(VentanaPrincipal ventanaPrincipal, ControladorJuego controladorJuego) {
		this.controladorJuego = controladorJuego;
		this.ventanaPrincipal = ventanaPrincipal;
		inicializarPanel();
		inicializarComponentes();
		inicializarLogica();
	}

	private void inicializarPanel() {
		setBorder(new EmptyBorder(50, 25, 50, 25));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void inicializarComponentes() {
		// titulo
		JLabel lblTitulo = new JLabel("Ahora, ¿quién eres, capitán?");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
		crearEspaciado(this, lblTitulo, 20);

		// preparar paneles y componentes para cada pregunta
		// NOMBRE DEL CAPITÁN
		JPanel panelNombreCap = new JPanel();
		panelNombreCap.setLayout(new BoxLayout(panelNombreCap, BoxLayout.X_AXIS));
		// lbl para el nombre del jugador
		JLabel lblNombre = new JLabel("Cómo te llamas?");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		crearEspaciado(panelNombreCap, lblNombre, 20);
		// crear espacio entre los dos componentes
		panelNombreCap.add(Box.createRigidArea(new Dimension(20, 0)));
		// txtfield para el nombre del jugador
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		txtNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		crearEspaciado(panelNombreCap, txtNombre, 20);
		crearEspaciado(this, panelNombreCap, 20);

		JLabel lblPreguntaTrip = new JLabel("Y quiénes te acompañan?");
		lblPreguntaTrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPreguntaTrip.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreguntaTrip.setFont(new Font("Dialog", Font.BOLD, 21));
		crearEspaciado(this, lblPreguntaTrip, 20);

		// NOMBRE TRIPULANTE 1
		JPanel panelTrip1 = new JPanel();
		panelTrip1.setLayout(new BoxLayout(panelTrip1, BoxLayout.X_AXIS));
		// lbl para el nombre
		JLabel lblTrip1 = new JLabel("Tripulante 1: ");
		lblTrip1.setFont(new Font("Dialog", Font.BOLD, 18));
		crearEspaciado(panelTrip1, lblTrip1, 20);
		// crear espacio entre los dos componentes
		panelTrip1.add(Box.createRigidArea(new Dimension(20, 0)));
		// txtfield para el nombre del tripulante
		txtTrip1 = new JTextField();
		txtTrip1.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTrip1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		crearEspaciado(panelTrip1, txtTrip1, 20);
		crearEspaciado(this, panelTrip1, 20);

		// NOMBRE TRIPULANTE 2
		JPanel panelTrip2 = new JPanel();
		panelTrip2.setLayout(new BoxLayout(panelTrip2, BoxLayout.X_AXIS));
		// lbl para el nombre
		JLabel lblTrip2 = new JLabel("Tripulante 2: ");
		lblTrip2.setFont(new Font("Dialog", Font.BOLD, 18));
		crearEspaciado(panelTrip2, lblTrip2, 20);
		// crear espacio entre los dos componentes
		panelTrip2.add(Box.createRigidArea(new Dimension(20, 0)));
		// txtfield para el nombre del tripulante
		txtTrip2 = new JTextField();
		txtTrip2.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTrip2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		crearEspaciado(panelTrip2, txtTrip2, 20);
		crearEspaciado(this, panelTrip2, 20);

		// NOMBRE TRIPULANTE 3
		JPanel panelTrip3 = new JPanel();
		panelTrip3.setLayout(new BoxLayout(panelTrip3, BoxLayout.X_AXIS));
		// lbl para el nombre
		JLabel lblTrip3 = new JLabel("Tripulante 3: ");
		lblTrip3.setFont(new Font("Dialog", Font.BOLD, 18));
		crearEspaciado(panelTrip3, lblTrip3, 20);
		// crear espacio entre los dos componentes
		panelTrip3.add(Box.createRigidArea(new Dimension(20, 0)));
		// txtfield para el nombre del tripulante
		txtTrip3 = new JTextField();
		txtTrip3.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTrip3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		crearEspaciado(panelTrip3, txtTrip3, 20);
		crearEspaciado(this, panelTrip3, 20);

		// NOMBRE TRIPULANTE 4
		JPanel panelTrip4 = new JPanel();
		panelTrip4.setLayout(new BoxLayout(panelTrip4, BoxLayout.X_AXIS));
		// lbl para el nombre
		JLabel lblTrip4 = new JLabel("Tripulante 4: ");
		lblTrip4.setFont(new Font("Dialog", Font.BOLD, 18));
		crearEspaciado(panelTrip4, lblTrip4, 20);
		// crear espacio entre los dos componentes
		panelTrip4.add(Box.createRigidArea(new Dimension(20, 0)));
		// txtfield para el nombre del tripulante
		txtTrip4 = new JTextField();
		txtTrip4.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTrip4.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		crearEspaciado(panelTrip4, txtTrip4, 20);
		crearEspaciado(this, panelTrip4, 20);

		// BOTON PARA TERMINAR
		panelFinalizar = crearOpcionMenu("Listo!");
		crearEspaciado(this, panelFinalizar, 20);
	}

	// crear espaciado entre los elementos y añadirlo al menu
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
				ControladorJuego.CONTROLADOR_VISTA.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.salirHover(panel);
			}
		});

		return panel;
	}

	public void inicializarLogica() {
		panelFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] tripulantes = new String[4];
				String nombreCap;
				boolean tripSinNombre = false;
				nombreCap = txtNombre.getText();
				if (nombreCap.isBlank()) {
					JOptionPane.showMessageDialog(panelFinalizar, "No podemos tener un capitán sin nombre!", null,
							JOptionPane.ERROR_MESSAGE);
				} else {
					tripulantes[0] = txtTrip1.getText();
					tripulantes[1] = txtTrip2.getText();
					tripulantes[2] = txtTrip3.getText();
					tripulantes[3] = txtTrip4.getText();
					for (int i = 0; i < tripulantes.length; i++) {
						if (tripulantes[i].isBlank()) {
							tripSinNombre = true;
						}
					}
					if (tripSinNombre) {
						JOptionPane.showMessageDialog(panelFinalizar, "No puedes dejar a ningún tripulante sin nombre!",
								null, JOptionPane.ERROR_MESSAGE);
					} else {
						controladorJuego.crearJugador(nombreCap, tripulantes);
						JOptionPane.showMessageDialog(panelFinalizar, "Partida creada correctamente!",
								null, JOptionPane.INFORMATION_MESSAGE);
						ControladorJuego.CONTROLADOR_VISTA.volverSaves(ventanaPrincipal);
					}
				}
			}
		});
	}
}
