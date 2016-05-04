package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.g2d.Sprite;

import be.ac.umons.sgl.gemcraft.g2.Models.Gem;
import be.ac.umons.sgl.gemcraft.g2.Models.Gems;
import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;
import be.ac.umons.sgl.gemcraft.g2.Models.Tower;

public class TowerTest {

	private Tower tower;
	String couleur="red";
	Gem gem= new Gem(couleur);
	Gems g= new Gems(gem,2);
	private ArrayList<Gems> listGems = new ArrayList<Gems>();
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		tower= new Tower(new Sprite(),new Position(22,23),1);
		tower.setListGem(listGems);
		tower.initialisationGemmes();
	}
	 /**
	  *  tets la pureté de la tour
	 */
	@Test
	public void testPure()
	{	
		assertEquals(true,tower.isPure());
	}
	 /**
	  *  ajout d'une gem
	 */
	@Test
	public void testAddGem()
	{	
		tower.addGem(couleur);
		assertEquals(1,tower.getNbrGem());
		
	}
	 /**
	  *  suppression d'une gem
	 */
	@Test
	public void testRemoveGem()
	{	
		tower.addGem(couleur);
		tower.removeGem(couleur);
		assertEquals(0,tower.getNbrGem());
		
	}
	 /**
	  *  Setters de la classe
	 */
	@Test
	public void testTower()
	{
		assertEquals(1,tower.getNum());
		assertEquals(22,tower.getPosition().getIntAbscisse());
		assertEquals(23,tower.getPosition().getIntOrdonne());
	}
	 /**
	  *  test création d'un tir
	 */
	@Test
	public void testBullet()
	{
		
	}
	
	
}
