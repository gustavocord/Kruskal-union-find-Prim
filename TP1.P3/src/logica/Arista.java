package logica;


public class Arista implements Comparable<Arista>{
	private int origen ;
	private int destino ;
	private int peso ;
	
	public Arista(int a , int b , int peso) {
		this.origen = a;
		this.destino = b;
		this.peso = peso;
	}

	public int getA() {
		return origen+0;
	}

	public int getB() {
		return destino+0;
	}
	public int getPeso() {
		return peso+0;
	}

	@Override
	public int compareTo(Arista o) {
		if(this.peso<o.peso) {
			return -1;
		}else if (this.peso>o.peso) {
			return 1;
		}
		return 0;
	}

	public void setPeso(int peso2) {
		this.peso = peso2;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + origen;
		result = prime * result + destino;
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
		if (origen != other.origen)
			return false;
		if (destino != other.destino)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Arista [a=");
		builder.append(origen);
		builder.append(", b=");
		builder.append(destino);
		builder.append(", peso=");
		builder.append(peso);
		builder.append("]");
		return builder.toString();
	}

	

}
