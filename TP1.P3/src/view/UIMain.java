package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class UIMain {

	private JFrame frame;
	private static JPanelGrafo panelGrafo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMain window = new UIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelGrafo=new JPanelGrafo();
		frame.add(panelGrafo);
		
		
	}
	
	
	public void mostrar() {
		
		
	}
	
	
	

}
