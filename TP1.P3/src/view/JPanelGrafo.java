package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;

public class JPanelGrafo extends JPanel {
	
	private static JLabel vertice;
	private static JLabel arista;
	private JTextField textField;
	private JTextField textField_1;



	/**
	 * Create the panel.
	 */
	public JPanelGrafo() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ingrese vertice y arista");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 410, 29);
		add(lblNewLabel);
		
		textField = new JTextField("ingrese vertice");
		textField.setBounds(10, 48, 186, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("Ingrese arista");
		textField_1.setBounds(10, 79, 186, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		
	}
}
