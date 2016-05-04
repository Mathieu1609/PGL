package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.PoisonEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.SlowEffect;

public class SlowEffectTest {

	private Monster m;
	private SlowEffect sE;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		 m=new Monster();
		 sE=new SlowEffect(m,true,2,15);
	}
	 /**
	  * Test des dégats infligés
	 */
	@Test
	public void testDammage()
	{
		sE.begin();
		m.setSpeed(2);
		sE.alterMonster();
		assertEquals(2,m.getSpeed(),0);
	}

}
