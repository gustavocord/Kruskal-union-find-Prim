package test;
import logica.UnionFind;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnionFindTest {


	@Test
	public void raizTest() {
		UnionFind uf = inicializarEjemplo(); 
		int[] raices = {0,1,2,3,4};
		assertArrayEquals(raices, uf.getRaices());
	}
	@Test
	public void agregarUnaAristaTest() {
		UnionFind uf = inicializarEjemplo(); 
		uf.agregarArista(0, 1, 10);
		int[] raices = {0,0,2,3,4};
		assertArrayEquals(raices, uf.getRaices());
	}
	@Test
	public void agregarAristasGrafoNoConexo() {
		UnionFind uf = inicializarEjemplo(); 
		uf.agregarArista(0, 1, 10);
		uf.agregarArista(3, 4, 10);
		int[] raices = {0,0,2,3,3};
		assertArrayEquals(raices, uf.getRaices());
	}
	public void agregarAristasGrafoConexo() {
		UnionFind uf = inicializarEjemplo(); 
		uf.agregarArista(0, 1, 10); 
		uf.agregarArista(3, 2, 10); 
		uf.agregarArista(1, 3, 10);
		uf.agregarArista(1, 2, 10);
		uf.agregarArista(4, 2, 10);
		int[] raices = {0,0,0,0,0};
		assertArrayEquals(raices, uf.getRaices());
	}
	public void agregarAristasGrafoConexo2() {
		UnionFind uf = inicializarEjemplo(); 
		uf.agregarArista(1, 0, 10); 
		uf.agregarArista(3, 2, 10); 
		uf.agregarArista(4, 3, 10);
		uf.agregarArista(2, 1, 10);
		uf.agregarArista(4, 2, 10);
		int[] raices = {3,3,3,3,3};
		assertArrayEquals(raices, uf.getRaices());
	}
	@Test
	public void agregarDosAristasSobreUnMismoVertice() {
		UnionFind uf = inicializarEjemplo(); 
		uf.agregarArista(0, 1, 10); 
		uf.agregarArista(3, 2, 10); 
		uf.agregarArista(1, 3, 10);
		int[] raices = {0,0,3,0,4};
		assertArrayEquals(raices, uf.getRaices());
	}
	private UnionFind inicializarEjemplo() {
		UnionFind uf = new UnionFind(5);
		return uf;
	}
}
