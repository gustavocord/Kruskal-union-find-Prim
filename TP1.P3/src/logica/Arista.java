package logica;


public class Arista implements Comparable<Arista>{
	private int verticeI;
	private int verticeJ;
	private int peso;
	public Arista(int verticeI, int verticeJ){
		if(verticeI<0 || verticeJ<0 || (verticeI==verticeJ)) {
			throw new IllegalArgumentException("La Arista: (" + verticeI + "," + verticeJ + ") no es valida");
		}
		this.verticeI= verticeI;
		this.verticeJ= verticeJ;
		this.peso= -1;//indica que no esta definida
	}
	public Arista(int verticeI, int verticeJ,int peso){
		this(verticeI,verticeJ);
		verificarPeso(peso);
		this.peso= peso;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if (!Arista.class.isInstance(obj)) { //si no es del mismo tipo
			System.out.print("no son el mismo tipo");
			return false;
		}
		Arista objConvertido= (Arista) obj;

		boolean valor= (this.verticeI == objConvertido.verticeI) || (this.verticeI == objConvertido.verticeJ);
		boolean valor2= (this.verticeJ == objConvertido.verticeI) || (this.verticeJ == objConvertido.verticeJ);

		return (valor && valor2);
	}

	@Override
	public int hashCode() {
		int mayor= this.verticeI > this.verticeJ? this.verticeI : this.verticeJ;
		int menor= this.verticeI < this.verticeJ? this.verticeI : this.verticeJ;
		return (Integer.toString(menor) + "," + Integer.toString(mayor)).hashCode(); //de esta forma se distingue mejor
	};
	@Override
	public String toString() {
		return "(" + this.verticeI + "," + this.verticeJ + ")";
	}
	public int getVerticeI() {
		return verticeI;
	}
	public void setVerticeI(int verticeI) {
		this.verticeI = verticeI;
	}
	public int getVerticeJ() {
		return verticeJ;
	}
	public void setVerticeJ(int verticeJ) {
		this.verticeJ = verticeJ;
	}

	@Override
	public int compareTo(Arista o) { //compara el peso
		return this.peso - o.getPeso() ; //orden ascendente

	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	private void verificarPeso(int peso) {
		if(peso < 0) {
			throw new IllegalArgumentException("El valor del peso esta fuera de rango: " + peso);
		}
	}
}

