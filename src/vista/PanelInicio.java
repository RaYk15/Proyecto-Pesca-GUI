package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;

public class PanelInicio extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	// atributos
	VentanaPrincipal ventanaPrincipal;
	ControladorVista controlador = new ControladorVista();

	// constructor
	public PanelInicio(JFrame ventanaPrincipal) {
		this.ventanaPrincipal = (VentanaPrincipal) ventanaPrincipal;
		inicializarPanel();
		inicializarComponentes();
		addKeyListener(this);
		setFocusable(true);
	}

	private void inicializarPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
	}

	private void inicializarComponentes() {
		JLabel lblTitulo = new JLabel("Cañones Y Fogones");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblTitulo.setBounds(12, 146, 616, 54);
		this.add(lblTitulo);

		JLabel lblTitulo2 = new JLabel("Versión pesca!");
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setFont(new Font("Dialog", Font.BOLD, 21));
		lblTitulo2.setBounds(368, 212, 212, 34);
		this.add(lblTitulo2);

		JLabel lblNewLabel = new JLabel("Pulsa Enter para comenzar!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 330, 616, 34);
		this.add(lblNewLabel);
	}

	// metodos KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		controlador.escenaInicio(ventanaPrincipal, e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
