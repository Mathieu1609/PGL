package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.CriticalEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.DrainEffect;

public class DrainEffectTest {

	private Monster m;

	  private DrainEffect aC;
	  /**
		  *  initialisation des variables
		 */
	@Before
	public void init() 
	{

		aC=new DrainEffect(4,false,10);
	}
	 /**
	  *  test des dégats infligés (Mana)
	 */
	@Test
	public void testDammage()
	{
		
		assertEquals(4,aC.activeDrain());
		
	}

}
