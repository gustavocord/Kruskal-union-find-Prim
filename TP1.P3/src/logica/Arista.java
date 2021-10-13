package logica;


public class Arista implements Comparable<Arista>{
	private int _verticeI;
	private int _verticeJ;
	private int _peso;
	public Arista(int verticeI, int verticeJ){
		if(verticeI<0 || verticeJ<0 || (verticeI==verticeJ)) {
			throw new IllegalArgumentException("La Arista: (" + verticeI + "," + verticeJ + ") no es valida");
		}
		this._verticeI= verticeI;
		this._verticeJ= verticeJ;
		this._peso= -1;//indica que no esta definida
	}
	public Arista(int verticeI, int verticeJ,int peso){
		this(verticeI,verticeJ);
		verificarPeso(peso);
		this._peso= peso;
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

		boolean valor= (this._verticeI == objConvertido._verticeI) || (this._verticeI == objConvertido._verticeJ);
		boolean valor2= (this._verticeJ == objConvertido._verticeI) || (this._verticeJ == objConvertido._verticeJ);

		return (valor && valor2);
	}

	@Override
	public int hashCode() {
		int mayor= this._verticeI > this._verticeJ? this._verticeI : this._verticeJ;
		int menor= this._verticeI < this._verticeJ? this._verticeI : this._verticeJ;
		return (Integer.toString(menor) + "," + Integer.toString(mayor)).hashCode(); //de esta forma se distingue mejor
	};
	@Override
	public String toString() {
		return "(" + this._verticeI + "," + this._verticeJ + ")";
	}
	public int getVerticeI() {
		return _verticeI;
	}
	public void setVerticeI(int verticeI) {
		this._verticeI = verticeI;
	}
	public int getVerticeJ() {
		return _verticeJ;
	}
	public void setVerticeJ(int verticeJ) {
		this._verticeJ = verticeJ;
	}

	@Override
	public int compareTo(Arista o) { //compara el peso
		return this._peso - o.getPeso() ; //orden ascendente

	}
	public int getPeso() {
		return _peso;
	}
	public void setPeso(int peso) {
		this._peso = peso;
	}
	private void verificarPeso(int peso) {
		if(peso < 0) {
			throw new IllegalArgumentException("El valor del peso esta fuera de rango: " + peso);
		}
	}
}

