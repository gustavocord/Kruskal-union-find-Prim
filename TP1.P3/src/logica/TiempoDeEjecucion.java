package logica;

public class TiempoDeEjecucion {
	
	
	public static long kruskalBFS(GrafoConPeso grafo) {
		long TInicio, TFin, tiempo;
		TInicio= System.nanoTime(); 
		Kruskal.kruskalConBFS(grafo);
		TFin= System.nanoTime(); 
		tiempo= TFin - TInicio;
		return tiempo;
	}
	public static long kruskalConUnionFind(GrafoConPeso grafo) {
		long TInicio, TFin, tiempo;
		TInicio= System.nanoTime(); 
		Kruskal.unionFind(grafo);
		TFin= System.nanoTime(); 
		tiempo= TFin - TInicio;
		return tiempo;
	}

	public static long promedioKruskalBFS(GrafoConPeso grafo, int cantDeVeces) {
		long tiempo= 0;
		for(int i=0; i<cantDeVeces; i++) {
			tiempo+= kruskalBFS(grafo);
		}
		return tiempo/cantDeVeces;
	}
	public static long promedioKruskalConUnionFind(GrafoConPeso grafo,int cantDeVeces) {
		long tiempo= 0;
		for(int i=0; i<cantDeVeces; i++) {
			tiempo+= kruskalConUnionFind(grafo);
		}
		return tiempo/cantDeVeces;
	}


	
}
