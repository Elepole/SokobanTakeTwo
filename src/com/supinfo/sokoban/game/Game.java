package com.supinfo.sokoban.game;

import com.supinfo.sokoban.level.Box;
import com.supinfo.sokoban.level.Case;
import com.supinfo.sokoban.level.Niveau;
import com.supinfo.sokoban.level.Player;
import com.supinfo.sokoban.level.Wall;

public class Game extends Niveau {
	
	private int x_joueur;
	public int getX_joueur() {
		return x_joueur;
	}

	public void setX_joueur(int x_joueur) {
		this.x_joueur = x_joueur;
	}

	public int getY_joueur() {
		return y_joueur;
	}

	public void setY_joueur(int y_joueur) {
		this.y_joueur = y_joueur;
	}

	private int y_joueur;

	public Game() {
		x_joueur = 1;
		y_joueur = 1;
	}
	
	public void joueurDroite(){
		x_joueur++;
	}
	
	public void joueurGauche(){
		x_joueur--;
	}
	
	public void joueurHaut(){
		y_joueur++;
	}
	
	public void joueurBas(){
		y_joueur--;
	}
	
	public void changeCase(int coordX, int coordY, String contenu, int cible){
		Case[][] plateau = super.getPlateau();
		switch (contenu){
		case "X": 
			plateau[coordX][coordY] = new Player(coordX,coordY,cible);
			break;
		case "B":
			plateau[coordX][coordY] = new Box(coordX,coordY,cible);
			break;
		case "=":
			plateau[coordX][coordY] = new Wall(coordX,coordY);
			break;
		case " ":
			plateau[coordX][coordY] = new Case(coordX,coordY,cible);
			break;
		default:
			break;
		}
		 super.setPlateau(plateau);
	}
	
	

}
