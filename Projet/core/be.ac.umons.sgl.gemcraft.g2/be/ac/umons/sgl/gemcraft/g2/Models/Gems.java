package be.ac.umons.sgl.gemcraft.g2.Models;

public class Gems
{
	private enum enumColor {red,orange,yellow,green,cyan,blue,magenta,violet}
	private Gem gemme;
	private Integer quantity;
	 /**
	  * constructeur de la classe gemm
	  * @param le type de gem et la quantité
	 */
	public Gems(Gem gemme_,int quantity_)
	{
		gemme=gemme_;
		quantity=quantity_;
	}
	 /**
	  * méthode get retournant une gem de la classe gems
	  * @return une gem
	 */
	public Gem getGemme()
	{
		return gemme;
	}
	 /**
	  * méthode set définissant une gem de la classe gems
	  * @param une gem
	 */
	public void setGemme(Gem gemme_)
	{
		gemme=gemme_;
	}
	 /**
	  * méthode get retournant la quantité en int de gem de la classe gems
	  * @return la quantité
	 */
	public int getQuantity()
	{
		return quantity;
	}
	 /**
	  * méthode get définissant la quantité de gem de la classe gems
	  * @param la quantité
	 */
	public void setQuantity(int quantity_)
	{
		quantity=quantity_;
	}
	 /**
	  * méthode get retournant la quantité en string de gem de la classe gems
	  * @return la quantité
	 */
	public String getStringQuantity()
	{
		return String.valueOf(quantity);
	}
	

}
