package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VentanaPrincipal {

	private JFrame frame;

	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		this.frame = new JFrame();

		frame.setBounds(100, 100, 537, 364);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	
	public void mostrar() {
		this.frame.setVisible(true);
	}
}
