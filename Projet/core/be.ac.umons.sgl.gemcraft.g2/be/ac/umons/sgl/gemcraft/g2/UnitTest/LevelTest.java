package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Level;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;

public class LevelTest {

	private Level level;
	private Position position;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
	  position= new Position (2,6);
		level=new Level("niveau","map",100,200,"path",position,"3");
	}
	 /**
	  *  vérification de la position du nexus
	 */
	@Test
	public void testNexus()
	{
		assertEquals(position,level.getNexus());
	}
	 /**
	  *  Setters de la classe
	 */
	@Test
	public void testLevel()
	{
		assertEquals("niveau",level.getName());
		assertEquals("map",level.getmap());
		assertEquals(100,level.getlifeValue());
		assertEquals(200,level.getmanaValue());
		assertEquals("path",level.getPath());
		assertEquals("3",level.getNbrWaves());
	}

}
