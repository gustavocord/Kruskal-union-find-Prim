package logica;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grafo grafo = new Grafo(4);
		grafo.agregarVertice(new Vertice(1));
		grafo.agregarVertice(new Vertice(2));
		grafo.agregarVertice(new Vertice(3));
		grafo.agregarVertice(new Vertice(4));
		grafo.agregarVertice(new Vertice(5));
		
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(1, 5, 4);
		grafo.agregarArista(5, 4, 6);
		grafo.agregarArista(2, 3, 5);
		
		
		

		Kruskal kruskal = new Kruskal(grafo);
		System.out.println();
		kruskal.kruskalConBFS(grafo);
	}

}
