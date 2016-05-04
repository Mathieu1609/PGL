package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.EnnemyType;
import be.ac.umons.sgl.gemcraft.g2.Models.Gem;
import be.ac.umons.sgl.gemcraft.g2.Models.Level;
import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;

public class MonsterTest {
	
	private Position position;
	private Monster monster;
	private Gem g=new Gem("red");
	private EnnemyType ennemyType=new EnnemyType();
	/**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		position= new Position (2,6);
		ennemyType=new EnnemyType("toto",g,0.1f,1.2f,"monster.png",45,25);
		monster=new Monster(position,ennemyType);
	}
	 /**
	  *  vérifiaction si le monstre est vivant 
	 */
	@Test
	public void testIsAlive() {
		assertEquals(true,monster.isAlive());
	}
	 /**
	  *  monstre peut bouger
	 */
	@Test
	public void testCanMoveTrue()
	{
		monster.setDelayMove(6);
		assertEquals(true,monster.canMove());
	
	}
	 /**
	  *  monstre peut bouger
	 */
	@Test
	public void testCanMoveFalse() 
	{
		monster.setDelayMove(1);
		assertEquals(false,monster.canMove());
	}
	 /**
	  *  test le nexus
	 */
	@Test
	public void testNexus() 
	{
		Level level=new Level("niveau","map",100,200,"path",position,"3");
		assertEquals(false,monster.hasReachNexus(level));
	}
	 /**
	  *  vérifiacation des tuiles de la map
	 */
	@Test
	public void testTile()
	{
		monster.defineTile();
		assertEquals((2/32),monster.getTileX());
		assertEquals((6/32),monster.getTileY());
	}

}
