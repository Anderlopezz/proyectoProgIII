package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Coche;


public class testCocheTest {
	private Coche a;

	@Before
	public void setUp() throws Exception {
		
		a=new Coche(0, null, null, null, 0, 0);
		a.setId(1);
		a.setMarca("Ferrari");
		a.setModelo("SF900");
		a.setColor("Rojo");
		a.setPrecio(450000);
		a.setKilometros(2756);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		a.setMarca("Ferrari");
		assertEquals("Ferrari", a.getMarca());
	}

}
