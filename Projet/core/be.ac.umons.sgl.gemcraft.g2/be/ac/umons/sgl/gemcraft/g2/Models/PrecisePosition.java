package be.ac.umons.sgl.gemcraft.g2.Models;

public class PrecisePosition
{
	private float abscisse;
	private float ordonne;

	/**
	 * constructeur par d�faut de la classe PrecisePosition
	*/
	public PrecisePosition(){}
	/**
	 * constructeur de la classe PrecisePosition
	 * @param abscisse et ordonn�e
	*/
	public PrecisePosition(float abscisse_,float ordonne_)
	{
		abscisse= abscisse_;
		ordonne=ordonne_;
	}
	/**
	 * Getter Abscisse de la classe PrecisePosition
	 * @return abscisse (float)
	*/
	public float getPreciseAbscisse()
	{
		return abscisse;
	}
	/**
	 * Getter ordonn�e de la classe PrecisePosition
	 * @return ordonn�e (float)
	*/
	public float getPreciseOrdonne()
	{
		return ordonne;
	}
	/**
	 * Setter Abscisse de la classe PrecisePosition
	 * @param abscisse 
	*/
	public void setPreciseAbscisse(float abscisse_)
	{
		abscisse=abscisse_;
	}
	/**
	 * Setter ordonn�e de la classe PrecisePosition
	 * @param  ordonn�e
	*/
	public void setPreciseOrdonne(float ordonne_)
	{
		ordonne=ordonne_;
	}
	
	
	

}
