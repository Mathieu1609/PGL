package be.ac.umons.sgl.gemcraft.g2.Models;

import java.util.ArrayList;

import org.jdom2.Element;

public class Groupe {

	private Spawn spawn;
	private float lapse;
	private int timer;
	private ArrayList<Ennemy> listEnnemy;
	
	 /**
	  * Constructeur par défaut de la classe Bulet
	 */
	public Groupe(){}
	/**
	  * Constructeur initialisant une liste d'ennemi de la classe Bulet
	  * @param liste d'ennemi
	 */
	public Groupe(ArrayList<Ennemy> listEnnemy_)
	{
		listEnnemy=listEnnemy_;
	}
	/**
	  * Constructeur  de la classe Bulet
	  * @param  Spawn , lapse , temps , une liste d'ennemi
	 */
	
	public Groupe(Spawn spawn_,float lapse_,int timer_,ArrayList<Ennemy> listEnnemy_)
	{
		spawn=spawn_;
		lapse=lapse_;
		timer=timer_;
		listEnnemy=listEnnemy_;
	}
	 /**
	  * return un spawn de la classe groupe
	  * @return spawn 
	 */
	public Spawn getSpawn()
	{
		return spawn;
	}
	 /**
	  * définie le spawn de la classe groupe
	  * @param spawn de la classe Spawn
	 */
	public void setSpawn(Spawn spawn_)
	{
		spawn=spawn_;
	}
	/**
	 * return le lapse de la classe groupe
	 * @return lapse
	*/
	public float getLapse()
	{
		return lapse;
	}
	/**
	 * définie le lapse de la classe groupe
	 * @param lapse
	*/
	public void setLapse(float lapse_)
	{
		lapse=lapse_;
	}
	/**
	 * retourne la durée du groupe de la classe groupe
	 * @return durée
	*/
	public int getTimer()
	{
		return timer;
	}
	/**
	 * définie la durée du groupe de la classe groupe
	 * @param durée
	*/
	public void setTimer(int timer_)
	{
		timer=timer_;
	}
	/**
	 * fonction permettant d'ajouter un ennemi à la liste d'ennemy de la classe groupe
	 * @param ennemy
	*/
	public void addEnnemy(Ennemy ennemy_)
	{
		listEnnemy.add(ennemy_);
	}
	/**
	 * fonction permettant de supprimer un ennemi de la liste d'ennemy de la classe groupe
	 * @param ennemy
	*/
	public void removeEnnemy(Ennemy ennemy_)
	{
		for(final Ennemy x: listEnnemy)
		{
			if(x.equals(ennemy_))
			{
				listEnnemy.remove(x);
			}
		}
	}
	/**
	 * foncion permettant de créer un monstre de la classe groupe
	 * @return liste de monstre
	*/
	public ArrayList<Monster> createMonster()
	{
		ArrayList<Monster>listMonster= new ArrayList<Monster>();
		for(final Ennemy x:listEnnemy)
		{
			for(int i=0;i<x.getQuantity();i++)
			{
				Position position= new Position(spawn.getPosition().getAbscisse(),spawn.getPosition().getOrdonne());
				if((x.getType().getName()).equals("fly"))
				{
					FlyMonster aerialMonster= new FlyMonster(position,x.getType());
					listMonster.add(aerialMonster);
				}else
				{
					Monster monster = new Monster(position,x.getType());
					listMonster.add(monster);
				}
				
				
				
			}
		}
		return listMonster;
		
	}
		
}
