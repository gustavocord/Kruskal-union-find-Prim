package test;

import java.util.Set;
import static org.junit.Assert.*;

public class Assert {
	public static <T> void conjuntoEsElEsperado(T[] esperado, Set<T> conjunto)
	{
		//dada un array, se fija si es igual al conjunto
		boolean todosPertenecen= true;
		for ( T elem: esperado) {
			todosPertenecen&= conjunto.contains(elem);
		}
		assertTrue(todosPertenecen&& (esperado.length == conjunto.size()));
	}

}
