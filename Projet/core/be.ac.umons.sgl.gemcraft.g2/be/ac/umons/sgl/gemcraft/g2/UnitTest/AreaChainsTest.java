package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaChains;

public class AreaChainsTest {

	  private Monster m;
	  private ArrayList<Monster> listM;
	  private AreaChains aC;
	  /**
		  *  Initialisation des différentes variables
		 */
	@Before
	public void init() 
	{
		m=new Monster();
		listM=new ArrayList<Monster>();
		listM.add(m);
		aC=new AreaChains(m,false,2,10);
	}
	 /**
	  *  test des dégats infligés
	 */
	@Test
	public void testDammage()
	{
		m.setLife(100);
		m.setCoefficientDefense(1);
		aC.setDammage(m);
		assertEquals(90,m.getLife());
		
	}

}
