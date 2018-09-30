package demo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateTest {
    Calculation cal=new Calculation();
	
    @BeforeClass
    public static void beforeClass() {
    	System.out.println("this is before class");
    }
	
	@Test
	public void testAdd() {
		assertEquals(11,cal.add(7, 4));
	}
	
	
	@Test
	public void testMult() {
		assertEquals(6,cal.mult(3, 2));
	}

}
