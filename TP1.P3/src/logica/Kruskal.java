package logica;


import java.util.ArrayList;



public class Kruskal {


	GrafoConPeso g; 
	GrafoConPeso AGM;
	UnionFind raices;
	
	public Kruskal(int vertices) {
		g = new GrafoConPeso(vertices);
		
		AGM = new GrafoConPeso(vertices);
		
		raices=new UnionFind(AGM);
			
		}

	public Arista getMinimaNoMarcada() {
		Arista temp = g.getAristas().get(0);
		for (Arista arista : g.getAristas()) {
			
			if(arista.compareTo(temp)<0) {
				if (!AGM.existeArista(arista.getOrigen(),arista.getDestino()) 
					&& !raices.mismaCompConexa(arista.getOrigen(), arista.getDestino())) {
					temp = arista;
				}
			}
		}
		
		return temp;
		
	}

	public void agregarArista(Arista arista) {
		AGM.setArista(arista.getOrigen(), arista.getDestino(), arista.getPeso());
		raices.unir(arista.getOrigen(), arista.getDestino());
	}
	
	
	
	
}
