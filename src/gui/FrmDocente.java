package gui;

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

import arreglos.ArregloDocentes;
import clases.Curso;
import clases.Docente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmDocente extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JLabel lblCodDocente;
	private JLabel lblNombres;
	private JLabel lblAPaterno;
	private JLabel lblAMaterno;
	private JLabel lblDni;
	private JLabel lblCelular;
	private JLabel lblEspecialidad;
	private JLabel lblFechaIngreso;
	private JTextField txtCodDocente;
	private JTextField txtNombres;
	private JTextField txtAMaterno;
	private JTextField txtAPaterno;
	private JTextField txtDni;	
	private JTextField txtCelular;
	private JTextField txtEspecialidad;
	private JTextField txtFechaIngreso;
	private JButton btnAceptar;
	private JButton btnAdicionar;	
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tblDocente;
	private DefaultTableModel model;

	ArregloDocentes ad = new ArregloDocentes();

	private final JPanel contentPanel = new JPanel();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDocente frame = new FrmDocente();
					// frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmDocente() {
		setResizable(false);
		setTitle("Mantenimiento | Curso");
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);
		
		lblCodDocente = new JLabel("CodDocente");
		lblCodDocente.setBounds(10, 10, 150, 23);
		getContentPane().add(lblCodDocente);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 40, 150, 23);
		getContentPane().add(lblNombres);
		
		lblAPaterno = new JLabel("A Paterno");
		lblAPaterno.setBounds(10, 70, 150, 23);
		getContentPane().add(lblAPaterno);

		lblAMaterno = new JLabel("A Materno");
		lblAMaterno.setBounds(10, 100, 150, 23);
		getContentPane().add(lblAMaterno);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 130, 150, 23);
		getContentPane().add(lblDni);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 160, 150, 23);
		getContentPane().add(lblCelular);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(10, 190, 150, 23);
		getContentPane().add(lblEspecialidad);
		
		lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setBounds(10, 220, 150, 23);
		getContentPane().add(lblFechaIngreso);

		txtCodDocente = new JTextField();
		txtCodDocente.setBounds(200, 10, 100, 23);
		getContentPane().add(txtCodDocente);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(200, 40, 100, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtAPaterno = new JTextField();
		txtAPaterno.setBounds(200, 70, 100, 23);
		getContentPane().add(txtAPaterno);
		txtAPaterno.setColumns(10);

		txtAMaterno = new JTextField();
		txtAMaterno.setBounds(200, 100, 100, 23);
		getContentPane().add(txtAMaterno);
		txtAMaterno.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(200, 130, 100, 23);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(200, 160, 100, 23);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(200, 190, 100, 23);
		getContentPane().add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setBounds(200, 220, 100, 23);
		getContentPane().add(txtFechaIngreso);
		txtFechaIngreso.setColumns(10);

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

		tblDocente = new JTable();
		tblDocente.addKeyListener(this);
		tblDocente.addMouseListener(this);
		tblDocente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDocente);
		

		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Nombres");
		model.addColumn("A Paterno");
		model.addColumn("A Materno");
		model.addColumn("Dni");
		model.addColumn("Celular");
		model.addColumn("Especialidad");
		model.addColumn("Fecha Ingreso");
		
		tblDocente.setModel(model);

		// txtCodAlumno.setEditable(false);

		 habilitarEntradas(false);
		 ajustarAnchoColumnas();
		 listar();
		 editarFila();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
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

		txtCodDocente.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		if (ad.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			noExistenAlumnosMensaje();
		} else {
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtCodDocente.setEditable(false);
			txtCodDocente.requestFocus();
		}


	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0)	 {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(false);
		if (ad.tamanio() == 0)
			noExistenAlumnosMensaje();
		else {
			editarFila();
			habilitarEntradas(false);

//			if (ad.buscar(leerCodCurso()).getEstado() != 0) {
//				message("Para eliminar un perfil el estado debe ser \"Registrado\"");
//			}
			int result = prompt("Eliminar registro?");
			if (result == 0) {
				// TODO Validar que Docente no tenga Alumnos matriculados en él
				ad.eliminar(ad.buscar(pInt(leerCodDocente())));
				ad.grabarDocentes();
				listar();
				editarFila();
			}
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codDocente = leerCodDocente();
		String nombres = leerNombre();
		String apaterno = leerAPaterno();
		String amaterno = leerAMaterno();
		String dni = leerDni();
		String celular = leerCelular();
		String especialidad = leerEspecialidad();
		String fechaIngreso = leerFechaIngreso();
		
		
		
		// TODO Validar campos
		
		if (btnAdicionar.isEnabled() == false) {
			if (ad.existeCod(pInt(codDocente))) {
				error("Cod ya existe", txtCodDocente);
				return;
			}
			Docente docente= new Docente(pInt(codDocente), nombres, apaterno, amaterno, dni, pInt(celular), especialidad, fechaIngreso);
			ad.adicionar(docente);
			ad.grabarDocentes();
			btnAdicionar.setEnabled(true);
			// TODO Ordernar Lista
		}
		if (btnModificar.isEnabled() == false) {
			Docente docente = ad.buscar(pInt(codDocente));
			docente.setNombres(nombres);
			docente.setApellidoPaterno(apaterno);
			docente.setApellidoMaterno(amaterno);
			docente.setDni(dni);
			docente.setCelular(pInt(celular));
			docente.setEspecialidad(especialidad);
			docente.setFechaIngreso(fechaIngreso);
			ad.grabarDocentes();
			btnModificar.setEnabled(true);
		}

		listar();
		habilitarEntradas(false);
		
	}
	
	int pInt(String value) {
		return Integer.parseInt(value);
	}


	void clear() {
		txtCodDocente.setText("" + ad.codigoCorrelativo());
		txtNombres.setText("");
		txtAPaterno.setText("");
		txtAMaterno.setText("");
		txtDni.setText("");
		txtCelular.setText("");
		txtEspecialidad.setText("");
		txtFechaIngreso.setText("");

	}

	void habilitarEntradas(boolean value) {
		btnAceptar.setEnabled(value);
		txtCodDocente.setEditable(value);
		txtAPaterno.setEditable(value);
		txtAMaterno.setEditable(value);
		txtDni .setEditable(value);
	}
	
	void habilitarBotones(boolean value) {
		btnAdicionar.setEnabled(value);
		btnModificar.setEnabled(value);
		// btnEliminar.setEnabled(value);
	}

	void editarFila() {
		if (ad.tamanio() == 0)
			clear();
		else {
			Docente d = ad.obtener(tblDocente.getSelectedRow());
			txtCodDocente.setText("" + d.getCodDocente());
			txtNombres.setText(d.getNombres());
			txtAPaterno.setText(d.getApellidoPaterno());
			txtAMaterno.setText(d.getApellidoMaterno());
			txtDni.setText(d.getDni());
			txtCelular.setText("" + d.getCelular());
			txtEspecialidad.setText(d.getEspecialidad());
			txtFechaIngreso.setText(d.getFechaIngreso());
		}
	}

	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblDocente.getSelectedRow();
		if (model.getRowCount() == ad.tamanio() - 1)
			posFila = ad.tamanio() - 1;
		if (posFila == ad.tamanio())
			posFila--;
		model.setRowCount(0);
		Docente d;
		///
		ad.ordenar();
		///
		for (int i = 0; i < ad.tamanio(); i++) {
			d = ad.obtener(i);
			Object[] fila = {
				d.getCodDocente(),
				d.getNombres(),
				d.getApellidoPaterno(),
				d.getApellidoMaterno(),
				d.getDni(),
				d.getCelular(),
				d.getEspecialidad(),
				d.getFechaIngreso()
			};
			model.addRow(fila);
		}
		if (ad.tamanio() > 0)
			tblDocente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblDocente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));
	}

	void noExistenAlumnosMensaje() {
		message("No existen alumnos registrados");
	}
	
	void message(String s) {
		JOptionPane.showMessageDialog(this, s, "Information", 0);
	}

	int prompt(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}

	void error(String s, JTextField txt) {
		message(s);
		txt.setText("");
		txt.requestFocus();
	}

	String leerCodDocente() {
		return txtCodDocente.getText().trim();
	}

	String leerNombre() {
		return txtNombres.getText().trim();
	}

	String leerAPaterno() {
		return txtAPaterno.getText().trim();
	}
	
	String leerAMaterno() {
		return txtAMaterno.getText().trim();
	}
	
	String leerDni() {
		return txtDni.getText().trim();
	}
	
	String leerCelular() {
		return txtCelular.getText().trim();
	}
	
	String leerEspecialidad() {
		return txtEspecialidad.getText().trim();
	}
	
	// TODO En vez de un textfield debería usar un picker
	String leerFechaIngreso() {
		return txtFechaIngreso.getText().trim();
	}

//	int leerEstado() {
//		return cboEstado.getSelectedIndex();
//	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	protected void mouseClickedTblCurso(MouseEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tblDocente) {
			mouseClickedTblCurso(e);;
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
		// TODO Auto-generated method stub
		if (e.getSource() == tblDocente) {
			e.consume();
			editarFila();	
		}	
	}
}