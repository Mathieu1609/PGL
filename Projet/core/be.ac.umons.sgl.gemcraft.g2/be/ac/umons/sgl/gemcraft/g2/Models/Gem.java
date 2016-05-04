package be.ac.umons.sgl.gemcraft.g2.Models;

public class Gem 
{
	private String color;
	
	 /**
	  * constructeur  par d�faut de la classe gem
	 */
	public Gem(){}
	 /**
	  * constructeur de la classe gem
	  * @param la couleur de la gem
	 */
	public Gem(String color_)
	{
		color=color_;
	}
	 /**
	  * m�thode get retournant la couleur de la gem de la classe gem
	  * @return la couleur de la gem
	 */
	public String getColor()
	{
		return color;
	}
	 /**
	  * m�thode set d�finissant la couleur de la gem de la classe gem
	  * @param la couleur de la gem
	 */
	public void setColor(String color_)
	{
		color=color_;
	}
	

}
