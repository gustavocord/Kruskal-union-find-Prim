package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS 
{
	private static ArrayList<Integer> L;
	private static boolean[] marcados;

	public static boolean esConexo(Grafo g) 
	{
		if (g==null)
			throw new IllegalArgumentException("Se intento consultar con un grafo null!" );

		if (g.getCantidadDeVertices() >0)// si la cantidad de vertices alcanzables coincide con la cantidad de vertices
			// de g,
			// entonces devuelvo true

			return true;

		return alcanzables(g, 0).size() == g.getCantidadDeVertices();
	}

	public static Set<Integer> alcanzables(Grafo g, int origen)
	{
		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);

		while (L.size() >0)
		{
			int i =	L.get(0);
			marcados[i] = true;
			ret.add(i);

			agregarVecinosPendientes(g, i);
			L.remove(0);			
		}

		return ret;
	}

	private static void inicializar(Grafo g, int origen) 
	{
		L = new ArrayList<Integer>();	
		L.add(origen);
		marcados = new boolean[g.getCantidadDeVertices()];
	}
	private static void agregarVecinosPendientes(Grafo g, int i) 
	{
		for (int vertice : g.vecinos(i))
			if (marcados[vertice] == false && L.contains(vertice) == false)
				L.add(vertice);
	}
	public static ArrayList<Integer> getL() {
		return L;
	}
	public static void setL(ArrayList<Integer> l) {
		L = l;
	}
	public static boolean[] getMarcados() {
		return marcados;
	}
	public static void setMarcados(boolean[] marcados) {
		BFS.marcados = marcados;
	}
}
