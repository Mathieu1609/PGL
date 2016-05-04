package be.ac.umons.sgl.gemcraft.g2.ModelsStrategies;

import java.util.ArrayList;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;

public interface Strategy 
{
	/**
	 * M�thode d�finissant les ennemis pouvant �tre atteintes
	 * @param listMonster liste des monstres de la carte
	 * @param portee la port�e de la tour
	 * @param positionTower position de la tour
	 * @return la liste des monstres pouvant �tre cibl�s
	 */
	
	public boolean canReachTarget(ArrayList<Monster> listMonster,int portee,Position positionTower);
	
	/**
	 * M�thode retournant l'id du mmonstre � cibler
	 * @param listMonster liste des monstres pouvant �tre atteints
	 * @param portee  la port�e de la tour
	 * @param positionTower la position de la tour
	 * @return l'id du monstre � cibler
	 */
	
	public int getIdTarget(ArrayList<Monster> listMonster,int portee,Position positionTower);
	

	
}
