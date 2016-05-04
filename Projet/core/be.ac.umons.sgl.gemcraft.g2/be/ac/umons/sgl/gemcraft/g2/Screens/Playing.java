package be.ac.umons.sgl.gemcraft.g2.Screens;

import java.io.File;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.TimeUtils;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;
import be.ac.umons.sgl.gemcraft.g2.Models.Bullet;
import be.ac.umons.sgl.gemcraft.g2.Models.DcaTower;
import be.ac.umons.sgl.gemcraft.g2.Models.Ennemy;
import be.ac.umons.sgl.gemcraft.g2.Models.EnnemyType;
import be.ac.umons.sgl.gemcraft.g2.Models.Gem;
import be.ac.umons.sgl.gemcraft.g2.Models.Gems;
import be.ac.umons.sgl.gemcraft.g2.Models.Groupe;
import be.ac.umons.sgl.gemcraft.g2.Models.Level;
import be.ac.umons.sgl.gemcraft.g2.Models.Monster;
import be.ac.umons.sgl.gemcraft.g2.Models.Position;
import be.ac.umons.sgl.gemcraft.g2.Models.ReadXml;
import be.ac.umons.sgl.gemcraft.g2.Models.Spawn;
import be.ac.umons.sgl.gemcraft.g2.Models.Tower;
import be.ac.umons.sgl.gemcraft.g2.Models.Wave;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaChains;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.AreaDammage;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.CriticalEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.DrainEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.Effects;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.PoisonEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.SlowEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.StatusEffects;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.StunEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsEffects.WeakEffect;
import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.LastEnnemyStrategie;
import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.MostLifeEnnemy;
import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.MostManaEnnemy;
import be.ac.umons.sgl.gemcraft.g2.ModelsStrategies.StandardStrategie;


public class Playing extends ApplicationAdapter  implements Screen,InputProcessor
{
	private int numberTower=1;
	private State state = State.RUN;
	private ActionState actionState= ActionState.Standard;
	private String couleur="";
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Level levelActual;
	private Sprite FondSprite;
	private BitmapFont font;
	private Stage stage;
	private TextButtonStyle pauseStyle;
	private Skin skin ;
	private TextButton redGemBtInv,blueGemBtInv, yellowGemBtInv, greenGemBtInv, oranjeGemBtInv,cyanGemBtInv,magGemBtInv,purpleGemBtInv;
	private TextButton redGemBtTower,blueGemBtTower, yellowGemBtTower, greenGemBtTower, orangeGemBtTower,cyanGemBtTower,magentaGemBtTower,violetGemBtTower;
	private  Table invTable,tourTable;
	private Main gdx;
	private ArrayList<Wave> listWaves= new ArrayList<Wave>();
	private ArrayList<Gems> listGems= new ArrayList<Gems>();
	private ArrayList<Gems> listGemsTour= new ArrayList<Gems>();
	private Label redGemsTower,greenGemsTower,blueGemsTower, yellowGemsTower, orangeGemsTower, cyanGemsTower,magentaGemsTower, violetGemsTower;
	private Label redGem,greenGem,blueGem, yellowGem, orangeGem, cyanGem,magentaGem, violetGem, lbWaveLevel, lbLifeLevel, lbManaLevel, tourLb,numTourLb, dommageTourLb, nbrTourLb;
	private LabelStyle invLbStyle;
	private long startTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
	private long timeBeforeWave=0;
	private long startEnnemyTime=startEnnemyTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
	private long timeBeforeNewEnnemy=0;
	private Wave actualWave=new Wave();
	private Groupe actualGroupe=new Groupe();
	private ArrayList<Monster>listMonster= new ArrayList<Monster>();
	private ArrayList<Monster>listMonsterInMap= new ArrayList<Monster>();
	private ArrayList<Bullet>listBullet= new ArrayList<Bullet>();
	private int numWave=0;
	private int numGroupe=0;
	private int numMonster=0;
	
	private Spawn actualSpawn= new Spawn();
	private ArrayList<Tower>listTower= new ArrayList<Tower>();
	private Sprite spriteTower;
	private Tower actualTower = new Tower();
	
	private boolean isWaitGroupeTime=false;
//	private boolean end=false;
	private boolean isFlyEnnemy;
	
	/**
	 * Chargement de la carte 
	 * @param gdx
	 * @param level
	 */
	
	public Playing(Main gdx)
	{
	
		 this.gdx=gdx;
		 levelActual=gdx.levelActual;
		 ReadXml read= new ReadXml(levelActual.getPath());
		 listGems=read.getGems();
		 listWaves=read.getWaves();
		 isFlyEnnemy=read.isFlyEnnemy();
		 // chargement de la première vague
		 
		 loadFirstWave();
		stage=new Stage();
	
		InputMultiplexer im= new InputMultiplexer();
		im.addProcessor(stage);
		im.addProcessor(this);
		Gdx.input.setInputProcessor(im);
		
		 font=new BitmapFont(Gdx.files.internal("Skin"+File.separator+"font32.fnt"));
		 skin= new Skin(gdx.atlas);
		 skin.add("default",font);
		Texture MenuTexture= new Texture("img"+File.separator+"FondJouer.jpg");
		FondSprite= new Sprite(MenuTexture);
		
		TmxMapLoader loader = new TmxMapLoader();//création du loader de carte
		map = loader.load("res"+File.separator+File.separator+levelActual.getmap()+".tmx");     // chargement de la carte
		renderer = new OrthogonalTiledMapRenderer(map);//création du renderer
		camera = new OrthographicCamera(1100,850);//taille du viewPort (1020,720) oookkk
		 camera.position.set(camera.viewportWidth/2.05f,camera.viewportHeight/2.1f, 0);//position de la caméra dansle monde 2D...centrée sur la carte (640*640) !!	(500,370,0) OKKKKKKK 
		 batch = new SpriteBatch();
		 label();
         inventaire();	
		 infoTour();
	}

