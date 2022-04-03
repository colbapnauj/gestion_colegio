package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame implements ActionListener {

    private JLabel lblFondo;
    private JMenuBar menuHome;
    private JMenu mnMantenimiento;
    private JMenu mnRegistro;
    private JMenu mnConsulta;
    private JMenu mnReporte;
    private JMenuItem mntmAlumno;
    private JMenuItem mntmCurso;
    private JMenuItem mntmDocente;
    private JMenuItem mntmMatricula;
    private JMenuItem mntmRetiro;
    private JMenuItem mntmCAlumnos;
    private JMenuItem mntmCCursos;
    private JMenuItem mntmCDocentes;
    private JMenuItem mntmCMatriculas;
    private JMenuItem mntmCRetiros;
    private JMenuItem mntmMatriculaPendiente;
    private JMenuItem mntmMatriculaVigente;
    private JMenuItem mntmRetirados;
    private JMenuItem mntmMatriculadosPorCurso;
    private JMenuItem mntmDocentesConCargaHoraria;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Home() {
		int ancho = 950;
		int alto = 700;
		int dx = 6;
		int dy = 52;
		
		setResizable(false);
		setTitle("Project - Home");
		// TODO Colocar una icon image
//		setIconImage(new ImageIcon(""));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho + dx, alto + dy);
		this.setLocationRelativeTo(null);
		
		
		menuHome = new JMenuBar();
		setJMenuBar(menuHome);
		
        mnMantenimiento = new JMenu("Mantenimiento");
        menuHome.add(mnMantenimiento);

        mntmAlumno = new JMenuItem("Alumno");
        mntmAlumno.addActionListener(this);
        mnMantenimiento.add(mntmAlumno);

        mntmCurso = new JMenuItem("Curso");
        mntmCurso.addActionListener(this);
        mnMantenimiento.add(mntmCurso);

        mntmDocente = new JMenuItem("Docente");
        mntmDocente.addActionListener(this);
        mnMantenimiento.add(mntmDocente);

        mnRegistro = new JMenu("Registro");
        menuHome.add(mnRegistro);

        mntmMatricula = new JMenuItem("Matricula");
        mntmMatricula.addActionListener(this);
        mnRegistro.add(mntmMatricula);

        mntmRetiro = new JMenuItem("Retiro");
        mntmRetiro.addActionListener(this);
        mnRegistro.add(mntmRetiro);

        mnConsulta = new JMenu("Consulta");
        menuHome.add(mnConsulta);

        mntmCAlumnos = new JMenuItem("CAlumnos");
        mntmCAlumnos.addActionListener(this);
        mnConsulta.add(mntmCAlumnos);

        mntmCCursos = new JMenuItem("CCursos");
        mntmCCursos.addActionListener(this);
        mnConsulta.add(mntmCCursos);

        mntmCDocentes = new JMenuItem("CDocentes");
        mntmCDocentes.addActionListener(this);
        mnConsulta.add(mntmCDocentes);

        mntmCMatriculas = new JMenuItem("CMatriculas");
        mntmCMatriculas.addActionListener(this);
        mnConsulta.add(mntmCMatriculas);

        mntmCRetiros = new JMenuItem("CRetiros");
        mntmCRetiros.addActionListener(this);
        mnConsulta.add(mntmCRetiros);

        mnReporte = new JMenu("Reporte");
        menuHome.add(mnReporte);

        mntmMatriculaPendiente = new JMenuItem("Alumnos con matrícula pendiente");
        mntmMatriculaPendiente.addActionListener(this);
        mnReporte.add(mntmMatriculaPendiente);

        mntmMatriculaVigente = new JMenuItem("Alumnos con matrícula vigente");
        mntmMatriculaVigente.addActionListener(this);
        mnReporte.add(mntmMatriculaVigente);

        mntmRetirados = new JMenuItem("Alumnos retirados");
        mntmRetirados.addActionListener(this);
        mnReporte.add(mntmRetirados);

        mntmMatriculadosPorCurso = new JMenuItem("Alumnos matriculados por curso");
        mntmMatriculadosPorCurso.addActionListener(this);
        mnReporte.add(mntmMatriculadosPorCurso);

        mntmDocentesConCargaHoraria = new JMenuItem("Docentes con carga horaria")		;
        mntmDocentesConCargaHoraria.addActionListener(this);
        mnReporte.add(mntmDocentesConCargaHoraria);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblFondo = new JLabel(new ImageIcon("imagenes/background.jpg"));
        lblFondo.setBounds(0, 0, ancho, alto);
        getContentPane().add(lblFondo);
	}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmAlumno)  {
            actionPerformedMntmAlumno(e);
        }
        if (e.getSource() == mntmCurso)  {
            actionPerformedMntmCurso(e);
        }
        if (e.getSource() == mntmDocente)  {
            actionPerformedMntmDocente(e);
        }
        if (e.getSource() == mntmMatricula)  {
            actionPerformedMntmMatricula(e);
        }
        if (e.getSource() == mntmRetiro)  {
            actionPerformedMntmRetiro(e);
        }
        if (e.getSource() == mntmCAlumnos)  {
            actionPerformedMntmCAlumnos(e);
        }
        if (e.getSource() == mntmCCursos)  {
            actionPerformedMntmCCursos(e);
        }
        if (e.getSource() == mntmCDocentes)  {
            actionPerformedMntmCDocentes(e);
        }
        if (e.getSource() == mntmCMatriculas)  {
            actionPerformedMntmCMatriculas(e);
        }
        if (e.getSource() == mntmCRetiros)  {
            actionPerformedMntmCRetiros(e);
        }
        if (e.getSource() == mntmMatriculaPendiente)  {
            actionPerformedMntmMatriculaPendiente(e);
        }
        if (e.getSource() == mntmMatriculaVigente)  {
            actionPerformedMntmMatriculaVigente(e);
        }
        if (e.getSource() == mntmRetirados)  {
            actionPerformedMntmRetirados(e);
        }
        if (e.getSource() == mntmMatriculadosPorCurso)  {
            actionPerformedMntmMatriculadosPorCurso(e);
        }
        if (e.getSource() == mntmDocentesConCargaHoraria)  {
            actionPerformedMntmDocentesConCargaHoraria(e);
        }
    }

    protected void actionPerformedMntmAlumno(ActionEvent arg0) {
        FrmAlumno fa = new FrmAlumno();
        contentPane.add(fa);
        
        Dimension contentSize = contentPane.getSize();
        Dimension frameSize = fa.getSize();
        fa.setLocation((contentSize.width - frameSize.width) / 2, (contentSize.height - frameSize.height) / 2);
        fa.setVisible(true);
        

    }
    protected void actionPerformedMntmCurso(ActionEvent arg0) {
    	FrmCurso fc = new FrmCurso();
        contentPane.add(fc);
        
        Dimension contentSize = contentPane.getSize();
        Dimension frameSize = fc.getSize();
        fc.setLocation((contentSize.width - frameSize.width) / 2, (contentSize.height - frameSize.height) / 2);
        fc.setVisible(true);

    }
    protected void actionPerformedMntmDocente(ActionEvent arg0) {

    }
    protected void actionPerformedMntmMatricula(ActionEvent arg0) {

    }
    protected void actionPerformedMntmRetiro(ActionEvent arg0) {

    }
    protected void actionPerformedMntmCAlumnos(ActionEvent arg0) {
    	ConsultaAlumno fca = new ConsultaAlumno();
        contentPane.add(fca);
        
        Dimension contentSize = contentPane.getSize();
        Dimension frameSize = fca.getSize();
        fca.setLocation((contentSize.width - frameSize.width) / 2, (contentSize.height - frameSize.height) / 2);
        fca.setVisible(true);

    }
    protected void actionPerformedMntmCCursos(ActionEvent arg0) {

    }
    protected void actionPerformedMntmCDocentes(ActionEvent arg0) {

    }
    protected void actionPerformedMntmCMatriculas(ActionEvent arg0) {

    }
    protected void actionPerformedMntmCRetiros(ActionEvent arg0) {

    }
    protected void actionPerformedMntmMatriculaPendiente(ActionEvent arg0) {

    }
    protected void actionPerformedMntmMatriculaVigente(ActionEvent arg0) {

    }
    protected void actionPerformedMntmRetirados(ActionEvent arg0) {

    }
    protected void actionPerformedMntmMatriculadosPorCurso(ActionEvent arg0) {

    }	
    protected void actionPerformedMntmDocentesConCargaHoraria(ActionEvent arg0) {
            
    }


}
