package test;
import logica.GrafoConPeso;
import logica.Kruskal;
import logica.UnionFind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logica.Arista;

public class KruskalTest {

	
	Kruskal arbol;
	@Test
	public void aristaMasChica() {
		GrafoConPeso grafo= new GrafoConPeso(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 3);
		grafo.agregarArista(2, 3, 1);
		grafo.agregarArista(3, 1, 7);
		Arista esperada= new Arista(2,3);
		assertEquals(esperada,Kruskal.aristaMasChica(grafo,grafo.getAristas()));
	}
	@Test (expected =  IllegalArgumentException.class)
	public void kruskalConBFSConGrafoSinAristas() {
		GrafoConPeso grafo= new GrafoConPeso(3);
		Kruskal.kruskalConBFS(grafo);
	}
	@Test (expected =  IllegalArgumentException.class)
	public void kruskalConUFV1ConGrafoSinAristas() {
		GrafoConPeso grafo= new GrafoConPeso(3);
		Kruskal.unionFind(grafo);
	}
	@Test (expected =  IllegalArgumentException.class)
	public void kruskalConUFV2ConGrafoSinAristas() {
		GrafoConPeso grafo= new GrafoConPeso(3);
		Kruskal.unionFind(grafo);
	}
	@Test (expected =  IllegalArgumentException.class)
	public void AristaMasChicaSinAristas() {
		GrafoConPeso grafo= new GrafoConPeso(5);
		Kruskal.aristaMasChica(grafo, grafo.getAristas());
	}
	public void kruskalConBFSSobreGrafoConAristasPeroSinPeso() {
		//este caso sucede cuando se agregan aristas sin peso
		GrafoConPeso grafo= new GrafoConPeso(3); 
		grafo.agregarArista(0, 1);
		grafo.agregarArista(1, 2);
		assertEquals(0,Kruskal.kruskalConBFS(grafo).getAristas().size()); //cuando esto sucede, el arbol no agrega aristas
		//las aristas sin peso no participan de la seleccion
	}
	@Test
	public void kruskalConBFSGrafoEjemplo() {
		GrafoConPeso grafo = grafoEjempo();
		GrafoConPeso arbolGeneradorMinimo= Kruskal.kruskalConBFS(grafo);
		Arista[] esperado= aristaEsperado();
		Assert.conjuntoEsElEsperado(esperado, arbolGeneradorMinimo.getAristas());
	}
	@Test
	public void kruskalUnionFind() {
		GrafoConPeso grafo = grafoEjempo();
		GrafoConPeso arbolGeneradorMinimo= Kruskal.unionFind(grafo);
		Arista[] esperado= aristaEsperado();
		Assert.conjuntoEsElEsperado(esperado, arbolGeneradorMinimo.getAristas());
	}




	//metodos
	public GrafoConPeso grafoEjempo() {
		GrafoConPeso grafo = new GrafoConPeso(9);
		grafo.agregarArista(0,1,4);
		grafo.agregarArista(1,3,8);
		grafo.agregarArista(3,6,6);
		grafo.agregarArista(6,8,9);
		grafo.agregarArista(8,7,10);
		grafo.agregarArista(6,7,13);
		grafo.agregarArista(3,7,4);
		grafo.agregarArista(3,4,3);
		grafo.agregarArista(4,5,5);
		grafo.agregarArista(5,7,3);
		grafo.agregarArista(1,2,12);
		grafo.agregarArista(0,2,8);
		grafo.agregarArista(2,5,1);
		grafo.agregarArista(2,4,6);
		return grafo;
	}
	public Arista[] aristaEsperado() {
		Arista[] esperado= new Arista[] {
				new Arista(0,1),
				new Arista(0,2),
				new Arista(2,5),
				new Arista(5,7),
				new Arista(7,3),
				new Arista(3,4),
				new Arista(3,6),
				new Arista(6,8)
		};
		return esperado;
	}
	
}
