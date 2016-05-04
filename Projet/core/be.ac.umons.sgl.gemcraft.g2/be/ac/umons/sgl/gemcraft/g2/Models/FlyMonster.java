package be.ac.umons.sgl.gemcraft.g2.Models;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.StatusEffects;

public class FlyMonster extends Monster
{
	
	public FlyMonster(Position position_, EnnemyType type_)
	{
		position=position_;
		type=type_;
		this.setLife(type.getLife());
		alive=true;
		defineTile();
		speed= this.getType().getSpeed();
		coefficientDefense=1;
		listEffets= new ArrayList<StatusEffects>();
		
	}
	
	
	/**
	 * Méthode déplaçant le monstre volant
	 */
	@Override
	public void move(TiledMapTileLayer layer,Level level)
	{
		int tileNexusX=(level.getNexus().getIntAbscisse())/32;
		int tileNexusY=(level.getNexus().getIntOrdonne())/32;
		
		int tileX=this.position.getIntAbscisse()/32;
		int tileY=this.position.getIntOrdonne()/32;
		
		boolean action =false;
		
		if(tileNexusX-tileX>0)
		{
			Position pos= new Position(position.getAbscisse()+32,position.getOrdonne());
			this.setPosition(pos);
			action =true;
		}
		if((tileX-tileNexusX>0)&&(action==false))
		{
			Position pos= new Position(position.getAbscisse()-32,position.getOrdonne());
			this.setPosition(pos);
			action =true;
		}
		if((tileNexusY-tileY>0)&&(action==false))
		{
			Position pos= new Position(position.getAbscisse(),position.getOrdonne()+32);
			this.setPosition(pos);
			action =true;
		}
		if((tileY-tileNexusY>0)&&(action==false))
		{
			Position pos= new Position(position.getAbscisse(),position.getOrdonne()-32);
			this.setPosition(pos);
			action =true;
		}
		
		
		
	}

}
