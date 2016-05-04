package be.ac.umons.sgl.gemcraft.g2.Models;

public class Ennemy 
{
	private EnnemyType type;
	private int quantity;
	 /**
	  * constructeur par défaut de la classe Ennemy
	 */
	public Ennemy(){}
	 /**
	  * constructeur de la classe Ennemy
	  * @param type Ennemi et la quantitée
	 */
	public Ennemy(EnnemyType type_,int quantity_)
	{
		type=type_;
		quantity=quantity_;
	}
	 /**
	  * méthode get retournant le type d'ennemi de la classe Ennemy
	  * @return tyoe d'ennemi
	 */
	public EnnemyType getType()
	{
		return type;
	}
	 /**
	  * méthode set définissant le type d'ennemi de la classe Ennemy
	  * @param type d'ennemi
	 */
	public void setType(EnnemyType type_)
	{
		type=type_;
	}
	 /**
	  * méthode get retournant la quantité de la classe Ennemy
	  * @return quantitée
	 */
	public int getQuantity()
	{
		return quantity;
	}
	 /**
	  * méthode set définissant la quantitée de la classe Ennemy
	  * @param quantité
	 */
	public void setQuantity(int quantity_)
	{
		quantity=quantity_;
	}
	
	
	

}
