package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Cliente;

public class testCliente {
	private Cliente a;

	@Before
	public void setUp() throws Exception {
		
		a=new Cliente();
		a.setId(1);
		a.setNombre("Ander");
		a.setApellido("Lopez");
		a.setEdad(20);
		a.setValorCompras(650000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		a.setApellido("Perez");
		assertEquals("Perez", a.getApellido());
	}

}
