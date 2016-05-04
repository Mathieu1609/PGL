package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public class WeakEffect implements StatusEffects
{
	private float lapse;
	private boolean isActive;
	private float endTime;
	private int coefficientInitial;
	
	private Monster monster;
	private boolean isPure;
	private int nombreGem;
	private int dammage;
	
	/**
	 * constructeur de la classe WeakEffects
	 * @param Objet Monstre, booleen , nombre de gemme, dégâts
	*/ 
	public WeakEffect(Monster monster_,boolean isPure_,int nombreGem_,int dammage_)
	{
		lapse=(float) 0.0;
		endTime=(float) 3.0;
		coefficientInitial=0;
		
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
	public Monster alterMonster()
	{
		
		if(isActive==true)
		{
			if(isPure==false)
			{
				endTime=(float)1.0;
			}
			
			if(coefficientInitial==0)
			{
				coefficientInitial=monster.getCoefficientDefense();
				
			}
			
			int newCoefficient=coefficientInitial+(nombreGem/(nombreGem+1));
			
			monster.setCoefficientDefense(newCoefficient);
			
			
		}else
		{
			resetCoefficientDefense();
		}
			
		
		
		return monster;
	}
	/**
	 * fonction activant l'état du dégât de la classe WeakEffect
	*/ 
	@Override
	public void begin() 
	{
		isActive=true;
		
	}

	/**
	 * fonction réinitialise le coefficient de défense d'un monstre de la classe WeakEffect
	*/ 
	public void resetCoefficientDefense()
	{
		monster.setCoefficientDefense(coefficientInitial);
	}
	
	/**
	 * fonction ??? de la classe WeakEffect
	*/ 
	@Override
	public boolean hasReachEndTime(float delay_)
	{
		lapse=lapse+delay_;
		if((lapse>endTime)||(lapse==endTime))
		{
			isActive=false;
			resetCoefficientDefense();
			return true;
		}else
		{
			return false;
		}
	}

}
