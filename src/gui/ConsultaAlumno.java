package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import arreglos.ArregloAlumnos;
import arreglos.ArregloMatriculas;
import clases.Alumno;
import clases.Matricula;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsultaAlumno extends JInternalFrame {
	private JButton btnNewButton;
	private JButton btnCerrar;
	private JTextField txtCodAlu;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloMatriculas am = new ArregloMatriculas();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAlumno frame = new ConsultaAlumno();
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
	public ConsultaAlumno() {
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(376, 62, 105, 27);
		getContentPane().add(btnNewButton);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnCerrar.setForeground(Color.BLUE);
		btnCerrar.setBounds(376, 95, 100, 23);
		getContentPane().add(btnCerrar);
		
		txtCodAlu = new JTextField();
		txtCodAlu.setBounds(206, 65, 114, 21);
		getContentPane().add(txtCodAlu);
		txtCodAlu.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 130, 449, 273);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		int cod = leerCodigoAlumno();
		try {
			Alumno alumno = aa.buscar(cod);
			if (alumno != null) {
				mostrarDatos(alumno);
				
				
			} else {
				txtS.setText("");
				imprimir("Alumno no existe");
			}
			
		} catch (Exception e1){
			System.out.println(e1);
		}
		
	}
	
	void mostrarDatos(Alumno a) {
		txtS.setText("");
		imprimir("Nombres\t: " + a.getNombres());
		
		a.setEstado(1);
		
		// Mostrar si está matriculado
		if (a.getEstado() == 1) {
			
//			Matricula matricula = am.buscar(a.getCodAlumno());
			Matricula matricula = new Matricula(1, a.getCodAlumno(), 2, 3,  "fecha", "hora");
			imprimir("codMatricula\t: " + matricula.getCodCurso());
		}
		
	}
	
	void imprimir() {
		txtS.append("\n");
	}
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void cerrar() {
		this.dispose();
	}
	
	int leerCodigoAlumno() {
		return Integer.parseInt(txtCodAlu.getText().trim());
	}
}
