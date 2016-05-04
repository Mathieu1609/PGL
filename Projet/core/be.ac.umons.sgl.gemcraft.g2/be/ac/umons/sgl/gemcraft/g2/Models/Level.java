package be.ac.umons.sgl.gemcraft.g2.Models;

public class Level 
{
	private String name;
	private String map;
	private int life;
	private int mana;
	private String path;
	private Position positionNexus;
	private String nbrWaves;
	
	/**
	 * Constructeur par defaut de la classe Level
	*/
	public Level(){};
	/**
	 * Constructeur de la classe Level
	 * @param nom , map, vie, mana, la carte, position du nexus, nombre de vague
	*/
	public Level(String name_,String map_,int life_,int mana_,String path_,Position positionNexus_,String nbrWaves_)
	{
		name=name_;
		map=map_;
		life=life_;
		mana=mana_;
		path=path_;
		positionNexus=positionNexus_;
		nbrWaves=nbrWaves_;
	}
	/**
	 * getter retournant la carte de la classe Level
	 * @return la carte
	*/
	public String getPath()
	{
		return path;
	}
	/**
	 * Setter définissant la carte du niveau de la classe Level
	 * @param carte (string)
	*/
	public void setPath(String path_)
	{
		path=path_;
	}
	/**
	 * getter retournant le nom du niveau de la classe Level
	 * @return le nom
	*/
	public String getName()
	{
		
		return name;
	}
	/**
	 * Setter définissant le nom du niveau de la classe Level
	 * @param le nom
	*/
	public void setName(String name_)
	{
		name=name_;
	}
	/**
	 * getter retournant la map du niveau de la classe Level
	 * @return la carte
	*/
	public String getmap()
	{
		return map;
	}
	/**
	 * Setter définissant la vie du niveau de la classe Level
	 * @param vie
	*/
	public void setLife(int life_)
	{
		life=life_;
	}
	/**
	 * getter retournant la vie du niveau de la classe Level
	 * @return la vie (int)
	*/
	public int getlifeValue()
	{
		
		return life;
	}
	/**
	 * getter retournant la vie du niveau de la classe Level
	 * @return la vie (string)
	*/
	public String getLife()
	{
		return String.valueOf(life);
	}
	/**
	 * getter retournant le mana du niveau de la classe Level
	 * @return le mana (int)
	*/
	public int getmanaValue()
	{
		return mana;
	}
	/**
	 * getter retournant le mana du niveau de la classe Level
	 * @return le mana (string)
	*/
	public String getMana()
	{
		return String.valueOf(mana);
	}
	/**
	 * Setter définissant le mana du niveau de la classe Level
	 * @param mana
	*/
	public void setMana(int mana_)
	{
		mana=mana_;
	}
	/**
	 * getter retournant la position du nexus du niveau de la classe Level
	 * @return position
	*/
	public Position getNexus()
	{
		return positionNexus;
	}
	/**
	 * Setter définissant la position du nexus du niveau de la classe Level
	 * @param position
	*/
	public void setNexus(Position position_)
	{
		positionNexus=position_;
	}
	/**
	 * getter retournant le nombres de vagues du niveau de la classe Level
	 * @return nombre de vagues
	*/
	public String getNbrWaves()
	{
		return nbrWaves;
	}
	/**
	 * Setter définissant le nombres de vagues du niveau de la classe Level
	 * @param nombre de vagues
	*/
	public void setNbrWaves(String nbrWaves_)
	{
		nbrWaves=nbrWaves_;
	}

}
