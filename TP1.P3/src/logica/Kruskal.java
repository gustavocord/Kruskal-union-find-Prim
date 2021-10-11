package logica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;


public class Kruskal {

	private  Grafo nuevo;
	private  Grafo grafo;
	private int[] padres;

	private static ArrayList<Arista> aristas;
	private int minimoCosto;

	public Kruskal(Grafo g) {
		this.grafo = g;

		this.aristas = grafo.getAristas();
		// this.arbol = new ArrayList<Arista>();
		this.minimoCosto = 0;

	}

	public static Arista pesoMinimo(ArrayList<Arista>aristas) {
		int menor = aristas.get(0).getPeso();
		for (int i = 0; i < aristas.size(); i++) {
			if (aristas.get(i).getPeso() <= menor) {
				menor = aristas.get(i).getPeso();
			}
		}
		List<Arista> menores = new ArrayList<Arista>();
		for (int i = 0; i < aristas.size(); i++) {
			if (menor == aristas.get(i).getPeso()) {
				menores.add(aristas.get(i));
			}
		}
		Arista aux = menores.get(0);
		if (!(menores.size() == 1)) {
			for (int i = 0; i < menores.size(); i++) {
				if (aux.getPeso() > menores.get(i).getPeso()) {// falta agregar el metodo ese
					aux = menores.get(i);
				}
			}
		}
		aristas.remove(aux);
		return aux;
	}

	public static  void kruskalConBFS(Grafo grafo) {
		
		Grafo arbolGeneradorMinimo= new Grafo(grafo.getCantidadDeVertices()); //va a tener la misma cant de vertice
		ArrayList<Arista> listaOrdenada= new ArrayList<Arista>();
		listaOrdenada.addAll(grafo.getAristas());
		Collections.sort(listaOrdenada);
		Iterator<Arista> it= listaOrdenada.iterator();
		Arista masChica= pesoMinimo(listaOrdenada);
		//int i= 0;
		
		System.out.println(masChica);
		for(int i =0; i<grafo.getCantidadDeVertices()-1;i++) {//por teorema de Arbol
			if(!perteneceALaMismaComponenteConexa(arbolGeneradorMinimo,masChica)) { //se fija si no hace circuito
				arbolGeneradorMinimo.agregarArista(masChica.getExtremo1().getId(),masChica.getExtremo2().getId(),masChica.getPeso());
				//i++;//paso al siguiente
			}
			//masChica= pesoMinimo(listaOrdenada);
			System.out.println(listaOrdenada);

		}
		//System.out.println(arbolGeneradorMinimo);


}
	
	private static boolean perteneceALaMismaComponenteConexa(Grafo arbol, Arista arista) {
		//dado un grafo y una arista, se fija si desde el verticeI existe un camino hasta el verticeJ
		//la arista puede estar en el grafo como no
		for(int elem : BFS.alcanzables( arbol, arista.getExtremo1().getId()) ) {//si desde el verticeI
			if(elem==arista.getExtremo2().getId()) {//puedo llegar al verticeJ
				return true;
			}
		}
		return false;
	}
	
	
	public static Grafo unionFindAlgoritmo(Grafo grafo) {
		UnionFind arbolGeneradorMinimo =new UnionFind(grafo.getCantidadVertices());

		ArrayList<Arista> aristasDisponibles = new ArrayList<Arista>();
		aristasDisponibles.addAll(grafo.getAristas());

		int i = 0;
		while (i < grafo.getCantidadDeVertices() - 1) {
			Arista masChica = pesoMinimo(aristasDisponibles); // se busca la arista mas chica del grafo
			if (!arbolGeneradorMinimo.find(masChica.getExtremo1().getId(), masChica.getExtremo2().getId())) { // si no
																												// estan
																												// en la
																												// misma
																												// componente
																												// conexa
				arbolGeneradorMinimo.agregarArista(masChica.getExtremo1().getId(), masChica.getExtremo2().getId(),
						masChica.getPeso());
				i++;
			}
			aristasDisponibles.remove(masChica); // la arista ya fue incluida aasi que se retira de las posibles aristas
		}
		return arbolGeneradorMinimo.getGrafo();// se devuelve el grafo
	}

}
	
	
	
