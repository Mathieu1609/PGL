package be.ac.umons.sgl.gemcraft.g2.Main;

import java.io.File;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import be.ac.umons.sgl.gemcraft.g2.Models.Level;
import be.ac.umons.sgl.gemcraft.g2.Screens.MenuScreen;

public class Main extends Game {

	public Music music;
	public int musicVol;
	public BitmapFont black;
	public TextureAtlas atlas;
	public boolean MenuScreen =true;
	public boolean ExtentionTower=false;
	public boolean ExtensionAA=false;
	public Level levelActual= new Level();
	public Skin skin;
	public TextButton BackButton;
	 /**
	  *  Initialisation de la musique + appel à l'écran menu
	 */
	@Override
	public void create() {
			All();
	music=Gdx.audio.newMusic(Gdx.files.internal("son"+File.separator+"Danger.mp3"));
	music.setLooping(true);
	music.play();
	musicVol=3;
		setScreen(new MenuScreen(this));
	}
	 /**
	  * 
	  *  initialisation des variables Atlas et BitmapFont pour l'ensmble du projet
	 */
	public void All()
	{
		 atlas= new TextureAtlas("ui"+File.separator+"UI.pack");
		 black= new BitmapFont(Gdx.files.internal("Skin"+File.separator+"font32.fnt"));
		skin = new Skin(atlas);
		skin.add("default",black);
		//TextButtonStyle Bouton retour		
		TextButtonStyle BackTxtStyle = new TextButtonStyle();
		BackTxtStyle.font=skin.getFont("default");
		BackTxtStyle.up=skin.getDrawable("bouton_home");
								
		BackButton = new TextButton("",BackTxtStyle);
		BackButton.setPosition((Gdx.graphics.getWidth()/12)-45,(Gdx.graphics.getHeight()/16));
		BackButton.setSize(Gdx.graphics.getWidth()/12,(Gdx.graphics.getHeight()/12));
	}
	 /**
	* fonction dispose permettant de libérer les ressources de la fenêtre
	 */
	@Override
	public void dispose()
	{
		super.dispose();
 		music.dispose();
	}
}
