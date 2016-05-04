package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaChains;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaDammage;

public class AreaDammageTest {

	 private Monster m;
	  private ArrayList<Monster> listM;
	  private AreaDammage aD;
	  /**
	 *   Initialisation des différentes variables
	 */
	@Before
	public void init() 
	{
		m=new Monster();
		listM=new ArrayList<Monster>();
		listM.add(m);
		aD=new AreaDammage(m,10,false,2);
	}
	 /**
	  *  test des dégats infligés
	 */
	@Test
	public void testDammage()
	{
		m.setLife(100);
		m.setCoefficientDefense(1);
		aD.setDammage(m);
		assertEquals(90,m.getLife());
		
	}


}
