package logica;


public class VecinoConPeso {
	private int vertice;
	private int peso;

	public VecinoConPeso(int vertice, int peso) {
		this.vertice = vertice;
		this.peso = peso;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vecino: [" + this.vertice + "] - Peso: " + this.peso);
		return sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if (!VecinoConPeso.class.isInstance(obj)) { //si no es del mismo tipo
			System.out.print("no son el mismo tipo");
			return false;
		}
		VecinoConPeso objConvertido= (VecinoConPeso) obj;
		return this.vertice == objConvertido.vertice; 

	}
	@Override
	public int hashCode() {//solo vertice porque el peso no es relevante
		return vertice;
	};
	public int getVertice() {
		return vertice;
	}
	public void setVertice(int vertice) {
		this.vertice = vertice;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

}
