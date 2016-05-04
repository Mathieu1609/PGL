package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import be.ac.umons.sgl.gemcraft.g2.Models.Bullet;
import be.ac.umons.sgl.gemcraft.g2.Models.EnnemyType;
import be.ac.umons.sgl.gemcraft.g2.Models.Gem;
import be.ac.umons.sgl.gemcraft.g2.Models.Gems;
import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;
public class BulletTest {

	private Bullet bullet;
	private Position position;
	private Monster monster;
	
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		position=new Position(32,21);
		monster=new Monster();
		bullet=new Bullet();
		bullet.setDammage(10);
		bullet.setBulletPosition(position);
		bullet.setTarget(monster);
	
	}
	 /**
	  *  test des différents Setters de la classe
	 */
	@Test
	public void testBullet() 
	{
		assertEquals(monster,bullet.getTarget());
		assertEquals(position,bullet.getBulletPosition());
		assertEquals(10,bullet.getDammage());
	}
	 /**
	  *  test pour savoir si on peut frapper
	 */
	@Test
	public void testTir() 
	{
		Monster m =new Monster();
		m.setId(2);
		m.setAlive(true);
		bullet.setIdTarget(2);
		ArrayList<Monster> listM = new ArrayList<Monster>();
		listM.add(m);
		assertEquals(true,bullet.canMove(listM));
	}
	 /**
	  *  test si le tir à atteint la cible
	 */
	@Test
	public void testCible() 
	{
		
		assertEquals(true,bullet.hasReachTarget(32,12,32,12));
	}
	

}
