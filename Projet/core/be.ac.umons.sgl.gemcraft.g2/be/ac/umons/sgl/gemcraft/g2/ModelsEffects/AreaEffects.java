package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;

import java.util.ArrayList;

import be.ac.umons.sgl.gemcraft.g2.Models.Monster;

public interface AreaEffects extends Effects
{
	/**
	 * fonction calculant les dégâts de la classe AreaEffect
	 * @param liste de Monstre
	*/ 
	public ArrayList<Monster> CollateralDammage(ArrayList<Monster> listMonster);
}
