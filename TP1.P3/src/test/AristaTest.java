package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import logica.Arista;

public class AristaTest {

	@Test (expected = IllegalArgumentException.class)
	public void aristaFueraDeRango() {
		new Arista(-1,-1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void aristaMismoVertice() {
		new Arista(0,0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void aristaConPesoNoValido() {
		new Arista(0,1,-1);
	}

	@Test 
	public void equalsTest() {
		Arista aristaEjem1= new Arista(5,1);
		Arista aristaEjem2= new Arista(1,5);
		assertEquals(aristaEjem1,aristaEjem2);
	}
	@Test 
	public void conjuntoDeAristas() {
		Set<Arista> aristas= new HashSet<Arista>();
		aristas.add(new Arista(0,1));
		aristas.add(new Arista(1,0));
		aristas.add(new Arista(5,1));
		aristas.add(new Arista(1,5));
		aristas.add(new Arista(1,2));
		System.out.println(aristas.toString());
		Arista[] conjEsperado= new Arista[]{ new Arista(0,1) , new Arista(5,1), new Arista(1,2)};
		System.out.println(conjEsperado.toString());
		Assert.conjuntoEsElEsperado(conjEsperado, aristas);
	}


	@Test
	public void toStringTest() {
		Arista aristaEjem= new Arista(0,1);
		assertEquals("(0,1)" , aristaEjem.toString());
	}

}
