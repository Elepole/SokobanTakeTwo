package com.supinfo.sokoban;

import com.supinfo.sokoban.level.Plateau;


public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Plateau test = new Plateau();
		System.out.println(test.toString());
		
		 /*
		//Petite aide afin de generer un niveau par defaut facilement
		 
		Plateau niv1 = new Plateau();
		niv1.setNomPlateau("niv1");
		niv1.setPlateauCase(1, 1, "X", 0);
		niv1.setPlateauCase(4, 4, "B", 0);
		niv1.setPlateauCase(5, 5, "O", 1);
		niv1.setNb_cibles(1);
		for(int i=0; i<8; i++){
			niv1.setPlateauCase(i, 0, "=", 0);
			niv1.setPlateauCase(i, 7, "=", 0);
			niv1.setPlateauCase(0, i, "=", 0);
			niv1.setPlateauCase(7, i, "=", 0);
		}

		niv1.afficherPlateau();
		System.out.println(niv1.getNb_cibles());
		
		SaveMap saveniv1 = new SaveMap(niv1);
		*/
		
		
		
		//Parse the arguments from the console.
		/*
		if (args.length >= 1) { 						//Test if there is an argument
		
			if (args[0].equals("--create")) {			//Test if the argument equal --create and launch Editor.
				
				Editor sokobanedit = new Editor();
				
			} else if (args[0].equals("--score")) {		//Test if the argument equal --score and launch the Score
				
				Score sokobanscore = new Score();
				
			} else if (args[0].equals("--level")) {		//Test if the argument equal --level, and load the level with the second argument if there is one
				
				if (args.length >= 2) {
					
					Play sokoban = new Play(args[1]);
					
				} else {
					
					//If the --level argument is used without a second argument it launch the default level.
					
					Play sokoban = new Play();
					
				}
			}
			
		} else {

			Play sokoban = new Play();
			
		}
		*/
		
		
		
		
		

		
	}
	
}
