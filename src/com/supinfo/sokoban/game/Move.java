package com.supinfo.sokoban.game;

import com.supinfo.sokoban.unused.Case;

public class Move {
						
	
						//ATTRIBUTS :
	private int score;
	private Game game;
	private int xCaisse;
	private int yCaisse;
	private int xColli;
	private int yColli;
	private int isCaisseAlreadyUsed;
	private String directionJoueur;
	
						
	
						//CONSTRUCTEUR
	
	public Move(Case map[][], int largeurMap, int hauteurMap, int x_joueur, int y_joueur){
		score = 0;
		xJoueur = x_joueur;
		yJoueur = y_joueur;
		xCaisse=0;
		yCaisse=0;
		xColli=0;
		yColli=0;
		isCaisseAlreadyUsed=0;
		directionJoueur = "RIEN";
		
	}
						//METHODES :
	public boolean deplacerCaisse(Case map[][],int xCaisse,int yCaisse){
		
		if(gestionCollision(map,xCaisse,yCaisse,1) == true){	//Si on � le droit de se d�placer  
			
			switch(directionJoueur){
				//TODO Switch all setContenue by a new Case()
					case "HAUT":
						if(map[xCaisse][yCaisse].getCible() == 0){	//Si la case ou l'on se trouve n'est pas un espace de stockage...
							map[xCaisse][yCaisse].setContenu(" ");	//...le contenu de la case sera un espace vide.
						}
						else{
							map[xCaisse][yCaisse].setContenu("O");	//...Autrement si c'est un espace de stockage le contneu de la case sera un espace de stokage
						}
						yCaisse--;
						map[xCaisse][yCaisse].setContenu("B");	//enfin on d�place le joueur et on change le contenu de la case afin qu'elle contienne le joueur
						break;
				
					case "BAS":
						if(map[xCaisse][yCaisse].getCible() == 0){
							map[xCaisse][yCaisse].setContenu(" ");
						}
						else{
							map[xCaisse][yCaisse].setContenu("O");
						}
						yCaisse++;
						map[xCaisse][yCaisse].setContenu("B");
						break;
				
					case "GAUCHE":
						if(map[xCaisse][yCaisse].getCible() == 0){
							map[xCaisse][yCaisse].setContenu(" ");
						}
						else{
							map[xCaisse][yCaisse].setContenu("O");
						}
						xCaisse--;
						map[xCaisse][yCaisse].setContenu("B");

						break;
				
					case "DROITE":
						if(map[xCaisse][yCaisse].getCible() == 0){
							map[xCaisse][yCaisse].setContenu(" ");
						}
						else{
							map[xCaisse][yCaisse].setContenu("O");
						}
						xCaisse++;
						map[xCaisse][yCaisse].setContenu("B");
						break;
				
					default :
						break;
						
				}
			return true;
			} else {
				return false;
			}
	}
	
	private void currentCaseIsCible(Case c){
		if(c.getCible() == 0){	//Si la case ou l'on se trouve n'est pas un espace de stockage...
			c.setContenu(" ");	//...le contenu de la case sera un espace vide.
		}
		else{
			c.setContenu("O");	//...Autrement si c'est un espace de stockage le contneu de la case sera un espace de stokage
		}
	}
	
	public static void deplacerJoueur(Game game,String directionJoueur){
		
		if(gestionCollision(map,xJoueur,yJoueur,0) == true){	//Si on � le droit de se d�placer  
		
		switch(directionJoueur){
			
				case "HAUT":
					this.currentCaseIsCible(game.getCase(game.getX_joueur(), game.getY_joueur()));
					game.joueurHaut();
					game.getCase(game.getX_joueur(), game.getY_joueur()).setContenu("X");	//enfin on d�place le joueur et on change le contenu de la case afin qu'elle contienne le joueur
					break;
			
				case "BAS":
					this.currentCaseIsCible(map[xJoueur][yJoueur]);
					yJoueur++;
					map[xJoueur][yJoueur].setContenu("X");
					break;
			
				case "GAUCHE":
					this.currentCaseIsCible(map[xJoueur][yJoueur]);
					xJoueur--;
					map[xJoueur][yJoueur].setContenu("X");

					break;
			
				case "DROITE":
					this.currentCaseIsCible(map[xJoueur][yJoueur]);
					xJoueur++;
					map[xJoueur][yJoueur].setContenu("X");
					break;
			
				default :
					break;
			}
		directionJoueur="RIEN";
		}
		
	}
	
