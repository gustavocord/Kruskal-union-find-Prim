package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grafo {
	private ArrayList<Set<Integer>> _vecinos;
	protected Set <Arista> _aristas;
	protected int _cantidadDeVertices; 
	protected int _limiteDeAristas;

	public Grafo(int cantidadDeVertices){
		this._vecinos = new ArrayList<Set<Integer>>(cantidadDeVertices);
		for (int i = 0; i < cantidadDeVertices; i++) {
			this._vecinos.add(new HashSet<Integer>());
		}
		this._cantidadDeVertices = cantidadDeVertices;
		this._aristas= new HashSet<Arista>();
		this._limiteDeAristas= (cantidadDeVertices * (cantidadDeVertices-1) ) / 2;
	}
	public Grafo(int cantidadDeVertices, int cantDeAristas) {

		this(cantidadDeVertices);
		verificarCantidadAristaVertice(cantidadDeVertices,cantDeAristas);
		if(!esConexo()) {
			if(cantDeAristas<cantidadDeVertices-1) {
				throw new IllegalArgumentException("la cantidad de aristas para un grafo conexo es de: " + (cantidadDeVertices-1));
			}
			grafoAleatorioConexo();
		}
		grafoAleatorioConCantDeAristas(cantDeAristas);
	}

	public void agregarArista(int verticeI, int verticeJ){	//O(1)
		verificarArista(verticeI, verticeJ,"agregar");
		this._vecinos.get(verticeI).add(verticeJ);
		this._vecinos.get(verticeJ).add(verticeI);
		this._aristas.add(new Arista(verticeI,verticeJ));
	}

	public void eliminarArista(int verticeI, int verticeJ){	//O(1)
		verificarArista(verticeI, verticeJ,"eliminar");
		if(!existeArista(verticeI, verticeJ)) {
			throw new IllegalArgumentException("Se intento eliminar una arista que no existe: "+ verticeI +"/" + verticeJ);
		}
		this._vecinos.get(verticeI).remove(verticeJ);
		this._vecinos.get(verticeJ).remove(verticeI);
		this._aristas.remove(new Arista(verticeI,verticeJ));

	}

	public boolean existeArista(int verticeI, int verticeJ){//O(1)
		return this._vecinos.get(verticeI).contains(verticeJ);
	}

	public Set<Integer> vecinos(int vertice){	//O(1)
		verificarVertice(vertice, "obtener los vecinos de un vertice");
		return this._vecinos.get(vertice);
	}

	public int grado(int vertice){ 
		verificarVertice(vertice, "consultar");
		return _vecinos.get(vertice).size();
	}

	//BFS
	public boolean esConexo() { //Con BFS
		return BFS.esConexo(this); //le paso este objeto
	}

	public boolean esUnArbol(){
		if(!esConexo()) {
			return false;
		}
		if(this._aristas.size() != (this._cantidadDeVertices -1) ) {
			return false;
		}
		return true;
	}

	private void grafoAleatorioConCantDeAristas(int cantidadDeAristas) {
		if(cantidadDeAristas<0 || cantidadDeAristas>this._limiteDeAristas) {
			throw new IllegalArgumentException("La cantidad de aristas debe ser: [0," + (this._limiteDeAristas) + "]");
		}
		while(this.getAristas().size()<cantidadDeAristas) {
			int iAleatorio= numeroRandomEntre(0,this._cantidadDeVertices);
			int jAleatorio= numeroRandomEntre(0,this._cantidadDeVertices);
			if(iAleatorio!=jAleatorio) {
				this.agregarArista(iAleatorio, jAleatorio);
			}
		}
	}
	private void grafoAleatorioConexo() {
		int[] arrayVertices= new int[this._cantidadDeVertices];
		for(int i=0; i<this._cantidadDeVertices;i++) {
			arrayVertices[i]=i;
		}
		for(int i=0; i<this._cantidadDeVertices-1 ;i++) {
			int indiceJAleatorio= numeroRandomEntre(i+1,this._cantidadDeVertices);
			int elemI= arrayVertices[i];
			int elemJAleatorio= arrayVertices[indiceJAleatorio];
			this.agregarArista(elemI, elemJAleatorio);
		}
	}
	protected int numeroRandomEntre(int min, int max) {
		Random aleatorio= new Random();
		return min + aleatorio.nextInt(max-min);
	}

	//Verificacion

	protected void verificarArista(int verticeI, int verticeJ, String accion) {
		if (verticeI == verticeJ) {
			throw new IllegalArgumentException("Se intento "+accion+" una arista con i=j : "+ verticeI +"/" + verticeJ);
		}
		verificarVertice(verticeI, accion);
		verificarVertice(verticeJ, accion);
	}

	protected void verificarVertice(int vertice, String accion) {
		if (vertice < 0 || vertice >= _cantidadDeVertices) {
			throw new IllegalArgumentException("Se intento "+ accion +" con valores fuera de rango: "+ vertice);
		}
	}
	
	protected void verificarCantidadAristaVertice(int cantArista, int cantVertice ) {
		if (cantArista <= 0 || cantVertice == 0  ) {
			throw new IllegalArgumentException("Se intento consultar con valores fuera de rango: ");
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("|Grafo: \n");
		for (int i = 0; i < this._cantidadDeVertices; i++) {
			sb.append("|" + i + ": [ ");
			for(Integer elem : this._vecinos.get(i)) {
				sb.append("[" + elem.toString() + "]");
			}
			sb.append(" ] \n");
		}
		return sb.toString();
	}
	public ArrayList<Set<Integer>> getVecinos() {
		return this._vecinos;
	}
	public Set<Arista> getAristas() {
		return this._aristas;
	}
	public int getCantidadDeVertices() {
		return this._cantidadDeVertices;
	}
	public int getLimiteDeAristas() {
		return _limiteDeAristas;
	}
	public void setLimiteDeAristas(int limiteDeAristas) {
		this._limiteDeAristas = limiteDeAristas;
	}
	public void setVecinos(ArrayList<Set<Integer>> vecinos) {
		this._vecinos = vecinos;
	}
	public void setAristas(Set<Arista> aristas) {
		this._aristas = aristas;
	}
	public void setCantidadDeVertices(int cantidadDeVertices) {
		this._cantidadDeVertices = cantidadDeVertices;
	}	
}


