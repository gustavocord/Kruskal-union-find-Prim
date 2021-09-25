package logica;



public class UnionFind {
	private int[] Raices;
	
	UnionFind(GrafoConPeso a){
		int[] raices=new int[a.getVertice()];
		for(int i=0; i<a.vertices(); i++) {
			raices[i]=i;		
		}
		Raices=raices;
	}
	
	public int buscarRaiz(int i) {
		while(Raices[i]!=i) {
			i=Raices[i];
		}
		return i;
	}
	
	public boolean mismaCompConexa(int i,int j) {
		return Raices[i]==Raices[j];
	}
	
	public void unir(int i, int j) {
		int raizDei=buscarRaiz(i);
		int raizDej=buscarRaiz(j);
		Raices[raizDei]=raizDej;
	}

}