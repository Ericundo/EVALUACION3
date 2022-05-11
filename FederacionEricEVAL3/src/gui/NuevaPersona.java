package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.EquipoDAO;
import dao.PatrocinadorDAO;
import entidades.Prueba;
import utils.ConexBD;
import validaciones.Validaciones;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import entidades.Equipo;
import entidades.Lugar;
import entidades.Patrocinador;

public class NuevaPersona extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textFieldNIFNIE;
	private JTextField textFieldTelefono;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaPersona frame = new NuevaPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuevaPersona() {
		setBackground(Color.WHITE);
		setTitle("Datos Personales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre *:");
		lblNombre.setBounds(39, 30, 77, 14);
		contentPane.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(126, 27, 261, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba nueva = new Prueba();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {
					errores += "El nombre de la persona no es válido (3-50 caracteres sin n�meros).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nueva.setNombre(nombre);
				valido = false;

				String telefono = textFieldTelefono.getText();
				valido = Validaciones.validarTelefono(telefono);
				if (!valido) {
					errores += "El telefono no es válido (solo numeros).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nueva.setNombre(nombre);
				valido = false;

				String nifnie = textFieldNIFNIE.getText();
				valido = Validaciones.validarNIE(nifnie);
				valido = Validaciones.validarNIF(nifnie);
				if (!valido) {
					errores += "El nif/nie no es válido.\n";
					lblNombre.setForeground(Color.RED);
				} else
					nueva.setNombre(nombre);
				valido = false;

			}
		});
		buttonAceptar.setBounds(193, 227, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(298, 227, 89, 23);
		contentPane.add(buttonCancelar);

		JRadioButton rbNIE = new JRadioButton("NIE");
		buttonGroupTipo.add(rbNIE);
		rbNIE.setBounds(234, 54, 109, 23);
		contentPane.add(rbNIE);

		JRadioButton rbNIF = new JRadioButton("NIF");
		buttonGroupTipo.add(rbNIF);
		rbNIF.setBounds(234, 71, 109, 23);
		contentPane.add(rbNIF);

		textFieldNIFNIE = new JTextField();
		textFieldNIFNIE.setBounds(217, 106, 109, 20);
		contentPane.add(textFieldNIFNIE);
		textFieldNIFNIE.setColumns(10);

		JLabel lblIntroduzcaUnValor = new JLabel("Introduzca un valor para el NIF/NIE*:");
		lblIntroduzcaUnValor.setBounds(40, 55, 188, 54);
		contentPane.add(lblIntroduzcaUnValor);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setToolTipText("");
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(65, 137, 133, 20);
		contentPane.add(textFieldTelefono);

		JLabel lblFechaNac = new JLabel("Fecha Nac*:");
		lblFechaNac.setBounds(217, 120, 60, 54);
		contentPane.add(lblFechaNac);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(282, 137, 123, 20);
		contentPane.add(spinnerFecha);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 140, 77, 14);
		contentPane.add(lblTelfono);

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Equipo> equiposModel = new DefaultComboBoxModel<Equipo>();
		JComboBox<Equipo> comboBox = new JComboBox<Equipo>(equiposModel);
		EquipoDAO eqDAO = new EquipoDAO(ConexBD.getCon());
		ArrayList<Equipo> equiposList = (ArrayList<Equipo>) eqDAO.buscarTodos();
		for (Equipo eq : equiposList)
			comboBox.addItem(eq);
		/// Pero el modelo de comboBox básico requiere Strings
		String[] equipossStr = new String[equiposList.size()+1];
		for (int i = 0; i < equiposList.size(); i++)
			equipossStr[i] = equiposList.get(i).toString();
		equipossStr[equipossStr.length-1] = "NINGUNO";
		comboBox.setModel(new DefaultComboBoxModel(equipossStr));

		comboBox.setBounds(234, 182, 153, 22);
		contentPane.add(comboBox);

		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(75, 168, 86, 20);
		contentPane.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(75, 199, 86, 20);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		JLabel lblNewLabel = new JLabel("Peso");
		lblNewLabel.setBounds(10, 171, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setBounds(10, 202, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Equipo");
		lblNewLabel_2.setBounds(171, 185, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