	/**
	 * Charge la vague actuelle.
	 */
	public void loadFirstWave()
	{

		actualWave=giveWave(numWave);
		actualGroupe=actualWave.getGroupe(numGroupe);
		listMonster=actualGroupe.createMonster();	
		
		
		startTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
		timeBeforeWave=actualWave.getDelay();

	}
	/**
	 * actualise le groupe de la vague
	 */
	public void actualiseGroupeWave()
	{
		if(actualWave.isLastGroupe(numGroupe))
		{
			if(islastWave(numWave))
			{
			
				gdx.setScreen(new WinScreen(gdx));
				
			}else
			{
					numWave++;
					actualWave=giveWave(numWave);
					numGroupe=0;
					actualGroupe=actualWave.getGroupe(numGroupe);
					listMonster=actualGroupe.createMonster();	
			}
		
		}
		else
		{
			numGroupe++;
			actualGroupe=actualWave.getGroupe(numGroupe);
			listMonster=actualGroupe.createMonster();
		}
		startTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
		timeBeforeWave=actualWave.getDelay();
	}
	
	

	
	/**
	 * Modifie le curseur de la souris en tour
	 * @param si le curseur est par défault (boolean)
	 */
	
	public void modifyMouseTower(boolean isCorrect,boolean dca)
	{
		
		if(isCorrect==true)
		{
			Pixmap tm= new Pixmap(Gdx.files.internal("Skin"+File.separator+File.separator+"yessTower.png"));
			Gdx.graphics.setCursor(Gdx.graphics.newCursor(tm,0,0));
		    tm.dispose();
		    if(dca==true)
		    {
		    	actionState=ActionState.BuildDCATowerAuthorize;
		    }else
		    {
		    	actionState=ActionState.BuildTowerAuthorize;
		    }
		    
		}else
		{
			Pixmap wm=new Pixmap(Gdx.files.internal("Skin"+File.separator+File.separator+"noTower.png"));
			Gdx.graphics.setCursor(Gdx.graphics.newCursor(wm,0,0));
		    wm.dispose();
		    if(dca==true)
		    {
		    	actionState=ActionState.BuildDCATowerAuthorize;
		    }
		    else
		    {
		    	actionState=ActionState.BuildTowerUnAuthorize;
		    }
		    
		}
	}
	/**
	 * modifie l'aspect du curseur en gem
	 * @param couleur de la gem
	 */
	public void modifyMouseGem(String gem_)
	{

			Pixmap tm= new Pixmap(Gdx.files.internal("Gem"+File.separator+gem_+".png"));
			Gdx.graphics.setCursor(Gdx.graphics.newCursor(tm,0,0));
		    tm.dispose();
				
	}
	
	/**
	 * Charge l'aspect du curseur par défaut
	 */
	public void originalMouse()
	{
		Gdx.graphics.setSystemCursor(SystemCursor.Arrow);
		actionState=ActionState.Standard;
	}
	public enum State
	{
	    PAUSE,RUN,RESUME,STOPPED
	}
	/**
	 *  Fonction permettant de mettre en pause ou play le jeu
	 */ 
	public void PauseBt ()
	{
		state=state.RUN;
								
		 pauseStyle = new TextButtonStyle();
		 pauseStyle.font=gdx.skin.getFont("default");
		pauseStyle.up = gdx.skin.getDrawable("pause");
					
		final TextButton pauseButton = new TextButton("",pauseStyle);
		pauseButton.setPosition((Gdx.graphics.getWidth()/2),(float) (Gdx.graphics.getHeight()/1.2));
		pauseButton.setSize(150,100);
		stage.addActor(pauseButton);

		pauseButton.addListener(new ClickListener(){
		public void clicked (InputEvent event, float x,float y)
		{
			if(state.name()=="RUN")
			{
				pauseStyle.up=gdx.skin.getDrawable("play");
				state=state.PAUSE;
			}
			else
			{
				pauseStyle.up=gdx.skin.getDrawable("pause");
				state=state.RUN;
			}
		}
			});
	}
	
	/**
	 *  Fonction permettant de créer les labels pour les informations du niveau
	 */ 
	public void label ()
	{
	
	
		 LabelStyle lbStyle= new LabelStyle(font,Color.GOLDENROD);


		 lbStyle.font=skin.getFont("default");;
		  lbWaveLevel = new Label("Numero de la vague: 0  Temps restant : "+timeBeforeWave,lbStyle);
		   lbLifeLevel = new Label("Vie  : "+levelActual.getLife(),lbStyle);
		   lbManaLevel = new Label("Mana : "+levelActual.getMana(),lbStyle);

		 		
		  lbWaveLevel.setPosition((float) (Gdx.graphics.getWidth()/25),(float)(Gdx.graphics.getHeight()/1.2));
		  lbWaveLevel.setSize(45,45);
			stage.addActor(lbWaveLevel);
			//Vie
			lbLifeLevel.setPosition((float) (Gdx.graphics.getWidth()/27),(float)(Gdx.graphics.getHeight()/1.1));
			lbLifeLevel.setSize(45,45);
			stage.addActor(lbLifeLevel);
			
			//Mana
			lbManaLevel.setPosition((float) (Gdx.graphics.getWidth()/5),(float)(Gdx.graphics.getHeight()/1.1));
			lbManaLevel.setSize(45,45);
			stage.addActor(lbManaLevel);
			PauseBt ();
	}
	
	
	/**
	 * Diminue le temps d'attente avant la vague.
	 */
	
	public void decreaseDelayWave()
	{
		
		  long diffTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
		  long elapsed=(diffTime-startTime)/1000;
	      timeBeforeWave=actualWave.getDelay()-elapsed;
			  
		 if(timeBeforeWave>0)
		 {					
		     lbWaveLevel.setText("Numero de la vague: "+actualWave.getNumWave()+"  "+ "Temps restant :"+timeBeforeWave);
		     
		     
		 }else
		 {
			 lbWaveLevel.setText("Numero de la vague: "+actualWave.getNumWave()+"  Vague en cours");
		 }
		 
		
	}
	
	/**
	 * Diminue le délai d'apparition d'un ennemi
	 * @return  true si le temps d'attente est finit, false sinon
	 */
	
	public boolean decreaseDelayEnnemy()
	{
		boolean isLapse=false;
		long diffTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
		long elapsed=(diffTime-startEnnemyTime);
		float lapse = (actualGroupe.getLapse()*1000);
		
		if(elapsed>lapse)
		{
			  isLapse=true;
			  startEnnemyTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
			
		}
		return isLapse;
		
	}
	
