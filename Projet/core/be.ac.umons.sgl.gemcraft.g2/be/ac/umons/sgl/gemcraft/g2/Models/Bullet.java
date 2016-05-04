package be.ac.umons.sgl.gemcraft.g2.Models;

import java.io.File;
import java.util.ArrayList;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaChains;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaDammage;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.CriticalEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.DrainEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.Effects;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.PoisonEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.SlowEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.StunEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.WeakEffect;

public class Bullet 
{
	private Monster target;
	private int idTarget;
	private Position sourcePosition;
	private Position bulletPosition;
	private Sprite sprite;
	private boolean isActive;
	private int dammage;

	private Texture texture;

	private boolean isPure;
	
	private ArrayList<Gems> listGems;
	private ArrayList<Effects>listEffects;
	
	 /**
	  * Constructeur par défaut de la classe Bulet
	 */
	public Bullet()
	{}
	
	 /**
	  * Constructeur Bullet de la classe Bulet
	  * @param position du tir et Monstre
	 */
	public Bullet(Position sourcePosition_,Monster target_,int dammage_)
	{
		texture = new Texture(Gdx.files.internal("textures"+File.separator+"bullet.png"));
		sprite=new Sprite(texture);
		sourcePosition=new Position((sourcePosition_.getIntAbscisse()),(sourcePosition_.getIntOrdonne()));
		sprite.setPosition(sourcePosition.getIntAbscisse(),sourcePosition.getIntOrdonne());
		bulletPosition=sourcePosition_;
		target=target_;
		isActive=true;
		idTarget=target_.getId();
		dammage=dammage_;
		isPure=false;
		listEffects= new ArrayList<Effects>();
		listGems=new ArrayList<Gems>();
		
	}
	 /**
	  * vérifie si le tir est pure de la classe Bulet
	  * @return booleen pure
	 */	
	public boolean isPure()
	{
		return this.isPure;
	}
	 /**
	  * définie si le tir est pure de la classe Bulet
	  * @param booleen pure
	 */
	public void SetIsPure(boolean isPure_)
	{
		isPure=isPure_;
		this.dammage=dammage+5;
	}
	 /**
	  * méthode get du Monstre de la classe Bulet
	  * @return monstre
	 */
	public Monster getTarget()
	{
		return this.target;
	}
	 /**
	  * méthode set pour définir le monstre de la classe Bulet
	  * @param monstre
	 */
	public void setTarget(Monster target_)
	{
		this.target=target_;
	}
	 /**
	  * méthode get de la position du tir de la classe Bulet
	  * @return position
	 */
	public Position getSourcePosition()
	{
		return this.sourcePosition;
	}
	 /**
	  * méthode set pour définir la position du tir de la classe Bulet
	  * @param Position
	 */
	public void setSourcePosition(Position sourcePosition_)
	{
		this.sourcePosition=sourcePosition_;
	}
	 /**
	  * méthode get du Sprite de la classe Bulet
	  * @return sprite
	 */
	public Sprite getSprite()
	{
		return this.sprite;
	}
	 /**
	  * méthode set pour définir le sprite du tir de la classe Bulet
	  * @param sprite
	 */
	public void setSprite(Sprite sprite_)
	{
		this.sprite=sprite_;
	}
	 /**
	  * méthode get 
	  * @return position
	 */
	public Position getBulletPosition()
	{
		return this.bulletPosition;
	}
	 /**
	  * méthode set 
	  * @param position
	 */
	public void setBulletPosition(Position bulletPosition_)
	{
		this.bulletPosition=bulletPosition_;
	}
	 /**
	  * méthode  get de l'id du monstre de la classe bullet
	  * @param id du monstre
	 */
	public int getIdTarget()
	{
		return this.idTarget;
	} /**
	  * méthode set pour définir l'id du monstre de la classe bullet
	  * @param  id du monstre
	 */
	
	public void setIdTarget(int idTarget_)
	{
		this.idTarget=idTarget_;
	}
	 /**
	  * méthode get pour savoir si le tir est active de la classe bullet
	  * @param boolean
	 */
	public boolean getIsActive()
	{
		return this.isActive;
	} 
	 /**
	  * méthode set pour définir si le tir est active de la classe bullet
	  * @param sprite
	 */
	public void setIsActive(boolean isActive_)
	{
		this.isActive=isActive_;
	}
	 /**
	  * méthode get permettant d'obtenir les dommages d'un tir de la classe bullet
	  * @return dommage d'un tir
	 */
	public int getDammage()
	{
		return this.dammage;
	}
	 /**
	  * méthode set définissant la puissance du tir de la classe bullet
	  * @return domage d'un tir
	 */
	public void setDammage(int dammage_)
	{
		this.dammage=dammage_;
		
	}
	 /**
	  * méthode get pour récupérer la liste de gemme de la tour lier au tir de la classe Bulet
	  * @return list de gemme
	 */
	public ArrayList<Gems> getGems()
	{
		return this.listGems;
	}
	 /**
	  * méthode set défissant la list de gem de la tour lier au tir de la classe bullet
	  * @param liste de gemme
	 */
	public void setGems(ArrayList<Gems> listGems_)
	{
		this.listGems=listGems_;
		defineEffect();
		
	}
	
