package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Position;

public class PositionTest {

	private Position positionInt,positionFloat;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		positionInt=new Position (2,6);
		positionFloat = new Position((float)2.4,(float)1.9);
	}
	 /**
	  *  position en Int
	 */
	@Test
	public void testPositionInt() {
		assertEquals(2,positionInt.getIntAbscisse());
		assertEquals(6,positionInt.getIntOrdonne());
	}
	 /**
	  *  position en float
	 */
	@Test
	public void testPositionFloat() {
	//Assert.assertEquals(expected, actual, delta)delta between expected and actual for which both numbers are still considered equal.

		assertEquals(2.4f,positionFloat.getAbscisse(),0);
		assertEquals(1.9f,positionFloat.getOrdonne(),0);
	}

}
