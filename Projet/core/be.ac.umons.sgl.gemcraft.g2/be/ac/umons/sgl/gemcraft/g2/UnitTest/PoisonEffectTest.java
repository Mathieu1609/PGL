package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.PoisonEffect;

public class PoisonEffectTest {

	private Monster m;
	private PoisonEffect pE;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		 m=new Monster();
		 pE=new PoisonEffect(m,false,2,15);
	}
	 /**
	  *  Test des dégats infligés
	 */
	@Test
	public void testDammage()
	{
		pE.begin();
		m.setLife(10);
		m.setCoefficientDefense(1);
		pE.alterMonster();
		assertEquals(8,m.getLife());
	}

}
