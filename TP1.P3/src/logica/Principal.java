package logica;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		System.out.println("probando kruskal");
		Kruskal kruskal = new Kruskal(9);
		kruskal.g.setArista(2, 3, 350);
		kruskal.g.setArista(0, 1, 250);
		kruskal.g.setArista(1, 2, 120);
		
		kruskal.agregarArista(new Arista(1,2,120));
		Arista minima = kruskal.getMinimaNoMarcada();
		System.out.println(new Arista(0, 1, 250).equals(minima));
	}

}