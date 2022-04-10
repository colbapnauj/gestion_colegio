package gui;

import clases.Alumno;
import libreria.Lib;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloAlumnos;
import helpers.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmAlumno extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JLabel lblCodAlumno;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JLabel lblEstado;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblDni;
	private JTextField txtCodAlumno;
	private JTextField txtNombres;
	private JTextField txtApellidoPaterno;
	private JTextField txtApellidoMaterno;
	private JTextField txtDni;	
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JComboBox<String> cboEstado;
	private JButton btnAceptar;
	private JButton btnAdicionar;	
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tblAlumno;
	private DefaultTableModel model;
	

	ArregloAlumnos aa = new ArregloAlumnos();

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlumno frame = new FrmAlumno();
					// frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAlumno() {
		setResizable(false);
		setTitle("Mantenimiento | Alumno");
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);

		lblCodAlumno = new JLabel("CodAlumno");
		lblCodAlumno.setBounds(10, 10, 150, 23);
		getContentPane().add(lblCodAlumno);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 40, 150, 23);
		getContentPane().add(lblNombres);
		
		lblApellidoPaterno = new JLabel("ApellidoPaterno");
		lblApellidoPaterno.setBounds(10, 70, 150, 23);
		getContentPane().add(lblApellidoPaterno);

		lblApellidoMaterno = new JLabel("ApellidoMaterno");
		lblApellidoMaterno.setBounds(10, 100, 150, 23);
		getContentPane().add(lblApellidoMaterno);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 130, 150, 23);
		getContentPane().add(lblDni);

		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 160, 150, 23);
		getContentPane().add(lblEdad);

		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 190, 150, 23);
		getContentPane().add(lblCelular);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 220, 150, 23);
		getContentPane().add(lblEstado);		

		txtCodAlumno = new JTextField();
		txtCodAlumno.setBounds(200, 10, 100, 23);
		getContentPane().add(txtCodAlumno);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(200, 40, 100, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setBounds(200, 70, 100, 23);
		getContentPane().add(txtApellidoPaterno);
		txtApellidoPaterno.setColumns(10);

		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setBounds(200, 100, 100, 23);
		getContentPane().add(txtApellidoMaterno);
		txtApellidoMaterno.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(200, 130, 100, 23);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(200, 160, 100, 23);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.addKeyListener(this);
		txtCelular.setBounds(200, 190, 100, 23);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel<String>(Lib.estadosAlumno));
		cboEstado.setBounds(200, 220, 100, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setBounds(329, 10, 100, 23);
		getContentPane().add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(509, 40, 100, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(509, 70, 100, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(509, 100, 100, 23);
		getContentPane().add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.addMouseListener(this);
		btnCerrar.setForeground(Color.BLUE);
		btnCerrar.setBounds(509, 150, 100, 23);
		getContentPane().add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 300, 675, 250);
		getContentPane().add(scrollPane);

		tblAlumno = new JTable();
		tblAlumno.addKeyListener(this);
		tblAlumno.addMouseListener(this);
		tblAlumno.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumno);

		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Nombres");
		model.addColumn("A Paterno");
		model.addColumn("A Materno");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");

		tblAlumno.setModel(model);

		txtCodAlumno.setEditable(false);
		
		txtCodAlumno.setNextFocusableComponent(txtNombres);
		txtNombres.setNextFocusableComponent(txtApellidoPaterno);
		txtApellidoPaterno.setNextFocusableComponent(txtApellidoMaterno);
		txtApellidoMaterno.setNextFocusableComponent(txtDni);
		txtDni.setNextFocusableComponent(txtEdad);
		txtEdad.setNextFocusableComponent(txtCelular);
		txtCelular.setNextFocusableComponent(cboEstado);
		

		 habilitarEntradas(false);
		 ajustarAnchoColumnas();
		 listar();
		 editarFila();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar();
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
        this.dispose();
    }

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);

		clear();
		habilitarEntradas(true);

		txtNombres.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		if (aa.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			noExistenAlumnosMensaje();
		} else {
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtDni.setEditable(false);
			txtNombres.requestFocus();
		}


	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0)	 {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(false);
		if (aa.tamanio() == 0)
			noExistenAlumnosMensaje();
		else {
			editarFila();
			habilitarEntradas(false);

			if (aa.buscar(leerCodigoAlumno()).getEstado() != 0) {
				Utils.message("Para eliminar un perfil el estado debe ser \"Registrado\"", this);
			}
			int result = Utils.prompt("Eliminar registro?", this);
			if (result == 0) {
				aa.eliminar(aa.buscar(leerCodigoAlumno()));
				aa.grabarAlumnos();
				listar();
				editarFila();
			}
		}
	}

	protected void actionPerformedBtnAceptar() {
		int codigoAlumno = leerCodigoAlumno();
		String nombres = leerNombres().toUpperCase();
		String apaterno = leerAPaterno().toUpperCase();
		String amaterno = leerAMaterno().toUpperCase();
		String dni = leerDni();
		int edad = leerEdad();
		int celular = leerCelular();
		int estado = leerEstado();

		if (nombres.length() == 0) {
			Utils.error("Nombres, debe completar este campo", txtNombres, this);
			return;
		}
		if (apaterno.length() == 0) {
			Utils.error("Apellido Paterno, debe completar este campo", txtApellidoPaterno, this);
			return;
		}
		if (amaterno.length() == 0) {
			Utils.error("Apellido Materno, debe completar este campo", txtApellidoMaterno, this);
			return;
		}
		if (dni.length() != 8) {
			Utils.error("DNI, debe completar este campo", txtDni, this);
			return;
		}
		// TODO validar solo ingreso de valor hasta 100 años
		if (edad == -1) {
			Utils.error("Edad, debe completar este campo", txtEdad, this);
			return;
		}
		// TODO valor debe tener como longitud 9 caracteres.
		// Otra forma de validar podría ser trabajar con Strings
		if (celular == -1) {
			Utils.error("Celular, debe completar este campo", txtCelular, this);
			return;
		}
		
		if (btnAdicionar.isEnabled() == false) {
			if (aa.existeDni(dni)) {
				Utils.error("Dni ya registrado", txtDni, this);
				return;
			}
			Alumno alumno = new Alumno(codigoAlumno, nombres, apaterno, amaterno, dni, edad, celular, estado);
			aa.adicionar(alumno);
			aa.grabarAlumnos();
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Alumno alumno = aa.buscar(codigoAlumno);
			alumno.setNombres(nombres);
			alumno.setApellidoPaterno(apaterno);
			alumno.setApellidoMaterno(amaterno);
			 alumno.setDni(dni);
			alumno.setEdad(edad);
			alumno.setCelular(celular);
			alumno.setEstado(estado);
			aa.grabarAlumnos();
			btnModificar.setEnabled(true);
		}

		listar();
		habilitarEntradas(false);
		
	}


	void clear() {
		txtCodAlumno.setText("" + aa.codigoCorrelativo());
		txtEdad.setText("");
		txtCelular.setText("");
		txtNombres.setText("");
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		txtDni.setText("");

	}

	void habilitarEntradas(boolean value) {
		btnAceptar.setEnabled(value);
		txtNombres.setEditable(value);
		txtApellidoPaterno.setEditable(value);
		txtApellidoMaterno.setEditable(value);
		txtDni.setEditable(value);
		txtEdad.setEditable(value);
		txtCelular.setEditable(value);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}

	void editarFila() {
		if (aa.tamanio() == 0)
			clear();
		else {
			Alumno a = aa.obtener(tblAlumno.getSelectedRow());
			txtCodAlumno.setText("" + a.getCodAlumno());
			txtNombres.setText(a.getNombres());
			txtApellidoPaterno.setText(a.getApellidoPaterno());
			txtApellidoMaterno.setText(a.getApellidoMaterno());
			txtDni.setText(a.getDni());
			txtEdad.setText("" + a.getEdad());
			txtCelular.setText("" + a.getCelular());
		}
	}

	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblAlumno.getSelectedRow();
		if (model.getRowCount() == aa.tamanio() - 1)
			posFila = aa.tamanio() - 1;
		if (posFila == aa.tamanio())
			posFila--;
		model.setRowCount(0);
		Alumno a;
		for (int i = 0; i < aa.tamanio(); i++) {
			a = aa.obtener(i);
			Object[] fila = {
				a.getCodAlumno(),
				a.getNombres(),
				a.getApellidoPaterno(),
				a.getApellidoMaterno(),
				a.getDni(),
				a.getEdad(),
				a.getCelular(),
				Lib.estadosAlumno[a.getEstado()]
			};
			model.addRow(fila);
		}
		if (aa.tamanio() > 0)
			tblAlumno.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblAlumno.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(6).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(7).setPreferredWidth(anchoColumna(20));
	}

	void noExistenAlumnosMensaje() {
		Utils.message("No existen alumnos registrados", this);
	}

		int leerCodigoAlumno() {
		return Integer.parseInt(txtCodAlumno.getText().trim());
	}

	String leerNombres() {
		return txtNombres.getText().trim();
	}

	String leerAPaterno() {
		return txtApellidoPaterno.getText().trim();
	}

	String leerAMaterno() {
		return txtApellidoMaterno.getText().trim();
	}

	String leerDni() {
		return txtDni.getText().trim();
	}

	int leerEdad() {
		String value = txtEdad.getText().trim();
		if (value.equals("")) {
			return -1;
		}
		return Integer.parseInt(value);
	}

	int leerCelular() {
		String value = txtCelular.getText().trim();
		if (value.equals("")) {
			return -1;
		}
		return Integer.parseInt(value);
	}

	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	protected void mouseClickedTblAlumno(MouseEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tblAlumno) {
			mouseClickedTblAlumno(e);;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCelular) {
			do_txtCelular_keyReleased(e);
		}
		// TODO Auto-generated method stub
		if (e.getSource() == tblAlumno) {
			e.consume();
			editarFila();	
		}	
	}


	
	protected void do_txtCelular_keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 10 && !btnAdicionar.isEnabled()) {
			actionPerformedBtnAceptar();
		}
	}
	
}
