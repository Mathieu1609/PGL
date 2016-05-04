package be.ac.umons.sgl.gemcraft.g2.Models;

import java.util.ArrayList;

import org.jdom2.Element;
import java.util.Timer;
import java.util.TimerTask;
import com.badlogic.gdx.Gdx;


public class Wave 
{
	private int delay;
	private ArrayList<Groupe> listGroupe;
	private int numWave;
	/**
	 * constructeur par défaut de la classe Wave
	*/
	public Wave(){}
	/**
	 * methode timer
	*/
	public void Timer()
	{
		TimerTask task = new TimerTask()
		{
			@Override
			public void run() 
			{
				
			}	
		};

	}
	/**
	 * constructeur de la classe Wave
	 * @param liste de groupe
	*/
	public Wave(ArrayList<Groupe>listGroupe_)
	{
		listGroupe=listGroupe_;
	}
	/**
	 * constructeur de la classe Wave
	 * @param liste de groupe et un delai
	*/
	public Wave(int delay_,ArrayList<Groupe>listGroupe_)
	{
		delay=delay_;
		listGroupe=listGroupe_;
	}
	/**
	 * Getter Delay de la classe Wave
	 * @return délai
	*/
	public int getDelay()
	{
		return delay;
	}
	/**
	 * Setter Delay de la classe Wave
	 * @param délai
	*/
	public void setDelay(int delay_)
	{
		delay=delay_;
	}
	/**
	 * Getter numéro de la vague de la classe Wave
	 * @return numéro de la vague
	*/
	public int getNumWave()
	{
		return numWave;
	}
	/**
	 * Setter numéro de la vague de la classe Wave
	 * @param numéro de la vague
	*/
	public void setNumWave(int numWave_)
	{
		numWave=numWave_;
	}
	/**
	 * fonction permettant d'ajouter un groupe à une liste de groupe de la classe Wave
	 * @param un groupe
	*/
	public void addListGroupe(Groupe groupe)
	{
		listGroupe.add(groupe);
	}
	/**
	 * fonction permettant de supprimer un groupe à une liste de groupe de la classe Wave
	 * @param un groupe
	*/
	public void removeListGroupe(Groupe groupe)
	{
		for(final Groupe x: listGroupe)
		{
			if(x.equals(groupe))
			{
				listGroupe.remove(x);
			}
		}
	}
	/**
	 * fonction permettant de retourner le groupe en fonction du numéro de la classe Wave
	 * @return le numéro du groupe dans la liste groupe
	*/
	public Groupe getGroupe(int num_)
	{	
		return listGroupe.get(num_);
	}
	/**
	 * fonction permettant de savoir en fonction du numéro si c'est le dernier groupe de la classe Wave
	 * @return booleen
	*/
	public boolean isLastGroupe(int num_)
	{
		boolean bool = false;
		
		if(((num_ +1) >listGroupe.size())|| ((num_ +1)==listGroupe.size()))
		{
			bool=true;
		}
		
		return bool;
		
	}
	/**
	 * fonction retournant le premier groupe de la liste groupe de la classe Wave
	 * @return le premier groupe de la liste groupe
	*/
	public Groupe getFirstGroupe()
	{
		return listGroupe.get(0);
	}
	

}
