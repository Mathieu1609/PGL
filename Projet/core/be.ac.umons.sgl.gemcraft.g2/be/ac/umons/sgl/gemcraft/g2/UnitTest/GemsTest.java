package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Gem;
import be.ac.umons.sgl.gemcraft.g2.Models.Gems;

public class GemsTest {

	private Gems gems;
	private Gem g;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		g=new Gem("green");
		gems=new Gems(g,2);
	}
	 /**
	  *  test des Setters de la classe
	 */
	@Test
	public void testGem() 
	{
		assertEquals(g,gems.getGemme());
		assertEquals(2,gems.getQuantity());
		assertEquals("2",gems.getStringQuantity());
	}
	
}
