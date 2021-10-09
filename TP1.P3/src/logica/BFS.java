package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {

	private static ArrayList<Integer> L;
	private static boolean[] marcados;

	public static boolean esConexo(Grafo g) {
		if (g.getCantidadDeVertices() > 0) {
			// si la cantidad de vertices alcanzables coincide con la cantidad de vertices
			// de g,
			// entonces devuelvo true
			Set<Integer> alcanzables = BFS.alcanzables(g, g.getVertices().get(0).getId());
			if (g.getCantidadDeVertices() == alcanzables.size()) {
				return true;
			}
		}
		return false;

	}

	protected static Set<Integer> alcanzables(Grafo g, int origen) {

		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);// Agrego el origen a los pendientes y vacio la lista de marcados.

		while (L.size() > 0) {

			int i = L.get(0);// tomo el primer id de la lista L
			marcados[g.getIndiceDeVerticeConId(i)] = true;// marco el vertice con ese id
			ret.add(g.getVerticePorId(i).getId()); // agrego a la lista de alcanzables a ese id

			agregarVecinosPendientes(g, i);// agrego los vecinos pendientes de ese id
			L.remove(0);// quito de la lista de pendientes a ese id
		}

		return ret;

	}

	private static void inicializar(Grafo g, int origen) {
		L = new ArrayList<Integer>();
		L.add(origen);
		marcados = new boolean[g.getCantidadDeVertices()];
	}

	private static void agregarVecinosPendientes(Grafo g, int i) {
		for (Vertice vertice : g.getVerticePorId(i).getVecinos()) {// recorro los vecinos del vertice con id "i"
			// Si ese vertice no esta marcado y no esta en la lista de pendientes
			if (marcados[g.getIndiceDeVerticeConId(vertice.getId())] == false && !L.contains(vertice.getId())) {
				L.add(vertice.getId());// lo agrego a la lista de pendientes
			}
		}
	}

	protected static void actualizarPadresPorAristaModificada(Grafo g, int i, int j) {
		actualizarPadresDeComponenteConexa(g, i);
		actualizarPadresDeComponenteConexa(g, j);
		ArrayList<Integer> raices = new ArrayList<Integer>();
		for (Vertice v : g.getVertices()) {
			if (!raices.contains(v.getPadre())) {
				raices.add(v.getPadre());
			}
		}
		g.setRaices(raices);
	}

	protected static void actualizarPadresDeComponenteConexa(Grafo g, int id) {
		Set<Integer> alcanzables = BFS.alcanzables(g, id);
		int raizActual = 0;
		for (Integer n : alcanzables) {
			if (n > raizActual) {
				raizActual = n;
			}
		}

		for (Integer n : alcanzables) {
			Vertice v = g.getVerticePorId(n);
			v.setPadre(raizActual);
		}
	}

}
