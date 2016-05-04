package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Position;
import be.ac.umons.sgl.gemcraft.g2.Models.Spawn;

public class SpawnTest {

	private Spawn spawn ;
	private Position position;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init() 
	{
		position =new Position(12,76);
		spawn=new Spawn("toto",position);
	}
	 /**
	  *  Setters de la classe
	 */
	@Test
	public void testSpawn() 
	{
		assertEquals("toto",spawn.getName());
		assertEquals(position,spawn.getPosition());
	}

}
