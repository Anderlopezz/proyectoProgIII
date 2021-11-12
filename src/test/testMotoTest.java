package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Coche;
import clases.Moto;

public class testMotoTest {
	private Moto a;

	@Before
	public void setUp() throws Exception {
		a=new Moto(0, null, null, null, 0, 0);
		a.setId(1);
		a.setMarca("Ducati");
		a.setModelo("Yt");
		a.setColor("Rojo");
		a.setPrecio(18000);
		a.setKilometros(1378);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		a.setMarca("Ducati");
		assertEquals("Ducati", a.getMarca());
	}

}
