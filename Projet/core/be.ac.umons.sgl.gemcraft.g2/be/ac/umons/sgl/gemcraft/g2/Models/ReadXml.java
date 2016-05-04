package be.ac.umons.sgl.gemcraft.g2.Models;

import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.input.sax.XMLReaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class ReadXml 
{
	private Document document;
	private Element racine;
	private String repertoryPath;
	private String[]listFichier;
	private ArrayList<Level> listLevel= new ArrayList<Level>();
	private FileHandle[] files;
	
	private ArrayList<EnnemyType> ennemyType= new ArrayList<EnnemyType>();
	private ArrayList<Spawn> spawnGroupe=new ArrayList<Spawn>();
	private ArrayList<Wave> listWave= new ArrayList<Wave>();
	
	/**
	 * Constructeur
	 * @param path_ chemin du fichier .xml
	 */
	public ReadXml (String path_)
	{
		repertoryPath=path_;
		parsage(path_);
	}
	
	/**
	 * Constructeur
	 * @param path_ chemin du répertoire des fichiers .xml
	 * @param listFichier_ liste des fichiers .xml
	 */
	public ReadXml(String path_,String[]listFichier_)
	{
		repertoryPath=path_;
		listFichier=listFichier_;
	}
	/**
	 * Constructeur
	 * @param files_ chemin du répertoire des fichiers .xml
	 *  
	 */
	public ReadXml(FileHandle[]files_)
	{
		files=files_;
	}
	
	/**
	 * Lecture des fichiers .xml
	 * @return liste des niveaux
	 */
	
	
	/*public ArrayList<Level> reading()
	{
		for(String x: listFichier)
		{
			getHeadInfo(repertoryPath+File.separator+x);
		}
		return listLevel;
	}*/
	
	public ArrayList<Level> reading()
	{

		
		for(FileHandle x: files)
		{
			getHeadInfo(x);
		}
		
		
		return listLevel;
	}
	
	/**
	 * Récupère les informations du niveau
	 * @param path Chemin du .xml
	 */
	
	public void getHeadInfo(FileHandle x)
	{
		
		parsage(x.file().getAbsolutePath());
				
		//  Récupération des données
		String levelName=racine.getAttributeValue("name");
		String levelMap= racine.getAttributeValue("map");	
		
		int levelLife=Integer.parseInt(racine.getAttributeValue("life"));
		int levelMana=Integer.parseInt(racine.getAttributeValue("mana"));
		Position positionNexus= new Position();
		positionNexus.setAbscisse(Integer.parseInt(racine.getAttributeValue("nexus_x")));
		positionNexus.setOrdonne(Integer.parseInt(racine.getAttributeValue("nexus_y")));
		String nbrWaves=countNbrWaves();
		
		
		// Ajout à la liste de niveau
		
		Level newLevel= new Level(levelName,levelMap,levelLife,levelMana,x.file().getAbsolutePath(),positionNexus,nbrWaves);
		listLevel.add(newLevel);
	
	}
	
	/**
	 * Compteur du nombre de vagues d'un niveau
	 * @return le nombre total
	 */
	public String countNbrWaves()
	{
		int compteur=0;
           Element gems = racine.getChild("waves");
		
		List<Element> tmp= gems.getChildren("wave");
		for(final Element x: tmp)
		{
			compteur++;
		
		}
		return String.valueOf(compteur);
		
	}
	
	/**
	 * Parsage du document .xml
	 * @param path Chemin du .xml
	 */
	
	
	public void parsage(String path)
	{
		SAXBuilder build = new SAXBuilder(); 

		try
		{
			// Parsing.
			document=build.build(new File(path));
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		// Initialisation de la racine
		racine=document.getRootElement();
	}
	
	/**
	 * Récupère les gemmes du niveau
	 * @return les gemmes du niveau et leur quantité associé
	 */
	
	public ArrayList<Gems> getGems()
	{
		
		ArrayList<Gems> listGem= new ArrayList<Gems>();
	
		Element gems = racine.getChild("gems");
		List<Element> tmp= gems.getChildren("gem");
		for(final Element x: tmp)
		{
			Gem gemme=new Gem();
			gemme.setColor(x.getAttributeValue("color"));
			Gems gemmeQuantity= new Gems(gemme,Integer.parseInt(x.getAttributeValue("quantity")));
		
			//listGem.put(key,gemme);
			listGem.add(gemmeQuantity);
		}
		
		getSpawns();
		getEnnemytypes();
		
		return listGem;

	}
	
	/**
	 * Récupère les spawns du niveau
	 * @return Les spawns du niveau
	 */
	
	public ArrayList<Spawn> getSpawns()
	{
		Element gems = racine.getChild("spawns");
		
		List<Element> tmp= gems.getChildren("spawn");
		for(final Element x: tmp)
		{
			Spawn spawn = new Spawn();
			spawn.setName(x.getAttributeValue("name"));
			Position position= new Position(Integer.parseInt(x.getAttributeValue("x")),Integer.parseInt(x.getAttributeValue("y")));
			spawn.setPosition(position);
			spawnGroupe.add(spawn);
		}
		return spawnGroupe;
	}
	
	/**
	 * Récupère les types d'ennemis du niveau
	 * @return les types d'ennemis
	 */

	public ArrayList<EnnemyType> getEnnemytypes()
	{
		Element types= racine.getChild("enemytypes");
		List<Element>tmp=types.getChildren("type");
		for(final Element x: tmp)
		{
			EnnemyType type= new EnnemyType();
			type.setName(x.getAttributeValue("name"));
			Gem gemme = new Gem(x.getAttributeValue("immunity"));
			type.setImmunity(gemme);
			type.setSpeed(Float.parseFloat(x.getAttributeValue("speed")));
			type.setSize(Float.parseFloat(x.getAttributeValue("size")));
			type.setSprite(x.getAttributeValue("sprite"));
			type.setLife(Integer.parseInt(x.getAttributeValue("life")));
			type.setMana(Integer.parseInt(x.getAttributeValue("life")));
			ennemyType.add(type);
		}
		return ennemyType;
	}
	
	/**
	 * Récupère les vagues d'un niveau
	 * @return les vagues du niveau
	 */
	
	public ArrayList<Wave> getWaves()
	{
		Element waves = racine.getChild("waves");
		List<Element>listWaves=waves.getChildren("wave");
		int i=0;
		for(final Element waveCompteur: listWaves)
		{
			i++;
			List<Element>listGroupe=waveCompteur.getChildren("group");
			Wave wave = new Wave(readGroupe(listGroupe));
			wave.setDelay(Integer.parseInt(waveCompteur.getAttributeValue("delay")));
		//	listWave.add(wave);			
			wave.setNumWave(i);
			listWave.add(wave);
		}
		return listWave;
		
	}
	
	/**
	 * Sélectionne les groupes correspondants à une vague
	 * @param listElementGroupe les elements groupes
	 * @return la liste des groupes correspondants
	 */
	
	public ArrayList<Groupe> readGroupe(List<Element>listElementGroupe)
	{
		ArrayList<Groupe> listeGroupe= new ArrayList<Groupe>();
		ArrayList<Ennemy>listeEnnemyInGroupe= new ArrayList<Ennemy>();
		for(final Element groupeCompteur : listElementGroupe)
		{
		
			List<Element>listEnnemy=groupeCompteur.getChildren("ennemy");
			listeEnnemyInGroupe=readEnnemy(listEnnemy);
			Groupe groupe = new Groupe(listeEnnemyInGroupe);
			groupe.setLapse(Float.parseFloat(groupeCompteur.getAttributeValue("lapse")));
			groupe.setTimer(Integer.parseInt(groupeCompteur.getAttributeValue("timer")));
			groupe.setSpawn(findSpawn(groupeCompteur.getAttributeValue("spawn")));
			listeGroupe.add(groupe);
		}
		return listeGroupe;
	}
	
	/**
	 * Sélectionne les Ennemies correspondants à un groupe
	 * @param listElementEnnemy les elements Ennemy
	 * @return Les ennmis correspondants
	 */
	
	public ArrayList<Ennemy> readEnnemy(List<Element>listElementEnnemy)
	{
		ArrayList<Ennemy> listeEnnemy= new ArrayList<Ennemy>();
		for(final Element ennemyCompteur: listElementEnnemy)
		{
			Ennemy ennemy = new Ennemy();
			ennemy.setQuantity(Integer.parseInt(ennemyCompteur.getAttributeValue("quantity")));
			ennemy.setType(findEnnemyType(ennemyCompteur.getAttributeValue("type")));
			
			listeEnnemy.add(ennemy);
		}
		return listeEnnemy;
	}
	
	
	/**
	 * Permet de retrouver un type à partir de son nom
	 * @param name le nom d'un type
	 * @return Le type d'ennemis correspondant.
	 */
	public EnnemyType findEnnemyType(String name)
	{
		EnnemyType type = new EnnemyType();
		for(final EnnemyType x: ennemyType)
		{
			
			if((x.getName()).equals(name))
			{
				type=x;
			}
			
		}	
		return type;
	} 
	
	/**
	 * Permet de retrouver un spawn à partir de son nom
	 * @param name le nom du spawn
	 * @return le spawn corrspondant
	 */
	
	public Spawn findSpawn(String name)
	{
		Spawn spawn = new Spawn();
		for(final Spawn x:spawnGroupe )
		{
			if((x.getName()).equals(name))
			{
				spawn=x;
			}
		}
		return spawn;
	}
	
	/**
	 * Définit si des ennemis volants seront dans le niveau
	 * @return true si oui, false sinon
	 */
	public boolean isFlyEnnemy()
	{
		boolean flyEnnemy=false;
		for(final EnnemyType x: ennemyType)
		{
			
			if((x.getName()).equals("fly"))
			{
				flyEnnemy=true;
			}
			
		}	
		return flyEnnemy;
	}

}
