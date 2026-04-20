package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class VentanaSaves extends JFrame {
	// atributos
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// constructor
	public VentanaSaves() {
		inicializarVentana();
		inicializarComponentes();
	}

	public void inicializarVentana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Partidas guardadas");
		setResizable(false);
	}

	public void inicializarComponentes() {
		JLabel lblTitulo = new JLabel("Partidas guardadas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
		lblTitulo.setBounds(12, 12, 426, 36);
		contentPane.add(lblTitulo);

		JLabel lblCargar = new JLabel("Cargar partida");
		lblCargar.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCargar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargar.setBounds(22, 79, 126, 15);
		contentPane.add(lblCargar);

		JLabel lblBorrar = new JLabel("Borrar partida");
		lblBorrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrar.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBorrar.setBounds(22, 106, 126, 15);
		contentPane.add(lblBorrar);

		JLabel lblCerrar = new JLabel("Cerrar");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCerrar.setBounds(22, 133, 126, 15);
		contentPane.add(lblCerrar);

		JList listSaves = new JList();
		listSaves.setBounds(166, 59, 257, 200);
		contentPane.add(listSaves);
	}
}
