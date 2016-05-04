package be.ac.umons.sgl.gemcraft.g2.Models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.StatusEffects;

public class Monster
{
	protected Position position;
	protected EnnemyType type;
	protected Sprite sprite;
	protected boolean alive;
	protected int lastMove=0;
	protected int tileX;
	protected int tileY;
	protected int id;
	protected int life;
	protected int coefficientDefense;
	
	protected float speed;	
	protected float timeToMove=(float) 1.35;
	protected float delayMove=0;
	
	protected ArrayList<StatusEffects> listEffets;
	
	
	public Monster()
	{
	
	}
	
	
	public Monster(Position position_, EnnemyType type_)
	{
		position=position_;
		type=type_;
		this.setLife(type.getLife());
		alive=true;
		defineTile();
		speed= this.getType().getSpeed();
		coefficientDefense=1;
		listEffets= new ArrayList<StatusEffects>();
		
	}
	/**
	 * Getter de l'id du monstre de la classe Monster
	 * @return id
	*/
	public int getId()
	{
		return id;
	}
	/**
	 * Setter de l'id du monstre de la classe Monster
	 * @param id
	*/
	public void setId(int id_)
	{
		this.id=id_;
	}
	/**
	 * Getter tileX de la classe Monster
	 * @return tileX
	*/
	public int getTileX()
	{
		return this.tileX;
	}
	/**
	 * Getter tileY de la classe Monster
	 * @return tileY
	*/
	public int getTileY()
	{
		return this.tileY;
	}
	/**
	 * Getter DelayMove de la classe Monster
	 * @return delay pour bouger
	*/
	public float getDelayMove()
	{
		return delayMove;
	}
	/**
	 * Getter TimeToMove de la classe Monster
	 * @return temps pour bouger
	*/
	public float getTimeToMove()
	{
		return this.timeToMove;
	}
	/**
	 * Setter TimeToMove de la classe Monster
	 * @param temps pour bouger
	*/
	public void setTimeToMove(float time_)
	{
		this.timeToMove=time_;
	}
	
	/**
	 * fonction permettant de savoir si le monstre est en vie
	 * @return booleen
	*/
	public boolean isAlive()
	{
		return alive;
	}
	/**
	 * méthode définissant si le monstre est en vie de la classe Monster
	 * @param boolean
	*/
	public void setAlive(boolean alive_)
	{
		alive=alive_;
	}
	/**
	 * Getter position de la classe Monster
	 * @return position du monstre
	*/
	public Position getPosition()
	{
		return position;
	}
	/**
	 * Setter position de la classe Monster
	 *@param la position du monstre
	*/
	public void setPosition(Position position_)
	{
		position=position_;
	}
	/**
	 * Getter EnnemyType de la classe Monster
	 * @param EnnemyType
	*/
	public EnnemyType getType()
	{
		return type;
	}
	/**
	 * Setter EnnemyType de la classe Monster
	 * @param EnnemyType
	*/
	public void setType(EnnemyType type_)
	{
		type=type_;
		this.setLife(type.getLife());
	}
	/**
	 * Getter vie de la classe Monster
	 * @return vie du monstre
	*/
	public int getLife()
	{
		return life;
	}
	/**
	 * Setter vie du monstre de la classe Monster
	 * @param vie du monstre
	*/
	public void setLife(int life_)
	{

		this.life=life_;
	}
	/**
	 * fonction diminuant la vie des monstres de la classe Monster
	 * @param dommage
	*/
	public void decreaseLive(int dammage_)
	{
	  int diff=(this.getLife())-dammage_;
	  diff=diff*(getCoefficientDefense());
	  this.life=diff;
	}
	
	/**
	 * Getter vitesse de la classe Monster
	 * @return vitesse des monstres
	*/
	public float getSpeed()
	{
		return this.speed;
	}
	/**
	 * Setter Vitesse de la classe Monster
	 * @param vitesse des monstres
	*/
	public void setSpeed(float speed_)
	{
		this.speed=speed_;
	}
	/**
	 * Getter coefficient de défense du monstre de la classe Monster
	 * @return  coefficient de défense
	*/
	public int getCoefficientDefense()
	{
		return this.coefficientDefense;
	}
	/**
	 * Setter coefficient de défense du monstre de la classe Monster
	 * @param coefficient de défense
	*/
	public void setCoefficientDefense(int defense_)
	{
		this.coefficientDefense=defense_;
	}
	/**
	 * Getter Sprite du monstre de la classe Monster
	 * @return  Sprite
	*/
	public Sprite getSprite()
	{
		return sprite;
	}
	/**
	 * Setter Sprite du monstre de la classe Monster
	 * @param  Sprite
	*/
	public void setSprite(Sprite sprite_)
	{
		sprite=sprite_;
	}
	/**
	 * méthode comparant la vitesse de la classe Monster
	 * @return  TimeToMowe
	*/
	public float compareSpeed()
	{
		return (timeToMove-(this.getSpeed()));
	}
	/**
	 * Setter delayMove du monstre de la classe Monster
	 * @param temps
	*/
	public void setDelayMove(float delay_)
	{
		delayMove=delayMove+delay_;
	}
	/**
	 * Getter Sprite du monstre de la classe Monster
	 * @return  Sprite
	*/
	public boolean canMove()
	{
		if(delayMove>compareSpeed())
		{
			delayMove=0;
			return true;
			
		}else
		{
			return false;
		}
	}
	/**
	 * méthode définissant les tuiles X et Y en fontion de la position du monstre de la classe Monster
	*/
	public void defineTile()
	{
		tileX=position.getIntAbscisse()/32;
		tileY=position.getIntOrdonne()/32;
	}
	/**
	 * méthode ajoutant les effets à la liste des effets de la classe Monster
	*/
	public void addEffects(StatusEffects status)
	{
		listEffets.add(status);	
	} 
	/**
	 * Getter de la liste des effets de la classe Monster
	 * @return liste des effets
	*/
	public ArrayList<StatusEffects> getStatusEffects()
	{
		return this.listEffets;
	}
	
