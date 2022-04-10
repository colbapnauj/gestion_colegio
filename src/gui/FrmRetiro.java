package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloAlumnos;
import arreglos.ArregloMatriculas;
import arreglos.ArregloRetiros;
import clases.Alumno;
import clases.Matricula;
import clases.Retiro;
import helpers.Utils;
import libreria.Lib;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FrmRetiro extends JInternalFrame implements ActionListener, KeyListener, MouseListener{
	private JLabel lblCod;
	private JLabel lblCodMat;
	private JTextField txtCod;
	private JTextField txtCodMat;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private JScrollPane scrollPane;
	private JTable tblRetiro;
	private DefaultTableModel model;
	
	private ArregloRetiros ar = new ArregloRetiros();
	private ArregloMatriculas am = new ArregloMatriculas();
	private ArregloAlumnos aa = new ArregloAlumnos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRetiro frame = new FrmRetiro();
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
	public FrmRetiro() {
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);
		
		lblCod = new JLabel("Código");
		lblCod.setBounds(55, 42, 130, 17);
		getContentPane().add(lblCod);
		
		lblCodMat = new JLabel("Número de Matrícula");
		lblCodMat.setBounds(55, 71, 130, 17);
		getContentPane().add(lblCodMat);
		
		txtCod = new JTextField();
		txtCod.setBounds(215, 40, 114, 21);
		getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
		txtCodMat = new JTextField();
		txtCodMat.setBounds(215, 69, 114, 21);
		getContentPane().add(txtCodMat);
		txtCodMat.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(341, 37, 105, 27);
		getContentPane().add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(473, 37, 105, 27);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(473, 76, 105, 27);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(473, 115, 105, 27);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(473, 154, 105, 27);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 220, 550, 200);
		getContentPane().add(scrollPane);
		
		tblRetiro = new JTable();
		tblRetiro.addKeyListener(this);
		tblRetiro.addMouseListener(this);
		tblRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiro);

		model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Código Matricula");
		model.addColumn("Alumno");
		model.addColumn("Curso");
		model.addColumn("Docente");
		model.addColumn("Estado");

		tblRetiro.setModel(model);

		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			aceptar();
		}
		if (e.getSource() == btnAdicionar) {
			adicionar();
		}
		if (e.getSource() == btnConsultar) {
			consultar();
		}
		if (e.getSource() == btnModificar) {
			modificar();
		}
		if (e.getSource() == btnEliminar) {
			eliminar();
		}
	}
	
	void aceptar() {
		int codRet = Utils.leerTxtInt(txtCod);
		int codMat = Utils.leerTxtInt(txtCodMat);
		
		// Manejar el ingreso o búsqueda de Alumno
		
		if (codRet == -1) {
			Utils.error("Error al ingresar el número de Retiro", txtCod, this);
			return;
		}
		if (codMat == -1) {
			Utils.error("Error al ingresar el número de Matrícula", txtCodMat, this);
			return;
		}
		
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
	    String fecha = date.format(LocalDateTime.now());
		String hora = time.format(LocalDateTime.now());
		
		Matricula m = am.buscar(codMat);
		
		
		if (btnAdicionar.isEnabled() == false) {
			Retiro r = new Retiro(codRet, codMat, fecha, hora);
			ar.adicionar(r);
			aa.cambiarEstado(m.getCodAlumno(), 2);
			
			aa.grabarAlumnos();
			ar.grabarRetiros();
			
			btnAdicionar.setEnabled(true);
		}
		
		if (btnModificar.isEnabled() == false) {
			// TODO Consultar
			Retiro r = ar.buscar(codMat);
			r.setNumRetiro(codRet);
			r.setNumMatricula(codMat);
			r.setFecha(fecha);
			r.setHora(hora);
			ar.grabarRetiros();
			btnModificar.setEnabled(true);
		}
		listar();
		habilitarEntradas(false);
		

		
	}
	
	void adicionar() {
		btnAdicionar.setEnabled(false);
		btnConsultar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);

		clear();
		habilitarEntradas(true);
		txtCod.setEditable(false);
		txtCodMat.requestFocus();
	}
	
	void consultar() {
		
	}
	
	void modificar() {
		// TODO Sólo puede cambiar en cualquier momento el curso de una matrícular desactivada
		if (am.tamanio() == 0) {
			habilitarEntradas(false);
			noExistenRetirosMensaje();
			habilitarBotones(true);
			return;	
		}
		
		habilitarBotones(false);
		
		editarFila();
		habilitarEntradas(false);
		txtCod.setEditable(true);
		txtCodMat.requestFocus();
	}
	
	void eliminar() {
		if (ar.tamanio() == 0) {
			noExistenRetirosMensaje();
			habilitarBotones(true);
			return;
		}
		int codRet = Utils.leerTxtInt(txtCod);
		int codMat = Utils.leerTxtInt(txtCodMat);
		if ( codRet == -1 || codMat== -1) {
			habilitarBotones(true);
			consultar();
			return;
		}
		
		int codAlu = am.buscar(codMat).getCodAlumno();
		int estadoAlu = aa.buscar(codAlu).getEstado();
		if (estadoAlu != 2) {
			Utils.message("No se puede cancelar el retiro", this);
		}	
		
		editarFila();
		habilitarEntradas(false);

		int result = Utils.prompt("Cancelar retiro?", this);
		if (result == 0) {
			ar.eliminar(ar.buscar(codRet));
			aa.cambiarEstado(codAlu, 1);
			ar.grabarRetiros();
			aa.grabarAlumnos();
			listar();
			editarFila();
		}
		
		habilitarBotones(true);
	}
	
	void editarFila() {
		if (ar.tamanio() == 0)
			clear();
		else {
			Retiro r = ar.obtener(tblRetiro.getSelectedRow());
			txtCod.setText("" + r.getNumRetiro());
			txtCodMat.setText("" + r.getNumMatricula());	
		}
	}
	
	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblRetiro.getSelectedRow();
		if (model.getRowCount() == ar.tamanio() - 1)
			posFila = ar.tamanio() - 1;
		if (posFila == ar.tamanio())
			posFila--;
		model.setRowCount(0);
		Retiro r;
		for (int i = 0; i < ar.tamanio(); i++) {
			r = ar.obtener(i);
			Object[] fila = {
				r.getNumRetiro(),
				r.getNumMatricula(),
				r.getFecha(),
				r.getHora(),
			};
			model.addRow(fila);
		}
		if (ar.tamanio() > 0)
			tblRetiro.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void clear() {
		txtCod.setText("" + ar.codigoCorrelativo());
		txtCodMat.setText("");
		

	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblRetiro.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(Utils.anchoColumna(20, scrollPane));
		tcm.getColumn(1).setPreferredWidth(Utils.anchoColumna(20, scrollPane));
		tcm.getColumn(2).setPreferredWidth(Utils.anchoColumna(20, scrollPane));
		tcm.getColumn(3).setPreferredWidth(Utils.anchoColumna(20, scrollPane));
		tcm.getColumn(4).setPreferredWidth(Utils.anchoColumna(20, scrollPane));
		tcm.getColumn(5).setPreferredWidth(Utils.anchoColumna(20, scrollPane));
	}

	
	void habilitarEntradas(boolean value) {
		btnAceptar.setEnabled(value);
		txtCod.setEditable(value);
		txtCodMat.setEditable(value);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	
	void noExistenRetirosMensaje() {
		Utils.message("No existen retiros", this);
	}


	@Override
	public void keyReleased(KeyEvent e) {
	if (e.getSource() == tblRetiro) {
		e.consume();
		editarFila();	
	}	

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
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}
