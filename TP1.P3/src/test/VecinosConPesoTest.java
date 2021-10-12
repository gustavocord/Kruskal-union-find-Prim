package test;
import logica.VecinoConPeso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VecinosConPesoTest {
	@Test
	public void equalsTest() {
		VecinoConPeso uno= new VecinoConPeso(1,5);
		VecinoConPeso dos= new VecinoConPeso(1,8);
		//notar que ambos tienen distintos peso
		assertEquals(uno,dos); //ambos son iguales, ya que, no importa el peso sino el vertice 
	}
	@Test
	public void toStringTest() {
		VecinoConPeso prueba= new VecinoConPeso(1,5);
		String expetativa= "Vecino: [" + prueba.getVertice() + "] - Peso: " + prueba.getPeso();
		assertEquals(expetativa,prueba.toString());
	}


}
