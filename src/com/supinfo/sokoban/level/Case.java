package com.supinfo.sokoban.level;

public class Case implements java.io.Serializable {

	// Attributs

	private static final long serialVersionUID = 101L;
	private boolean cible;

	// Constructors

	public Case() {
		cible = false;
	}

	public Case(boolean c) {
		cible = c;
	}

	// Methods

	@Override
	public String toString() {
		return " ";
	}
	
	public boolean isCible(){
		return cible;
	}

}
