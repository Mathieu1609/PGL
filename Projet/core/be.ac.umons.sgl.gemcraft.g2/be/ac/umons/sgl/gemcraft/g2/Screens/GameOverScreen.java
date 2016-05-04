package be.ac.umons.sgl.gemcraft.g2.Screens;

import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;

public class GameOverScreen implements Screen{
	
	private Stage stage;
	private Main gdx;
	private Sprite sprite;
	private SpriteBatch spriteBatch;
	
	public GameOverScreen(Main gdx)
	{
		this.gdx=gdx;
		stage=new Stage();
		BackButton();
	}
	/**
	 *  Fonction permettant d'afficher le bouton retour ainsi que de gérer l'évenement du clique
	 */
	public void BackButton()
	{
		//déclarations
				stage=new Stage();
				Gdx.input.setInputProcessor(stage);
		//TextButtonStyle		
				
				stage.addActor(gdx.BackButton);
		
				gdx.BackButton.addListener(new ClickListener(){
				public void clicked (InputEvent event, float x,float y)
				{
					gdx.setScreen(new MenuScreen(gdx));
					dispose();
				}
					});
			
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		spriteBatch= new SpriteBatch();
		Texture MenuTexture= new Texture("img"+File.separator+"FondGameOver.jpg");
		sprite= new Sprite(MenuTexture);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		spriteBatch.end();
		stage.act();
		stage.draw();
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		BackButton();
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
		stage.dispose();
		spriteBatch.dispose();
	}
	
}
