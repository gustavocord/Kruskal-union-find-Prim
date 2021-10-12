package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class VentanaPrincipal {

	private JFrame frame;
	private HubPanel hubPanel;
	public VentanaPrincipal() {
		initialize();
		hubPanel = new HubPanel();
		this.frame.getContentPane().add(hubPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.frame.setBounds(0, 0, 800, 600);
		this.frame.setLocationRelativeTo(null); //centra la ventana
		this.frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void mostrar() {
		frame.setVisible(true);
	}
	public JFrame getFrame() {
		return frame;
	}
	public HubPanel getHubPanel() {
		return hubPanel;
	}
	public int cantidadDeVertices() {
		return (int) this.hubPanel.getSpinnerVertices().getValue();
	}
	public int cantidadDeAristas() {
		return (int) this.hubPanel.getSpinnerAristas().getValue();
	}
	public void actualizarGrafica(long bfs, long unionFindV1, long unionFindV2, long bfsOptimizado, long unionFindV1Optimizado, long unionFindV2Optimizado) {
		this.hubPanel.getGraficoPanel().actualizarGrafica(bfs, unionFindV1, unionFindV2,bfsOptimizado, unionFindV1Optimizado, unionFindV2Optimizado);
	}
}
