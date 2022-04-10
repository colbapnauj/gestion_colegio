package helpers;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Utils {
	public enum Tipo {
		Curso,
		Alumno,
		Docente,
		Matricula
	}
	
	public static void message(String s, JInternalFrame frm) {
		JOptionPane.showMessageDialog(frm, s, "Information", 0);
	}
	
	
	public static void error(String s, JTextField txt, JInternalFrame frm) {
		message(s, frm);
		txt.setText("");
		txt.requestFocus();
	}
	
	public static int prompt(String s, JInternalFrame frm) {
		return JOptionPane.showConfirmDialog(frm, s, "Alerta", 0, 1, null);
	}
	
	public static int leerTxtInt(JTextField txt) {
		try {
			return Integer.parseInt(txt.getText().trim());
		} catch (Exception e) {
			return -1;
		}
		
	}
	
	public static int anchoColumna(int porcentaje, JScrollPane scrollP) {
		return porcentaje * scrollP.getWidth() / 100;
	}
	

}
