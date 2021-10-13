package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Representacion con Lista de Vecinos

public class GrafoConPeso extends Grafo{
	protected  ArrayList<Set<VecinoConPeso>> vecinosConPeso;
	public GrafoConPeso(int cantidadDeVertices){
		super(cantidadDeVertices);
		this.vecinosConPeso = new ArrayList<Set<VecinoConPeso>>(cantidadDeVertices);
		for (int i = 0; i < cantidadDeVertices; i++) {
			this.vecinosConPeso.add(new HashSet<VecinoConPeso>());
		}	
	}
	public GrafoConPeso(int cantidadDeVertices, int cantDeAristas) {
		super(cantidadDeVertices, cantDeAristas);
		this.vecinosConPeso = new ArrayList<Set<VecinoConPeso>>(cantidadDeVertices);
		for (int i = 0; i < cantidadDeVertices; i++) {
			this.vecinosConPeso.add(new HashSet<VecinoConPeso>());
		}	
		for(Arista elem: super.getAristas() ) { //a cada arista le agrego el peso
			int pesoAleatorio= pesoAleatorio();
			//le creo el vecinoConPeso
			this.vecinosConPeso.get(elem.getVerticeI()).add(new VecinoConPeso(elem.getVerticeJ(),pesoAleatorio));
			this.vecinosConPeso.get(elem.getVerticeJ()).add(new VecinoConPeso(elem.getVerticeI(),pesoAleatorio));
			//le escribo el peso
			elem.setPeso(pesoAleatorio);
		}
	}
	
	
	
	public void agregarArista(int verticeI, int verticeJ, int peso){	//O(1)
		verificarArista(verticeI, verticeJ,"agregar");
		super.getVecinos().get(verticeI).add(verticeJ);
		super.getVecinos().get(verticeJ).add(verticeI);
		this._aristas.add(new Arista(verticeI,verticeJ,peso));//no utilizamos el mismo metodo del super porque la arista que se agrega es con peso
		this.vecinosConPeso.get(verticeI).add(new VecinoConPeso(verticeJ,peso));
		this.vecinosConPeso.get(verticeJ).add(new VecinoConPeso(verticeI,peso));
	}
	@Override
	public void eliminarArista(int verticeI, int verticeJ){	//O(1)
		super.eliminarArista(verticeI, verticeJ);
		//Borrar la arista en pesos
		this.vecinosConPeso.get(verticeI).remove(new VecinoConPeso (verticeJ,-1));
		this.vecinosConPeso.get(verticeJ).remove(new VecinoConPeso (verticeI,-1));
		
	}

	public Set<VecinoConPeso> vecinosConPeso(int vertice){	//O(1)
		super.verificarVertice(vertice, "obtener los vecinos de un vertice");
		return this.vecinosConPeso.get(vertice);
	}

	public int peso(int verticeI, int verticeJ) {
		super.verificarArista(verticeI, verticeJ,"consultar ");
		for(VecinoConPeso elem: vecinosConPeso.get(verticeI)) {
			if(verticeJ == elem.getVertice()) {
				return elem.getPeso();
			}
		}
		return -1; //en caso que no exista, va a ser -1
	}

	private int pesoAleatorio() {
		return super.numeroRandomEntre(1, 16); //el peso va entre 1 y 16
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("|Grafo: \n");
		for (int i = 0; i < super._cantidadDeVertices; i++) {
			sb.append("|" + i + ": [ ");
			for(VecinoConPeso elem : this.vecinosConPeso.get(i)) {
				sb.append("[" + elem.toString() + "]");
			}
			sb.append(" ] \n");
		}
		return sb.toString();
	}
	
	//Setters and Getters
	public ArrayList<Set<VecinoConPeso>> getVecinosConPeso() {
		return this.vecinosConPeso;
	}
	public void setVecinosConPeso(ArrayList<Set<VecinoConPeso>> vecinosConPeso) {
		this.vecinosConPeso = vecinosConPeso;
	}

}
