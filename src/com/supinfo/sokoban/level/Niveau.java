package com.supinfo.sokoban.level;

public class Niveau extends Plateau {
	
	private String nomNiveau;
	
	public String getNomNiveau() {
		return nomNiveau;
	}

	public void setNomNiveau(String nomNiveau) {
		this.nomNiveau = nomNiveau;
	}

	public Niveau() {
		super();
		nomNiveau="temp";
	}
	
	

}
