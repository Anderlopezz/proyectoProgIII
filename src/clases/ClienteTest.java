package clases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.utils;

public class ClienteTest 
{
	private Cliente c;
	private Cliente c1;

	@Before
	public void setUp() throws Exception {
		this.c= new Cliente(1, 20);
		this.c1= new Cliente(2, 30);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testSumarEdades() {
		int sumar= utils.sumarEdades(c, c1);
		assertEquals(50,sumar, 0.0);
		//fail("Not yet implemented");
	}
	
	public void testSumarEdades_Exception_Test() throws Exception{
		try{
			
			fail();
		}
		catch (Exception E){
			int sumar= utils.sumarEdades(c, c1);
		}
	}

}


