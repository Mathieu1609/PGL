package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Gem;

public class GemTest {

	private Gem gem;
	private String color;
	/**
	  *  Initialisation des différentes variables
	 */
	@Before 
	public void init ()
	{
		color="red";
		gem = new Gem(color);
	}
	/**
	  *  test du Setter de la classe
	 */
	@Test
	public void testColor() 
	{
		assertEquals("red",gem.getColor());
	}

}
