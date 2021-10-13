package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logica.Grafo;

public class GrafoTest {

	private Grafo grafo = new Grafo(5);

	//Valores de i y j invalidos
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaSobreElMismoVertice(){
		grafo.agregarArista(0, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaISuperior(){
		grafo.agregarArista(5, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaJSuperior(){
		grafo.agregarArista(0, 5);
	}

	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaIInferior(){
		grafo.agregarArista(-1, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaJInferior(){
		grafo.agregarArista(0, -1);
	}

	//Agregar y eliminar arista
	@Test
	public void agregarArista() {
		grafo.agregarArista(0, 1);
		assertTrue(grafo.existeArista(0, 1));
	}

	@Test
	public void agregarAristaEsSimetrica() {
		grafo.agregarArista(0, 1);
		assertTrue(grafo.existeArista(1, 0));
	}
	@Test
	public void agregarAristaDosVeces() {
		grafo.agregarArista(0, 1);
		grafo.agregarArista(1, 0);
		assertEquals(1,grafo.vecinos(0).size());
	}
	@Test
	public void eliminarArista() {
		grafo.agregarArista(0, 1);
		grafo.eliminarArista(0, 1);
		assertFalse(grafo.existeArista(0, 1));
	}

	@Test
	public void eliminarAristaEsSimetrica() {
		grafo.agregarArista(0, 1);
		grafo.eliminarArista(1, 0);
		assertFalse(grafo.existeArista(0, 1));
	}

	@Test (expected = IllegalArgumentException.class)
	public void eliminarAristaDosVeces() {
		grafo.agregarArista(0, 1);
		grafo.eliminarArista(0, 1);
		grafo.eliminarArista(1, 0);
	}

	//Vecinos
	@Test
	public void vecinoTamanio0(){
		assertEquals(0, grafo.vecinos(1).size());
	}
	@Test
	public void vecinoTamanio(){
		this.grafo = grafoEjemplo();
		assertEquals(2, grafo.vecinos(0).size());
	}

	@Test
	public void esVecino(){
		this.grafo = grafoEjemplo();
		assertTrue(this.grafo.vecinos(0).contains(1));

	}

	@Test
	public void noEsVecino(){
		this.grafo = grafoEjemplo();
		assertFalse(this.grafo.vecinos(0).contains(2));
	}

	//Grado
	@Test
	public void grado(){
		this.grafo = grafoEjemplo();
		assertEquals(2, this.grafo.grado(1));
	}

	@Test
	public void gradoCero(){
		this.grafo = grafoEjemplo();
		assertEquals(0, this.grafo.grado(4));

	}

	//BFF
	@Test
	public void esConexoGrafoVacio(){
		Grafo grafoVacio = new Grafo(0);
		assertFalse(grafoVacio.esConexo());
	}

	@Test
	public void esNoConexo(){
		assertFalse(grafo.esConexo());
	}

	@Test
	public void esConexo(){
		this.grafo = grafoEjemplo();
		this.grafo.agregarArista(3,4);
		assertTrue(grafo.esConexo());
	}
	@Test 
	public void esArbol() {
		this.grafo= new Grafo(4);
		this.grafo.agregarArista(0, 1);
		this.grafo.agregarArista(1, 2);
		this.grafo.agregarArista(2, 3);
		assertTrue(this.grafo.esUnArbol());
	}
	@Test 
	public void noEsArbol() {
		this.grafo= grafoEjemplo();
		assertFalse(this.grafo.esUnArbol());
	}
	@Test
	public void GrafoAleatorioConexo() {
		this.grafo= new Grafo(5, 4);
		//System.out.print(this.grafo.esUnArbol());
		assertTrue(this.grafo.esUnArbol());
	}
	@Test (expected = IllegalArgumentException.class)
	public void GrafoAleatorioConexoConCantAristasMenoresACantVertices() {
		this.grafo= new Grafo(5, 3);
	}
	@Test (expected = IllegalArgumentException.class)
	public void grafoAleatorioConExcedenteDeAristas() {
		this.grafo= new Grafo(5, 11);
	}
	@Test (expected = IllegalArgumentException.class)
	public void grafoAleatorioConCantAristasMenoresA0() {
		this.grafo= new Grafo(5, -1);
	}
	//Metodos
	private Grafo grafoEjemplo(){
		Grafo grafoEjempo= new Grafo(5);
		grafoEjempo.agregarArista(0, 1);
		grafoEjempo.agregarArista(1, 2);
		grafoEjempo.agregarArista(2, 3);
		grafoEjempo.agregarArista(3, 0);
		System.out.println(grafoEjempo.toString());
		return grafoEjempo;
	}
}

