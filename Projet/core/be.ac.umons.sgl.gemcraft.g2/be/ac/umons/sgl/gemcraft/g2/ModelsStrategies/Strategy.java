package be.ac.umons.sgl.gemcraft.g2.ModelsStrategies;

import java.util.ArrayList;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;

public interface Strategy 
{
	/**
	 * Méthode définissant les ennemis pouvant être atteintes
	 * @param listMonster liste des monstres de la carte
	 * @param portee la portée de la tour
	 * @param positionTower position de la tour
	 * @return la liste des monstres pouvant être ciblés
	 */
	
	public boolean canReachTarget(ArrayList<Monster> listMonster,int portee,Position positionTower);
	
	/**
	 * Méthode retournant l'id du mmonstre à cibler
	 * @param listMonster liste des monstres pouvant être atteints
	 * @param portee  la portée de la tour
	 * @param positionTower la position de la tour
	 * @return l'id du monstre à cibler
	 */
	
	public int getIdTarget(ArrayList<Monster> listMonster,int portee,Position positionTower);
	

	
}
