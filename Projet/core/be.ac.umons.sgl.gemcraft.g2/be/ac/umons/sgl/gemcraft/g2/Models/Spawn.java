package be.ac.umons.sgl.gemcraft.g2.Models;

public class Spawn 
{
	private String name;
	private Position position;
	/**
	 * constructeur par défaut de la classe Spawn
	*/
	public Spawn(){};
	/**
	 * constructeur  de la classe Spawn
	 * @param nom et Position
	*/
	public Spawn(String name_,Position position_)
	{
		name=name_;
		position=position_;
	}
	/**
	 * Getter du nom du spawn de la classe Spawn
	 * @return nom
	*/
	public String getName()
	{
		return name;
	}
	/**
	 * Getter position de la classe Spawn
	 * @return Position
	*/
	public Position getPosition()
	{
		return position;
	}
	/**
	 * Setter du nom du spawn  de la classe Spawn
	 * @param nom
	*/
	public void setName(String name_)
	{
		name=name_;
	}
	/**
	 * Setter position de la classe Spawn
	 * @param Position
	*/
	public void setPosition(Position position_)
	{
		position=position_;
	}

}
