package dialogs;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloDocentes;
import arreglos.ArregloMatriculas;
import clases.Alumno;
import clases.Curso;
import clases.Docente;
import clases.Matricula;
import gui.FrmMatricula;
import helpers.Utils.Tipo;
import libreria.Lib;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyEvent;

public class DlgMatriculas extends JDialog implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtValue;
	private JLabel lblSearch;
	private JScrollPane scrollPane;
	private CustomTable tblData;
	private DefaultTableModel model;
	private TableRowSorter<TableModel> trsfiltro;
	private ArregloMatriculas am = new ArregloMatriculas();
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloCursos ac = new ArregloCursos();
	private ArregloDocentes ad = new ArregloDocentes();
	private Matricula m;
	private Tipo tipo;
	FrmMatricula frmMat = FrmMatricula.getInstance();
	
	String filtro;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DlgMatriculas dialog = new DlgMatriculas();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DlgMatriculas(DefaultTableModel model, Tipo tipo) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		txtValue = new JTextField();
		txtValue.addKeyListener(this);
		txtValue.setBounds(12, 53, 219, 21);
		contentPanel.add(txtValue);
		txtValue.setColumns(10);
		
		lblSearch = new JLabel("Buscar - cod o nombre");
		lblSearch.setBounds(12, 24, 189, 17);
		contentPanel.add(lblSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.addKeyListener(this);
		scrollPane.setBounds(12, 99, 415, 175);
		contentPanel.add(scrollPane);
		
		tblData = new CustomTable();
		tblData.addKeyListener(this);
		tblData.setDragEnabled(false);
		scrollPane.setViewportView(tblData);
		
		
//		model = new DefaultTableModel();
//		model.addColumn("Código");
//		model.addColumn("Alumno");
//		model.addColumn("Curso");
//		model.addColumn("Docente");
//		model.addColumn("Fecha de matrícula");
//		model.addColumn("Hora de matrícula");
		
		this.model = model;
		this.tipo = tipo;
		tblData.setModel(this.model);
		trsfiltro = new TableRowSorter<TableModel>(tblData.getModel());
		listar();
		
	}
	
	void filtro() {
        filtro = txtValue.getText();
        
        Pattern pat = Pattern.compile("^2.*");
        Matcher mat = pat.matcher(filtro);                                                                           
        if (mat.matches()) {
        	// System.out.println("SI");
        	trsfiltro.setRowFilter(RowFilter.regexFilter(filtro, 0));
        } else {
            // System.out.println("NO");                                                                                
            trsfiltro.setRowFilter(RowFilter.regexFilter(filtro, 1));
        }
       
        
    }
	
	void listar() {
		
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblData.getSelectedRow();
		if (model.getRowCount() == am.tamanio() - 1)
			posFila = am.tamanio() - 1;
		if (posFila == am.tamanio())
			posFila--;
		model.setRowCount(0);
		Matricula m;
		Alumno a;
		Curso c;
		Docente d;
		
			
			switch(this.tipo) {
			case Matricula:
				for (int i = 0; i < am.tamanio(); i++) {
					m = am.obtener(i);
					a = aa.buscar(m.getCodAlumno());
					c = ac.buscar(m.getCodCurso());
					d = ad.buscar(m.getCodDocente());
				Object[] filaMat = {
				m.getCodAlumno(),
				a.getNombres(),
				c.getAsignatura(),
				d.getNombres(),
				m.getFecha(),
				m.getHora(),
				Lib.estadosAlumno[a.getEstado()]
				
			};
			
			
			model.addRow(filaMat);
				}
				if (am.tamanio() > 0)
					tblData.getSelectionModel().setSelectionInterval(posFila, posFila);
			
			break;
			case Alumno:
				ArregloAlumnos aa = new ArregloAlumnos();
				for (int i = 0; i < aa.tamanio(); i++) {
					a = aa.obtener(i);
				Object[] filaAlu = {
						a.getCodAlumno(),
						a.getNombres(),
						a.getApellidoPaterno(),
						a.getApellidoMaterno(),
						a.getDni(),
						a.getEdad(),
						a.getCelular(),
						Lib.estadosAlumno[a.getEstado()]
					};
					model.addRow(filaAlu);
				}
				if (aa.tamanio() > 0)
					tblData.getSelectionModel().setSelectionInterval(posFila, posFila);
			
			break;
			case Curso:
				for (int i = 0; i < ac.tamanio(); i++) {
					c = ac.buscar(i);
				Object[] filaCur = {
						c.getCodCurso(),
						Lib.cicloCurso[c.getCiclo()],
						c.getCreditos(),
						c.getHoras(),
						c.getAsignatura()
					};
					model.addRow(filaCur);
				}
				if (ac.tamanio() > 0)
					tblData.getSelectionModel().setSelectionInterval(posFila, posFila);
				
				break;
			case Docente:
				for (int i = 0; i < ad.tamanio(); i++) {
					d = ad.obtener(i);
				Object[] filaDoc = {
						d.getCodDocente(),
						d.getNombres(),
						d.getApellidoPaterno(),
						d.getApellidoMaterno(),
						d.getDni(),
						d.getCelular(),
						d.getEspecialidad(),
						d.getFechaIngreso()
					};
					model.addRow(filaDoc);
				}
				break;
			}	
				
//		}
		
		
	}
	
	void do_txtValue_keyReleased(KeyEvent e) {
		int key = e.getKeyChar();
		boolean numerosLetras = key >= 48 && key <= 57 ||key >= 65 && key <= 90 || key >=  97 && key <= 122 || key == 8 || key == 46;
		
		if (numerosLetras) {
			// TODO Guardar en UpperCase
			String cadena = (txtValue.getText()).toUpperCase();
			txtValue.setText(cadena);
			filtro();
			repaint();
			System.out.println(e.getKeyCode());
			if (tblData.getSelectedRow() == -1) {
				tblData.changeSelection(0, 0, false, false);				
			}
			tblData.getSelectedRow();			
		}

		
		if (e.getKeyCode() == 40) {
		tblData.requestFocus();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tblData.requestFocus();
		}
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 27) {
			this.setVisible(false);
		}
	}
	
	void do_tblData_keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int obj = (int) model.getValueAt(tblData.getSelectedRow(), 0);
			System.out.println(obj + "");
			switch( this.tipo ) {
			case Alumno:
				frmMat.consultarAlumno(obj);
				break;
			case Curso:
				frmMat.consultarCurso(obj);
				break;
			case Docente:
				frmMat.consultarDocente(obj);
				break;
			}
						
			
			this.setVisible(false);
//			Matricula _m = am.buscar();
        }
		if (e.getKeyCode() == KeyEvent.VK_F2) {
			txtValue.requestFocus();	
		}
		if (e.getKeyCode() == 27) {
			this.setVisible(false);
		}
}
	
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtValue) {
			do_txtValue_keyReleased(e);
		} 
		if (e.getSource() == tblData) {
			do_tblData_keyReleased(e);
		}
		
		
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtValue) {
			do_txtValue_keyTyped(e);
		}
	}
	protected void do_txtValue_keyTyped(KeyEvent e) {
		trsfiltro = new TableRowSorter<TableModel>(tblData.getModel());
        tblData.setRowSorter(trsfiltro);
        
	}
	protected void do_scrollPane_keyReleased(KeyEvent e) {
		
	}
}


