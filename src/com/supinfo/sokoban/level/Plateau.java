package com.supinfo.sokoban.level;

public class Plateau implements java.io.Serializable{
	
	//Attributs
	private static final long serialVersionUID = 1002L;
	private int ordonneePlateau;
	private int abscissePlateau;	
	private Case plateau[][];
	
	
	

	public Plateau() {
		// TODO Auto-generated constructor stub
		ordonneePlateau = 8;
		abscissePlateau = 8;
		
		this.init();
	}
	
	protected void init(){
		plateau = new Case[abscissePlateau][ordonneePlateau];
		for(int x = 0; x < abscissePlateau; x++) {
			for(int y =0; y < ordonneePlateau; y++) {
				plateau[x][y] = new Case(x, y, 0);
			}
		}
	}
	
	@Override
	public String toString(){
		String contenuePlateau="";
		for( int x =0; x < abscissePlateau; x++){
			for( int y =0; y < ordonneePlateau; y++ ){
				contenuePlateau = contenuePlateau + plateau[x][y].toString();
			}
			contenuePlateau += "\n";
		}	
		return contenuePlateau;
	}
	
	public int getNbCible() {
		int result=0;
		for( int x =0; x < abscissePlateau; x++){
			for( int y =0; y < ordonneePlateau; y++ ){
				result += (plateau[x][y].isCible()?1:0); 
			}
		}	
		return result;
	}
	
	//Compatibilite avant d'utiliser toString() dans le reste du code
	public void afficherPlateau(){
		System.out.println(this.toString());
	}
	
	

	public int getOrdonneePlateau() {
		return ordonneePlateau;
	}

	public int getAbscissePlateau() {
		return abscissePlateau;
	}

	public Case[][] getPlateau() {
		return plateau;
	}
	
	public Case getCase(int x, int y){
		return plateau[x][y];
	}

	protected void setPlateau(Case[][] plateau) {
		this.plateau = plateau;
	}
	
	public void changeCaseToCase(int x, int y, boolean cible){
		this.plateau[x][y] = new Case();
	}

}
