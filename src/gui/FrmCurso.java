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

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import clases.Curso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmCurso extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JLabel lblCodCurso;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JLabel lblAsignatura;
	private JTextField txtCodCurso;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JTextField txtAsignatura;	
	private JComboBox<String> cboCiclo;
	private JButton btnAceptar;
	private JButton btnAdicionar;	
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tblCurso;
	private DefaultTableModel model;

	ArregloCursos ac = new ArregloCursos();

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCurso frame = new FrmCurso();
					// frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCurso() {
		setResizable(false);
		setTitle("Mantenimiento | Curso");
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);

		lblCodCurso = new JLabel("CodCurso");
		lblCodCurso.setBounds(10, 10, 150, 23);
		getContentPane().add(lblCodCurso);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(10, 40, 150, 23);
		getContentPane().add(lblCiclo);
		
		lblCreditos = new JLabel("Créditos");
		lblCreditos.setBounds(10, 70, 150, 23);
		getContentPane().add(lblCreditos);

		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(10, 100, 150, 23);
		getContentPane().add(lblHoras);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(10, 130, 150, 23);
		getContentPane().add(lblAsignatura);

		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(200, 10, 100, 23);
		getContentPane().add(txtCodCurso);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(200, 70, 100, 23);
		getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);

		txtHoras = new JTextField();
		txtHoras.setBounds(200, 100, 100, 23);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);

		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(200, 130, 100, 23);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);

		cboCiclo = new JComboBox<String>();
		cboCiclo.setEnabled(true);
		cboCiclo.setModel(new DefaultComboBoxModel<String>(Lib.cicloCurso));
		cboCiclo.setBounds(200, 40, 100, 23);
		getContentPane().add(cboCiclo);

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

		tblCurso = new JTable();
		tblCurso.addKeyListener(this);
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);

		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Ciclo");
		model.addColumn("Créditos");
		model.addColumn("Horas");
		model.addColumn("Asignatura");

		tblCurso.setModel(model);

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

		txtCodCurso.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		if (ac.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			noExistenAlumnosMensaje();
		} else {
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtCodCurso.setEditable(false);
			txtCodCurso.requestFocus();
		}


	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0)	 {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(false);
		if (ac.tamanio() == 0)
			noExistenAlumnosMensaje();
		else {
			editarFila();
			habilitarEntradas(false);

//			if (ac.buscar(leerCodCurso()).getEstado() != 0) {
//				message("Para eliminar un perfil el estado debe ser \"Registrado\"");
//			}
			int result = prompt("Eliminar registro?");
			if (result == 0) {
				// TODO Validar que Curso no tenga Alumnos matriculados en él
				ac.eliminar(ac.buscar(pInt(leerCodCurso())));
				ac.grabarCursos();
				listar();
				editarFila();
			}
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codCurso = leerCodCurso();
		int ciclo = leerCiclo();
		String creditos = leerCreditos();
		String horas = leerHoras();
		String asignatura = leerAsignatura();
		
		// TODO Solo se debe permitir el paso de números
		if (codCurso.length() != 4) {
			error("Cod Curso, Debe contener cuatro dígitos", txtCodCurso);
			return;
		}
//		if (ciclo.length() == 0) {
//			error("Nombres, debe completar este campo", txtCiclo);
//			return;
//		}
		// TODO Debe ser menor a 10?
		if (creditos.length() == 0) {
			error("Créditos, debe completar este campo", txtCreditos);
			return;
		}
		// TODO Consultar valor permitido
		if (horas.length() == 0) {
			error("Horas, debe completar este campo", txtHoras);
			return;
		}
		if (asignatura.length() == 0) {
			error("Asignatura , debe completar este campo", txtAsignatura);
			return;
		}
		
		if (btnAdicionar.isEnabled() == false) {
			if (ac.existeCod(pInt(codCurso))) {
				error("Cod ya existe", txtCodCurso);
				return;
			}
			Curso curso= new Curso(pInt(codCurso), ciclo, pInt(creditos), pInt(horas), asignatura );
			ac.adicionar(curso);
			ac.grabarCursos();
			btnAdicionar.setEnabled(true);
			// TODO Ordernar Lista
		}
		if (btnModificar.isEnabled() == false) {
			Curso curso = ac.buscar(pInt(codCurso));
			curso.setCiclo(ciclo);
			curso.setCreditos(pInt(creditos));
			curso.setHoras(pInt(horas));;
			curso.setAsignatura(asignatura);;
			ac.grabarCursos();
			btnModificar.setEnabled(true);
		}

		listar();
		habilitarEntradas(false);
		
	}
	
	int pInt(String value) {
		return Integer.parseInt(value);
	}


	void clear() {
		txtCodCurso .setText("");
//		txtCiclo.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		txtAsignatura.setText("");
	}

	void habilitarEntradas(boolean value) {
		btnAceptar.setEnabled(value);
		txtCodCurso .setEditable(value);
		cboCiclo.setEnabled(value);
		txtCreditos.setEditable(value);
		txtHoras.setEditable(value);
		txtAsignatura .setEditable(value);
	}
	
	void habilitarBotones(boolean value) {
		btnAdicionar.setEnabled(value);
		btnModificar.setEnabled(value);
		// btnEliminar.setEnabled(value);
	}

	void editarFila() {
		if (ac.tamanio() == 0)
			clear();
		else {
			Curso a = ac.obtener(tblCurso.getSelectedRow());
			txtCodCurso.setText("" + a.getCodCurso());
//			txtCiclo.setText("" + a.getCiclo());
			txtCreditos.setText("" + a.getCreditos());
			txtHoras.setText("" + a.getHoras());
			txtAsignatura.setText("" + a.getAsignatura());
		}
	}

	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblCurso.getSelectedRow();
		if (model.getRowCount() == ac.tamanio() - 1)
			posFila = ac.tamanio() - 1;
		if (posFila == ac.tamanio())
			posFila--;
		model.setRowCount(0);
		Curso c;
		///
		ac.ordenar();
		///
		for (int i = 0; i < ac.tamanio(); i++) {
			c = ac.obtener(i);
			Object[] fila = {
				c.getCodCurso(),
				Lib.cicloCurso[c.getCiclo()],
				c.getCreditos(),
				c.getHoras(),
				c.getAsignatura()
			};
			model.addRow(fila);
		}
		if (ac.tamanio() > 0)
			tblCurso.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCurso.getColumnModel();
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

	String leerCodCurso() {
		return txtCodCurso.getText().trim();
	}

	int leerCiclo() {
		return cboCiclo.getSelectedIndex();
	}

	String leerCreditos() {
		return txtCreditos.getText().trim();
	}

	String leerHoras() {
		return txtHoras.getText().trim();
	}

	String leerAsignatura() {
		return txtAsignatura.getText().trim();
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
		if (e.getSource() == tblCurso) {
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
		if (e.getSource() == tblCurso) {
			e.consume();
			editarFila();	
		}	
	}


}
