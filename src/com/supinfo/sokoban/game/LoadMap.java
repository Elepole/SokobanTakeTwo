package com.supinfo.sokoban.game;

/*
Exemple d'utilisation de LoadMap.

Plateau loadedMap = null;
LoadMap test = new LoadMap("temp");
loadedMap = test.getMap();
loadedMap.afficherPlateau();
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.supinfo.sokoban.level.Niveau;
import com.supinfo.sokoban.unused.Plateau;

public class LoadMap {
	
	private Niveau niveau;

	public LoadMap(String mapName){
		
		niveau = null;
		
		try
	      {
	         FileInputStream fileIn = new FileInputStream(mapName+".sok");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         niveau = (Niveau) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Plateau class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	
	public Niveau getNiveau() {
		return niveau;
	}
}
