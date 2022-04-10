package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloDocentes;
import arreglos.ArregloMatriculas;
import clases.Alumno;
import clases.Curso;
import clases.Docente;
import clases.Matricula;
import dialogs.DlgMatriculas;
import libreria.Lib;
import helpers.Utils;
import helpers.Utils.Tipo;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmMatricula extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static FrmMatricula single_instance = null;

	public static FrmMatricula getInstance() {
		if (single_instance == null)
			single_instance = new FrmMatricula();

		return single_instance;
	}

	private JLabel lblCodigo;
	private JLabel lblAlumno;
	private JLabel lblCurso;
	private JLabel lblDocente;
	private JTextField txtCodigo;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JTextField txtCodDocente;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private DefaultTableModel model;
	private ArregloMatriculas am = new ArregloMatriculas();
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloCursos ac = new ArregloCursos();
	private ArregloDocentes ad = new ArregloDocentes();
	private JButton btnCerrar;

	public static String pCodMat = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMatricula frame = FrmMatricula.getInstance();
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
	@SuppressWarnings("deprecation")
	public FrmMatricula() {
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(180, 37, 114, 21);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(48, 39, 60, 17);
		getContentPane().add(lblCodigo);

		lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(48, 72, 60, 17);
		getContentPane().add(lblAlumno);

		txtCodAlumno = new JTextField();
		txtCodAlumno.addKeyListener(this);
		txtCodAlumno.setBounds(180, 70, 114, 21);
		getContentPane().add(txtCodAlumno);
		txtCodAlumno.setColumns(10);

		txtCodCurso = new JTextField();
		txtCodCurso.addKeyListener(this);
		txtCodCurso.setBounds(180, 103, 114, 21);
		getContentPane().add(txtCodCurso);
		txtCodCurso.setColumns(10);

		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(48, 105, 60, 17);
		getContentPane().add(lblCurso);

		lblDocente = new JLabel("Docente");
		lblDocente.setBounds(48, 134, 60, 17);
		getContentPane().add(lblDocente);

		txtCodDocente = new JTextField();
		txtCodDocente.addKeyListener(this);
		txtCodDocente.setColumns(10);
		txtCodDocente.setBounds(180, 132, 114, 21);
		getContentPane().add(txtCodDocente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 550, 200);
		getContentPane().add(scrollPane);

		tblMatricula = new JTable();
		tblMatricula.addKeyListener(this);
		tblMatricula.addMouseListener(this);
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(303, 34, 105, 27);
		getContentPane().add(btnAceptar);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(455, 34, 105, 27);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(455, 72, 105, 27);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(455, 113, 105, 27);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(455, 152, 105, 27);
		getContentPane().add(btnEliminar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(455, 191, 105, 27);
		getContentPane().add(btnCerrar);

		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Alumno");
		model.addColumn("Curso");
		model.addColumn("Docente");
		model.addColumn("Fecha de matrícula");
		model.addColumn("Hora de matrícula");

		tblMatricula.setModel(model);

		txtCodAlumno.setNextFocusableComponent(txtCodCurso);
		txtCodCurso.setNextFocusableComponent(txtCodDocente);

		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			modificar();
		}
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
		if (e.getSource() == btnConsultar) {
			// consultar();
		}
		if (e.getSource() == btnEliminar)
			eliminar();
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			aceptar();
		}
	}

	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	void aceptar() {

		int codMat = leerCodigoMatricula();
		int codAlu = leerCodigoAlumno();
		int codCur = leerCodigoCurso();
		int codDoc = leerCodigoDocente();

		// Manejar el ingreso o búsqueda de Alumno

		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = date.format(LocalDateTime.now());

		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		String hora = time.format(LocalDateTime.now());

		if (codMat == -1) {
			Utils.error("Error al ingresar el código", txtCodigo, this);
			return;
		}
		if (codAlu == -1) {
			Utils.error("Error al ingresar el cod Alumno", txtCodAlumno, this);
			return;
		}
		if (codCur == -1) {
			Utils.error("Error al ingresar el cod Curso", txtCodCurso, this);
			return;
		}
		if (codDoc == -1) {
			Utils.error("Error al ingresar el cod Docente", txtCodDocente, this);
			return;
		}

		if (btnAdicionar.isEnabled() == false) {
			Matricula m = new Matricula(codMat, codAlu, codCur, codDoc, fecha, hora);
			am.adicionar(m);
			aa.cambiarEstado(codAlu, 1);

			aa.grabarAlumnos();
			am.grabarMatriculas();

			btnAdicionar.setEnabled(true);
		}

		if (btnModificar.isEnabled() == false) {
			Matricula mat = am.buscar(codMat);
			mat.setCodAlumno(codAlu);
			mat.setCodCurso(codCur);
			mat.setCodDocente(codDoc);
			mat.setFecha(fecha);
			mat.setHora(hora);
			am.grabarMatriculas();
			btnModificar.setEnabled(true);
		}
		listar();
		habilitarEntradas(false);

	}

	void eliminar() {
		if (am.tamanio() == 0) {
			noExistenMatriculasMensaje();
			habilitarBotones(true);
			return;
		}

		if (leerCodigoMatricula() == -1 ||
				leerCodigoAlumno() == -1) {
			habilitarBotones(true);
			// consultar();
			return;
		}

		int codAlu = leerCodigoAlumno();
		if (aa.buscar(codAlu).getEstado() == 2) {
			Utils.message("Alumno retirado, no se puede cancelar la Matrícula", this);
		}

		// btnAdicionar.setEnabled(true);
		// btnModificar.setEnabled(true);
		// btnEliminar.setEnabled(false);

		editarFila();
		habilitarEntradas(false);

		int result = Utils.prompt("Eliminar matrícula?", this);
		if (result == 0) {
			am.eliminar(am.buscar(leerCodigoMatricula()));
			aa.cambiarEstado(codAlu, 0);
			am.grabarMatriculas();
			aa.grabarAlumnos();
			listar();
			editarFila();
		}

		habilitarBotones(true);
	}

	public void consultarAlumno() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Nombres");
		model.addColumn("A Paterno");
		model.addColumn("A Materno");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");
		try {
			DlgMatriculas dialog = new DlgMatriculas(model, Tipo.Alumno);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarCurso() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Ciclo");
		model.addColumn("Créditos");
		model.addColumn("Horas");
		model.addColumn("Asignatura");
		try {
			DlgMatriculas dialog = new DlgMatriculas(model, Tipo.Curso);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarDocente() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Nombres");
		model.addColumn("A Paterno");
		model.addColumn("A Materno");
		model.addColumn("Dni");
		model.addColumn("Celular");
		model.addColumn("Especialidad");
		model.addColumn("Fecha Ingreso");
		try {
			DlgMatriculas dialog = new DlgMatriculas(model, Tipo.Docente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarAlumno(int cod) {
		txtCodAlumno.setText(cod + "");
	}

	public void consultarCurso(int cod) {
		txtCodCurso.setText(cod + "");
	}

	public void consultarDocente(int cod) {
		txtCodDocente.setText(cod + "");
	}

	public void getCodCursoFromDialog(int cod) {
		txtCodCurso.setText(cod + "");
	}

	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblMatricula.getSelectedRow();
		if (model.getRowCount() == am.tamanio() - 1)
			posFila = am.tamanio() - 1;
		if (posFila == am.tamanio())
			posFila--;
		model.setRowCount(0);
		Matricula m;
		Alumno a;
		Curso c;
		Docente d;
		for (int i = 0; i < am.tamanio(); i++) {
			m = am.obtener(i);
			a = aa.buscar(m.getCodAlumno());
			c = ac.buscar(m.getCodCurso());
			d = ad.buscar(m.getCodDocente());
			Object[] fila = {
					m.getCodAlumno(),
					a.getNombres(),
					c.getAsignatura(),
					d.getNombres(),
					m.getFecha(),
					m.getHora(),
					Lib.estadosAlumno[a.getEstado()]
			};
			model.addRow(fila);
		}
		if (aa.tamanio() > 0)
			tblMatricula.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblMatricula.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(20));

	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	void habilitarEntradas(boolean value) {
		btnAceptar.setEnabled(value);
		txtCodigo.setEditable(value);
		txtCodAlumno.setEditable(value);
		txtCodCurso.setEditable(value);
		txtCodDocente.setEditable(value);
	}

	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}

	protected void mouseClickedTblMatricula(MouseEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblMatricula) {
			mouseClickedTblMatricula(e);
			;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodAlumno) {
			do_textField_keyTyped(e);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCodAlumno) {
			do_textField_keyTyped(e);
		}
		if (e.getSource() == txtCodDocente) {
			do_txtCodDocente_keyReleased(e);
		}
		if (e.getSource() == txtCodCurso) {
			do_txtCodCurso_keyReleased(e);
		}
		if (e.getSource() == tblMatricula) {
			e.consume();
			editarFila();
		}

	}

	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		btnAdicionar.setEnabled(false);
		btnConsultar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);

		clear();
		habilitarEntradas(true);
		txtCodigo.setEditable(false);

		txtCodAlumno.requestFocus();
	}

	void clear() {
		txtCodigo.setText("" + am.codigoCorrelativo());
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
		txtCodDocente.setText("");
	}

	void modificar() {
		if (am.tamanio() == 0) {
			habilitarEntradas(false);
			noExistenMatriculasMensaje();
			habilitarBotones(true);
			return;
		}

		habilitarBotones(false);

		editarFila();
		habilitarEntradas(false);
		txtCodCurso.setEditable(true);
		txtCodCurso.requestFocus();

	}

	void noExistenMatriculasMensaje() {
		Utils.message("No existen matriculas", this);
	}

	void editarFila() {
		if (am.tamanio() == 0)
			clear();
		else {
			Matricula m = am.obtener(tblMatricula.getSelectedRow());
			txtCodigo.setText("" + m.getNumMatricula());
			txtCodAlumno.setText("" + m.getCodAlumno());
			txtCodCurso.setText("" + m.getCodCurso());
			txtCodDocente.setText("" + m.getCodDocente());
		}
	}

	int leerCodigoMatricula() {
		try {
			return Integer.parseInt(txtCodigo.getText().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	int leerCodigoAlumno() {
		try {
			return Integer.parseInt(txtCodAlumno.getText().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	int leerCodigoCurso() {
		try {
			return Integer.parseInt(txtCodCurso.getText().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	int leerCodigoDocente() {
		try {
			return Integer.parseInt(txtCodDocente.getText().trim());
		} catch (Exception e) {
			return -1;
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	protected void do_textField_keyTyped(KeyEvent e) {
		consultarAlumno();
	}

	protected void do_txtCodAlumno_keyReleased(KeyEvent e) {

	}

	protected void do_txtCodCurso_keyReleased(KeyEvent e) {
		consultarCurso();
	}

	protected void do_txtCodDocente_keyReleased(KeyEvent e) {
		consultarDocente();
	}
}
