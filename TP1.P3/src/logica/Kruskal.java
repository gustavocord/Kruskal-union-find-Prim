package logica;
import java.util.HashSet;
import java.util.Set;
public class Kruskal {

	public static GrafoConPeso kruskalConBFS(GrafoConPeso grafo){
		validarGrafoConexo(grafo);
		GrafoConPeso arbolGeneradorMinimo= new GrafoConPeso(grafo._cantidadDeVertices); //va a tener la misma cant de vertices
		Set<Arista>aristasDisponibles= new HashSet<Arista>();
		aristasDisponibles.addAll(grafo.getAristas());
		int i= 0;
		while(i<grafo.getCantidadDeVertices()-1) {//por teorema de Arbol
			Arista masChica= aristaMasChica(grafo,aristasDisponibles); //busca la arista mas chica del grafo
			if(!perteneceALaMismaComponenteConexa(arbolGeneradorMinimo,masChica)) { //se fija si no hace circuito
				arbolGeneradorMinimo.agregarArista(masChica.getVerticeI(),masChica.getVerticeJ(), grafo.peso(masChica.getVerticeI(), masChica.getVerticeJ()));
				i++;//paso al siguiente
			}
			aristasDisponibles.remove(masChica); //la arista ya no esta disponible
		}
		return arbolGeneradorMinimo;
	}

	
	public static Arista aristaMasChica(GrafoConPeso grafo, Set <Arista> aristas) {
		//recibe el grafo y el conjunto de aristas que se desea buscar cual es la arista mas chica
		//busca cual es la arista mas chica dentro del grafo
		if(grafo.getAristas().size()==0) {
			throw new IllegalArgumentException("El grafo no tiene aristas, por lo tanto no se puede buscar la arista mas chica");
		}
		Arista masChica= aristas.iterator().next(); //va a agarrar el primer elem
		for(Arista elem : aristas) {//todas las aristas
			int pesoMasChica= grafo.peso(masChica.getVerticeI(), masChica.getVerticeJ());
			int pesoAComparar= grafo.peso(elem.getVerticeI(), elem.getVerticeJ());
			if(pesoAComparar!=-1 && pesoMasChica>pesoAComparar) { //si pesoAComparar es -1 significa que la arista no existe en el grafo o no tiene definido el peso
				masChica= elem;
			}
		}
		return masChica;
	}

	private static void validarGrafoConexo(GrafoConPeso grafo) {
		if(!grafo.esConexo()) {
			throw new IllegalArgumentException("El grafo debe ser conexo para hacer un ArbolGeneradorMinimo");
		}
	}
	private static boolean perteneceALaMismaComponenteConexa(GrafoConPeso arbol, Arista arista) {
		//dado un grafo y una arista, se fija si desde el verticeI existe un camino hasta el verticeJ
		//la arista puede estar en el grafo como no
		for(int elem : BFS.alcanzables( arbol, arista.getVerticeI()) ) {//si desde el verticeI
			if(elem==arista.getVerticeJ()) {//puedo llegar al verticeJ
				return true;
			}
		}
		return false;
	}


	
	private static GrafoConPeso unionFindAlgoritmo(GrafoConPeso grafo) {
	
		validarGrafoConexo(grafo);
		//UnionFind arbolGeneradorMinimo= null;
		UnionFind arbolGeneradorMinimo= new UnionFind(grafo.getCantidadDeVertices());
		
		Set<Arista>aristasDisponibles= new HashSet<Arista>();
		aristasDisponibles.addAll(grafo.getAristas());

		int i= 0;
		while(i<grafo.getCantidadDeVertices()-1) {//por teorema de Arbol
			Arista masChica= aristaMasChica(grafo,aristasDisponibles); //busca la arista mas chica del grafo
			int pesoDeMasChica= grafo.peso(masChica.getVerticeI(), masChica.getVerticeJ());
			if(!arbolGeneradorMinimo.find(masChica.getVerticeI() , masChica.getVerticeJ())) { //si NO estan en la misma componente conexa
				arbolGeneradorMinimo.agregarArista(masChica.getVerticeI(), masChica.getVerticeJ(), pesoDeMasChica);
				i++;
			}
			aristasDisponibles.remove(masChica); //la arista ya no esta disponible
		}
		return arbolGeneradorMinimo.getGrafo();//devuelvo el grafo
	}
	
	
	
	public static GrafoConPeso unionFind(GrafoConPeso grafo) {
		return unionFindAlgoritmo(grafo);
	}


}
	
	
	
