package logica;

import java.util.Set;
import java.util.TreeSet;

public class Vertice implements Comparable<Vertice> {
	private int id;
	private int padre;
	private Set<Vertice> vecinos;

	// Constructor
	protected Vertice(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("El numero de ID debe ser mayor o igual a 0");
		}
		this.id = id;
		this.vecinos = new TreeSet<Vertice>();
		this.padre = id;

	}

	// Metodos propios de la clase

	protected void agregarVecino(Vertice v) {

		if (v.getId() != this.id) {
			this.vecinos.add(v);

			v.getVecinos().add(this);
		}

	}

	protected void quitarVecino(Vertice v) {
		if (v == null) {
			throw new NullPointerException("El vertice no existe");
		}
		this.vecinos.remove(v);
		v.getVecinos().remove(this);
	}

	protected boolean esVecinoDe(Vertice v) {
		if (v == null) {
			throw new NullPointerException("El vertice no existe");
		}
		for (Vertice vertice : this.vecinos) {
			if (vertice.equals(v)) {
				return true;
			}
		}
		return false;
	}

	// Getters y Setters

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected int getPadre() {
		return padre;
	}

	protected int getGrado() {
		return this.vecinos.size();
	}

	protected void setPadre(int padre) {
		this.padre = padre;
	}

	protected Set<Vertice> getVecinos() {
		return vecinos;
	}

	// Metodos Override

	@Override
	public String toString() {
		return "(" + id + ")";

	}

	@Override
	public int compareTo(Vertice otro) {
		if (this == null && otro != null || this != null && otro == null || this.id != otro.getId()) {
			return -1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Vertice other = (Vertice) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
