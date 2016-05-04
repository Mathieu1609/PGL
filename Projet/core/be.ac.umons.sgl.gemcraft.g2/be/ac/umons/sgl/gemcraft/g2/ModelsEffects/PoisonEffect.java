package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public class PoisonEffect implements StatusEffects
{
	
	private float lapse;
	private boolean isActive;
	private float endTime;
	
	private Monster monster;
	private boolean isPure;
	private int nombreGem;
	private int dammage;
	
	/**
	 * Constructeur de la classe PoisonEffect
	 * @param nombre de gemmes, quantité de gem, dommage, Objet Monstre
	*/ 
	public PoisonEffect(Monster monster_,boolean isPure_,int nombreGem_,int dammage_)
	{
		lapse=(float) 0.0;
		endTime=(float) 1.5;
		
		monster=monster_;
		isPure=isPure_;
		nombreGem=nombreGem_;
		dammage=dammage_;
		
	}
	/**
	 * fonction retournant un monstre avec des dégâts subit en fonction de la pureté de la gemme de la classe PoisonEffect
	 * @return Objet Monstre
	*/ 
	@Override
	public Monster alterMonster() 
	{
		if(isActive==true)
		{
			int poisonDammage=0;
			if(isPure==true)
			{
				poisonDammage=(dammage/10);
				poisonDammage=(poisonDammage*nombreGem);
			}
			else
			{
				poisonDammage=(dammage/15);
		        poisonDammage=(poisonDammage*nombreGem);
			}
			
			monster.decreaseLive(poisonDammage);
			if((monster.getLife()<0)||(monster.getLife()==0))
			{
				monster.setAlive(false);
			}
			
		}
		
		return monster;
		
	}
	/**
	 * fonction activant le poison de la classe PoisionEffect
	*/ 
	@Override
	public void begin() 
	{
		isActive=true;
		
	}
	/**
	 * fonction retournant un booleen en fonction de l'états active du poison de la classe PoisionEffect
	 * @param délai
	 * @return booleen
	*/ 
	@Override
	public boolean hasReachEndTime(float delay_) 
	{
		
		lapse=lapse+delay_;
		if((lapse>endTime)||(lapse==endTime))
		{
		isActive=false;
		return true;
		}else
		{
		return false;
		}
		
		
	}

}
