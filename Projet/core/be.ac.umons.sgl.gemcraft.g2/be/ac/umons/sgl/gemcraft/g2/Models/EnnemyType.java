package be.ac.umons.sgl.gemcraft.g2.Models;

public class EnnemyType {

	private String name;
	private Gem immunity;
	private float speed;
	private float size;
	private String sprite;
	private int life;
	private int mana;
	
	 /**
	  * constructeur par défaut de la classe EnnemyType
	 */
	public EnnemyType(){};
	 /**
	  * constructeur de la classe EnnemyType
	  * @param nom , gem , vitesse , taille, sprite, vie, mana
	 */
	public EnnemyType(String name_,Gem immunity_,float speed_,float size_,String sprite_,int life_, int mana_)
	{
		name=name_;
		immunity=immunity_;
		speed=speed_;
		size=size_;
		sprite=sprite_;
		life=life_;
		mana=mana_;
	}
	 /**
	  * méthode get retournant le nom du type d'ennemi de la classe EnnemyType
	  * @return nom du type d'ennemi
	 */
	public String getName()
	{
		return name;
	}
	 /**
	  * méthode set definissant le nom du type d'ennemi de la classe EnnemyType
	  * @param nom du type d'ennemi
	 */
	public void setName(String name_)
	{
		name=name_;
	}
	 /**
	  * méthode get retournant le type de gem de la classe EnnemyType
	  * @return type de gem
	 */
	public Gem getImmunity()
	{
		return immunity;
	}
	 /**
	  * méthode set définissant le type de gem de la classe EnnemyType
	  * @param type de gem
	 */
	public void setImmunity(Gem gemme_)
	{
		immunity=gemme_;
	}
	 /**
	  * méthode get retournant la vitesse des ennemis de la classe EnnemyType
	  * @return la vitesse
	 */
	public float getSpeed()
	{
		return speed;
	}
	 /**
	  * méthode set définissant la vitesse des ennemis de la classe EnnemyType
	  * @param la vitesse
	 */
	public void setSpeed(float speed_)
	{
		speed=speed_;
	}
	 /**
	  * méthode get retournant la taille d'un ennemi de la classe EnnemyType
	  * @return taille d'un ennemi
	 */
	public float getSize()
	{
		return size;
	}
	 /**
	  * méthode set définissant la taille d'un ennemi de la classe EnnemyType
	  * @param taille d'un ennemi
	 */
	public void setSize(float size_)
	{
		size=size_;
	}
	 /**
	  * méthode get retournant le sprite de l'ennemi de la classe EnnemyType
	  * @return  sprite
	 */
	public String getSprite()
	{
		return sprite;
	}
	 /**
	  * méthode set définissant le sprite de l'ennemi de la classe EnnemyType
	  * @param sprite
	 */
	public void setSprite(String sprite_)
	{
		sprite=sprite_;
	}
	 /**
	  * méthode get retournant la vie de l'ennemi de la classe EnnemyType
	  * @return la vie de l'ennemi
	 */
	public int getLife()
	{
		return life;
	}
	 /**
	  * méthode set définissant la vie de l'ennemi de la classe EnnemyType
	  * @param la vie de l'ennemi
	 */
	public void setLife(int life_)
	{
		life=life_;
	}
	 /**
	  * méthode get retournant le nom du type d'ennemi de la classe EnnemyType
	  * @return nom du type d'ennemi
	 */
	public int getMana()
	{
		return mana;
	}
	 /**
	  * méthode set définissant la vie de l'ennemi de la classe EnnemyType
	  * @param la vie de l'ennemi
	 */
	public void setMana(int mana_)
	{
		mana=mana_;
	}
	
	
	
	
	
	
}
