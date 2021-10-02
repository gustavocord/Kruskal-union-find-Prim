package logica;

import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		System.out.println("probando kruskal");
		Kruskal kruskal = new Kruskal(9);
		kruskal.g.setArista(0, 3, 14);
		kruskal.g.setArista(0, 4, 10);
		kruskal.g.setArista(3, 1, 1);
		kruskal.g.setArista(1, 5, 25);
		kruskal.g.setArista(5, 4, 0);
		kruskal.g.setArista(4, 2, 11);
		kruskal.g.setArista(2, 1, 120);
		
		kruskal.agregarArista(new Arista(1,2,120));
		List<Arista> minima = kruskal.getMinimaNoMarcada2();
		System.out.println(new Arista(0, 3, 1).equals(minima));
		System.out.println(minima);
	}

}