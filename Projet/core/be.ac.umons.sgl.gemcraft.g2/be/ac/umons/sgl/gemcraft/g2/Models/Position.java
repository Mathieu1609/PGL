package be.ac.umons.sgl.gemcraft.g2.Models;

public class Position {
	
private	float abscisse;
private	float ordonne;

/**
 * constructeur par d�faut de la classe Position
*/
public Position(){}

/**
 * constructeur Int de la classe Position
 * @param abscisse et ordonn�e
*/
public Position(int abscisse_,int ordonne_)
{
	abscisse= abscisse_;
	ordonne=ordonne_;
}
/**
 * constructeur float de la classe Position
 * @param abscisse et ordonn�e
*/
public Position(float abscisse_,float ordonne_)
{
	abscisse= abscisse_;
	ordonne=ordonne_;
}
/**
 * Getter Abscisse de la classe Position
 * @return abscisse (float)
*/
public float getAbscisse()
{
	return abscisse;
}
/**
 * Getter ordonn�e de la classe Position
 * @return ordonn�e (float)
*/
public float getOrdonne()
{
	return ordonne;
}
/**
 * Setter Abscisse de la classe Position
 * @param abscisse (float)
*/
public void setAbscisse(float f)
{
	abscisse=f;
}
/**
 * Setter ordonn�e de la classe Position
 * @param ordonn�e (float)
*/
public void setOrdonne(float f)
{
	ordonne=f;
}
/**
 * Getter Abscisse de la classe Position
 * @return abscisse (int)
*/
public int getIntAbscisse()
{
	return (int) abscisse;
}
/**
 * Getter ordonn�e de la classe Position
 * @return ordonn�e (int)
*/
public int getIntOrdonne()
{
	return (int) ordonne;
}

}
