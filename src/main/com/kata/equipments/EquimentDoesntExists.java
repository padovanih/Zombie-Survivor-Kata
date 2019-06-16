package com.kata.equipments;

public class EquimentDoesntExists extends RuntimeException{
	
	public EquimentDoesntExists() {
		super();
	}
	
	public EquimentDoesntExists(String message) {
		super(message);
	}
}
