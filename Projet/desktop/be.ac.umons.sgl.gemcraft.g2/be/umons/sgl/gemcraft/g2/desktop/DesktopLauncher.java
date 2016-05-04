package be.umons.sgl.gemcraft.g2.desktop;

import java.awt.Dimension;
import java.awt.Frame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import be.ac.umons.sgl.gemcraft.g2.Main.Main;

public class DesktopLauncher {
	
	
	public static void main (String[] arg) {
		Frame f = new Frame();
		java.awt.Toolkit t = f.getToolkit(); 
		Dimension d = t.getScreenSize();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="GemCraft";
	//config.useGL30=true;
	config.width=d.width;
	config.height=d.height;
	config.resizable=false;
	new LwjglApplication(new Main(), config);
	}
}
