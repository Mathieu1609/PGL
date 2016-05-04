package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Ennemy;
import be.ac.umons.sgl.gemcraft.g2.Models.Groupe;
import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Spawn;

public class GroupeTest {

	private Groupe groupe;
	private ArrayList<Ennemy> listEnnemy;
	Monster monster= new Monster();
	private Ennemy ennemy=new Ennemy();
	private Spawn spawn = new Spawn();
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		listEnnemy=new ArrayList<Ennemy>();
		groupe= new Groupe(spawn,(float)2.3,20,listEnnemy);
	}
	 /**
	  * ajout d'un ennemi dans le groupe
	 */
	@Test
	public void testAddEnnemy() 
	{
		groupe.addEnnemy(ennemy);
		assertEquals(1,listEnnemy.size());
	}
	 /**
	  *   suppression d'un ennemi dans le groupe
	 */
	@Test
	public void testSuppEnnemy() 
	{
		groupe.removeEnnemy(ennemy);
		assertEquals(0,listEnnemy.size());
	}
	 /**
	  *   création d'un monstre 
	 */
	@Test
	public void testCreateMonster() 
	{
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		monsterList=groupe.createMonster();
		assertEquals(monsterList,groupe.createMonster());
	}
	 /**
	  *  Setters de la classe
	 */
	@Test
	public void testGroupe() 
	{
		assertEquals(spawn,groupe.getSpawn());
		assertEquals((float)2.3,groupe.getLapse(),0);
		assertEquals(20,groupe.getTimer());
	}

}
