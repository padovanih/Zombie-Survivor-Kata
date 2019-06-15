package com.kata;

import com.kata.equipments.Equipment;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
	
	private int quantity;
	private List<Equipment> inReserveEquipments;
	private List<Equipment> inHandEquipments;
	
	BackPack() {
		quantity = 0;
		inReserveEquipments = new ArrayList<Equipment>();
		inHandEquipments = new ArrayList<Equipment>();
	}
	
	public int numEquipments() {
		return this.quantity;
	}
	
	public void pickEquipment(Equipment equipment) throws FullCarryingCapacity {
		if( this.quantity == 5 ) {
			throw new FullCarryingCapacity("Your cap is full.");
		}
		
		if ( this.quantity < 2 ) {
			this.inHandEquipments.add(equipment);
		} else {
			this.inReserveEquipments.add(equipment);
		}
		
		this.quantity++;
	}
	
	public String getEquipments() {
		return "In Hand: " +
				this.inHandEquipments.toString() +
				"\n" +
				"In Reserve: " +
				inReserveEquipments.toString();
	}
	
	
	
	
	
}
