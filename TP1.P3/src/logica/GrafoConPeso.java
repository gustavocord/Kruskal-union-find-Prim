package logica;

import java.util.ArrayList;


public class GrafoConPeso extends Grafo{
	
	private ArrayList<Arista> aristas;

	
	public GrafoConPeso(int vertices) {
		super(vertices);
		aristas = new ArrayList<Arista>();
	}
	
	public void setArista(int origen , int destino , int peso) {
		if(!existeArista(origen, destino)) {
			agregarArista(origen, destino);
			aristas.add(new Arista(origen, destino, peso));
		} else { 
			for (Arista arista : aristas) {
				if(arista.getOrigen() == origen && arista.getDestino() == destino)
					arista.setPeso(peso);
			}
		}
	}

	
	public ArrayList<Arista> getAristas(){
		return aristas;
	}
}
