package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.GrafoConPeso;
import logica.VecinoConPeso;

public class GrafoConPesoTest {
	GrafoConPeso grafo= new GrafoConPeso(5);

	@Test
	public void agregarArista() {
		this.grafo.agregarArista(0, 1, 5);
		this.grafo.agregarArista(0, 1, 5);
		boolean valoresAComprobar= grafo.existeArista(0, 1) && (grafo.peso(0,1)==5);
		assertTrue(valoresAComprobar);
	}
	@Test
	public void agregarVariasVecesAristaConDistintoPeso() {
		this.grafo.agregarArista(0, 1, 5);
		this.grafo.agregarArista(0, 1, 8);
		boolean valoresAComprobar= grafo.existeArista(0, 1) && (grafo.peso(0,1)==5);
		assertTrue(valoresAComprobar);
	}
	@Test
	public void peso() {
		this.grafo= grafoConPesoEjemplo();
		assertEquals(5, grafo.peso(1, 2));
	}
	public void pesoDeUnaAristaNoExistente() {
		assertEquals(-1, grafo.peso(1, 2));
	}
	@Test
	public void eliminarArista() {
		this.grafo= grafoConPesoEjemplo();
		grafo.eliminarArista(0, 1);
		boolean valoresAComprobar= !grafo.existeArista(0, 1) && (grafo.peso(0,1)==-1);
		assertTrue(valoresAComprobar);
	}
	@Test
	public void vecinosConPeso() {
		this.grafo= grafoConPesoEjemplo();

		VecinoConPeso[] expetativa= new VecinoConPeso[] {new VecinoConPeso(1,1),new VecinoConPeso(3,4)}; //creo el conjunto que espero
		//los vecinos de 0 son 1(con peso 1) y 3 (con peso 4)

		Assert.conjuntoEsElEsperado(expetativa , this.grafo.vecinosConPeso(0));
	}

	private GrafoConPeso grafoConPesoEjemplo(){
		GrafoConPeso grafoConPesoEjempo= new GrafoConPeso(5);
		grafoConPesoEjempo.agregarArista(0, 1 , 1);
		grafoConPesoEjempo.agregarArista(1, 2 , 5);
		grafoConPesoEjempo.agregarArista(2, 3 , 2);
		grafoConPesoEjempo.agregarArista(3, 0 , 4);
		return grafoConPesoEjempo;
	}
}

