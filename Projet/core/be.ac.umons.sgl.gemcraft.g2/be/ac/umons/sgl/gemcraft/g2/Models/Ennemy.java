package be.ac.umons.sgl.gemcraft.g2.Models;

public class Ennemy 
{
	private EnnemyType type;
	private int quantity;
	 /**
	  * constructeur par d�faut de la classe Ennemy
	 */
	public Ennemy(){}
	 /**
	  * constructeur de la classe Ennemy
	  * @param type Ennemi et la quantit�e
	 */
	public Ennemy(EnnemyType type_,int quantity_)
	{
		type=type_;
		quantity=quantity_;
	}
	 /**
	  * m�thode get retournant le type d'ennemi de la classe Ennemy
	  * @return tyoe d'ennemi
	 */
	public EnnemyType getType()
	{
		return type;
	}
	 /**
	  * m�thode set d�finissant le type d'ennemi de la classe Ennemy
	  * @param type d'ennemi
	 */
	public void setType(EnnemyType type_)
	{
		type=type_;
	}
	 /**
	  * m�thode get retournant la quantit� de la classe Ennemy
	  * @return quantit�e
	 */
	public int getQuantity()
	{
		return quantity;
	}
	 /**
	  * m�thode set d�finissant la quantit�e de la classe Ennemy
	  * @param quantit�
	 */
	public void setQuantity(int quantity_)
	{
		quantity=quantity_;
	}
	
	
	

}
