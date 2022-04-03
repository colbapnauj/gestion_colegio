package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import libreria.Lib;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmMatricula extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JLabel lblAlumno;
	private JTextField textField;
	private JTextField txtCurso;
	private JLabel lblCurso;
	private JLabel lblDocente;
	private JTextField txtDocente;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private DefaultTableModel model;
	
	private ArregloMatriculas am = new ArregloMatriculas();
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloCursos ac = new ArregloCursos();
	private ArregloDocentes ad = new ArregloDocentes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMatricula frame = new FrmMatricula();
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
		
		textField = new JTextField();
		textField.addKeyListener(this);
		textField.setBounds(180, 70, 114, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(180, 103, 114, 21);
		getContentPane().add(txtCurso);
		txtCurso.setColumns(10);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(48, 105, 60, 17);
		getContentPane().add(lblCurso);
		
		lblDocente = new JLabel("Docente");
		lblDocente.setBounds(48, 134, 60, 17);
		getContentPane().add(lblDocente);
		
		txtDocente = new JTextField();
		txtDocente.setColumns(10);
		txtDocente.setBounds(180, 132, 114, 21);
		getContentPane().add(txtDocente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 550, 200);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.addKeyListener(this);
		tblMatricula.addMouseListener(this);
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);

		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Alumno");
		model.addColumn("Curso");
		model.addColumn("Docente");
		model.addColumn("Fecha de matrícula");
		model.addColumn("Hora de matrícula");
		
//		habilitarEntradas(false);
//		 ajustarAnchoColumnas();
		 listar();
//		 editarFila();


	}

	public void actionPerformed(ActionEvent e) {
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if (e.getSource() == textField) {
			do_textField_keyTyped(e);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	protected void do_textField_keyTyped(KeyEvent e) {

	}
}
