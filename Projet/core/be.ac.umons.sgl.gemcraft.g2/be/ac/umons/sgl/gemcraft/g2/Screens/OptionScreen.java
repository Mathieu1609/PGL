package be.ac.umons.sgl.gemcraft.g2.Screens;


import com.badlogic.gdx.graphics.Color;

//import static org.junit.Assert.*;
//
//import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;



public class OptionScreen implements Screen{
	
	private TextButton SoundMaxBt;
	private Main gdx;
	private ChoiceLevel choixLevel;
	private SpriteBatch	batch;
	private Sprite OptionSprite;
	private Stage stage;
	private Sprite SoundSprite;
	private Texture texture;
	public CheckBox SoundCB;
	public CheckBox ExtentionCB;
	
	OptionScreen(Main gdx) {
		this.gdx=gdx;
	}
	/**
	 *  Fonction permettant d'afficher le bouton retour ainsi que de gérer l'évenement du clique
	 */
	public void BackButton()
	{
		//déclarations
				stage=new Stage();
				Gdx.input.setInputProcessor(stage);
				
						stage.addActor(gdx.BackButton);
		
				gdx.BackButton.addListener(new ClickListener(){
				public void clicked (InputEvent event, float x,float y)
				{
					if(gdx.MenuScreen==true)
					gdx.setScreen(new MenuScreen(gdx));
					else gdx.setScreen(new Playing(gdx));
					
					dispose();
				}
					});
			
	}
	/**
	 *  Fonction permettant d'afficher les CheckBox Son et Extension tour aériennes 
	 * + gestion des évenements
	 */
	public void CheckBox()
	{		
		CheckBoxStyle soundStyle = new CheckBoxStyle();
		soundStyle.checkboxOff= gdx.skin.getDrawable("checkbox-unchecked");
		soundStyle.checkboxOn=gdx.skin.getDrawable("checkbox_checked");
		soundStyle.font=gdx.skin.getFont("default");

		ExtentionCB = new CheckBox("",soundStyle);
		 SoundCB = new CheckBox("",soundStyle);
		SoundCB.setPosition((float) (Gdx.graphics.getWidth()/(2.5)),(Gdx.graphics.getHeight()/2)-10);
		SoundCB.setSize(Gdx.graphics.getWidth()/16,(Gdx.graphics.getHeight()/15));
		SoundCB.setChecked(true);
		stage.addActor(SoundCB);
		 ExtentionCB.setPosition((float) (Gdx.graphics.getWidth()/(2.5)),(float) (Gdx.graphics.getHeight()/1.7));
		 ExtentionCB.setSize(Gdx.graphics.getWidth()/16,(Gdx.graphics.getHeight()/15));
		 if(gdx.ExtentionTower==false)
	     {
			 ExtentionCB.setChecked(false);
		 }
		 else
		 {
			 ExtentionCB.setChecked(true);
		 }
		 
		stage.addActor(ExtentionCB);
		SoundCB.addListener(new ClickListener(){
			public void clicked(InputEvent event,float x,float y)
			{
				if(SoundCB.isChecked()==false){
					
					gdx.music.pause();
					texture=new Texture("son/SonMuet.png");
					PositionSon(texture);
					SoundMaxBt.setDisabled(true);
				}
				else 
				{
					gdx.music.play();
					Sound();
				}
			}
				});
		ExtentionCB.addListener(new ClickListener(){
			public void clicked(InputEvent event,float x,float y)
			{
				if(ExtentionCB.isChecked()==true)
				{
					gdx.ExtentionTower=true;
				}

			}
				});
	}
	/**
	 *  Fonction permettant d'afficher les différents textes présents sur la page (Son et extension)
	 */
	public void Label()
	{
		LabelStyle LbStyle = new LabelStyle(gdx.black,Color.YELLOW);
		LbStyle.font=gdx.skin.getFont("default");
				
		Label SoundTxt = new Label("Son",LbStyle);
		SoundTxt.setPosition((float) (Gdx.graphics.getWidth()/(2.1)),(Gdx.graphics.getHeight()/2));
		SoundTxt.setSize(45,45);
		stage.addActor(SoundTxt);
		Label ExtentionTxt = new Label("Ativer la strategie des tours",LbStyle);
		ExtentionTxt.setPosition((float)(Gdx.graphics.getWidth()/(2.1)),(float) (Gdx.graphics.getHeight()/1.7));
		ExtentionTxt.setSize(45,45);
		stage.addActor(ExtentionTxt);
	}
	/**
	 *  Fonction permettant de reposition l'image son
	 */
	public void PositionSon(Texture texture)
	{
		SoundSprite = new Sprite(texture);
		SoundSprite.setPosition((float) (Gdx.graphics.getWidth()/(1.55)),(Gdx.graphics.getHeight()/2));
		SoundSprite.setSize(Gdx.graphics.getWidth()/16,(Gdx.graphics.getHeight()/16));
	}
	/**
	 *  Fonction permettant de gérer le volume du son + images du son
	 */
	public int Sound()
	{
		
		TextButtonStyle SoudMinStyle;
		TextButtonStyle SoudMaxStyle;
		Skin SoundMinSkin,SoundMaxSkin;
			
		SoudMinStyle= new TextButtonStyle();
		SoudMinStyle.font=gdx.skin.getFont("default");
		SoudMinStyle.up=gdx.skin.getDrawable("moins");
				
		TextButton SoundMinBt = new TextButton("",SoudMinStyle);
		SoundMinBt.setPosition((float) (Gdx.graphics.getWidth()/(1.8)),(Gdx.graphics.getHeight()/2));
		SoundMinBt.setSize(Gdx.graphics.getWidth()/16,(Gdx.graphics.getHeight()/16));
		stage.addActor(SoundMinBt);
		
		SoudMaxStyle= new TextButtonStyle();
		SoudMaxStyle.font=gdx.skin.getFont("default");
		SoudMaxStyle.up=gdx.skin.getDrawable("plus");
				
		SoundMaxBt= new TextButton("",SoudMaxStyle);
		SoundMaxBt.setPosition((float) (Gdx.graphics.getWidth()/(1.4)),(Gdx.graphics.getHeight()/2));
		SoundMaxBt.setSize(Gdx.graphics.getWidth()/16,(Gdx.graphics.getHeight()/16));
		stage.addActor(SoundMaxBt);
		switch (gdx.musicVol){
		case 0:texture=new Texture("son/SonMuet.png");
				break;
		case 1: texture=new Texture("son/son1.png");
				break;
		case 2: texture=new Texture("son/son2.png");
				break;
		case 3: texture = new Texture("son/son3.png");	
		}
		PositionSon(texture);
		SoundMaxBt.addListener(new ClickListener(){
		public void clicked (InputEvent event, float x,float y)
			{	
				switch (gdx.musicVol)
				{
				case 0: 
					gdx.musicVol=1;
					gdx.music.play();
					gdx.music.setVolume(0.3f);
					texture=new Texture("son/son1.png");
						break;
				case 1: 
					gdx.musicVol=2;
					gdx.music.setVolume(0.7f);
					texture=new Texture("son/son2.png");
						break;
				case 2: 
					gdx.musicVol=3;
					gdx.music.setVolume(1f);
					texture=new Texture("son/son3.png");
						break;	
				}
				PositionSon(texture);
			}	
		});
		
		SoundMinBt.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				switch (gdx.musicVol)
				{
				case 2: 
					gdx.musicVol=1;
					gdx.music.play();
					gdx.music.setVolume(0.3f);
					texture=new Texture("son/son1.png");
						break;
				case 3: 
					gdx.musicVol=2;
					gdx.music.setVolume(0.7f);
					texture=new Texture("son/son2.png");
						break;
				case 1: 
					gdx.musicVol=0;
					gdx.music.pause();
					texture=new Texture("son/SonMuet.png");
						break;	
				}
				PositionSon(texture);
			}
		});
		
		return gdx.musicVol;
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		BackButton();
		CheckBox();
		Label();
		Sound();
	}
	/**
	 *  Fonction render
	 *
	 */
	@Override
	public void render(float delta) 
	{
		// TODO Auto-generated method stub
		batch= new SpriteBatch();
		 Texture MenuTexture= new Texture("img/fOptions.jpg");
		OptionSprite= new Sprite(MenuTexture);
		OptionSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.begin();
		OptionSprite.draw(batch);
		SoundSprite.draw(batch);
		batch.end();
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		show();
		// TODO Auto-generated method stub
		BackButton();
		CheckBox();
		Label();
		Sound();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	/**
	 *  Fonction dispose qui permet de libérer les ressources de la fenêtre
	 *
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		batch.dispose();
	}
}
