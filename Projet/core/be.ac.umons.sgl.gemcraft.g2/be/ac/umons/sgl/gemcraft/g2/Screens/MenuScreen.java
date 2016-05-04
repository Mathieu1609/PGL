package be.ac.umons.sgl.gemcraft.g2.Screens;



import java.io.File;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;

public class MenuScreen implements Screen {

	// déclarations des variables
	
	private Sprite MenuSprite;
	private SpriteBatch	Menubatch;
	private Stage Stage;
	private TextButton StartButton;
	private TextButton OptionButton;
	private TextButton QuitButton;
	private Main gdx;

	
	public MenuScreen(Main gdx) {
		this.gdx = gdx;
		gdx.MenuScreen=true;
	}
	/**
	 *  Fonction permettant d'afficher les boutons du menu + gestion des evenements
	 *
	 */
	public void Button()
	{
		Skin PlaySkin,OptionSkin,QuitSkin;
	    TextButtonStyle PlayStyle,OptionStyle,QuitStyle;
	   
		Stage=new Stage();
		Gdx.input.setInputProcessor(Stage);
					
		// définition du TextButtonStyle
		
		PlayStyle= new TextButtonStyle();
		OptionStyle= new TextButtonStyle();
		QuitStyle= new TextButtonStyle();
		PlayStyle.up= gdx.skin.getDrawable("PlayButton");
		OptionStyle.up= gdx.skin.getDrawable("OptionButton");
		QuitStyle.up= gdx.skin.getDrawable("QuitButton");
		PlayStyle.font=gdx.skin.getFont("default");
		PlayStyle.fontColor=Color.YELLOW;
		QuitStyle.fontColor=Color.YELLOW;
		OptionStyle.fontColor=Color.YELLOW;
		OptionStyle.font= gdx.skin.getFont("default");
		QuitStyle.font= gdx.skin.getFont("default");
			
		//Initialisation des boutons
		 StartButton = new TextButton("Jouer",PlayStyle);
		 OptionButton= new TextButton("option",OptionStyle);
		 QuitButton= new TextButton("Quitter",QuitStyle);
	     	     
	    // Definition de la taille et position des boutons
	     StartButton.setPosition((float) (Gdx.graphics.getWidth()/(2.5)),(Gdx.graphics.getHeight()/2)+120);
	     OptionButton.setPosition((float) (Gdx.graphics.getWidth()/(2.5)),(Gdx.graphics.getHeight()/2));
		 QuitButton.setPosition((float) (Gdx.graphics.getWidth()/(2.5)),(Gdx.graphics.getHeight()/2)-120);
		 StartButton.setSize(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()/14));
		 OptionButton.setSize(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()/14));
		 QuitButton.setSize(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()/14));
		 ButtonHelp();
		 
		 // Ajout des boutons
		Stage.addActor(StartButton);	
		Stage.addActor(OptionButton);
		Stage.addActor(QuitButton);
		
		//Evénements boutons
		StartButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x,float y)
			{
				gdx.setScreen(new ChoiceLevel(gdx));
				dispose();
			}			
		});
		
		QuitButton.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
			dispose();
			System.exit(0);
			}
		});	
		
		OptionButton.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
			gdx.setScreen(new OptionScreen(gdx));
			}
		});	
	}
	/**
	 *  Fonction permettant d'afficher le button aide
	 *
	 */
	public void ButtonHelp()
	{
				
		TextButtonStyle HelpBt = new TextButtonStyle();
		
		HelpBt.font= gdx.skin.getFont("default");
		HelpBt.up= gdx.skin.getDrawable("Help");
		final TextButton Help= new TextButton("",HelpBt);
		Help.setPosition((Gdx.graphics.getWidth()/24),Gdx.graphics.getHeight()/20);
		Help.setSize(65,65);
		Stage.addActor(Help);
		Help.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				gdx.setScreen(new HelpScreen(gdx));
				}
	});
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Button();
		
	}
	/**
	 *  @param delta
	 *  méthode render
	 *
	 */
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Menubatch= new SpriteBatch();
		 Texture MenuTexture= new Texture("img"+File.separator+"FondMenu.png");
		MenuSprite= new Sprite(MenuTexture);
		MenuSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Menubatch.begin();
		MenuSprite.draw(Menubatch);
		Menubatch.end();
		Stage.act();
		Stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		Button();
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
	 *  focntion dispose libérant les ressources de la fenêtre à sa fermeture
	 *
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		Stage.dispose();
		Menubatch.dispose();
	}

}
