package be.ac.umons.sgl.gemcraft.g2.Models;

public class Gems
{
	private enum enumColor {red,orange,yellow,green,cyan,blue,magenta,violet}
	private Gem gemme;
	private Integer quantity;
	 /**
	  * constructeur de la classe gemm
	  * @param le type de gem et la quantit�
	 */
	public Gems(Gem gemme_,int quantity_)
	{
		gemme=gemme_;
		quantity=quantity_;
	}
	 /**
	  * m�thode get retournant une gem de la classe gems
	  * @return une gem
	 */
	public Gem getGemme()
	{
		return gemme;
	}
	 /**
	  * m�thode set d�finissant une gem de la classe gems
	  * @param une gem
	 */
	public void setGemme(Gem gemme_)
	{
		gemme=gemme_;
	}
	 /**
	  * m�thode get retournant la quantit� en int de gem de la classe gems
	  * @return la quantit�
	 */
	public int getQuantity()
	{
		return quantity;
	}
	 /**
	  * m�thode get d�finissant la quantit� de gem de la classe gems
	  * @param la quantit�
	 */
	public void setQuantity(int quantity_)
	{
		quantity=quantity_;
	}
	 /**
	  * m�thode get retournant la quantit� en string de gem de la classe gems
	  * @return la quantit�
	 */
	public String getStringQuantity()
	{
		return String.valueOf(quantity);
	}
	

}
