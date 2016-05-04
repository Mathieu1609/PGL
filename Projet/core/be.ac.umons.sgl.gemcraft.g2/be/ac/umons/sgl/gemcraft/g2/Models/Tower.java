package be.ac.umons.sgl.gemcraft.g2.Models;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.StandardStrategie;
import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.Strategy;

public class Tower {
	
	protected Sprite sprite;
	protected Position position;
	protected ArrayList<Gems> listGem;
	protected int portee;
	protected boolean isPure;
	protected int level;
	protected int dammage;
	protected int num;
	protected int nbrGem;
	protected int nbrMaxGem;
	protected float cadence=(float) 0.8;
	protected float delayFire=0;
	protected Strategy actualStrategie;

	/**
	 * Constructeur par défaut de la classe Tower
	*/
     public Tower(){};
	
     /**
 	 * Constructeur de la classe Tower
 	 * @param Sprite, Position, numéro
 	*/
	public Tower(Sprite sprite_,Position position_,int num_)
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
 	 * Getter Sprite de la classe Tower
 	 * @return Sprite
 	*/
	public Sprite getSprite() {
		return sprite;
	}
	 /**
	 * Setter Sprite de la classe Tower
	 * @param Sprite
	*/
	public void setSprite(Sprite sprite_) {
		this.sprite = sprite_;
	}
	 /**
	 * Getter Position de la tour de la classe Tower
	 * @return Position
	*/
	public Position getPosition() {
		return position;
	}
	 /**
		 * Setter Position de la tour de la classe Tower
		 * @param Position
		*/
	public void setPosition(Position position_) {
		position = position_;
	}
	 /**
		 * Getter niveau de la tour de la classe Tower
		 * @return niveau
		*/
	public int getLevel() {
		return level;
	}
	/**
	 * Setter niveau de la tour de la classe Tower
	 * @param niveau
	*/
	public void setLevel(int level_) {
		this.level = level_;
	}
	/**
	 * Getter dommage de la tour de la classe Tower
	 * @return dommage
	*/	
	public int getDammage() {
		return dammage;
	}
	/**
	 * Setter dommage de la tour de la classe Tower
	 * @param dommage
	*/
	public void setDammage(int dammage_) {
		dammage = dammage_;
	}
	/**
	 * Getter numéro de la tour de la classe Tower
	 * @return numéro
	*/	
	public int getNum() {
		return num;
	}
	/**
	 * Setter numéro de la tour de la classe Tower
	 * @param numéro
	*/	
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * Getter portée de la tour
	 * @return la portée de la tour
	 */
	
	public int getPortee()
	{
		return this.portee;
	}
	
	/**
	 * Setter porté de la tour
	 * @param nouvelle portée
	 */
	
	public void setPortee(int portee_)
	{
		this.portee=portee_;
	}
	
	
	
	/**
	 * Getter de la strategie de tour actuelle
	 * @return la stratégie correspondante
	 */
	public Strategy getActualStrategie()
	{
		return this.actualStrategie;
	}
	
	/**
	 * Setter de la stratégie de tour actuelle
	 * @param nouvelle stratégie
	 */
	
	public void setActualStrategy(Strategy newStrat)
	{
		this.actualStrategie=newStrat;
	}
		
	/**
	 * Getter liste de gemme de la tour de la classe Tower
	 * @return liste de gemme
	*/
	public ArrayList<Gems> getListGem() {
		return listGem;
	}
	/**
	 * Setter liste de gemme de la tour de la classe Tower
	 * @param liste de gemme
	*/	
	public void setListGem(ArrayList<Gems> listGem) {
		this.listGem = listGem;
	}
	/**
	 * fonction ajoutant une gemme de la couleur passé en paramètre à la tour de la classe Tower
	 * @param couleur de la gemme
	*/
	public void addGem(String couleur)
	{
		for(final Gems x: listGem)
		{
			if((x.getGemme().getColor()).equals(couleur))
			{
				x.setQuantity(x.getQuantity()+1);
				nbrGem++;
			}
		
		}
		isPure();
	}
	/**
	 * fonction supprimant une gemme de la couleur passé en paramètre à la tour de la classe Tower
	 * @param couleur de la gemme
	*/
	public void removeGem(String couleur)
	{
		for(final Gems x: listGem)
		{
			if((x.getGemme().getColor()).equals(couleur))
			{
				x.setQuantity(x.getQuantity()-1);
				nbrGem--;
			}
		}
		isPure();
	}
		