	/**
	 * Méthode définissant si le monstre à atteint le nexus
	 * @return  true si oui, false sinon
	*/
	public boolean hasReachNexus(Level level)
	{
		boolean hasReach=false;
		Position positionNexus= level.getNexus();
		int diffAbscisse=(int) ((positionNexus.getAbscisse())-this.position.getAbscisse());
		int diffOrdonne=(int) ((positionNexus.getOrdonne())-this.position.getOrdonne());
		
		if((diffAbscisse==32&&diffOrdonne==0)||(diffOrdonne==32&&diffAbscisse==0))
		{
			hasReach=true;
		}
		if((diffAbscisse==-32 && diffOrdonne==0)||(diffOrdonne==-32&&diffAbscisse==0))
		{
			hasReach=true;
		}
		return hasReach;
		
	}
	/**
	 * méthode déplaçant le monstre
	*/
	public void move(TiledMapTileLayer layer,Level level)
	{
		boolean result=false;
		while(result !=true)
		{
			switch(lastMove)
			{
			case 0:
				result=moveUp(layer);
				if(result==false)result =moveRight(layer);
				if(result==false)result=moveDown(layer);
				if(result==false)result =moveLeft(layer);
			break;
			
			case 1: // up
				result=moveUp(layer);
				if(result==false)result =moveRight(layer);
				if(result==false)result =moveLeft(layer);
			break;
			case 2: // right
				result=moveUp(layer);
				if(result==false)result =moveRight(layer);
				if(result==false)result=moveDown(layer);
			break;
			case 3: // left
				result=moveUp(layer);
				if(result==false)result=moveDown(layer);
				if(result==false)result =moveLeft(layer);
			break;
			case 4: // down
	            result =moveRight(layer);
				if(result==false)result=moveDown(layer);
				if(result==false)result =moveLeft(layer);
			break;
			
			
			}
		}
		defineTile();	
	}
	/**
	 * méthode permettant de savoir si le monstre peut bouger en haut de la classe Monster
	 * @param TiledMapTileLayer
	 * */
	public boolean moveUp(TiledMapTileLayer layer)
	{
		if(layer.getCell(tileX,tileY+1)==null)
		{
			return false;
		}
		else
		{
			Object objet = layer.getCell(tileX,tileY+1).getTile().getProperties().get("path");
			if(Integer.valueOf((String)objet)==1)
			{
				
				Position pos= new Position(position.getAbscisse(),position.getOrdonne()+32);
				this.setPosition(pos);
				lastMove=1;
				return true;
			}
			else
			{
				return false;
			}
		}

	}
	/**
	 * méthode permettant de savoir si le monstre peut bouger en bas de la classe Monster
	 * @param TiledMapTileLayer
	 * */
	public boolean moveDown(TiledMapTileLayer layer)
	{
		if(layer.getCell(tileX,tileY-1)==null)
		{
			return false;
		}
		else
		{
			Object objet = layer.getCell(tileX,tileY-1).getTile().getProperties().get("path");
			if(Integer.valueOf((String)objet)==1)
			{		
				Position pos= new Position(position.getAbscisse(),position.getOrdonne()-32);
				this.setPosition(pos);
				lastMove=4;
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * méthode permettant de savoir si le monstre peut bouger à gauche de la classe Monster
	 * @param TiledMapTileLayer
	 * */
	public boolean moveLeft(TiledMapTileLayer layer)
	{
		if(layer.getCell(tileX-1,tileY)==null)
		{
			return false;
		}
		else
		{
			Object objet = layer.getCell(tileX-1,tileY).getTile().getProperties().get("path");
			if(Integer.valueOf((String)objet)==1)
			{
				Position pos= new Position(position.getAbscisse()-32,position.getOrdonne());
				this.setPosition(pos);
				
				position.setAbscisse(sprite.getX()-32);		
				lastMove=3;
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * méthode permettant de savoir si le monstre peut bouger à droite de la classe Monster
	 * @param TiledMapTileLayer
	 * */
	public boolean moveRight(TiledMapTileLayer layer)
	{
		if(layer.getCell(tileX+1,tileY)==null)
		{
			return false;
		}
		else
		{
			Object objet = layer.getCell(tileX+1,tileY).getTile().getProperties().get("path");
			if(Integer.valueOf((String)objet)==1)
			{	
				Position pos= new Position(position.getAbscisse()+32,position.getOrdonne());
				this.setPosition(pos);
				lastMove=2;
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
}
