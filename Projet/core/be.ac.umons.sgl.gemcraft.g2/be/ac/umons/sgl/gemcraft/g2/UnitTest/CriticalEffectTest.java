package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaChains;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.CriticalEffect;

public class CriticalEffectTest {


	  private CriticalEffect aC;

	  /**
		  *  tinitialisation des variables
		 */
	@Before
	public void init() 
	{
		aC=new CriticalEffect(4,false,10);
	}
	 /**
	  *  test des dégats infligés
	 */
	@Test
	public void testDammage()
	{
		
		assertEquals(20,aC.activeCritical());
		
	}


}
