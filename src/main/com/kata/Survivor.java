package com.kata;

import com.kata.equipments.Equipment;

import java.util.ArrayList;
import java.util.List;

public class Survivor {
	private String name;
	private int wounds;
	private int turns;
	private BackPack backpack;
	
	
	public Survivor(String name) {
		this.name = name;
		this.wounds = 0;
		this.backpack = new BackPack();
		this.turns = 3;
	}
	
	public int getWounds() {
		return wounds;
	}
	
	public void wound() {
		this.wounds++;
	}
	
	public boolean isAlive() {
		return this.wounds < 2;
	}
	
	public int getTurns() {
		return this.turns;
	}
	
	
	public void pickEquipment(Equipment equipment) {
		this.backpack.pickEquipment(equipment);
	}
	
	public String getEquipments() {
	    return backpack.getEquipments();
	}
	
	public int numEquipments() {
	    return backpack.numEquipments();
    }
	
	
}
