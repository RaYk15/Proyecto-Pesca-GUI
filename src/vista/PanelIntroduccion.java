package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVista;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class PanelIntroduccion extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	private ControladorVista controladorVista = new ControladorVista();
	private VentanaPrincipal ventanaPrincipal;
	private CardLayout cardIntro;
	private JPanel panelIntro;
	private JPanel panelVolver;
	private JPanel panelSiguiente;
	private JPanel panelComenzar;
	private int contadorLbl = 1;

	// constructor
	public PanelIntroduccion(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		inicializarPanel();
		inicializarComponentes();
		inicializarLogica();
	}

	private void inicializarPanel() {
		setBorder(new EmptyBorder(50, 16, 50, 16));
		setLayout(new BorderLayout(16, 16));
	}

	private void inicializarComponentes() {
		// titulo al norte
		JLabel lblTitulo = new JLabel("Bienvenido a Cañones Y Fogones!");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo, BorderLayout.NORTH);

		// panel para los botones al sur
		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.X_AXIS));
		panelOpciones.add(Box.createHorizontalGlue());
		// botones
		panelSiguiente = crearOpcionMenu("Siguiente");
		panelVolver = crearOpcionMenu("Volver");
		panelComenzar = crearOpcionMenu("Comenzar!");
		crearEspaciado(panelOpciones, panelVolver, 30);
		panelVolver.setVisible(false);
		crearEspaciado(panelOpciones, panelSiguiente, 30);
		panelComenzar.setVisible(false);
		crearEspaciado(panelOpciones, panelComenzar, 30);
		panelOpciones.add(Box.createHorizontalGlue());
		add(panelOpciones, BorderLayout.SOUTH);

		// texto en el centro del BorderLayout con un cardlayout para poder ir pasando
		// el texto con el boton siguiente
		cardIntro = new CardLayout();
		panelIntro = new JPanel(cardIntro);
		JLabel lblIntro1 = new JLabel(
				"<html>\n<body>\nBienvenido a Cañones Y Fogones. Dentro de poco te embarcarás en una aventura culinaria explosiva, suban a bordo y leven anclas!\n</body>\n</html>");
		lblIntro1.setFont(new Font("Dialog", Font.BOLD, 18));
		JLabel lblIntro2 = new JLabel(
				"<html>\n<body>\nTu misión como capitán del primer restaurante flotante del Gran Archipiélago será ir de isla en isla atendiendo a los clientes más variopintos.\n</body>\n</html>");
		lblIntro2.setFont(new Font("Dialog", Font.BOLD, 18));
		JLabel lblIntro3 = new JLabel(
				"<html>\n<body>\nPero a puerta cerrada, tras vuestro turno como cocineros y meseros, tú y tu tripulación trataréis de reunir información sobre un gran tesoro escondido en alguna parte del Archipiélago.\n</body>\n</html>");
		lblIntro3.setFont(new Font("Dialog", Font.BOLD, 18));
		JLabel lblIntro4 = new JLabel(
				"<html>\n<body>\nLa información es oro, y en el mundillo de los piratas hay gente que se toma eso muy en serio, así que prepárate, encended los fogones y cargad los cañones!\n</body>\n</html>");
		lblIntro4.setFont(new Font("Dialog", Font.BOLD, 18));
		panelIntro.add(lblIntro1, "INTRO_1");
		panelIntro.add(lblIntro2, "INTRO_2");
		panelIntro.add(lblIntro3, "INTRO_3");
		panelIntro.add(lblIntro4, "INTRO_4");
		cardIntro.show(panelIntro, "INTRO_1");
		add(panelIntro, BorderLayout.CENTER);
	}

	// crear espaciado entre los elementos y añadirlo al panel
	private void crearEspaciado(JPanel panel, JComponent componente, int espacio) {
		panel.add(componente);
		panel.add(Box.createRigidArea(new Dimension(0, espacio)));
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

	private void inicializarLogica() {
		panelSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (contadorLbl) {
				case 1:
					cardIntro.show(panelIntro, "INTRO_2");
					panelVolver.setVisible(true);
					contadorLbl++;
					break;
				case 2:
					cardIntro.show(panelIntro, "INTRO_3");
					contadorLbl++;
					break;
				case 3:
					cardIntro.show(panelIntro, "INTRO_4");
					panelSiguiente.setVisible(false);
					panelComenzar.setVisible(true);
					contadorLbl++;
					break;
				}
			}
		});

		panelVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (contadorLbl) {
				case 2:
					cardIntro.show(panelIntro, "INTRO_1");
					panelVolver.setVisible(false);
					contadorLbl--;
					break;
				case 3:
					cardIntro.show(panelIntro, "INTRO_2");
					contadorLbl--;
					break;
				case 4:
					cardIntro.show(panelIntro, "INTRO_3");
					panelSiguiente.setVisible(true);
					panelComenzar.setVisible(false);
					contadorLbl--;
					break;
				}
			}
		});
		
		panelComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controladorVista.entrarCreacion(ventanaPrincipal);
			}
		});
	}
}
