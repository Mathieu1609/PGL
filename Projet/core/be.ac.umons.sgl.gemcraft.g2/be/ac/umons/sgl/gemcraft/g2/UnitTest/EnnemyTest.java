package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Ennemy;
import be.ac.umons.sgl.gemcraft.g2.Models.EnnemyType;
import be.ac.umons.sgl.gemcraft.g2.Models.Gem;

import org.junit.*;

public class EnnemyTest {

	private Ennemy ennemy;
	private EnnemyType ennemyType;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		Gem g=new Gem("red");
		ennemyType=new EnnemyType("toto",g,(float)2.1,(float)1.2,"monster.png",45,25);
		ennemy=new Ennemy(ennemyType,12);
	}
	 /**
	  *  test des différents Setters de la classe
	 */
	@Test
	public void testEnnemy() 
	{
		// test de la quantité 
		assertEquals(12,ennemy.getQuantity());
		// test du type d'ennemi 
		assertEquals(ennemyType,ennemy.getType());
	}
	

}
