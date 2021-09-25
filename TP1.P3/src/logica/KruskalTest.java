package logica;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class KruskalTest {

	Kruskal kruskal = new Kruskal(9);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDameMinimaNoMarcada() {
		
		kruskal.g.setArista(2, 3, 350);
		kruskal.g.setArista(0, 1, 250);
		kruskal.g.setArista(1, 2, 120);
		
		kruskal.agregarArista(new Arista(1,2,120));
		Arista minima = kruskal.getMinimaNoMarcada();
		assertEquals(new Arista(0, 1, 250), minima);
		
		kruskal.agregarArista(new Arista(0,1,250));
		minima = kruskal.getMinimaNoMarcada();
		assertEquals(new Arista(2, 3, 350), minima);
	}

}