	/**
	 * Diminue le délai d'apparition d'un groupe
	 * 
	 */
	
	
	public void decreaseDelayGroupe()
	{
		
			if(isWaitGroupeTime==false)
			{
				isWaitGroupeTime=true;
				startTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
			}
		
		
		long diffTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
		long elapsed=(diffTime-startTime);
		if(elapsed>((actualGroupe.getTimer())*1000))
		{
			timeBeforeWave=-2;
		}
	}

	/**
	 * Initialise le nombre de gemmes de l'inventaire.
	 * @param style des labels.
	 */
	public void initialisationNbrGems(ArrayList<Gems> listGems_)
	{
	
		 redGem= new Label("0",invLbStyle);	 
		 greenGem= new Label("0",invLbStyle); 
		 blueGem= new Label("0",invLbStyle);
		 yellowGem= new Label("0",invLbStyle);
		 orangeGem= new Label("0",invLbStyle);
		 cyanGem= new Label("0",invLbStyle);
		 magentaGem= new Label("0",invLbStyle);
		 violetGem= new Label("0",invLbStyle);
		 greenGem= new Label("0",invLbStyle);
		
		for(final Gems x:listGems_ )
		{
			switch(x.getGemme().getColor())
			{
			case "red":
				redGem.setText(x.getStringQuantity());
			break;
			case "green":
				greenGem.setText(x.getStringQuantity());
			break;
			case "blue":
				blueGem.setText(x.getStringQuantity());
			break;
			case "yellow":
				yellowGem.setText(x.getStringQuantity());
			break;
			case "orange":
				orangeGem.setText(x.getStringQuantity());
			break;
			case "cyan":
				cyanGem.setText(x.getStringQuantity());
			break;
			case "magenta":
				magentaGem.setText(x.getStringQuantity());
			break;
			case "violet":
				violetGem.setText(x.getStringQuantity());
			break;
			default:
			break;
			
			}
		
		}

	}
	/**
	 * initialisation de la valeur des gems de l'inventaire
	 */
	
	public void initiationGemmesTower(ArrayList<Gems> listGems_)
	{
	
		 redGemsTower= new Label("0",invLbStyle);	 
		 greenGemsTower= new Label("0",invLbStyle); 
		 blueGemsTower= new Label("0",invLbStyle);
		 yellowGemsTower= new Label("0",invLbStyle);
		 orangeGemsTower= new Label("0",invLbStyle);
		 cyanGemsTower= new Label("0",invLbStyle);
		 magentaGemsTower= new Label("0",invLbStyle);
		 violetGemsTower= new Label("0",invLbStyle);
		
		for(final Gems x:listGems_ )
		{
			switch(x.getGemme().getColor())
			{
			case "red":
				redGemsTower.setText(x.getStringQuantity());
			break;
			case "green":
				greenGemsTower.setText(x.getStringQuantity());
			break;
			case "blue":
				blueGemsTower.setText(x.getStringQuantity());
			break;
			case "yellow":
				yellowGemsTower.setText(x.getStringQuantity());
			break;
			case "orange":
				orangeGemsTower.setText(x.getStringQuantity());
			break;
			case "cyan":
				cyanGemsTower.setText(x.getStringQuantity());
			break;
			case "magenta":
				magentaGemsTower.setText(x.getStringQuantity());
			break;
			case "violet":
				violetGemsTower.setText(x.getStringQuantity());
			break;
			default:
			break;
			
			}
		
		}

	}
	 /**
     *  Définit si c'est la dernière vague
     * @param num_ numéro de la vague
     * @return true si dernière vague , false sinon
     */
	
	public boolean islastWave(int num_)
	{
		boolean isLast=false;
		
		if(((num_ +1)>listWaves.size()) || ((num_ +1)==listWaves.size()))
		{
			isLast=true;
		}
		return isLast;
	}
	
	/**
	 * Donne la première vague.
	 * @return première vague.
	 */
	
	public Wave giveFirstWave()
	{
		return listWaves.get(0);
	}
	
	
	/**
	 * Donne une vague.
	 * @param num_ numéro de la vague.
	 * @return la vague correspondante.
	 */
	
	public Wave giveWave(int num_)
	{
		return listWaves.get(num_);
	}
	//gems
	/**
	* fonction qui permet de vérrifier si on peut supprimer une gemme si sa quantité est = ou < que 0
	* @return true si >0 ,false = ou > 0
	 */
	public boolean verifSuppGem( ArrayList<Gems> gemsTower)
	{
		for(final Gems x:gemsTower)
		{
			if((x.getGemme().getColor()).equals(couleur)&& x.getQuantity()<=0)
			{
				return false;
			}
		}
		
		return true;
	}
	/**
	* on vérifie si on peut ajouter une gemmes en fonction de sa quantité.
	* @return booleen false si < ou = 0
	 */
	
	public boolean verifAddGem()
	{
		boolean verif=true;
		
		boolean containsColor=false;
		
		
		for(final Gems x:listGems )
		{
			if((x.getGemme().getColor()).equals(couleur)&& x.getQuantity()<=0)
			{
				return false;
			}
			
		   if((x.getGemme().getColor()).equals(couleur))
		   {
			   containsColor=true;
		   }
			
		}
		
		if(containsColor==false)
		{
			verif=false;
		}
		
		if((actualTower.getNbrMaxGem())==(actualTower.getNbrGem()))
		{
			verif =false;
		}
		
		
		
		return verif;
	}
	/**
	* méthode supprimant un tir d'une tour
	 */
	public void deleteBullet()
	{
		int curseur= listBullet.size();
		for(int i=0;i<curseur;i++)
		{
			if(listBullet.get(i).getIsActive()==false)
			{
				listBullet.remove(i);
				curseur--;
			}
		}
	}
	/**
	* fonction vérifiant si le groupe est terminé
	* @return booleen 
	 */
	
