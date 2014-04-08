package com.supinfo.sokoban.game;

import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;


public class Score {
	
	private int j;
	private int tableauScore[];
	private String path;
	private String text;
	private int score2;
		
		public Score(){
			j = 0;
			score2=0;
			tableauScore = null;
			String path = null;
			String text = null;
		}
		
		//Lire un fichier texte et écrire dans un tableau.
		//trier le tout 
	
		public void EntryAndWriteScore(){
	
		while(getScore()!=0){ 
			tableauScore[j] = getScore();
			j++;
		}
	
		File fichier = new File ("Score");
	 
		try
		{
		    PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (fichier)));
	 
		    for (double d : tableauScore)
		    {
		        pw.println (d);
		    }
	 
		    pw.close();
		}
		catch (IOException exception)
		{
	  	  System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}
	
	
		public void compare(int score2){
			
		String filePath = " "; //mettre le chemin du fichier
		
		 
		Scanner scanner=new Scanner(new File(filePath));
		 
		// On boucle sur chaque champ detecté
		
		while (scanner.hasNextLine()) {
		    String line = scanner.nextLine();
		 
			//le traitement
		    
		    if(getScore<Integer.parseIn(line)){
		    	tableauScore[j]=Integer.parseIn(line);
		    }else{
		    	System.out.println("Votre score est trop faible");
		    }
		}
		 
		scanner.close();
		}
	
		public static void triBulleCroissant(int tableauScore[]) {
			int longueur = tableauScore.length;
			int tampon = 0;
			boolean permut;
	 
			do {
				// hypothèse : le tableau est trié
				permut = false;
				for (int i = 0; i < longueur - 1; i++) {
					// Teste si 2 éléments successifs sont dans le bon ordre ou non
					if (tableauScore[i] > tableauScore[i + 1]) {
						// s'ils ne le sont pas, on échange leurs positions
						tampon = tableauScore[i];
						tableauScore[i] = tableauScore[i + 1];
						tableauScore[i + 1] = tampon;
						permut = true;
					}
				}
			} while (permut);
		}
		
		public static void afficheTableau(){
			for (int i=0; i<tableauScore.length; i++){
				System.out.println(tableauScore);
				}
		}
	
	

}