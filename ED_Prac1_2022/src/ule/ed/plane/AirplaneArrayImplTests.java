package ule.ed.plane;

import static org.junit.Assert.*;

import org.junit.*;



public class AirplaneArrayImplTests {

	
	private AirplaneArrayImpl plane;
	
	
	@Before
	public void testBefore() throws Exception{
	 plane = new AirplaneArrayImpl("A001", 3, 4);

	}
	
	
	@Test
	public void testContadores_AvionVacio() throws Exception{	
        assertEquals(plane.getNumberOfChildren(),0);
        assertEquals(plane.getNumberOfPassengers(),0);
    	}

	@Test(expected=NoneChildrenInAvionException.class)
	public void testGetNumberOfColumnWithMoreChildren_AvionVacio() throws Exception{
		 assertEquals(plane.getNumberOfColumnWithMoreChildren(),0);
 	}
	
	@Test(expected=NoneChildrenInAvionException.class)
	public void testGetNumberOfRowWithMoreChildren_AvionVacio() throws Exception{
		 assertEquals(plane.getNumberOfRowWithMoreChildren(),0);
 	}
	
	@Test
	public void testGetters_AvionVacio() throws Exception {
	    assertEquals(plane.getName(),"A001");
	    assertEquals(plane.getNumberOfColumns(),4);
	    assertEquals(plane.getNumberOfRows(),3);
	}
	
	
	// Test insertar pasajero sin fila y columna 
	@Test	
	public void testInsertaPasajero() throws Exception{	
		
	    assertTrue(plane.addPassenger("10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
	    assertTrue(plane.isOccupiedSeat(1,1));
	    assertEquals(plane.getNumberOfChildren(),1);
        assertEquals(plane.getNumberOfPassengers(),1);
        assertEquals(plane.getNumberOfColumnWithMoreChildren(),1);
	
	}
	
	// Test insertar pasajero con fila y columna (posición ocupada)
		@Test	
		public void testInsertaPasajeroPosNoValida() throws Exception{	
			
		    assertTrue(plane.addPassenger(1,1,"10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
		    assertTrue(plane.isOccupiedSeat(1,1));
		    assertEquals(plane.getNumberOfChildren(),1);
	        assertEquals(plane.getNumberOfPassengers(),1);
	        assertEquals(plane.getNumberOfColumnWithMoreChildren(),1);
	        assertFalse(plane.addPassenger(1,2,"10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
			   
		}
		
		// Test insertar pasajero con fila y columna comprobando lista de posiciones ocupadas
				@Test	
				public void testInsertaPasajero_ListOccupied() throws Exception{	
					
				    assertTrue(plane.addPassenger(1,1,"10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
				    assertTrue(plane.isOccupiedSeat(1,1));
				    assertEquals(plane.getNumberOfChildren(),1);
			        assertEquals(plane.getNumberOfPassengers(),1);
			        assertEquals(plane.getNumberOfColumnWithMoreChildren(),1);
			        assertEquals(plane.getListOfOccupiedSeats().toString(),"[(1,1)]");
				}

				@Test	
				public void testInsertaPasajero_Repetido() throws Exception{	
					
				    assertTrue(plane.addPassenger(1,1,"10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
				    assertTrue(plane.isOccupiedSeat(1,1));
				    assertFalse(plane.addPassenger(2,2,"10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
					  
				}
				
				@Test
				public void testToStringAvion() throws Exception{

				    assertTrue(plane.addPassenger(1,1,"10203040X", "Pedro", 17)); // inserta en fila=1, columna=1
				    assertTrue(plane.isOccupiedSeat(1,1));
				    assertTrue(plane.addPassenger(2,2,"10203050C", "Ana", 27)); // inserta en fila=1, columna=1
					assertEquals(plane.toString(),"[(10203040X-Pedro-17)(null)(null)(null)\n" +
							"(null)(10203050C-Ana-27)(null)(null)\n" +
							"(null)(null)(null)(null)\n" +
							"]");
				}
				@Test
				public void mytest() throws Exception{
					assertTrue(plane.addPassenger(2,1,"10203050C", "Ana", 27));
				}



}
