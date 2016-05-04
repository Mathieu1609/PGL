package be.ac.umons.sgl.gemcraft.g2.Screens;

import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;

public class HelpScreen implements Screen {

	private Main gdx;
	private SpriteBatch HelpBatch;
	private Sprite sprite;
	private Stage stage;
	private int numDoc;
	private Label LbTxt;
	 private LabelStyle LbStyle;
	/**
	 *  constructeur
	 *	@param gdx
	 */
	public HelpScreen (Main gdx)
	{
		this.gdx=gdx;
		stage=new Stage();
		BackButton();
		NextButton();
		numDoc=1;
		AfficherTexte(numDoc);
		
	}
	
	/**
	 *  Fonction lisant le premier fichier texte relatives aux gemmes et l'affiche à l'écran
	 */
	public void AfficherTexte(int num)
	{
		FileHandle Fichier= Gdx.files.internal("Other"+File.separator+"Help"+num+".txt");
		BitmapFont font = new BitmapFont(Gdx.files.internal("Skin"+File.separator+"font32.fnt"));
		String texte= Fichier.readString();
		 LbStyle= new LabelStyle(gdx.black,Color.YELLOW);
		 Skin LbSkin= new Skin();
		 LbSkin.add("default",font);
		 LbStyle.font=LbSkin.getFont("default");
		 LbSkin.add("default",LbStyle);
		 LbTxt = new Label(texte,LbStyle);
		LbTxt.setPosition(Gdx.graphics.getWidth()/18,Gdx.graphics.getHeight()/5);
		stage.addActor(LbTxt);
	}
	/**
	 *  Fonction mettant à jour le texte afficher à l'écran en fonction du fichier texte chercher
	 */
	public void UpdateTexte( int num)
	{
		FileHandle Fichier= Gdx.files.internal("Other"+File.separator+"Help"+num+".txt");
		String texte= Fichier.readString();
		LbTxt.setText(texte);
		
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
	 *  Fonction créant et gérant l'évènement du bouton suivant pour changer de fichier texte
	 */
	 public void NextButton()
		{
		 
				Skin Menuskin = new Skin(gdx.atlas);
				Menuskin.add("default", gdx.black);
								
				// définition du TextButtonStyle
				
				TextButtonStyle textButtonStyle = new TextButtonStyle();
				textButtonStyle.up= Menuskin.getDrawable("Button");
				textButtonStyle.fontColor=Color.YELLOW;
				textButtonStyle.font=Menuskin.getFont("default");
				Menuskin.add("default", textButtonStyle);
				
				 TextButton NextButton = new TextButton("suivant",Menuskin);				 
				 NextButton.setPosition((float) (Gdx.graphics.getWidth()/1.2),Gdx.graphics.getHeight()/16);
				 NextButton.setSize(300,60);	
				 stage.addActor(NextButton);
		
	
			NextButton.addListener(new ClickListener(){
				public void clicked (InputEvent event, float x,float y)
				{
					if (numDoc==1)
					{
						numDoc=2;
						UpdateTexte(numDoc);
					}
					else
					{
						numDoc=1;
					UpdateTexte(numDoc);
					}
				}
				  });
									 
		}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	/**
	 *  Fonction render
	 * @param delta
	 */
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		HelpBatch= new SpriteBatch();
		Texture MenuTexture= new Texture("img"+File.separator+"FondJouer.jpg");
		sprite= new Sprite(MenuTexture);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		HelpBatch.begin();
		sprite.draw(HelpBatch);
		HelpBatch.end();
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		BackButton();
		NextButton();
		AfficherTexte(numDoc);
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		HelpBatch.dispose();
		stage.dispose();
	}

}
