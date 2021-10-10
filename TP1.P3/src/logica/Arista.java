package logica;
public class Arista implements Comparable<Arista> {
	private int peso;
	private Vertice extremo1;
	private Vertice extremo2;

	// Constructor
	public Arista(Vertice u, Vertice v, int peso) {
		if (u == null || v == null) {
			throw new NullPointerException("Uno de los vertices no existe.");

		}
		if (u.compareTo(v) == 0) {
			throw new IllegalArgumentException("La arista no puede tener el mismo vertice en ambos extremos.");
		}
		if (peso < 0) {
			throw new IllegalArgumentException("El peso no puede ser negativo.");
		}
		this.extremo1 = u;
		this.extremo2 = v;
		this.peso = peso;
	}

	// Getters y Setters

	protected int getPeso() {
		return peso;
	}

	protected void setPeso(int peso) {
		this.peso = peso;
	}

	public Vertice getExtremo1() {
		return extremo1;
	}

	protected void setExtremo1(Vertice extremo1) {
		this.extremo1 = extremo1;
	}

	public Vertice getExtremo2() {
		return extremo2;
	}

	protected void setExtremo2(Vertice extremo2) {
		this.extremo2 = extremo2;
	}

	// Metodos override

	@Override
	public int compareTo(Arista a) {
		if (this != null && a == null || this == null && a != null || this.peso != a.getPeso()) {
			return -1;
		} else if (this.extremo1.compareTo(a.getExtremo1()) == 0 && this.extremo2.compareTo(a.getExtremo2()) == 0
				|| this.extremo1.compareTo(a.getExtremo2()) == 0 && this.extremo2.compareTo(a.getExtremo1()) == 0) {
			return 0;
		}
		return -1;

	}

	@Override
	public String toString() {
		return "[" + extremo1 + "," + extremo2 + "," + "P" + peso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extremo1 == null) ? 0 : extremo1.hashCode());
		result = prime * result + ((extremo2 == null) ? 0 : extremo2.hashCode());
		result = prime * result + peso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (extremo1 == null) {
			if (other.extremo1 != null)
				return false;
		} else if (!extremo1.equals(other.extremo1))
			return false;
		if (extremo2 == null) {
			if (other.extremo2 != null)
				return false;
		} else if (!extremo2.equals(other.extremo2))
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}

}
