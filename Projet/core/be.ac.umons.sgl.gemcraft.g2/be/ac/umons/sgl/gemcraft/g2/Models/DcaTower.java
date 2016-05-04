package be.ac.umons.sgl.gemcraft.g2.Models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.StandardStrategie;

public class DcaTower extends Tower
{
	
	/**
	 * Constructeur
	 * @param sprite_  sprite 
	 * @param position_ position
	 * @param num_  identifiant
	 */
	
	public DcaTower(Sprite sprite_,Position position_,int num_)
	{
		sprite=sprite_;
		position=position_;
		listGem=new ArrayList<Gems>();
		initialisationGemmes();
		level=1;
		dammage=10;
		num=num_;
		isPure=true;
		portee=3;
		nbrGem=0;
		nbrMaxGem=2;
		StandardStrategie strat = new StandardStrategie();
		actualStrategie= strat;		
	}
	
	/**
	 * méthode vérifiant si la tour peut atteindre le monstre de la classe Tower
	 * @param liste de monstre 
	 * @return booleen 
	*/
	
	@Override
	public boolean canReachMonster(ArrayList<Monster>listeMonster)
	{
		 boolean canReach=false;
		 listeMonster=searchFlyEnnemy(listeMonster);
		 canReach=actualStrategie.canReachTarget(listeMonster, portee, position);		 
		 return canReach;	
	}
	
	/**
	 * Selectionne la cible
	 * @param liste de monstre 
	 * @return objet Bullet
	*/
	@Override
	public Bullet designeTarget(ArrayList<Monster>listeMonster)
	{
		Bullet bullet = new Bullet();
		listeMonster=searchFlyEnnemy(listeMonster);
		int IdTarget=actualStrategie.getIdTarget(listeMonster, portee, position);
		bullet= createBullet(IdTarget,listeMonster);
		return bullet;
	}
	
	/**
	 * méthode permettant la création d'un tir de la classe Tower
	 * @param liste de monstre et un id target
	 * @return Objet Bullet
	*/
	@Override
	public Bullet createBullet(int idTarget_,ArrayList<Monster>listeMonster)
	{
		Bullet bullet= new Bullet();
		for(final Monster x: listeMonster)
		{
			if((x.getId())==idTarget_)
			{
			
				int tileX=position.getIntAbscisse()/32;
				int tileY=position.getIntOrdonne()/32;
				Position position= new Position(((tileX)*32),((tileY)*32));
				
				 bullet = new Bullet(position,x,dammage);
				 bullet.SetIsPure(isPure);
				 bullet.setGems(listGem);
			}
		}
		return bullet;
	}
	
	
	/**
	 * Trie les ennemis volants
	 * @param listeMonster  liste de monstres
	 * @return les ennemis volants
	 */
	
	public ArrayList<Monster> searchFlyEnnemy(ArrayList<Monster>listeMonster)
	{
		ArrayList<Monster>listFlyMonster= new ArrayList<Monster>();
		for(final Monster x: listeMonster)
		{
			if((x.getType().getName()).equals("fly"))
			{
				listFlyMonster.add(x);
			}
		}
		return listFlyMonster;
	}
	
	
	
	

	

}
