package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import java.util.Random;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public class StunEffect implements StatusEffects
{
	private float lapse;
	private boolean isActive;
	private float endTime;

	private Monster monster;
	private boolean isPure;
	private int nombreGem;
	private int dammage;
	/**
	 * constructeur de la classe StunEffects
	 * @param Objet Monstre, booleen , nombre de gemme, dégâts
	*/ 
	
	public StunEffect(Monster monster_,boolean isPure_,int nombreGem_,int dammage_)
	{
		lapse=(float) 0.0;
		endTime=(float) 3.0;
		
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
		     if(isPure==true)
		     {
		    	 monster.setLife((monster.getLife())+dammage);
		    	 monster.setDelayMove(monster.getDelayMove()-(1*nombreGem));
		     }
		     else
		     {
		    	 if(isParalyse(nombreGem)==true)
		    	 {
		    		 monster.setDelayMove(monster.getDelayMove()-1);
		    	 }
		     }	
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
	 * fonction pour vérifier si le délai de l'attaque est fini de la classe StatusEffects
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
	
	/**
	 * fonction ?????? de la classe StatusEffects
	*/ 
	public boolean isParalyse(int nombreGemme)
	{
		
		
		int probabiliteMax= (20*nombreGemme);
		   
		   Random random = new Random();
		   int valeurGenere= 1 + random.nextInt(100-1);
		   
		   if((valeurGenere==probabiliteMax)||(valeurGenere<probabiliteMax))
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
	}


}
