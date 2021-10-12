package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logica.GrafoConPeso;
import logica.TiempoDeEjecucion;

public class Main {

	private VentanaPrincipal ventana;
	private JButton btnGenerar;
	
	public Main(VentanaPrincipal ventana) {
		
		this.ventana= ventana;
		this.btnGenerar= this.ventana.getHubPanel().getBtnGenerar();
		
		this.btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantDeVertices= ventana.cantidadDeVertices();
				int cantDeAristas= ventana.cantidadDeAristas();
				
				GrafoConPeso grafo= new GrafoConPeso(cantDeVertices,cantDeAristas, true );
				
				long tiempoBFS= TiempoDeEjecucion.promedioKruskalBFS(grafo,30);
				long tiempoUFV= TiempoDeEjecucion.promedioKruskalConUnionFind(grafo,30);
				
				ventana.actualizarGrafica(tiempoBFS,tiempoUFV);
			}
		});
	}
	public void mostrarVentanaPrincipal() {
		this.ventana.mostrar();
	}

	
	public static void main(String[] args){
		VentanaPrincipal ventana= new VentanaPrincipal();
		Main UiMain= new Main(ventana);
		UiMain.mostrarVentanaPrincipal();
	}


}
