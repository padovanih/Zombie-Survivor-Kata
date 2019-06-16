package com.kata;

import java.util.LinkedList;

public class Game {
	
	LinkedList<Survivor> survivors;
	
	Game() {
		survivors = new LinkedList<Survivor>();
	}
	
	public void addSurvivor(Survivor survivor) throws GameException {
		if( this.containSurvivor(survivor) ) {
			throw new GameException("The survivor " + survivor.getName() + " is already in game.");
		}
		this.survivors.add(survivor);
	}
	
	private boolean containSurvivor(Survivor survivor) {
		return survivors.contains(survivor);
	}
	
	public int numSurvivors() {
		return survivors.size();
	}
	
	
}
