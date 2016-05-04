package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Groupe;
import be.ac.umons.sgl.gemcraft.g2.Models.Wave;

public class WaveTest {

	private Wave wave;
	private Groupe groupe;
	private ArrayList<Groupe> groupList;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init() 
	{
		groupe=new Groupe();
		groupList= new ArrayList<Groupe>();
		wave=new Wave (20,groupList);
	}
	 /**
	  *  setter de la classe
	 */
	@Test
	public void testWave() 
	{
		assertEquals(20, wave.getDelay());
	}
	 /**
	  *  ajout d'un groupe
	 */
	@Test
	public void testAddGroupe()
	{
		wave.addListGroupe(groupe);
		assertEquals(1,groupList.size());
	}
	 /**
	  *  suppression d'un groupe
	 */
	@Test
	public void testRemoveGroupe()
	{
		wave.removeListGroupe(groupe);
		assertEquals(0,groupList.size());
	}
	 /**
	  *   vérification ds différents numéro des groupes
	 */
	@Test
	public void testNumGroupe()
	{
		wave.addListGroupe(groupe);
		assertEquals(true,wave.isLastGroupe(3));
		assertEquals(groupe,wave.getFirstGroupe());
	}

}
