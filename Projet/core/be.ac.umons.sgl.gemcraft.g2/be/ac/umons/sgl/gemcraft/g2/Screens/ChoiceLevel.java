package be.ac.umons.sgl.gemcraft.g2.Screens;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;
import be.ac.umons.sgl.gemcraft.g2.Models.Level;
import be.ac.umons.sgl.gemcraft.g2.Models.ReadXml;




public class ChoiceLevel extends ApplicationAdapter implements Screen
{
	private TiledMap map;
	private OrthogonalTiledMapRenderer tmr;
	private OrthographicCamera camera;
	private SpriteBatch batch= new SpriteBatch();;
	private TmxMapLoader loader= new TmxMapLoader();
	
	private int positionListLevel=0;
	private Sprite LevelSprite;
	private Stage Stage;
	private Main gdx;
	private  ArrayList<Level> listLevel= new ArrayList<Level>();
	 private Label LbNameLevel;
	 private Label LbLifeLevel;
	 private Label LbManaLevel;
	 private Label LbWaveLevel;
	private  TextButton NextButton;
	 /**
	  * @param gdx
	  *  Constructeur + chargements XML + positionnement de la caméra
	 */
	public ChoiceLevel(Main gdx) {
		this.gdx = gdx;		
		FileHandle fichier = new FileHandle(System.getProperty("user.home") + File.separator+"Desktop"+File.separator+"Gl-g2"+File.separator+"levels");

		ReadXml read=new ReadXml(fichier.list());
		//String path="files"+File.separator;
		//AssetManager a=new AssetManager();
		//String path= new File(".//files").getPath();
		//path=path+File.separator+File.separator+"files";     
	//	File file= new File(path);	// récupération du fichier contenant les .xml
		//String[] listFichier=file.list();	// récupération des .xml   
	   // ReadXml read= new ReadXml(path.toString(),listFichier); // lecture des .xml
		listLevel=read.reading();
		 gdx.levelActual=(Level) listLevel.get(positionListLevel);
          map = loader.load("res"+File.separator+File.separator+gdx.levelActual.getmap()+".tmx"); // récupération de la carte
		    tmr = new OrthogonalTiledMapRenderer(map);//création du renderer
			Texture MenuTexture= new Texture("img"+File.separator+"fLaunch.jpg");
		LevelSprite= new Sprite(MenuTexture);
		LevelSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera = new OrthographicCamera(1700,1700);//taille du viewPort
		camera.position.set(camera.viewportWidth/4.2f,camera.viewportWidth/5f, 0);//position de la caméra = position de l'image sur l'écran
		createButton();
		createLabel();
	}
	/**
	 *  Fonction permettant d'afficher le bouton retour . Attention corriger l'evenements du click
	 */ 
    public void MenuBackButton()
	{
		//déclarations
				Skin BtBackSkin = new Skin(gdx.atlas);
				BtBackSkin.add("default", gdx.black);
								
		//TextButtonStyle		
				TextButtonStyle BackTxtStyle = new TextButtonStyle();
				BackTxtStyle.font=BtBackSkin.getFont("default");
				BackTxtStyle.up=BtBackSkin.getDrawable("bouton_home");
				BtBackSkin.add("default",BackTxtStyle);
						
				TextButton MenuButton = new TextButton("",BtBackSkin);
				MenuButton.setPosition((Gdx.graphics.getWidth()/18),(Gdx.graphics.getHeight()/16));
				MenuButton.setSize(150,100);
				Stage.addActor(MenuButton);
		
						MenuButton.addListener(new ClickListener(){
				public void clicked (InputEvent event, float x,float y)
				{
					Gdx.app.log("Bouton Retour","Retour");
					dispose();
					gdx.setScreen(new MenuScreen(gdx));
				}
					});
			
	}
	/**
	 *  Fonction permettant de créer les boutons suivant et précendent pour la gestion des niveaux
	 */    
    public void createButton()
		{
	 			Stage=new Stage();
				Gdx.input.setInputProcessor(Stage);
				Skin Menuskin = new Skin(gdx.atlas);
				Menuskin.add("default", gdx.black);
								
				// définition du TextButtonStyle
				
				TextButtonStyle textButtonStyle = new TextButtonStyle();
				textButtonStyle.up= Menuskin.getDrawable("Button");
				textButtonStyle.fontColor=Color.YELLOW;
				textButtonStyle.font=Menuskin.getFont("default");
				Menuskin.add("default", textButtonStyle);
				
				//Initialisation des boutons
				 TextButton BackButton = new TextButton("précedent",Menuskin);
				 NextButton = new TextButton("suivant",Menuskin);
				 TextButton PlayButton = new TextButton("Jouer",Menuskin);
				 
				 BackButton.setPosition((float) (Gdx.graphics.getWidth()/(11)),(Gdx.graphics.getHeight()/2));
				 NextButton.setPosition((float) (Gdx.graphics.getWidth()/(1.35)),(Gdx.graphics.getHeight()/2));
				 PlayButton.setPosition((float) (Gdx.graphics.getWidth()/1.15),Gdx.graphics.getHeight()/16);
				 BackButton.setSize(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()/14));
				 NextButton.setSize(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()/14));
				 PlayButton.setSize(200,60);
					 
			   // Ajout des boutons
				Stage.addActor(BackButton);	
				Stage.addActor(NextButton);
				Stage.addActor(PlayButton);		
				MenuBackButton();
			PlayButton.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
				{	
					if(positionListLevel==0)
					{
						gdx.ExtensionAA=true;
					}
					else
					{
						gdx.ExtensionAA=false;
					}
						gdx.setScreen(new Playing(gdx));
						dispose();
					}
				});
			NextButton.addListener(new ClickListener(){
				final int countElement= listLevel.size(); // indice de listLevel
				public void clicked (InputEvent event, float x,float y)
				{
					if(positionListLevel<countElement-1)
						{
							 positionListLevel++; // récupération du niveau suivant
						}
					 else
					    {
						     positionListLevel=0; // récupération du premier niveau
					    }
							changeMap(positionListLevel);
							modifyLabel();
				}
				  });
						
			BackButton.addListener(new ClickListener(){
				final int countElement= listLevel.size(); // indice de listLevel
				public void clicked (InputEvent event, float x,float y)
				{
					 if(positionListLevel==0)
					    {
						 	positionListLevel=countElement-1;  //récupération du dernier niveau 
						}
					 else
					    {
							positionListLevel--; // récupération du niveau précédent
					    }
					 		changeMap(positionListLevel);
							modifyLabel();
				}
				});					 
		}
    /**
	 *  Fonction permettant de créer les labels pour les informations des niveaux
	 */ 
    public void createLabel()
    {
	 
		 LabelStyle LbStyle= new LabelStyle(gdx.black,Color.YELLOW);
		 Skin LbSkin= new Skin();
		 LbSkin.add("default",gdx.black);
	
		 LbStyle.font=LbSkin.getFont("default");
		 LbSkin.add("default",LbStyle);
		 LbNameLevel=new Label("Niveau : "+gdx.levelActual.getName(),LbStyle);
		 LbLifeLevel=new Label("Capacité de Vie  : "+gdx.levelActual.getLife(),LbStyle);
		 LbManaLevel=new Label("Capacité de Mana : "+gdx.levelActual.getMana(),LbStyle);
		 LbWaveLevel = new Label("Nombre de vague : "+gdx.levelActual.getNbrWaves(),LbStyle);
	 
		// Nom
		LbNameLevel.setPosition((float) (Gdx.graphics.getWidth()/(3.1)),(float) (Gdx.graphics.getHeight()/1.4));
		LbNameLevel.setSize(45,45);
		Stage.addActor(LbNameLevel);
	
		//Vie
		LbLifeLevel.setPosition((float) (Gdx.graphics.getWidth()/(3.1)),(Gdx.graphics.getHeight()/4));
		LbLifeLevel.setSize(45,45);
		Stage.addActor(LbLifeLevel);
		
		//Mana
		LbManaLevel.setPosition((float) (Gdx.graphics.getWidth()/(3.1)),(float) (Gdx.graphics.getHeight()/5));
		LbManaLevel.setSize(45,45);
		Stage.addActor(LbManaLevel);
		
		//wave
		LbWaveLevel.setPosition((float) (Gdx.graphics.getWidth()/(3.1)),(float) (Gdx.graphics.getHeight()/7));
		LbWaveLevel.setSize(45,45);
		Stage.addActor(LbWaveLevel);
    }
	@Override
	public void show() {
		
	}
	
	/**
	 *  Fonction render
	 *
	 */
	@Override
	public void render(float delta) {
		
		batch = new SpriteBatch();
		batch.begin();
		LevelSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		LevelSprite.draw(batch);
		batch.end();
		camera.update();//important sinon pas de prise en compte des input camera !!
		tmr.setView(camera);//on indique la caméra utilisée pour coupler les systèmes de coordonnées
		tmr.render();//rendu de la carte
		batch.setProjectionMatrix(camera.combined);
		Stage.act();
		Stage.draw();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	 /**
		 *  Fonction permettant de mettre à jours les labels
		 */ 
	public void modifyLabel()
	{
		LbNameLevel.setText("Niveau : "+gdx.levelActual.getName());
		LbLifeLevel.setText("Capacité de Vie  : "+gdx.levelActual.getLife());
		LbManaLevel.setText("Capacité de Mana : "+gdx.levelActual.getMana());
		LbWaveLevel.setText("Nombre de vague : "+gdx.levelActual.getNbrWaves());
	}
	 /**
	 *  Fonction permettant de mettre à jours la carte
	 */ 
	public void changeMap(int positionListLevel)
	{
		    gdx.levelActual=(Level) listLevel.get(positionListLevel);
            map = loader.load("res"+File.separator+File.separator+gdx.levelActual.getmap()+".tmx"); // récupération de la carte
            tmr.setMap(map);
            
	}
	
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	/**
	 *  Fonction permettant de libérer les ressources appropriées à la fenêtre
	 *
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		Stage.dispose();
		tmr.dispose();
		map.dispose();
		
	}
	@Override
	public void resize(int width, int height) {
	createButton();	createLabel();

	}
	
}
