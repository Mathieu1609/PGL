package be.ac.umons.sgl.gemcraft.g2.ModelsStrategies;

import java.util.ArrayList;

import be.ac.umons.sgl.gemcraft.g2.Models.Gems;
import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;

public class StandardStrategie implements Strategy
{
	
	
	ArrayList<Monster>possibleTarget;
	
	
	public StandardStrategie()
	{
		possibleTarget=new ArrayList<Monster>();
	}

	
	/**
	 * Méthode définissant les ennemis pouvant être atteintes
	 * @param listMonster liste des monstres de la carte
	 * @param portee la portée de la tour
	 * @param positionTower position de la tour
	 * @return la liste des monstres pouvant être ciblés
	 */


	@Override
	public boolean canReachTarget(ArrayList<Monster> listMonster, int portee,Position positionTower)		
	{
		
		possibleTarget= new ArrayList<Monster>();
		
		int tileXTower=(positionTower.getIntAbscisse()/32);
		int tileYTower=(positionTower.getIntOrdonne()/32);
		
		for(final Monster x: listMonster)
		{
			
			if(x.isAlive()==true)
			{
			int monsterX=(x.getPosition().getIntAbscisse())/32;
			int monsterY=(x.getPosition().getIntOrdonne())/32;
			int diffAbscisse=0;
			int diffOrdonne=0;
			
			if(monsterX>tileXTower)
			{
			    diffAbscisse=monsterX-tileXTower;
			}
			else
			{
				diffAbscisse=tileXTower-monsterX;
			}
			
			if(monsterY>tileYTower)
			{
				diffOrdonne=monsterY-tileYTower;
			}
			else
			{
				diffOrdonne=tileYTower-monsterY;
			}
			
			if((diffAbscisse<=portee)&&(diffOrdonne<=portee))
			{
				possibleTarget.add(x);
			}
				
				
			}
			
		}
		
		if(possibleTarget.size()>0)
		{
			return true;
		}else
		{
			return false;
		}
		
		
	}


	/**
	 * Méthode retournant l'id du mmonstre à cibler
	 * @param listMonster liste des monstres pouvant être atteints
	 * @param portee  la portée de la tour
	 * @param positionTower la position de la tour
	 * @return l'id du monstre à cibler
	 */
	
	@Override
	public int getIdTarget(ArrayList<Monster> listMonster, int portee,Position positionTower)		 
	{

		
		if(possibleTarget.size()>0)
		{
			return possibleTarget.get(0).getId();
		}
		else
		{
			return 0;
		}
		
		
		
	}


	
	
	
	
	
	
	
	
	
	


}
