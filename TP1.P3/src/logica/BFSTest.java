package logica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BFSTest {
	@Test(expected = NullPointerException.class)
	public void testEsConexoNull() {
		Grafo g = null;
		BFS.esConexo(g);
	}

	@Test
	public void testEsConexo() {
		Grafo g = new Grafo(4);

		g.agregarArista(0, 1, 10);
		g.agregarArista(0, 3, 10);
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 3, 10);

		assertTrue(BFS.esConexo(g));
	}

	@Test
	public void testNoEsConexo() {
		Grafo g = new Grafo(4);

		g.agregarArista(0, 1, 10);
		g.agregarArista(2, 3, 10);

		assertFalse(BFS.esConexo(g));
	}

	@Test(expected = NullPointerException.class)
	public void testAlcanzablesNull() {
		Grafo g = null;
		BFS.alcanzables(g, 0);
	}

	@Test
	public void testAlcanzables() {
		Grafo g = new Grafo(5);

		g.agregarArista(0, 1, 10);
		g.agregarArista(0, 3, 10);
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 3, 10);

		Set<Integer> resultado = BFS.alcanzables(g, 0);
		Set<Integer> esperado = new HashSet<Integer>();
		esperado.add(0);
		esperado.add(1);
		esperado.add(2);
		esperado.add(3);
		assertTrue(resultado.containsAll(esperado));

	}

	@Test
	public void testRaicesAgregarArista() {
		Grafo g = new Grafo(5);
		g.agregarArista(2, 3, 10);
		int[] raicesEsperadas = { 0, 2, 4, 5 };

		assertTrue(sonIguales(raicesEsperadas, (ArrayList<Integer>) g.getRaices()));

	}

	@Test
	public void testActualizarRaicesQuitoArista() {
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1, 10);
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 3, 10);
		g.quitarArista(1, 2);
		int[] raicesEsperadas = { 1, 3 };

		assertTrue(sonIguales(raicesEsperadas, (ArrayList<Integer>) g.getRaices()));
	}

	private static boolean sonIguales(int[] esperado, ArrayList<Integer> resultado) {
		if (esperado.length != resultado.size())
			return false;

		for (Integer res : resultado) {
			if (!resultado.contains(res))
				return false;
		}

		return true;
	}

}
