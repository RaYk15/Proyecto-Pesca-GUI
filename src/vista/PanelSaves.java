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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControladorJuego;
import controlador.ControladorSaves;

public class PanelSaves extends JPanel {
	private static final long serialVersionUID = 1L;
	// atributos
	private VentanaPrincipal ventanaPrincipal;
	private ControladorSaves controladorSaves;
	private JPanel panelOpciones;
	private JPanel panelCargar;
	private JLabel lblCargar = new JLabel();
	private JPanel panelBorrar;
	private JLabel lblBorrar = new JLabel();
	private JPanel panelVolver;
	private JLabel lblVolver = new JLabel();
	private JLabel lblDatosPartida;
	private JList<String> listaSaves;
	private DefaultListModel<String> modeloLista;
	private String saveSeleccionado;

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
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		panelCargar = crearOpcionMenu("Cargar partida", lblCargar, false);
		panelBorrar = crearOpcionMenu("Borrar partida", lblBorrar, false);
		panelVolver = crearOpcionMenu("Volver", lblVolver, true);
		crearEspaciado(panelOpciones, panelCargar, 30);
		crearEspaciado(panelOpciones, panelBorrar, 30);
		crearEspaciado(panelOpciones, panelVolver, 30);

		// area para mostrar los datos de la partida
		JPanel panelDatosPartida = new JPanel();
		panelDatosPartida.setLayout(new BorderLayout(16, 16));
		panelDatosPartida.setBorder(new EmptyBorder(6, 6, 6, 6));
		panelDatosPartida.setOpaque(true);
		panelDatosPartida.setBackground(Color.decode("#FFFFFF"));
		panelDatosPartida.setPreferredSize(new Dimension(0, 158));
		panelDatosPartida.setMaximumSize(new Dimension(Integer.MAX_VALUE, 158));
		panelDatosPartida.setMinimumSize(new Dimension(0, 158));
		lblDatosPartida = new JLabel();
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDatosPartida.add(lblDatosPartida);
		crearEspaciado(panelOpciones, panelDatosPartida, 0);
		add(panelOpciones, BorderLayout.WEST);

		// centro para la lista
		modeloLista = new DefaultListModel<>();
		listaSaves = new JList<>(modeloLista);
		JScrollPane scroll = new JScrollPane(listaSaves);
		controladorSaves.recuperarListaSaves(modeloLista);
		add(scroll, BorderLayout.CENTER);
	}

	// envolver los JLabel en JPanel para hacerlos interactuables y poder hacer el
	// bg de cada panel opaco (efecto del hover)
	private JPanel crearOpcionMenu(String texto, JLabel label, boolean activo) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(16, 16));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setBorder(new EmptyBorder(6, 20, 6, 20));
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#EEEEEE"));

		label.setText(texto);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setForeground(activo ? Color.decode("#333333") : Color.decode("#ABABAB"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);

		if (activo) {
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
		}

		return panel;
	}

	// activar opcion
	private void activarBorrar(JPanel panel, JLabel label) {
		// ajustar el texto
		label.setForeground(Color.decode("#333333"));

		// borrar listeners por si acaso
		for (var i : panel.getMouseListeners()) {
			panel.removeMouseListener(i);
		}

		// añadir listeners
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.salirHover(panel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (saveSeleccionado == null) {
					return;
				}
				int seleccion = JOptionPane.showConfirmDialog(panelBorrar, "Seguro que quieres borrar la partida?",
						"Selecciona una opción", JOptionPane.YES_NO_OPTION);
				if (seleccion == 0) {
					controladorSaves.borrarPartida(saveSeleccionado, ventanaPrincipal);
					saveSeleccionado = null;
					lblDatosPartida.setText(null);
					controladorSaves.recuperarListaSaves(modeloLista);
				}
			}
		});

		panel.repaint();
	}

	private void activarCargar(JPanel panel, JLabel label) {
		// ajustar el texto
		label.setForeground(Color.decode("#333333"));

		// borrar listeners por si acaso
		for (var i : panel.getMouseListeners()) {
			panel.removeMouseListener(i);
		}

		// añadir listeners
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.entrarHover(panel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.salirHover(panel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		panel.repaint();
	}

	// desactivar opcion
	private void desactivarOpcion(JPanel panel, JLabel label) {
		// ajustar el texto
		label.setForeground(Color.decode("#ABABAB"));

		// eliminar los listeners
		for (var i : panel.getMouseListeners()) {
			panel.removeMouseListener(i);
		}

		panel.repaint();
	}

	// crear espaciado entre los elementos y añadirlo al panel
	private void crearEspaciado(JPanel panel, JComponent componente, int espacio) {
		panel.add(componente);
		panel.add(Box.createRigidArea(new Dimension(0, espacio)));
	}

	// inicializar la lógica de cada opción del menu WIP
	private void inicializarLogica() {
		// volver al menu principal
		panelVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControladorJuego.CONTROLADOR_VISTA.volverSaves(ventanaPrincipal);
			}
		});

		// seleccion de saves de la JList
		listaSaves.addListSelectionListener(e -> {
			// guardar el nombre del archivo que se selecciona en la JList
			if (!e.getValueIsAdjusting()) {
				saveSeleccionado = listaSaves.getSelectedValue();
				if (saveSeleccionado != null) {
					controladorSaves.mostrarDatosPartida(saveSeleccionado, lblDatosPartida);
					activarCargar(panelCargar, lblCargar);
					activarBorrar(panelBorrar, lblBorrar);
				} else {
					lblDatosPartida.setText(null);
					desactivarOpcion(panelCargar, lblCargar);
					desactivarOpcion(panelBorrar, lblBorrar);
				}
			}
		});

		// cargar partida
		panelCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (saveSeleccionado == null) {
					return;
				}
			}
		});

		// borrar partidad
		panelBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (saveSeleccionado == null) {
					return;
				}
				int seleccion = JOptionPane.showConfirmDialog(panelBorrar, "Seguro que quieres borrar la partida?",
						"Selecciona una opción", JOptionPane.YES_NO_OPTION);
				if (seleccion == 0) {
					controladorSaves.borrarPartida(saveSeleccionado, ventanaPrincipal);
					saveSeleccionado = null;
					lblDatosPartida.setText(null);
					controladorSaves.recuperarListaSaves(modeloLista);
				}
			}
		});

	}

	// getters y setters
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public JPanel getPanelCargar() {
		return panelCargar;
	}

	public void setPanelCargar(JPanel panelCargar) {
		this.panelCargar = panelCargar;
	}

	public JPanel getPanelBorrar() {
		return panelBorrar;
	}

	public void setPanelBorrar(JPanel panelBorrar) {
		this.panelBorrar = panelBorrar;
	}

	public JPanel getPanelVolver() {
		return panelVolver;
	}

	public void setPanelVolver(JPanel panelVolver) {
		this.panelVolver = panelVolver;
	}

	public JLabel getLblDatosPartida() {
		return lblDatosPartida;
	}

	public void setLblDatosPartida(JLabel lblDatosPartida) {
		this.lblDatosPartida = lblDatosPartida;
	}

	public JList<String> getListaSaves() {
		return listaSaves;
	}

	public void setListaSaves(JList<String> listaSaves) {
		this.listaSaves = listaSaves;
	}

	public DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	public void setModeloLista(DefaultListModel<String> modeloLista) {
		this.modeloLista = modeloLista;
	}

}
