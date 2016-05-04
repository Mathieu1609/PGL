package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public interface StatusEffects extends Effects
{
	
	public Monster alterMonster();	
	public void begin();
	public boolean hasReachEndTime(float delay_);
	

}
