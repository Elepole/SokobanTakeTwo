package com.supinfo.sokoban;

public class Play {
	
						//ATTRIBUT
	private int largeurMap; 
	private int hauteurMap;
	private int nb_cibles;
	private int nb_caissesRangees;
	
	private Case [][]map = new Case[largeurMap][hauteurMap];
	private Joueur player ;
	
						//CONSTRUCTEURS
	
	//Constructeur par defaut
	Play(){
		
		largeurMap = 8;
		hauteurMap = 8;
		nb_cibles = 1;
		nb_caissesRangees =0;
		
		
		for(int i =0; i < largeurMap; i++){
			for(int j = 0; j < hauteurMap; j++){
				map[i][j] = new Case();
			}
		}
		
		player = new Joueur(map, largeurMap, hauteurMap);
	}
	
	//constructeur surcharg� :
	
	Play(String level){
		
		//chargerNiveau(level)
		
		
		/*for(int i =0; i < largeurMap; i++){
			for(int j = 0; j < hauteurMap; j++){
				map[i][j] = new Case();
			}
		}*/
	}
	
	
						// METHODES
	
	
	
	public void chargerNiveau(String level){		//m�thode permettant de charger un niveau � partire d'un fichier
		//largeurMap = level.largeurMap;
		//hauteurMap = level.hauteurMap;
		//nb_cible = level.nb_cible;
	}
	
	public void afficherMap(){
		
		for( int i =0; i < largeurMap; i++){
			for( int j =0; j < hauteurMap; j++ ){
				map[i][j].afficherContenu();
			}
			System.out.println();
		}
	}
	
	//La m�thode jouer devra etre appel�e dans le main elle permet de faire tourner le jeu
	public void jouer(){
		
		boolean victoire = false;
		
		//On boucle tant que l'utilisateur n'a pas gagn� : 
		do{
			
			afficherMap(); //On affiche la map
			
			//player.setDirectionJoueur( SAISIE CLAVIER );
			
			player.deplacerJoueur(map);		//on d�place le joueur sur la map
			chercherCaissesRangees();		//On cherche les caisse d�j� rang�es
			if(nb_caissesRangees == nb_cibles){		//si toutes les caisses sont rang�es on � gagn� 
				victoire = true;
			}
			
		}
		while(victoire == false); 	//On sort de la boucle si les conditions de victoire sont remplies
	}
	
	public void chercherCaissesRangees(){
		
		for(int i =0 ; i < largeurMap; i++){
			for( int j =0; j < hauteurMap; j++){
				if(map[i][j].getContenu() == "B" && map[i][j].getCible() ==1){
					nb_caissesRangees++;
				}
			}
		}
	}
	
	
						// GETTER ET SETTER
	public int getLargeurMap() {
		return largeurMap;
	}

	public void setLargeurMap(int largeurMap) {
		this.largeurMap = largeurMap;
	}

	public int getHauteurMap() {
		return hauteurMap;
	}

	public void setHauteurMap(int hauteurMap) {
		this.hauteurMap = hauteurMap;
	}

	public int getNb_cibles() {
		return nb_cibles;
	}

	public void setNb_cibles(int nb_cibles) {
		this.nb_cibles = nb_cibles;
	}

}
