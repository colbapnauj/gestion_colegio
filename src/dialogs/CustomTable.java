package dialogs;

import javax.swing.JTable;
import javax.swing.KeyStroke;

public class CustomTable extends JTable {
	 
    public CustomTable() {
    	super.getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("ENTER"), "moveFocus");
    }
}