	public boolean gestionCollision(Case map[][], int xColli, int yColli, int isCaisseAlreadyUsed){
		
		boolean ok = false;
		
		switch(directionJoueur){	//On teste la direction du joueur gr�ce a un switch
		
			case "HAUT" :
				//On teste le contenu de la case au dessus du joueur :
				
				switch(map[xColli][yColli-1].getContenu()){		//On teste le contenu de la case au dessus du joueur
					case " " :
						ok = true;	//Si la case d'au dessus est vide on peut deplacer le joueur vers le haut
						break;
					
					case "B" :	//Si la case au dessus est une caisse...
						if(isCaisseAlreadyUsed == 0){
							ok = this.deplacerCaisse(map,xColli,yColli-1);
						} else {
							ok = false;
						}
						break;
					
					case "=":	//Si la case du dessus est un mur :
						ok = false;
						break;
					
					case "O":		//Si la case au dessus du joueur est une zone de stokage
						ok = true;	//ALors on peut se d�placer vers le haut 
						break;
						
					default :
						break;
				}
				break;
			
			case "BAS" :
				//On teste le contenu de la case en dessus du joueur :
				switch(map[xColli][yColli+1].getContenu()){
					case " ":
						ok =true;
						break;
					
					case "B":
						if(isCaisseAlreadyUsed == 0){
							ok = this.deplacerCaisse(map,xColli,yColli+1);
						} else {
							ok = false;
						}
						break;
					
					case "=":	
						ok =false; //s'il yColli a un mur on interdit le d�placement
						break;
					
					case "O":		//si la case est un espace de stockage ou peut d�placer le joueur vers le bas
						ok = true;
						break;
					
					default :
						break;
				}
				break;
			
			case "GAUCHE" :
				//On teste le contenu de la case � gauche du joueur :
				switch(map[xColli-1][yColli].getContenu()){
					case " ":
						ok = true;	//si la case de gauche est vide on peut se d�placer
						break;
					
					case "B" :	//si la case de gauche contient une caisse...
						if(isCaisseAlreadyUsed == 0){
							ok = this.deplacerCaisse(map,xColli-1,yColli);
						} else {
							ok = false;
						}
						break;
					
					case "=":
						ok = false;		//Si la case de gauche est un mur on interdit le d�placement
						break;
					
					case "O":
						ok =true;	//Si la case de gauchte est un espace de stockage on peut se d�placer
						break;
					
					default:
						break;
				}
				break;
			
			case "DROITE" :
				//On teste le contenu de la case � droite du joueur :
				switch(map[xColli+1][yColli].getContenu()){
					
					case " ":
						ok =true;	//Si la case de droite ne contient rien on peut se d�placer.
						break;
					
					case "B":	//Si la case de droite contient une caisse...
						if(isCaisseAlreadyUsed == 0){
							ok = this.deplacerCaisse(map,xColli+1,yColli);
						} else {
							ok = false;
						}
						break;
						
					case "=":
						ok = false;	//Si la case de droite contient un mur , on interdit le d�placement.
						break;
						
					case "O":
						ok =true;	//si la case de droite contient un espace de stockage, on peut se d�placer. 
						break;
						
					default:
						break;
				}
				break;
			
			default :
				break;
		}
		
		return ok;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getxJoueur() {
		return xJoueur;
	}

	public void setxJoueur(int xJoueur) {
		this.xJoueur = xJoueur;
	}

	public int getyJoueur() {
		return yJoueur;
	}

	public void setyJoueur(int yJoueur) {
		this.yJoueur = yJoueur;
	}

	public String getDirectionJoueur() {
		return directionJoueur;
	}

	public void setDirectionJoueur(String directionJoueur) {
		this.directionJoueur = directionJoueur;
	}

}
