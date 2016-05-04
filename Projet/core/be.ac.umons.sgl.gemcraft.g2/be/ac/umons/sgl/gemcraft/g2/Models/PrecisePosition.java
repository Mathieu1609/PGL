package be.ac.umons.sgl.gemcraft.g2.Models;

public class PrecisePosition
{
	private float abscisse;
	private float ordonne;

	/**
	 * constructeur par défaut de la classe PrecisePosition
	*/
	public PrecisePosition(){}
	/**
	 * constructeur de la classe PrecisePosition
	 * @param abscisse et ordonnée
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
	 * Getter ordonnée de la classe PrecisePosition
	 * @return ordonnée (float)
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
	 * Setter ordonnée de la classe PrecisePosition
	 * @param  ordonnée
	*/
	public void setPreciseOrdonne(float ordonne_)
	{
		ordonne=ordonne_;
	}
	
	
	

}
