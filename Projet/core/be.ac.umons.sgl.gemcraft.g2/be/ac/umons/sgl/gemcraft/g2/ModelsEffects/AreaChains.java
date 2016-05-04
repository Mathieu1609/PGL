package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import java.util.ArrayList;
import java.util.Random;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public class AreaChains implements AreaEffects 
{
      private Monster target;
      private	boolean isPure;
	  private int quantityGem;
	  private int dammage;
	  
	/**
	 * Constructeur de la classe AreaChains
	 * @param Objet Monstre, booleen, quantité de gem, dommage
	*/ 
	public AreaChains(Monster target_,boolean isPure_,int quantityGem_,int dammage_)
	{
		target=target_;
		isPure=isPure_;
		quantityGem=quantityGem_;		
		dammage=dammage_;
	}
	/**
	 * fonction retournant une liste de monstre ayant reçu des dégâts de la classe AreaChains
	 * @param liste de monstre
	 *  @return liste de monstre
	*/ 
	
	@Override
	public ArrayList<Monster> CollateralDammage(ArrayList<Monster> listMonster )
    {
		// TODO Auto-generated method stub
		
		int	tileXTarget=target.getTileX();
		int tileYTarget= target.getTileY();
		int distance=1;
		
		if(isPure!= true)
		{
			dammage=(dammage/10);
			dammage=(dammage*8);
		}
		
		
		for(Monster x: listMonster)
		{
			if(x.isAlive()==true)
			{
				int tileX= x.getTileX();
				int tileY= x.getTileY();
				if(((tileX+distance)==tileXTarget)&&((tileY==tileYTarget)))
				{
					if(randomise(quantityGem)==true)
					{
						x=setDammage(x);
					}
					
				}
				
				if(((tileX-distance)==tileXTarget)&&((tileY==tileYTarget)))
				{
					if(randomise(quantityGem)==true)
					{
						x=setDammage(x);
					}
				}
				if(((tileX)==tileXTarget)&&((tileY+distance==tileYTarget)))
				{
					if(randomise(quantityGem)==true)
					{
						x=setDammage(x);
					}
				}
				if(((tileX)==tileXTarget)&&((tileY-distance==tileYTarget)))
				{
					if(randomise(quantityGem)==true)
					{
						x=setDammage(x);
					}
				}
				
			}
			
		}
		return listMonster;
		
	}
	
	/**
	 * fonction diminuant la vie d'un monstre en fonction des dégâts de la classe AreaChains
	 * @param Objet Monstre
	 *  @return Objet Monstre
	*/ 
	public Monster  setDammage(Monster monster)
	{
		monster.decreaseLive(dammage);
		if((monster.getLife()==0) || (monster.getLife()<0))
		{
			monster.setAlive(false);
		}
		return monster;
	}
	/**
	 * fonction renvoyant un booleen de la classe AreaChains
	 * @param quantité de gemme
	 *  @return booleen
	*/ 
	public boolean randomise(int quantityGem)
	{
	   int probabiliteMax= (20*quantityGem);
	   
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
