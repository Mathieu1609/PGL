package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import java.util.ArrayList;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public class AreaDammage implements AreaEffects
{
	private Monster target;
	private int dammage;
	private boolean isPure;
	private int quantityGem;
	
	/**
	 * Constructeur de la classe AreaDammage
	 * @param Objet Monstre, booleen, quantit� de gem, dommage
	*/ 
	public AreaDammage(Monster target_,int dammage_,boolean isPure_,int quantityGem_)
	{
		target=target_;
		dammage=dammage_;
		isPure=isPure_;
		quantityGem=quantityGem_;
	}
	
	/**
	 * fonction retournant une liste de monstre ayant re�u des d�g�ts de la classe AreaDammage
	 * @param liste de monstre
	 *  @return liste de monstre
	*/ 
	@Override
	public ArrayList<Monster> CollateralDammage(ArrayList<Monster> listMonster) 
	{
		int	tileXTarget=target.getTileX();
		int tileYTarget= target.getTileY();
		int distance=1;
		if(isPure== true)
		{
			distance= distance*quantityGem;
		}
		else
		{
			dammage= minimiseDammage();
			distance=(distance*quantityGem);
		}
		for(Monster x: listMonster)
		{
			if(x.isAlive()==true)
			{
				int tileX= x.getTileX();
				int tileY= x.getTileY();
				if(((tileX+distance)==tileXTarget)&&((tileY==tileYTarget)))
				{
					x=setDammage(x);
				}				
				if(((tileX-distance)==tileXTarget)&&((tileY==tileYTarget)))
				{
					x=setDammage(x);
				}
				if(((tileX)==tileXTarget)&&((tileY+distance==tileYTarget)))
				{
					x=setDammage(x);
				}
				if(((tileX)==tileXTarget)&&((tileY-distance==tileYTarget)))
				{
					x=setDammage(x);
				}
				
			}
			
		}
		return listMonster;
		
	}
	/**
	 * fonction diminuant la vie d'un monstre en fonction des d�g�ts de la classe AreaDammage
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
	 * fonction qui d�finit les d�g�ts minimum de la classe AreaDammage
	 *  @return d�g�ts
	*/ 
	public int minimiseDammage()
	{
		dammage=(dammage/4);
		dammage=(dammage*3);
		return dammage;
	}
	
	
	

}
