package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public class SlowEffect implements StatusEffects
{
	
	private float lapse;
	private boolean isActive;
	private float endTime;
	private float initialSpeed;

	private Monster monster;
	private boolean isPure;
	private int nombreGem;
	private int dammage;
	
	/**
	 * constructeur de la classe StatusEffects
	 * @param Objet Monstre, booleen , nombre de gemme, dégâts
	*/ 
	public SlowEffect(Monster monster_,boolean isPure_,int nombreGem_,int dammage_)
	{
		lapse=(float) 0.0;
		endTime=(float) 3.0;
		initialSpeed=0;
		
		monster=monster_;
		isPure=isPure_;
		nombreGem=nombreGem_;
		dammage=dammage_;
		
	}
	
	/**
	 * méthode renvoyant un monstre dont sa vitesse à dimninuer en fonction de la pureté de la gemme et de son nombre de la classe StatusEffects
	 * @return Objet Monstre
	*/ 
	@Override
	public Monster alterMonster( ) 
	{
		if(isActive==true)
		{
			if(initialSpeed==0)
			{
				initialSpeed=monster.getSpeed();
			}
			
			if(isPure==true)
			{
				monster.setSpeed(monster.getSpeed()-(nombreGem/10));
				
			}else
			{
				monster.setSpeed(monster.getSpeed()-(nombreGem/10));
				endTime=1;
			}
		}else
		{
			  resetSpeed();
		}
		
		return monster;
	}
	/**
	 * fonction activant l'état du dégât de la classe StatusEffects
	*/ 
	@Override
	public void begin()
	{
		isActive=true;
		
	}
	/**
	 * fonction rétablissant la vitesse par defaut du monstre de la classe StatusEffects
	*/ 
	public void  resetSpeed()
	{
		monster.setSpeed(initialSpeed); 
	}
	
	
	/**
	 * fonction .??????? de la classe StatusEffects
	*/ 
	@Override
	public boolean hasReachEndTime(float delay_) 
	{
		lapse=lapse+delay_;
		if((lapse>endTime)||(lapse==endTime))
		{
			isActive=false;
			resetSpeed();
			return true;
		}else
		{
			return false;
		}
	}

}
