package logica;

public class UnionFind {
    private GrafoConPeso grafo;
    private int[] raices;

    public UnionFind(int cantidadDeVertices) {
        this.grafo = new GrafoConPeso(cantidadDeVertices);
        this.raices = new int[cantidadDeVertices];
        for (int i = 0; i < cantidadDeVertices; i++) {
            this.raices[i] = i;
        }
    }

    public void agregarArista(int verticeI, int verticeJ, int peso) {
        union(verticeI, verticeJ);// uno a los subconjuntos
        this.grafo.agregarArista(verticeI, verticeJ, peso); // y agrego la arista al grafo
    }

    public int raiz(int i) {
        while (this.raices[i] != i) {
            i = this.raices[i];
        }
        return i;
    }

    public void union(int i, int j) {
        int raizDeI = raiz(i);
        int raizDeJ = raiz(j);
        if (this.grafo.grado(raizDeI) < this.grafo.grado(raizDeJ)) {
            // la raiz del mas chico debe tener como raiz al mas grande
            this.raices[raizDeI] = raizDeJ;
        } else {
            if (this.grafo.grado(raizDeI) > this.grafo.grado(raizDeJ)) {
                this.raices[raizDeJ] = raizDeI;
            } else {// son iguales
                this.raices[raizDeJ] = raizDeI;
            }
        }
    }

    public boolean find(int i, int j) { // Muestra si esta en la misma componente conexa
        return raiz(i) == raiz(j);
    }

    public GrafoConPeso getGrafo() {
        return this.grafo;
    }

    public int[] getRaices() {
        return raices;
    }
    //sfsfds

    public void setRaices(int[] raices) {
        this.raices = raices;
    }

    public void setGrafo(GrafoConPeso grafo) {
		this.grafo = grafo;
	}

}
