package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
  Representacin con Lista de vecinos
*/
public class Grafo 
{
	protected ArrayList<Set<Integer>> vecinos;
	protected int vertice; 
	
	public Grafo( int vertices)
	{
		vecinos = new ArrayList<Set<Integer>>(vertices);

		for (int i = 0; i < vertices; i++)
			vecinos.add(new HashSet<Integer>());	

		vertice = vertices;
	}
	
	public void agregarArista ( int i, int j)
	{
		verificarArista(i, j);
		
		vecinos.get(i).add(j);
		vecinos.get(j).add(i);
	}
	
	public void eliminarArista(int i, int j)
	{
		verificarArista(i, j);
		
		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);

	}
	
	public boolean existeArista (int i, int j)
	{
		verificarArista(i, j);
		
		return vecinos.get(i).contains(j);
	}

	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		return vecinos.get(i);
	}

	public int grado (int i)
	{ 
		return vecinos.get(i).size();
	}
		
	protected void verificarArista(int i, int j) 
	{
		if (i == j)
			throw new IllegalArgumentException("una arista con i=j : "+i +"/"  + j);
		
		verificarVertice(i);

		verificarVertice(j);

	}

	private void verificarVertice(int i) 
	{
		if (i < 0 || i >= vertice)
			throw new IllegalArgumentException("fuera de rango: "+ i);
	}

	public int vertices()
	{
		return vertice;
	}
	
	public int tamano() {
		return vecinos.size();
	}
	
	
	public boolean esClique( Set<Integer> conjunto) 
	{
		if (conjunto == null)
			throw new IllegalArgumentException("El conjunto no puede ser null");

		for (int v: conjunto)
		   verificarVertice(v);
		
		if (conjunto.isEmpty())
			return true;
		
		for (int v: conjunto)
		for (int otro: conjunto) 
			if (v != otro)
				if (existeArista(v,otro) == false)
					return false;
		
		return true;
	}

	public ArrayList<Set<Integer>> get_vecinos() {
		return vecinos;
	}

	public int getVertice() {
		return vertice;
	}

	public void set_vertice(int _vertice) {
		this.vertice = _vertice;
	} 
	

	

}