	public boolean isGroupeFinish()
	 {
		boolean isFinish=true;
		boolean isAlive=false;
		
		if((listMonster.size())==(listMonsterInMap.size())) // si tous les monstres du groupe sont apparus sur la carte
		{
			for(final Monster x:listMonsterInMap)
			{
				if(x.isAlive()==true)
				{
					isAlive=true;
				}
			}
			
		}else
		{
			isFinish=false;
		}
		
		
		if(isAlive==true)
		{
			isFinish=false;
		}
		
		
		return isFinish;
		
	}
	/**
	 * Définit si il y a un monstre suivant
	 * @return true si oui, false sinon
	 */
	public boolean isNextMonster()
	{
		boolean isNext=false;
		if(numMonster<(listMonster.size()))
		{
			isNext=true;
		}
		return isNext;
	}
	/**
	 * Fait apparaitre un monstre.
	 */
	
	public void appearsMonster()
	{	

			Monster actualMonster= new Monster();
			actualMonster=listMonster.get(numMonster);
			actualMonster.setId(numMonster);
			actualMonster.setPosition(actualGroupe.getSpawn().getPosition());
			Texture textureMonster= new Texture("textures"+File.separator+actualMonster.getType().getSprite());
			Sprite monsterSprite= new Sprite(textureMonster);
			monsterSprite.setPosition(actualMonster.getPosition().getAbscisse(),actualMonster.getPosition().getOrdonne());
			numMonster++;
			actualMonster.setSprite(monsterSprite);
			listMonsterInMap.add(actualMonster);			
		
	}
	public void removeGemTower()
	{
		boolean verif=true;
		verif=verifSuppGem(listGemsTour);
			if (verif==true)
			{
				actualTower.removeGem(couleur);				
			    modifyInfoTower(actualTower.getDammage(),actualTower.getNum(),actualTower.getLevel());
			    addGemInventaire();
			    affichageGemTower(listGemsTour);
			}
	}
	/**
	 * gestion des évenements des gemmes de l'inventaire permettant d'ajouter une gemme à une tour
	 */
	
