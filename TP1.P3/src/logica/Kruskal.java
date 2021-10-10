package logica;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kruskal {

	private Grafo nuevo;
	private Grafo grafo;
	private int[] padres;

	private static ArrayList<Arista> aristas;
	private int minimoCosto;

	public Kruskal(Grafo g) {
		this.grafo = grafo;

		this.aristas = new ArrayList<Arista>();
		// this.arbol = new ArrayList<Arista>();
		this.minimoCosto = 0;

	}

	public static Arista pesoMinimo() {
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
				if (aux.getOrdem() > menores.get(i).getOrdem()) {// falta agregar el metodo ese
					aux = menores.get(i);
				}
			}
		}
		aristas.remove(aux);
		return aux;
	}

	public static Grafo kruskalConBFS(Grafo grafo) {
		BFS.esConexo(grafo);
		Grafo arbolGeneradorMinimo = new Grafo(grafo.getCantidadVertices()); //
		Set<Arista> aristasDisponibles = new HashSet<Arista>();
		aristas.addAll(grafo.getAristas());
		int i = 0;
		while (i < grafo.getCantidadDeVertices() - 1) {//
			Arista masChica = pesoMinimo();
			if (!BFS.esConexo(grafo)) { //
				// arbolGeneradorMinimo.agregarArista(masChica.getExtremo1(),masChica.getExtremo2()
				// //grafo.peso(masChica.getExtremo1(), masChica.getExtremo2()));
				i++;// paso al siguiente
			}
			aristasDisponibles.remove(masChica); // la arista ya no esta disponible
		}
		return arbolGeneradorMinimo;
	}

}
