package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import java.util.Random;

public class CriticalEffect implements Effects
{
	
	private int quantityGem;
	private boolean isPure;
	private int dammage;
	
	/**
	 * Constructeur de la classe CriticalEffect
	 * @param booleen, quantit� de gem, dommage
	*/ 
	public CriticalEffect(int quantityGem_,boolean isPure_,int dammage_)
	{
		quantityGem=quantityGem_;
		isPure=isPure_;
		dammage=dammage_;
		
	}
	/**
	 * fonction renvoyant les d�g�ts en fonction de la puret� de la gem de la classe AreaDammage
	 * @return d�g�ts
	*/ 
	public int activeCritical()
	{
		
		if(randomCritical(quantityGem)==true)
		{
			if(isPure==true)
			{
				dammage=dammage*3;
			}else
			{
				dammage=dammage*2;
			}
		}
			
		
		return dammage;
	}
	
	
	
	public boolean randomCritical(int quantityGem)
	{
		 int probabiliteMax= (20*quantityGem);
		   
		   Random random = new Random();
		   int valeurGenere= 1 + random.nextInt(100-1);
		   
		   if((valeurGenere==probabiliteMax)||(probabiliteMax>valeurGenere))
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
	}
	
}