	/**
	 * Getter du nombre de gemme de la tour de la classe Tower
	 * @return Nombre de gem
	*/
	public int getNbrGem() {
		return nbrGem;
	}
	/**
	 * Setter du nombre de gemme de la tour de la classe Tower
	 * @param Nombre de gem
	*/	
	public void setNbrGem(int nbrGem) {
		this.nbrGem = nbrGem;
	}
	
	/**
	 * Getter du nombre de gemmes maximum
	 * @return le nombre de gemmes maximum
	 */
	
	public int getNbrMaxGem()
	{
		return this.nbrMaxGem;
	}
	
	
	/**
	 * Setter du nombre de gemmes maximum
	 * @param nouveau maximum
	 */
	public void setNbrMaxGem(int nbrMax_)
	{
			this.nbrMaxGem=nbrMax_;
	} 
	
	
	/**
	 * méthode initialisant les gemmes de la tour à 0 de la classe Tower
	*/
	public void initialisationGemmes()
	{
		Gem gemme = new Gem("red");
		Gems objectGemme= new Gems(gemme, 0);
		
		listGem.add(objectGemme);
	    gemme = new Gem("orange");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);
		gemme = new Gem("yellow");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);
		gemme = new Gem("green");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);
		gemme = new Gem("cyan");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);
		gemme = new Gem("blue");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);
		gemme = new Gem("magenta");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);
		gemme = new Gem("violet");
	    objectGemme= new Gems(gemme, 0);
		listGem.add(objectGemme);	
		
	}
	/**
	 * méthode vérifiant si la tour est pure de la classe Tower
	 * @return booleen 
	*/
	
	public boolean isPure()
	{
		boolean gemmeDominante=false;
		boolean isPure=true;
		
		for(final Gems x: listGem)
		{
			
			if(x.getQuantity()>0 && gemmeDominante==true)
			{
				isPure=false;
			}
			
			if(x.getQuantity()>0 && gemmeDominante==false)
			{
				gemmeDominante=true;
			}
			
			
		}
		
		
		return isPure;
	}
	
	/**
	 * méthode définissant le délai du tir de la tour de la classe Tower
	*/
	public void setDelayFire(float delay_)
	{
		delayFire=delayFire+delay_;
	}
	/**
	 * méthode vérifiant si la tour peut tirer en fonction du délai de la classe Tower
	 * @return booleen  
	*/
	public boolean canFire()
	{
		if(delayFire>cadence)
		{
			delayFire=0;
			return true;
		}else
		{
			return false;
		}
	}
	/**
	 * méthode vérifiant si la liste de gem de la tour n'est pas vide de la classe Tower
	 * @return booleen 
	*/
	public boolean isNotEmpty()
	{
		if(this.listGem.size()>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	/**
	 * méthode vérifiant si la tour peut atteindre le monstre de la classe Tower
	 * @param liste de monstre 
	 * @return booleen 
	*/
	public boolean canReachMonster(ArrayList<Monster> listeMonster)
	{
		 boolean canReach=false;
		 listeMonster=this.isGroundMonster(listeMonster);
		 canReach=actualStrategie.canReachTarget(listeMonster, portee, position);		 
		 return canReach;	
	}
	/**
	 * (chemin du tir)  de la classe Tower ?????????
	 * @param liste de monstre 
	 * @return objet Bullet
	*/
	public Bullet designeTarget(ArrayList<Monster>listeMonster)
	{
		Bullet bullet = new Bullet();
		listeMonster=this.isGroundMonster(listeMonster);
		int IdTarget=actualStrategie.getIdTarget(listeMonster, portee, position);
		bullet= createBullet(IdTarget,listeMonster);
		return bullet;
	}
	/**
	 * méthode permettant la création d'un tir de la classe Tower
	 * @param liste de monstre et un id target
	 * @return Objet Bullet
	*/
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
	 * Augmente le niveau de la tour
	 */
	
	public void increaseLevel()
	{
		dammage=dammage+5;
		portee= portee+1;
		level=level+1;
		nbrMaxGem=nbrMaxGem+1;
	}
	
	public ArrayList<Monster> isGroundMonster(ArrayList<Monster> listeMonster)
	{
		ArrayList<Monster>groundMonster= new ArrayList<Monster>();
		
		for(final Monster x: listeMonster)
		{
					
			if(x.getType().getName().equals("fly"))
			{
				
			}else
			{
				groundMonster.add(x);
			}
					
		}
		return groundMonster;
	}
	
	
}