	public void eventBtGemsInv()
	{
		cyanGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconCyan");
				actionState=ActionState.AddGem;
				couleur="cyan";
			
			}
		});
		purpleGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconViolet");
				actionState=ActionState.AddGem;
				couleur="violet";
			}
		});
		redGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconRed");
				actionState=ActionState.AddGem;
				couleur="red";
			}
		});
		magGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconMagenta");
				actionState=ActionState.AddGem;
				couleur="magenta";
			}
		});
		blueGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconBlue");
				actionState=ActionState.AddGem;
				couleur="blue";
			}
		});
		yellowGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconJaune");
				actionState=ActionState.AddGem;
				couleur="yellow";
			}
		});
		greenGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconGreen");
				actionState=ActionState.AddGem;
				couleur="green";
			}
		});
		oranjeGemBtInv.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseGem("iconOrange");
				actionState=ActionState.AddGem;
				couleur="orange";
			}
		});
	}
	/**
	* gestion des évenements des gemmes de l'inventaire permettant d'ajouter une gemme à une tour
	 */
	
	public void eventBtGemsTour()
	{
		cyanGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="cyan";
				removeGemTower();
			}
		});
		violetGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="violet";
				removeGemTower();
			}
		});
		redGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
			couleur="red";
			removeGemTower();
			}
		});
		magentaGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="magenta";
				removeGemTower();
			}
		});
		blueGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="blue";
				removeGemTower();
			}
		});
		yellowGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="yellow";
				removeGemTower();
			}
		});
		greenGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="green";
				removeGemTower();
			}
		});
		orangeGemBtTower.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x,float y)
			{
				couleur="orange";
				removeGemTower();
			}
		});
	}
	
	/**
	 *  Fonction permettant d'afficher les Gemmes ainsi que leur nombres
	 */ 
 	public void createGem()
	{
		
		TextButtonStyle redGemStyle= new TextButtonStyle ();TextButtonStyle greenGemStyle= new TextButtonStyle ();
		TextButtonStyle blueGemStyle= new TextButtonStyle ();TextButtonStyle oranjeGemStyle= new TextButtonStyle ();
		TextButtonStyle violetGemStyle = new TextButtonStyle ();TextButtonStyle cyanGemStyle= new TextButtonStyle ();
		TextButtonStyle yellowGemStyle= new TextButtonStyle ();TextButtonStyle magentaGemStyle = new TextButtonStyle ();
	
		
		redGemStyle.font=skin.getFont("default");
		blueGemStyle.font=skin.getFont("default");
		violetGemStyle.font=skin.getFont("default");
		oranjeGemStyle.font=skin.getFont("default");;
		greenGemStyle.font=skin.getFont("default");
		cyanGemStyle.font=skin.getFont("default");
		yellowGemStyle.font=skin.getFont("default");
		magentaGemStyle.font=skin.getFont("default");
		redGemStyle.up=skin.getDrawable("redGem");
		blueGemStyle.up=skin.getDrawable("blueGem");
		violetGemStyle.up=skin.getDrawable("violetGemme");
		oranjeGemStyle.up=skin.getDrawable("orangeGem");
		greenGemStyle.up=skin.getDrawable("greenGem");
		cyanGemStyle.up=skin.getDrawable("cyan");
		yellowGemStyle.up=skin.getDrawable("jaune");
		magentaGemStyle.up=skin.getDrawable("magenta");
				
		redGemBtInv= new TextButton("",redGemStyle);
		blueGemBtInv= new TextButton("",blueGemStyle);
		yellowGemBtInv= new TextButton("",yellowGemStyle);
		greenGemBtInv= new TextButton("",greenGemStyle); 
		oranjeGemBtInv= new TextButton("",oranjeGemStyle);
		cyanGemBtInv= new TextButton("",cyanGemStyle);
		magGemBtInv= new TextButton("",magentaGemStyle);
		purpleGemBtInv= new TextButton("",violetGemStyle);
		
		redGemBtTower= new TextButton("",redGemStyle);
		blueGemBtTower= new TextButton("",blueGemStyle);
		yellowGemBtTower= new TextButton("",yellowGemStyle);
		greenGemBtTower= new TextButton("",greenGemStyle); 
		orangeGemBtTower= new TextButton("",oranjeGemStyle);
		cyanGemBtTower= new TextButton("",cyanGemStyle);
		magentaGemBtTower= new TextButton("",magentaGemStyle);
		violetGemBtTower= new TextButton("",violetGemStyle);
	}
 	/**
	* ajoutes les boutons et labels des gemmes à la table Inventaire
	 */
	public void gemsInventaire(Table t)
	{
		t.add(redGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,1);
		t.add(redGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(blueGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(blueGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
		t.add(yellowGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,1);
		t.add(yellowGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(greenGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(greenGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
		t.add(oranjeGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1,1, 10,1);
		t.add(orangeGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(cyanGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(cyanGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
		t.add(magGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1,1, 10,1);
		t.add(magentaGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(purpleGemBtInv).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(violetGem).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
	}
	/**
	* ajoutes les boutons et labels des gemmes à la table Tour
	 */
	public void gemsTowerTable(Table t)
	{
		
		t.add(redGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,1);
		t.add(redGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(blueGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(blueGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
		t.add(yellowGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,1);
		t.add(yellowGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(greenGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(greenGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
		t.add(orangeGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1,1, 10,1);
		t.add(orangeGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(cyanGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(cyanGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
		t.add(magentaGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 30,1);
		t.add(magentaGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.add(violetGemBtTower).height(Gdx.graphics.getHeight()/26).width(Gdx.graphics.getWidth()/28).pad(1, 1, 10,50);
		t.add(violetGemsTower).height(Gdx.graphics.getHeight()/28).width(Gdx.graphics.getWidth()/28);
		t.row();
	}
	/**
	* création des boutons, de la table et des gemmes et autres relatives à l'inventaire
	 */
	public void inventaire()
	{
		invTable= new Table();
		 invLbStyle= new LabelStyle (font,Color.GOLDENROD);
		TextButtonStyle invBtStyle= new TextButtonStyle ();
		
		 //Label
		invLbStyle.font=skin.getFont("default");	
		 Label invLb= new Label("Inventaire",invLbStyle);
		
		// Button

		invBtStyle.font=skin.getFont("default");invBtStyle.up=skin.getDrawable("Button");
		
		TextButton addTwBt= new TextButton("T+",invBtStyle);
		TextButton addTwaBt= new TextButton("AA+",invBtStyle);		
		
				
		addTwaBt.addListener(new ClickListener()
		{
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseTower(false,true);	
				actionState=ActionState.BuildDCATowerUnAuthorize;
				
			}
		});
		
		addTwBt.addListener(new ClickListener()
		{
			public void clicked (InputEvent event, float x,float y)
			{
				modifyMouseTower(false,false);		
				actionState=ActionState.BuildTowerUnAuthorize;	
			}
		});
		
		//Gemm
	     createGem();
	     eventBtGemsInv();
	     initialisationNbrGems(listGems);
		invTable.add(invLb).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(1, 1,10,1).center();
		invTable.row();
		gemsInventaire(invTable);
		invTable.add(addTwBt).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(20, 10, 10,10);
		if(isFlyEnnemy==true)
		{
			invTable.add(addTwaBt).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(20, 10, 10,10);
		}		
		invTable.setWidth(300);
		invTable.setPosition((float) (Gdx.graphics.getWidth()-invTable.getWidth()-50),(float) (Gdx.graphics.getHeight()/1.3));
		
		stage.addActor(invTable);
			
	}
		
	/**
	 *  Fonction permettant d'afficher les informations sur une tour
	 */ 
	public void infoTour()
	{
		tourTable=new Table();
		LabelStyle tourLbStyle= new LabelStyle (font,Color.GOLDENROD);
		TextButtonStyle tourBtStyle= new TextButtonStyle ();
		//label
		tourLbStyle.font=skin.getFont("default");
				
		//boutons
		tourBtStyle.font=skin.getFont("default");
		tourBtStyle.up=skin.getDrawable("Button");
		TextButton addLvlBt= new TextButton("+",tourBtStyle);
		//TextButton optionBt= new TextButton("Option",tourBtStyle);
		//TextButton helpBt= new TextButton("Aide",tourBtStyle);
		TextButton stratBt1= new TextButton("1",tourBtStyle);
		TextButton stratBt2= new TextButton("2",tourBtStyle);
		TextButton stratBt3= new TextButton("3",tourBtStyle);
		TextButton stratBt4= new TextButton("4",tourBtStyle);
		/*optionBt.setPosition((float) (Gdx.graphics.getWidth()/1.1),(Gdx.graphics.getHeight()/16));
		optionBt.setSize(100,55);
		stage.addActor(optionBt);
		helpBt.setPosition((float) (Gdx.graphics.getWidth()/1.2),(Gdx.graphics.getHeight()/16));
		helpBt.setSize(100,55);
		stage.addActor(helpBt);*/
		createGem();
		eventBtGemsTour();
		 initiationGemmesTower(listGemsTour);
		tourLb= new Label("Niveau :" ,tourLbStyle);
		numTourLb= new Label("N° : ",tourLbStyle);
		dommageTourLb= new Label("",tourLbStyle);
		tourTable.add(tourLb).height(Gdx.graphics.getHeight()/23).pad(1,1,20,1);
		tourTable.add(addLvlBt).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(1, 1,20,1).center();
		tourTable.row().align(10);
		tourTable.add(numTourLb).height(Gdx.graphics.getHeight()/23).pad(1,1,2,1);
		tourTable.add(dommageTourLb).height(Gdx.graphics.getHeight()/23).pad(1,1,2,1);
		tourTable.row();
		tourTable.add(nbrTourLb).height(Gdx.graphics.getHeight()/23).pad(1,1,2,1);
		tourTable.row();
		gemsTowerTable(tourTable);
		tourTable.row();
		if(gdx.ExtentionTower==true)
		{
			tourTable.add(stratBt1).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(1, 1,2, 1);
			tourTable.add(stratBt2).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(1, 1,2, 30);
			tourTable.add(stratBt3).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(1, 1,2, 30);
			tourTable.add(stratBt4).height(Gdx.graphics.getHeight()/23).width(Gdx.graphics.getWidth()/23).pad(1, 1,2, 1);
		}
		
		tourTable.setWidth(300);
		tourTable.setPosition((float) (Gdx.graphics.getWidth()-tourTable.getWidth()-20),(float) (Gdx.graphics.getHeight()/2.8));
		stage.addActor(tourTable);
		tourTable.setVisible(false);
		
		addLvlBt.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				if((levelActual.getmanaValue()>((actualTower.getLevel())*30))||(levelActual.getmanaValue()==((actualTower.getLevel())*30)))
				{
				    decreaseMana((actualTower.getLevel())*30);
					actualTower.increaseLevel();
					modifyInfoTower(actualTower.getDammage(), actualTower.getNum(), actualTower.getLevel());
				}
			}
		});
		
		
		stratBt1.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				StandardStrategie strategie= new StandardStrategie();
				actualTower.setActualStrategy(strategie);
			}
		});
		
		stratBt2.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				MostLifeEnnemy strategie = new MostLifeEnnemy();
				actualTower.setActualStrategy(strategie);
			}
		});
		stratBt3.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				MostManaEnnemy strategie= new MostManaEnnemy();
				actualTower.setActualStrategy(strategie);
			}
		});
		stratBt4.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				LastEnnemyStrategie strategie= new LastEnnemyStrategie();
				actualTower.setActualStrategy(strategie);
			}
		});
		
		/*helpBt.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				Gdx.app.log("Bouton Aide","Ecran game");
				gdx.MenuScreen=false;
				gdx.setScreen(new HelpScreen(gdx));
			}
		});
		optionBt.addListener(new ClickListener (){
			public void clicked (InputEvent event, float x,float y)
			{
				gdx.MenuScreen=false;
				Gdx.app.log("Bouton Option","Ecran game");
				gdx.setScreen(new OptionScreen(gdx));
			}
		});*/
		
	}
	/**
	* permet de modifier les informations relatifs à une tour (mise à jour des labels)
	 */
	public void modifyInfoTower(int dommage_,int num_,int level_)
	{
		tourTable.setVisible(true);
		tourLb.setText("Niveau : " +level_ );
		numTourLb.setText("N°: "+ num_);
		dommageTourLb.setText(Integer.toString(dommage_));
		
			
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	* création d'une enumérateur couleur pour les diférentes couleur relatives au gemmes
	 */
	public enum enumColor 
	{
		red,orange,yellow,green,cyan,blue,magenta,violet
	}
	/**
	* création d'une énumérateur pour les différents états relatives à la gestion des cliques
	 */
	public enum ActionState
	{
	    BuildTowerAuthorize, BuildTowerUnAuthorize, Standard, AddGem,BuildDCATowerAuthorize,BuildDCATowerUnAuthorize
	}
	/**
	* afficher la quantité des gemmes en fonction de leur couleur
	* @param liste de gemmes, couleur de la gemme
	 */
	public void affichageGemTower(ArrayList<Gems> listGemsTower)
	{
		
		for(Gems gems: listGemsTower)
		{
			
			
			if((gems.getGemme().getColor()).equals("red"))
			{
				redGemsTower.setText(gems.getStringQuantity());
			}
			if((gems.getGemme().getColor()).equals("yellow"))
			{
				yellowGemsTower.setText(gems.getStringQuantity());
			}
			if((gems.getGemme().getColor()).equals("green") )
			{
				greenGemsTower.setText(gems.getStringQuantity());
			}
			if((gems.getGemme().getColor()).equals("orange"))
			{
				orangeGemsTower.setText(gems.getStringQuantity());
			}
			if((gems.getGemme().getColor()).equals("blue"))
			{
				blueGemsTower.setText(gems.getStringQuantity());
			}if((gems.getGemme().getColor()).equals("blue") )
			{
				magentaGemsTower.setText(gems.getStringQuantity());
			}
			if((gems.getGemme().getColor()).equals("violet"))
			{
				violetGemsTower.setText(gems.getStringQuantity());
			}
			if((gems.getGemme().getColor()).equals("cyan"))
			{
				cyanGemsTower.setText(gems.getStringQuantity());
			}		
				
		}
		
	}
	/**
	* suppression d'une gem de l'inventaire en fonction de sa couleur
	 */
	public void suppressionGemInventaire()
	{
		for(Gems x:listGems )
		{
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="red")
			{
			    x=texteGemSupp(x,redGem);	

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="blue")
			{
				x=texteGemSupp(x,blueGem);

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="green")
			{
				x= texteGemSupp(x,greenGem);	

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="yellow")
			{
				x= texteGemSupp(x,yellowGem);	

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="orange")
			{
				x=  texteGemSupp(x,orangeGem);

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="magenta")
			{
				x= texteGemSupp(x,magentaGem);

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="violet")
			{
				x= texteGemSupp(x,violetGem);

			}
			if((x.getGemme().getColor()).equals(couleur)&&couleur=="cyan")
			{
				x= texteGemSupp(x,cyanGem);

			}
		
		}	
		
	}
	/**
	* met à jour le label de la gem
	 */
	public Gems texteGemSupp (Gems gems, Label label )
	{
		gems.setQuantity(gems.getQuantity()-1);
		label.setText(gems.getStringQuantity());		
		return gems;
	}
	/**
	* met à jour le label de la gem
	 */
	public Gems texteGemAdd (Gems gems, Label label )
	{
		gems.setQuantity(gems.getQuantity()+1);	
		label.setText(gems.getStringQuantity());	
		return gems;
	}
	/**
	* Ajout d'une gemmes dans l'inventaire en fonction de la couleur
	 */
	public void addGemInventaire()
	{

		for(Gems x:listGems )
		{
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="red")
			{

				x= texteGemAdd(x,redGem);	
			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="blue")
			{

				x= texteGemAdd(x,blueGem);
			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="green")
			{
				x=texteGemAdd(x,greenGem);
	
			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="yellow")
			{
			    x=texteGemAdd(x,yellowGem);	

			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="orange")
			{
				x=texteGemAdd(x,orangeGem);

			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="magenta")
			{
			    x=texteGemAdd(x,magentaGem);

			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="violet")
			{
				x=texteGemAdd(x,violetGem);

			}
			if(((x.getGemme().getColor()).equals(couleur))&&couleur=="cyan")
			{
				x=texteGemAdd(x,cyanGem);

			}
		
		}	
		
	}

	
	/**
	* fonction render
	* @param delta
	 */
	@Override
	public void render(float delta) 
	{
		
		switch (state)
	    {
	    case RUN:
	    	
	    	TiledMapTileLayer collisionLayer = (TiledMapTileLayer)map.getLayers().get(0); // récupération du calque du chemin.
			Gdx.gl.glClearColor(0, 0, 0, 1); 
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			camera.update();
			
			batch = new SpriteBatch();
			batch.begin();
			FondSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			FondSprite.draw(batch);
			batch.end();
			stage.act();
			stage.draw();
			
			camera.update();//important sinon pas de prise en compte des input camera !!
			renderer.setView(camera);//on indique la caméra utilisée pour coupler les systèmes de coordonnées
			renderer.render();//rendu de la carte
			batch.setProjectionMatrix(camera.combined);
			
     		if(listTower.size()>0)
     		{
     			batch.begin();
     			for(final Tower x: listTower)
				{
     				x.getSprite().draw(batch);
				}
     			batch.end();
     		}
				
			if(timeBeforeWave>0||timeBeforeWave==0)
			{
				decreaseDelayWave();
				
			}
			else // si compte à rebours finit
			{			
				if(timeBeforeWave==-1)   // timer du groupe
				{
					decreaseDelayGroupe();

			
				}
				else  
				{
					
					// apparition des bullets
					
					if(listMonsterInMap.size()>0)
					{
						
					for(final Tower x: listTower)
					{

						
						if(x.getNbrGem()>0)
						{
							x.setDelayFire(delta);	
		
	     					if((x.canReachMonster(listMonsterInMap)==true)&&(x.canFire()==true))
	     					{
	     						Bullet bullet = new Bullet();
	     						bullet=x.designeTarget(listMonsterInMap);
	     						listBullet.add(bullet);
	     					}
						}
						
					}
					if(listBullet.size()>0)
					{
						for(final Bullet x: listBullet)
						{
		
								
							if((x.canMove(listMonsterInMap)==true)&& (x.getIsActive()==true))
							{
								boolean hasReach=x.move();
								if((hasReach==false) )
								{
									batch.begin();
					     			x.getSprite().draw(batch);
					     			batch.end();
								}else
								{
									// le bullet à atteint sa cible
									if(x.getIsActive()==true)
									{											
										x.setIsActive(false);
									decreaseMonsterLife(x.getIdTarget(),x);
										
									}
																		
								}
							}	
													
						}
						deleteBullet();
					}					
						
					}
					
					
					
					 // apparition des ennemis
					
					if(isNextMonster()==true)
					{
						if(decreaseDelayEnnemy()==true)
						{ 	
							appearsMonster();
							startEnnemyTime=TimeUtils.nanosToMillis(TimeUtils.nanoTime());
							
						}
						
			
					}
					
					batch.begin();
					for(Monster x: listMonsterInMap)
					{
						
						boolean hasReach=false;
						 hasReach=x.hasReachNexus(levelActual);
						if(hasReach==true)
						{
							if(x.isAlive()==true)
							{
								 decreaseLife();
								 x.setAlive(false);								
							}
						  					
						}
						else
						{
							
							if(x.isAlive()==true)
							{
								
							   if(x.getStatusEffects().size()>0)	
							   {
								   x=actEffecsMonster(x,delta);
							   }
								
								
								x.setDelayMove(delta);
								if(x.canMove()==true)
								{
							       x.move(collisionLayer,levelActual);
								}
								x.getSprite().setX(x.getPosition().getAbscisse());
						        x.getSprite().setY(x.getPosition().getOrdonne());
							    x.getSprite().draw(batch);																
							}
							
							
						}
					
					}
					
					if(isGroupeFinish()==true)
					{
						listMonster= new ArrayList<Monster>();
						listMonsterInMap= new ArrayList<Monster>();
						numMonster=0;
						actualiseGroupeWave();
						
					}				
					batch.end();
					
				}
				
			}

	        break;
	    case PAUSE:
	    	stage.act();
			stage.draw();
	    	break;
	    }

		
}
	
	/**
	* diminue la vie des monstres
	* @param bullet = Tir , IdTarget
	 */
	public  void decreaseMonsterLife(int idTarget, Bullet bullet)
	{
		for(final Monster x: listMonsterInMap)
		{
			if(idTarget==x.getId())
			{				
				x.decreaseLive(bullet.getDammage());
				reactionEffectBullet(x, bullet);
				if((x.getLife()==0)||(x.getLife()<0))
				{
					x.setAlive(false);
				increaseMana(x.getType().getMana());
				}
				
			}
			
		}
	}
	/**
	* fonction définissant la reaction des effets des tir sur les monstres
	* @param tir et monstre
	 */
	public void reactionEffectBullet(Monster monster,Bullet bullet)
	{
		for(Object x: bullet.getListEffects())
		{
			boolean find=false;
			
			if(x instanceof AreaDammage)
			{
			listMonsterInMap=((AreaDammage) x).CollateralDammage(listMonsterInMap);
			find=true;
			}
			if(x instanceof AreaChains)
			{
			listMonsterInMap= ((AreaChains) x).CollateralDammage(listMonsterInMap);
			find=true;
			}	
			if(x instanceof DrainEffect)
			{
				increaseMana(((DrainEffect) x).activeDrain());
				find=true;
			}
			
			if(find == false)
			{
				((StatusEffects)x).begin();
				monster.addEffects((StatusEffects) x);
			}
			
		}
	}
	
	/**
	* fonction affectant un monstre
	* @param monstre et delta
	* @return monstre
	 */
	public Monster actEffecsMonster(Monster monster,float delta)
	{
		for(StatusEffects status: monster.getStatusEffects())
		{
			if(status.hasReachEndTime(delta)!=true)
			{						
				status.alterMonster();			
			}
			
		}
		return monster;
	}
		
	/**
	 * Diminue la vie du joueur.
	 */
	
	public void decreaseLife()
	{
		levelActual.setLife((levelActual.getlifeValue())-50);
		lbLifeLevel.setText("Vie  : "+levelActual.getLife());
	
		if (levelActual.getlifeValue()==0)
		{
			lbLifeLevel.setText("Vie  : 0");
			gdx.setScreen(new GameOverScreen(gdx));
		
		}

	}
	/**
	 * Diminue le mana.
	 */
	public void decreaseMana(int value)
	{
		levelActual.setMana((levelActual.getmanaValue())-value);
		lbManaLevel.setText("Mana : "+levelActual.getMana());
		
	}
	/**
	 * Augmente le mana
	 */
	public void increaseMana(int manaSupp)
	{
		levelActual.setMana((levelActual.getmanaValue())+manaSupp);
		lbManaLevel.setText("Mana : "+levelActual.getMana());
	}
	
	
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * gère les effets du relachement du clic sur un objet (tour ou gemme)
	 * @param int screenX, int screenY, int pointer, int button
	 */
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		Vector3 click= new Vector3(screenX,screenY,0);
		Vector3 position= camera.unproject(click);
		int tileX=(int) (position.x)/32;
		int tileY=(int)(position.y)/32;
		
		
		// création d'une tour
		
		if(actionState.name()=="BuildTowerAuthorize"&& (button !=Input.Buttons.RIGHT || pointer>0))
		{
			if((levelActual.getmanaValue()==50) || (levelActual.getmanaValue()>50))
			{
		    Texture textureTower = new Texture("Skin"+File.separator+File.separator+"tower.png");
			spriteTower=new Sprite(textureTower);						
			spriteTower.setPosition(tileX*32,tileY*32);
			Position pos= new Position(position.x,position.y);
			Tower tower =new Tower(spriteTower,pos,numberTower);
			listTower.add(tower);
			numberTower++;
			decreaseMana(50);
			}
			
	   }
		
		if(actionState.name()=="BuildDCATowerAuthorize" &&(button !=Input.Buttons.RIGHT || pointer>0))
		{
			if((levelActual.getmanaValue()==50) || (levelActual.getmanaValue()>50))
			{
		    Texture textureTower = new Texture("skin"+File.separator+File.separator+"dcaTower.png");
			spriteTower=new Sprite(textureTower);						
			spriteTower.setPosition(tileX*32,tileY*32);
			Position pos= new Position(position.x,position.y);
			DcaTower tower= new DcaTower(spriteTower,pos,numberTower);
			listTower.add(tower);
			numberTower++;
			decreaseMana(50);
			}
		}
		
		
		// affichage d'une tour
		
		if(actionState.name()=="Standard"&& (button !=Input.Buttons.RIGHT || pointer>0))
		{		
			boolean clickTower=false;
			
			for(final Tower x: listTower)
			{
				int tileXTower=(x.getPosition().getIntAbscisse())/32;
				int tileYTower=(x.getPosition().getIntOrdonne())/32;
				if(tileXTower==tileX && tileYTower==tileY)
				{
						actualTower=x;
					listGemsTour=x.getListGem();
					affichageGemTower(listGemsTour);
					modifyInfoTower(x.getDammage(),x.getNum(),x.getLevel());
					// récupérer les infos de la tour
					clickTower=true;
				}
			}
			if(clickTower==false)
			{
				tourTable.setVisible(false);
			}
			
		}
		
		
		
		
		if(button !=Input.Buttons.LEFT ||pointer>0)
		{
			actionState=ActionState.Standard;
		    originalMouse();
		}
	
		
		return false;
	}
		
	/**
	 * gère les effets du clic sur un objet (tour ou gemme)
	 * @param int screenX, int screenY, int pointer, int button
	 */
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) 
	{
	
		Vector3 click= new Vector3(screenX,screenY,0);
		Vector3 position= camera.unproject(click);
		int tileX=(int) (position.x)/32;
		int tileY=(int)(position.y)/32;
			
		if(actionState.name()=="AddGem"&& (button !=Input.Buttons.RIGHT || pointer>0))
		{		
			for(final Tower x: listTower)
			{
				int tileXTower=(x.getPosition().getIntAbscisse())/32;
				int tileYTower=(x.getPosition().getIntOrdonne())/32;
				actualTower=x;
				if(tileXTower==tileX && tileYTower==tileY)    
				{
				boolean	verif=verifAddGem();
						if (verif==true)
						{
							x.addGem(couleur);
							modifyInfoTower(x.getDammage(),x.getNum(),x.getLevel());
							suppressionGemInventaire();
							listGemsTour=x.getListGem();
							affichageGemTower(listGemsTour);							
							originalMouse();
						}
					

			    }
		    }
			
	    }
		
		return false;
	
}
	
		
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * gère le déplacement de la souris
	 * @param screenX,screenY
	 */
	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		
		if(actionState.name()=="BuildTowerAuthorize"||actionState.name()=="BuildTowerUnAuthorize"||actionState.name()=="BuildDCATowerAuthorize"||actionState.name()=="BuildDCATowerUnAuthorize")
		{
			boolean isAlreadyBuild=false;
			
			TiledMapTileLayer buildLayer = (TiledMapTileLayer)map.getLayers().get(0); // récupération du calque de construction.
			// coordonnée de l'écran du jeux
		     Vector3 touchPos = new Vector3();
		     touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		     camera.unproject(touchPos); // touchPos.x and touchPos.y sont les variable à utiliser		
		     
		     boolean isCorrect=false;
		    int tileX=(int)(touchPos.x/32);
			int tileY=(int)(touchPos.y/32);
			if(buildLayer.getCell(tileX,tileY)!=null)			
			{
				Object objet = buildLayer.getCell(tileX,tileY).getTile().getProperties().get("buidable");		
				if(Integer.valueOf((String)objet)==1)
				{
					objet = buildLayer.getCell(tileX,tileY).getTile().getProperties().get("tower");
					if(Integer.valueOf((String)objet)==0)
					{
						
						for(final Tower x: listTower)
						{
							int tileXtower= (int) ((x.getPosition().getAbscisse()))/32;
							int tileYtower=(int) ((x.getPosition().getOrdonne()))/32;
							if(tileXtower==tileX &&tileYtower==tileY)
							{
								isAlreadyBuild=true;
							}
						}
						
						if(isAlreadyBuild==false)
						{
							isCorrect=true;	
						}
								
					}
				}
			}
			if(actionState.name()=="BuildDCATowerAuthorize"||actionState.name()=="BuildDCATowerUnAuthorize")
			{
					modifyMouseTower(isCorrect,true);
			}
			else
			{
					modifyMouseTower(isCorrect,false);
			}
		
		}
	
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
