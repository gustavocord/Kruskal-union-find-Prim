package view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JPanelResultado extends JPanel {

	/**
	 * Create the panel.
	 */
	private JLabel lblJugador;
	private JLabel img = new JLabel(" ");
	private ImageIcon imagenPerdio =new ImageIcon(getClass().getResource("/imagenes/perdio.jpg"));
	private ImageIcon imagenGano =new ImageIcon(getClass().getResource("/imagenes/gano.jpg"));

	

	
	public JPanelResultado () {

		try {   //cambio de estilo, en las ventanas
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			((Throwable) e).printStackTrace();
		}
		
		this.setBounds(0, 0, 521, 325);
		
		// Seteamos el tamaño de la imagen , la ubicacion y lo hacemos visible
		img.setSize(135,135);
		img.setLocation(550,20);
		img.setVisible(true);
		
		
		lblJugador = new JLabel();
		lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblJugador.setBounds(152, 38, 234, 49);
		add(lblJugador);
		add(img);
		
	
	}
	
	
	public void mostrarResultado(boolean resultado) {
		if (resultado) {
			img.setIcon(imagenGano);
			this.lblJugador.setText("Felicidades ganaste");
			
		}
		else {
			img.setIcon(imagenPerdio);
			this.lblJugador.setText("upps se le terminaron los movimientos");
			
		}
	}

	}
