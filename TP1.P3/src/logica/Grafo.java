package logica;

import java.util.ArrayList;

import java.util.List;

public class Grafo {

	private List<Integer> raices;
	private List<Vertice> vertices;
	private ArrayList<Arista> aristas;

	// Constructor
	public Grafo(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El grafo no puede tener una cantidad negativa de vertices");
		}
		this.raices = new ArrayList<Integer>();
		this.vertices = new ArrayList<Vertice>();
		this.aristas = new ArrayList<Arista>();
		for (int i = 0; i < n; i++) {
			Vertice v = new Vertice(i);
			this.vertices.add(v);

		}
	}

	// Metodos propios de la clase

	public void agregarArista(int i, int j, int peso) {
		if (i < 0 || j < 0)
			throw new IllegalArgumentException("Los vertices no pueden ser negativos.");

		if (peso < 0)
			throw new IllegalArgumentException("El peso de la arista no puede ser negativo.");

		if (!this.getIdsVertices().contains(i) || !this.getIdsVertices().contains(j))
			throw new IllegalArgumentException("Los vertices (" + i + "," + j + ") deben estar en el grafo.");

//		if (this.existeAristaEntre(i, j)) {
//			throw new IllegalArgumentException("Arista "+i+j +" ya existente.");
//		}

		// Hago vecinos a ambos vertices entre si
		this.getVerticePorId(i).agregarVecino(this.getVerticePorId(j));
		this.getVerticePorId(j).agregarVecino(this.getVerticePorId(i));

		Arista a = new Arista(this.getVerticePorId(i), this.getVerticePorId(j), peso);// Guardo la arista con su peso
		this.aristas.add(a);
		BFS.actualizarPadresPorAristaModificada(this, i, j);
	}

	protected void quitarArista(int i, int j) {
		if (i < 0 || j < 0) {
			throw new IllegalArgumentException("Los vertices no pueden ser negativos.");
		}
		if (i >= this.vertices.size() || j >= this.vertices.size()) {
			throw new IllegalArgumentException("Los vertices ingresados deben estar en el grafo.");
		}
		if (!this.getVerticePorId(i).esVecinoDe(this.getVerticePorId(j))) {
			throw new IllegalArgumentException("Arista inexistente.");
		}

		this.getVerticePorId(i).quitarVecino(this.getVerticePorId(j));// Quito como vecinos a ambos vertices entre si
		this.getVerticePorId(j).quitarVecino(this.getVerticePorId(i));

		for (int k = 0; k < this.aristas.size(); k++) {// Recorro las aristas pre-existentes
			// Si ambos extremos coinciden con los vertices ingresados,la elimino
			if (this.aristas.get(k).getExtremo1().compareTo(this.getVerticePorId(i)) == 0
					&& this.aristas.get(k).getExtremo2().compareTo(this.getVerticePorId(j)) == 0
					|| this.aristas.get(k).getExtremo1().compareTo(this.getVerticePorId(j)) == 0
							&& this.aristas.get(k).getExtremo2().compareTo(this.getVerticePorId(i)) == 0) {
				this.aristas.remove(k);

				break;

			}
		}
		BFS.actualizarPadresPorAristaModificada(this, i, j);
	}

	protected void quitarAristaDeMayorPeso() {
		Arista aristaDeMayorPeso = this.aristaDeMayorPeso();
		if (this.getAristas().size() == 0) {
			throw new RuntimeException("El grafo no tiene aristas.");
		}
		if (aristaDeMayorPeso != null) {
			this.quitarArista(aristaDeMayorPeso.getExtremo1().getId(), aristaDeMayorPeso.getExtremo2().getId());
		}
	}

	public boolean existeAristaEntre(int i, int j) {

		if (i < 0 || j < 0) {
			throw new IllegalArgumentException("Los vertices no pueden ser negativos.");
		}
		if (!this.getIdsVertices().contains(i) || !this.getIdsVertices().contains(j))
			throw new IllegalArgumentException("Los vertices (" + i + "," + j + ") deben estar en el grafo.");
		// Chequeo que los vertices ingresados sean vecinos entre si.
		if (this.vertices.get(i).esVecinoDe(this.vertices.get(j))
				|| this.vertices.get(j).esVecinoDe(this.vertices.get(i)))
			return true;
		return false;
	}

	// Getters y Setters

	protected List<Integer> getRaices() {
		return raices;
	}

	protected void setRaices(ArrayList<Integer> raices) {
		this.raices = raices;
	}

	protected List<Vertice> getVertices() {
		return vertices;
	}

	protected Vertice getVerticePorId(int id) {
		for (int i = 0; i < this.vertices.size(); i++) {
			if (this.vertices.get(i).getId() == id)
				return this.vertices.get(i);
		}
		return null;
	}

	protected int getIndiceDeVerticeConId(int id) {
		for (int i = 0; i < this.vertices.size(); i++) {
			if (this.getVertices().get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public int getCantidadDeVertices() {
		return this.vertices.size();
	}

	protected List<Integer> getIdsVertices() {
		ArrayList<Integer> listaIds = new ArrayList<Integer>();
		for (Vertice v : this.vertices) {
			listaIds.add(v.getId());
		}
		return listaIds;
	}

	public void agregarVertice(Vertice v) {
		this.vertices.add(v);
	}

	public void agregarNVertices(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El grafo no puede tener una cantidad negativa de vertices");
		}

		for (int i = 0; i < n; i++) {
			Vertice v = new Vertice(i);
			agregarVertice(v);
		}
	}

	protected boolean contieneAlVertice(Vertice v) {
		for (Vertice vertice : this.vertices) {
			if (vertice.compareTo(v) == 0)
				return true;
		}
		return false;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public int cantAristas() {
		return this.aristas.size();

	}

	public int getIDExtremo1Arista(int i) {

		return this.aristas.get(i).getExtremo1().getId();
	}

	public int getIDExtremo2Arista(int i) {

		return this.aristas.get(i).getExtremo2().getId();
	}

	protected Arista aristaDeMayorPeso() {
		if (this.getAristas().size() == 0) {
			return null;
		}

		Arista aristaDeMayorPeso = this.getAristas().get(0);
		int pesoActual = aristaDeMayorPeso.getPeso();
		
		for (int i = 0; i < this.aristas.size(); i++) {
			if (this.aristas.get(i).getPeso() > pesoActual) {
				pesoActual = this.aristas.get(i).getPeso();
				aristaDeMayorPeso = this.aristas.get(i);
			}
		}
		return aristaDeMayorPeso;
	}

	protected Arista aristaDeMenorPeso() {
		if (this.getAristas().size() == 0) {
			return null;
		}
		
		Arista aristaDeMenorPeso = this.getAristas().get(0);
		int pesoActual = aristaDeMenorPeso.getPeso();
		
		for (int i = 0; i < this.aristas.size(); i++) {
			if (this.aristas.get(i).getPeso() < pesoActual) {
				pesoActual = this.aristas.get(i).getPeso();
				aristaDeMenorPeso = this.aristas.get(i);
			}
		}
		return aristaDeMenorPeso;
	}
	
	
	protected int getCantidadVertices(){
		return vertices.size();
	}

	
// faltan vecinos con el peso

	// Metodo Override
	@Override
	public String toString() {
		return "Grafo {raices=" + raices + ", \nvertices=" + vertices + ", \naristas=" + aristas + "}\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aristas == null) ? 0 : aristas.hashCode());
		result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == null && obj != null || this != null && obj == null)
			return false;
		Grafo otro = (Grafo) obj;
		if (this.getCantidadDeVertices() != otro.getCantidadDeVertices()
				|| this.getAristas().size() != otro.getAristas().size())
			return false;
		if (!this.getVertices().containsAll(otro.getVertices()) || !this.getAristas().containsAll(otro.getAristas()))
			return false;
		return true;
	}

	// Metodos que podrian ir en clase BFS

	// protected int cantComponentesConexas(Grafo g); //Devuelve la cantidad de
	// componentes conexas del grafo
	// protected boolean esArbol(Grafo g); //Devuelve true si el grafo ingresado es
	// un grafo arbol

	public Grafo generarRegiones(int k) {// El grafo debe ser un arbol
		if (k > this.getCantidadDeVertices()) {
			throw new IllegalArgumentException(
					"No se puede generar una cantidad de regiones mayor que la cantidad de vertices del grafo.");
		}
		if (k == 1) {
			return this;
		}
		for (int i = 0; i < k - 1; i++) {
			this.quitarAristaDeMayorPeso();

		}
		return this;
	}
	
	public int grado(int vertice) {
		return vertices.get(vertice).getVecinos().size();
	 }
}