	 /**
	  * méthode définissant les effet en fonction de la couleur de la gemme présent dans la liste de la classe Bulet
	 */
	public void defineEffect()
	{
		for(final Gems x: listGems)
		{
			if(x.getQuantity()>0)
			{
				switch(x.getGemme().getColor())
				{				
				case "red":
					if(target.getType().getImmunity().getColor()!="red")
					{
						AreaDammage DammageEffect= new AreaDammage(target,dammage,isPure,x.getQuantity());
					    listEffects.add(DammageEffect);
					}
					
				break;
				case "green":
					if(target.getType().getImmunity().getColor()!="green")
					{
						PoisonEffect poisonEffect=new PoisonEffect(target,isPure,x.getQuantity(),dammage);
					    listEffects.add(poisonEffect);
					}
					
				break;
				case "blue":	
					if(target.getType().getImmunity().getColor()!="blue")
					{
						SlowEffect slowEffect= new SlowEffect(target,isPure,x.getQuantity(),dammage);
					    listEffects.add(slowEffect);
					}
					
				break;
				case "yellow":
					if(target.getType().getImmunity().getColor()!="yellow")
					{
						CriticalEffect criticalEffect= new CriticalEffect(x.getQuantity(),isPure,dammage); // cas particulier on calcule directement l'effet des gemmes
						dammage=criticalEffect.activeCritical();	
					}
						
				break;
				case "orange":
					
					if(target.getType().getImmunity().getColor()!="orange")
					{
						DrainEffect drainEffect = new DrainEffect(x.getQuantity(),isPure,dammage);
					    listEffects.add(drainEffect);
					}
					
					
					
				break;
				case "cyan":
					
					 if(target.getType().getImmunity().getColor()!="cyan")
					 {
						 StunEffect stunEffect= new StunEffect(target,isPure,x.getQuantity(),dammage);
					     listEffects.add(stunEffect);
					 }
					
					
				break;
				case "magenta":
					if(target.getType().getImmunity().getColor()!="magenta")
					{
						AreaChains chainEffect= new AreaChains(target,isPure,x.getQuantity(),dammage);
					    listEffects.add(chainEffect);
					}
					
					
				break;
				case "violet":
					
					if(target.getType().getImmunity().getColor()!="violet")
					{
						WeakEffect weakEffect= new WeakEffect(target,isPure,x.getQuantity(),dammage);
					    listEffects.add(weakEffect);
					}
					
					
				
					
				break;
				default:
				break;
				}
			}
			
		}
	}
	
	 /**
	  * méthode get permettant d'obtenir la liste de effets de la classe Bulet
	  * @return la liste des effets
	 */
	public ArrayList<Effects> getListEffects()
	{
		return this.listEffects;
	}
	 /**
	  * méthode  permettant de savoir si le tir peut frapper
	  * @return booleen
	 */
	public boolean canMove(ArrayList<Monster>listeMonster)
	{
		boolean canMove=false;
		for(final Monster x: listeMonster) // mise à jour des informations sur le monstre cible
		{
			if((x.getId())==idTarget)
			{
				if(x.isAlive()==true)
				{
				  target = new Monster();
				  target=x;
				  canMove=true;				  
				}
				
			}
		}	
		return canMove;	
	}
	 /**
	  * méthode déplaçant le tir vers le monstre ciblé
	  * @return booleen
	 */
	public boolean move()
	{
		
		int XBullet= (bulletPosition.getIntAbscisse()/32)*32;
		int YBullet= (bulletPosition.getIntOrdonne()/32)*32;
		
		int XMonster=((target.getPosition().getIntAbscisse())/32)*32;
		int YMonster=((target.getPosition().getIntOrdonne())/32)*32;
				
		if(XMonster>XBullet)
		{
			bulletPosition.setAbscisse(XBullet+32);
		}
		if(XMonster<XBullet)
		{
			bulletPosition.setAbscisse(XBullet-32);
		}
		
		if(YMonster>YBullet)
		{
			bulletPosition.setOrdonne(YBullet+32);
		}
		
		if(YMonster<YBullet)
		{
			bulletPosition.setOrdonne(YBullet-32);
		}
		
		sprite.setPosition(bulletPosition.getIntAbscisse(),bulletPosition.getIntOrdonne());
		
		return hasReachTarget(XBullet,YBullet,XMonster,YMonster);
		
		
	}
	 /**
	  * Méthode indiquant si le bullet à atteint sa cible
	  * @return booleen
	 */
	public boolean hasReachTarget(int XBullet,int YBullet,int XMonster,int YMonster)
	{
		if((XBullet==XMonster)&&(YBullet==YMonster))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
