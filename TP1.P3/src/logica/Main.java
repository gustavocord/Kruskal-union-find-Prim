package logica;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GrafoConPeso grafo = new GrafoConPeso(4);

		
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(1, 5, 4);
		grafo.agregarArista(5, 4, 6);
		//grafo.agregarArista(2, 3, 5);
		//grafo.agregarArista(3, 4, 6);
		
		

		Kruskal kruskal = new Kruskal();
		System.out.println();
		System.out.println(kruskal.kruskalConBFS(grafo));
	}

}
