package logica;


import java.util.ArrayList;
import java.util.List;



public class Kruskal {


	GrafoConPeso g; 
	GrafoConPeso AGM;
	UnionFind raices;
	BFS anchura ;
	
	public Kruskal(int vertices) {
		g = new GrafoConPeso(vertices);
		
		AGM = new GrafoConPeso(vertices);
		
		raices=new UnionFind(AGM);
		
		anchura = new BFS();
		
			
		}

	public Arista getMinimaNoMarcada() {
		Arista temp = g.getAristas().get(0);
		//Arista camino= g.getAristas().get(0);
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
	
	

	public List<Arista> getMinimaNoMarcada2() {
		Arista temp = g.getAristas().get(0);
		List<Arista> camino = new ArrayList<Arista>();
		for (Arista arista : g.getAristas()) {
			
			if(arista.compareTo(temp)<0) {
				if (!AGM.existeArista(arista.getOrigen(),arista.getDestino()) 
					&& !anchura.esConexo(g)) {
					temp = arista;
				}
			}
			else {
				camino.add(arista);
			}
		}
		
		return camino;
		
	}

	public void agregarArista(Arista arista) {
		AGM.setArista(arista.getOrigen(), arista.getDestino(), arista.getPeso());
		raices.unir(arista.getOrigen(), arista.getDestino());
	}
	
	//deberiamos encontrar el peso minimo para luego comenzar a recorrer por bfs
	public void pesoMinimo() {
		
	}
	
	
	
	
}
