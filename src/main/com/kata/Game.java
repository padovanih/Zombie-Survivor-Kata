package com.kata;

import java.util.LinkedList;

public class Game {
	
	LinkedList<Survivor> survivors;
	
	Game() {
		survivors = new LinkedList<Survivor>();
	}
	
	public int numSurvivors() {
		return survivors.size();
	}
	
	
}
