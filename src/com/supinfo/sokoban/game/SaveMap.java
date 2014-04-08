package com.supinfo.sokoban.game;

/*
Exemple d'utilisation de la classe SaveMap

Plateau test = new Plateau();
SaveMap saveTest = new SaveMap(test);
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.supinfo.sokoban.level.Niveau;

public class SaveMap {
	
	public SaveMap(Niveau niveau){
		
				try{
					FileOutputStream fileout = new FileOutputStream(niveau.getNomNiveau()+".sok"); //As the name of the level is in Plateau.nomPlateau we just need to add ".sok" to it.
					ObjectOutputStream out = new ObjectOutputStream(fileout);
					out.writeObject(niveau);
					out.close();
					fileout.close();
					//System.out.printf("finished");
				}catch(IOException i)
			      {
			          i.printStackTrace();
			      }
			}
}
