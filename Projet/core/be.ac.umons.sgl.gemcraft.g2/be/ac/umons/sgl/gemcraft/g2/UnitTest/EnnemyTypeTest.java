package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.EnnemyType;
import be.ac.umons.sgl.gemcraft.g2.Models.Gem;

public class EnnemyTypeTest {
	
	private EnnemyType ennemyType;
	private Gem g=new Gem("red");
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		ennemyType=new EnnemyType("toto",g,2.1f,1.2f,"monster.png",45,25);
	}
	 /**
	  *  test des différents Setters de la classe
	 */
	@Test
	public void testCreateEnnemyType() {
		// test le nom
		assertEquals("toto",ennemyType.getName());
		// test le type de gem
		assertEquals(g,ennemyType.getImmunity());
		// test la vitesse
		assertEquals(2.1f,ennemyType.getSpeed(),0);
		// test la taille
		assertEquals(1.2f,ennemyType.getSize(),0);
		// test le sprite
		assertEquals("monster.png",ennemyType.getSprite());
		// test le nombre de vie
		assertEquals(45,ennemyType.getLife());
		// test le nombre de mana
		assertEquals(25,ennemyType.getMana());
	}

}
