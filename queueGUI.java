import java.util.*;
import javax.swing.*;
import BreezySwing.*;

public class queueGUI extends GBFrame{
	JLabel inputMessageLabel = addLabel("Input Message:", 1, 1, 1, 1);
	JTextField inputMessageField = addTextField("", 1, 2, 1, 1);
	JLabel inputKeyLabel = addLabel("Input Key (seperate numbers by spaces):", 2, 1, 1, 1);
	JTextField inputKeyField = addTextField("", 2, 2, 1, 1);
	JButton encrypt = addButton("Encrypt", 3, 1, 1, 1);
	JButton decrypt = addButton("Decrypt", 3, 2, 1, 1);
	JTextArea output = addTextArea("", 4, 1, 1, 1);

	private String msg = "";
	private change c = new change();
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == encrypt) {
			output.append((c.encrypt(inputMessageField.getText(), inputKeyField.getText())) + "\n");
		}
		if (buttonObj == decrypt) {
			output.append(c.decrypt(inputMessageField.getText(), inputKeyField.getText()));
		}	
	}
	
	public static void main(String[] args) {
		JFrame frm = new queueGUI();
		frm.setTitle("Encryption Program");
		frm.setSize(1000, 1000);
		frm.setVisible(true);
	}
}