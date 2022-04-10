package cibertec;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarObsequios extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblObsequio1;
	private JLabel lblObsequio2;
	private JLabel lblObsequio3;
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}


	/**
	 * Create the frame.
	 */
	public ConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 600, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblObsequio1 = new JLabel("1 unidad");
		lblObsequio1.setBounds(12, 30, 155, 15);
		contentPane.add(lblObsequio1);
		
		lblObsequio2 = new JLabel("2 a 5 unidades");
		lblObsequio2.setBounds(12, 57, 155, 15);
		contentPane.add(lblObsequio2);
		
		lblObsequio3 = new JLabel("6 a más unidades");
		lblObsequio3.setBounds(12, 84, 155, 15);
		contentPane.add(lblObsequio3);
		
		txtObsequio1 = new JTextField();
		txtObsequio1.setBounds(200, 28, 114, 19);
		contentPane.add(txtObsequio1);
		txtObsequio1.setColumns(10);
		
		txtObsequio2 = new JTextField();
		txtObsequio2.setColumns(10);
		txtObsequio2.setBounds(200, 55, 114, 19);
		contentPane.add(txtObsequio2);
		
		txtObsequio3 = new JTextField();
		txtObsequio3.setColumns(10);
		txtObsequio3.setBounds(200, 82, 114, 19);
		contentPane.add(txtObsequio3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(460, 25, 117, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(460, 52, 117, 25);
		contentPane.add(btnCancelar);
	}
	
	void cargarObsequios() {
//		txtObsequio1.setText(Tienda.obsequio1);
//		txtObsequio2.setText(Tienda.obsequio2);
//		txtObsequio3.setText(Tienda.obsequio3);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	boolean validarObsequios() {
		if (txtObsequio1.getText().trim().startsWith("0") || txtObsequio1.getText().trim().equals("")) return false;
		if (txtObsequio2.getText().trim().startsWith("0") || txtObsequio2.getText().trim().equals("")) return false;
		if (txtObsequio3.getText().trim().startsWith("0") || txtObsequio3.getText().trim().equals("")) return false;
		return true;
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		// TODO Validar campos, solo texto y no pueden ir vacios o si es así no se debe modificar el obsequio
		if (!validarObsequios()) {
			JOptionPane.showMessageDialog(this, "Por valor ingrese un valores válidos diferentes de 0 o espacios en blanco", "Alerta", 3);
			return;
		}
//		Tienda.obsequio1 = txtObsequio1.getText();
//		Tienda.obsequio2 = txtObsequio2.getText();
//		Tienda.obsequio3 = txtObsequio3.getText();
		
		dispose();
	}
}