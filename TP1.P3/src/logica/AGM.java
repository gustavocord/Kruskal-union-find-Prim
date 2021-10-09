package logica;

import java.util.ArrayList;

public class AGM {
	protected static Grafo AGM;

	// Utiliza el algoritmo de Prim
	public static Grafo generarAGM(Grafo g) {
		AGM = new Grafo(0);
		AGM.agregarVertice(new Vertice(g.getVertices().get(0).getId()));// Se inicaliza el agm con un solo vertice

		while (AGM.getCantidadDeVertices() < g.getCantidadDeVertices()) {
			// Busco la proxima arista para extender el agm seg�n Prim
			Arista aristaNueva = aristaMenorParaAgregar(g, AGM);

			// Si el agm tiene al extremo 1 pero no al extremo 2, agrego al 2 y extiendo el
			// agm hacia ese vertice
			if (AGM.contieneAlVertice(aristaNueva.getExtremo1()) && !AGM.contieneAlVertice(aristaNueva.getExtremo2())) {

				AGM.agregarVertice(new Vertice(aristaNueva.getExtremo2().getId()));
				AGM.agregarArista(aristaNueva.getExtremo1().getId(), aristaNueva.getExtremo2().getId(),
						aristaNueva.getPeso());
			}
			// Si el agm tiene al extremo 2 pero no al extremo 1, agrego al 1 y extiendo el
			// agm hacia ese vertice
			if (AGM.contieneAlVertice(aristaNueva.getExtremo2()) && !AGM.contieneAlVertice(aristaNueva.getExtremo1())) {
				AGM.agregarVertice(new Vertice(aristaNueva.getExtremo1().getId()));
				AGM.agregarArista(aristaNueva.getExtremo1().getId(), aristaNueva.getExtremo2().getId(),
						aristaNueva.getPeso());
			}

		}
		return AGM;

	}

	protected static Arista aristaMenorParaAgregar(Grafo g, Grafo agm) {
		ArrayList<Arista> aristasAgregables = aristasAgregables(g, agm);
		int pesoMenor = aristasAgregables.get(0).getPeso();
		int indiceMenor = 0;
		// Recorro las aristas agregables de g y guardo la de menor peso
		for (int i = 0; i < aristasAgregables.size(); i++) {
			if (aristasAgregables.get(i).getPeso() <= pesoMenor) {
				pesoMenor = aristasAgregables.get(i).getPeso();
				indiceMenor = i;
			}
		}
		return aristasAgregables.get(indiceMenor);
	}

	protected static ArrayList<Arista> aristasAgregables(Grafo g, Grafo agm) {
		ArrayList<Arista> aristasAgregables = new ArrayList<Arista>();
		// Recorro las aristas del grafo original
		for (int i = 0; i < g.getAristas().size(); i++) {
			Vertice extremo1 = g.getAristas().get(i).getExtremo1();
			Vertice extremo2 = g.getAristas().get(i).getExtremo2();
			// Si el AGM contiene a uno de los extremos de la arista pero no al otro, lo
			// agrego a la lista

			if (agm.contieneAlVertice(extremo1) && !agm.contieneAlVertice(extremo2)
					|| agm.contieneAlVertice(extremo2) && !agm.contieneAlVertice(extremo1)) {
				aristasAgregables.add(g.getAristas().get(i));
			}

		}
		return aristasAgregables;
	}

}
