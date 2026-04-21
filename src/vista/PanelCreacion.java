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

import controlador.ControladorVista;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelCreacion extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	private ControladorVista controladorVista = new ControladorVista();
	private VentanaPrincipal ventanaPrincipal;
	private JPanel panelFinalizar;
	private JTextField txtNombre;
	
	// constructor
	public PanelCreacion(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		inicializarPanel();
		inicializarComponentes();
	}

	private void inicializarPanel() {
		setBorder(new EmptyBorder(50, 16, 50, 16));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void inicializarComponentes() {
		// titulo
		JLabel lblTitulo = new JLabel("Ahora, ¿quién eres, capitán?");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
		crearEspaciado(this, lblTitulo, 20);
		
		// text field para el nombre
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		crearEspaciado(this, txtNombre, 20);
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
				controladorVista.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controladorVista.salirHover(panel);
			}
		});

		return panel;
	}
}
