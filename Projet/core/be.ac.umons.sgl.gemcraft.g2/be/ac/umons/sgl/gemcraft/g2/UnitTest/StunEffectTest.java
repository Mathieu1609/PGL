package be.ac.umons.sgl.gemcraft.g2.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.SlowEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.StunEffect;

public class StunEffectTest {

	private Monster m;
	private StunEffect sE;
	 /**
	  *  Initialisation des différentes variables
	 */
	@Before
	public void init()
	{
		 m=new Monster();
		 sE=new StunEffect(m,true,2,15);
	}
	 /**
	  *  test de la vie du monstre + si le monstre est paralisé 
	 */
	@Test
	public void testDammage()
	{
		sE.begin();
		m.setLife(100);
		sE.alterMonster();
		assertEquals(115,m.getLife());
		assertEquals(false,sE.isParalyse(2));
	}
}
