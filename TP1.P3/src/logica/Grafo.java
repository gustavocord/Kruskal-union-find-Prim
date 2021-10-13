package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grafo {
	private ArrayList<Set<Integer>> vecinos;
	protected Set <Arista> aristas;
	protected int cantidadDeVertices; 
	protected int limiteDeAristas;

	public Grafo(int cantidadDeVertices){
		this.vecinos = new ArrayList<Set<Integer>>(cantidadDeVertices);
		for (int i = 0; i < cantidadDeVertices; i++) {
			this.vecinos.add(new HashSet<Integer>());
		}
		this.cantidadDeVertices = cantidadDeVertices;
		this.aristas= new HashSet<Arista>();
		this.limiteDeAristas= (cantidadDeVertices * (cantidadDeVertices-1) ) / 2;
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
		this.vecinos.get(verticeI).add(verticeJ);
		this.vecinos.get(verticeJ).add(verticeI);
		this.aristas.add(new Arista(verticeI,verticeJ));
	}

	public void eliminarArista(int verticeI, int verticeJ){	//O(1)
		verificarArista(verticeI, verticeJ,"eliminar");
		if(!existeArista(verticeI, verticeJ)) {
			throw new IllegalArgumentException("Se intento eliminar una arista que no existe: "+ verticeI +"/" + verticeJ);
		}
		this.vecinos.get(verticeI).remove(verticeJ);
		this.vecinos.get(verticeJ).remove(verticeI);
		this.aristas.remove(new Arista(verticeI,verticeJ));

	}

	public boolean existeArista(int verticeI, int verticeJ){//O(1)
		return this.vecinos.get(verticeI).contains(verticeJ);
	}

	public Set<Integer> vecinos(int vertice){	//O(1)
		verificarVertice(vertice, "obtener los vecinos de un vertice");
		return this.vecinos.get(vertice);
	}

	public int grado(int vertice){ 
		verificarVertice(vertice, "consultar");
		return vecinos.get(vertice).size();
	}

	//BFS
	public boolean esConexo() { //Con BFS
		return BFS.esConexo(this); //le paso este objeto
	}

	public boolean esUnArbol(){
		if(!esConexo()) {
			return false;
		}
		if(this.aristas.size() != (this.cantidadDeVertices -1) ) {
			return false;
		}
		return true;
	}

	private void grafoAleatorioConCantDeAristas(int cantidadDeAristas) {
		if(cantidadDeAristas<0 || cantidadDeAristas>this.limiteDeAristas) {
			throw new IllegalArgumentException("La cantidad de aristas debe ser: [0," + (this.limiteDeAristas) + "]");
		}
		while(this.getAristas().size()<cantidadDeAristas) {
			int iAleatorio= numeroRandomEntre(0,this.cantidadDeVertices);
			int jAleatorio= numeroRandomEntre(0,this.cantidadDeVertices);
			if(iAleatorio!=jAleatorio) {
				this.agregarArista(iAleatorio, jAleatorio);
			}
		}
	}
	private void grafoAleatorioConexo() {
		int[] arrayVertices= new int[this.cantidadDeVertices];
		for(int i=0; i<this.cantidadDeVertices;i++) {
			arrayVertices[i]=i;
		}
		for(int i=0; i<this.cantidadDeVertices-1 ;i++) {
			int indiceJAleatorio= numeroRandomEntre(i+1,this.cantidadDeVertices);
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
		if (vertice < 0 || vertice >= cantidadDeVertices) {
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
		for (int i = 0; i < this.cantidadDeVertices; i++) {
			sb.append("|" + i + ": [ ");
			for(Integer elem : this.vecinos.get(i)) {
				sb.append("[" + elem.toString() + "]");
			}
			sb.append(" ] \n");
		}
		return sb.toString();
	}
	public ArrayList<Set<Integer>> getVecinos() {
		return this.vecinos;
	}
	public Set<Arista> getAristas() {
		return this.aristas;
	}
	public int getCantidadDeVertices() {
		return this.cantidadDeVertices;
	}
	public int getLimiteDeAristas() {
		return limiteDeAristas;
	}
	public void setLimiteDeAristas(int limiteDeAristas) {
		this.limiteDeAristas = limiteDeAristas;
	}
	public void setVecinos(ArrayList<Set<Integer>> vecinos) {
		this.vecinos = vecinos;
	}
	public void setAristas(Set<Arista> aristas) {
		this.aristas = aristas;
	}
	public void setCantidadDeVertices(int cantidadDeVertices) {
		this.cantidadDeVertices = cantidadDeVertices;
	}	
}


