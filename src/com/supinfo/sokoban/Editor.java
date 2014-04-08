package com.supinfo.sokoban;

import java.util.Scanner;

import com.supinfo.sokoban.game.SaveMap;
import com.supinfo.sokoban.unused.Plateau;

public class Editor {

	// On cr�� un string dans lequel le joueur entrera le 8 lignes de la map
	String ligne;
	// Cible passera a 1 si le caract�re "O" est rep�r� lors de la v�rification
	// d'un caractere d'une ligne
	int cible = 0;
	private Plateau plateau;
	Character t;
	Character j;
	int nbJoueur;
	int nbCibles;

	public Editor() {

		ligne = new String();
		plateau = new Plateau();
		nbCibles = 0;

		// l est un entier qui sera �gale a 1 une fois les lignes bien valid�es
		int l = 0;

		System.out.println("Bienvenu dans l'editeur");
		System.out.println("Creation du niveau");
		Scanner sc = new Scanner(System.in);

		// Saisi des lignes
		for (int x = 0; x < 8; x++) {
			do {
				System.out.print("Saisir  ligne:");
				ligne = sc.nextLine();

				if (ligne.length() == 8) {
					
                 
					l = 1;

				}

				else {
					System.out
							.println("la ligne doit contenir 8 caracteres max");
				}
			}

			while (l != 1);

			l = 0;

			for (int y = 0; y < 8; y++) {
				t = Character.valueOf(ligne.charAt(y));

				if (t.toString().equals("O")) {
					cible = 1;
					nbCibles++;
				} else if(t.toString().equals("X")){
					plateau.setX_joueur(x);
					plateau.setY_joueur(y);
				}
				plateau.setPlateauCase(x, y, t.toString(), cible);
				cible = 0;
			}

		}

		System.out.println("Donner un nom a votre map");
		ligne = sc.nextLine();
		plateau.setNomPlateau(ligne);
		plateau.setNb_cibles(nbCibles);

		SaveMap saveMap = new SaveMap(plateau);
		sc.close();

		plateau.afficherPlateau();

	}

}
