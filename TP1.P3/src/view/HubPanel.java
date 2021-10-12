package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

public class HubPanel extends JPanel {
	private JButton btnGenerar;
	private GraficosPanel graficoPanel;
	private JSpinner spinnerVertices, spinnerAristas;
	private JLabel txtCantVertices, txtCantAristas;
	public HubPanel() {
		setLayout(null);
		//el panel del grafico
		this.graficoPanel = new GraficosPanel();
		this.graficoPanel.setBounds(10, 11, 765, 476);
		add(this.graficoPanel);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(655, 508, 120, 43);
		add(btnGenerar);

		txtCantVertices = new JLabel("Cantidad de Vertices:");
		txtCantVertices.setBounds(87, 508, 136, 49);
		add(txtCantVertices);
		
		txtCantAristas = new JLabel("Cantidad de Aristas:");
		txtCantAristas.setBounds(353, 508, 128, 49);
		add(txtCantAristas);

		spinnerVertices = new JSpinner();
		spinnerVertices.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerVertices.setBounds(233, 522, 54, 20);
		add(spinnerVertices);
		
		spinnerAristas = new JSpinner();
		spinnerAristas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerAristas.setBounds(491, 522, 54, 20);
		add(spinnerAristas);
	}
	public JButton getBtnGenerar() {
		return btnGenerar;
	}
	public GraficosPanel getGraficoPanel() {
		return graficoPanel;
	}
	public JSpinner getSpinnerVertices() {
		return spinnerVertices;
	}
	public JSpinner getSpinnerAristas() {
		return spinnerAristas;
	}
	public JLabel getTxtCantVertices() {
		return txtCantVertices;
	}
	public JLabel getTxtCantAristas() {
		return txtCantAristas;
	}
	
}
