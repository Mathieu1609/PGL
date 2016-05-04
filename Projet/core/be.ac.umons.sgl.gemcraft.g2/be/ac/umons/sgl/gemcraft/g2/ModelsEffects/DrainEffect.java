package be.ac.umons.sgl.gemcraft.g2.ModelsEffects;


public class DrainEffect implements Effects
{
	private int nbrGems;
	private boolean isPure;
	private int dammage;
	/**
	 * Constructeur de la classe DrainEffect
	 * @param nombre de gemmes, quantit� de gem, dommage
	*/ 
	public DrainEffect(int nbrGems_,boolean isPure_,int dammage_)
	{
		nbrGems=nbrGems_;
		isPure=isPure_;
		dammage=dammage_;
	}
	/**
	 * fonction renvoyant la quantit� de mana en fonction de la puret� et des d�g�ts de la classe DrainEffect
	 * @return mana
	*/ 
	public int activeDrain()
	{
		
		int mana= dammage/10;
		if(isPure==true)
		{
			mana=(mana*5);
		}else
		{
			mana=(mana*nbrGems);
		}
		return mana;
	}

}
