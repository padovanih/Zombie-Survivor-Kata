package com.kata;

import com.kata.equipments.EquimentDoesntExists;
import com.kata.equipments.Equipment;

import java.util.LinkedList;
import java.util.Queue;

public class BackPack {
	
	private int capacity;
	private LinkedList<Equipment> inReserveEquipments;
	private LinkedList<Equipment> inHandEquipments;
	
	BackPack() {
		capacity = 5;
		inReserveEquipments = new LinkedList<Equipment>();
		inHandEquipments = new LinkedList<Equipment>();
	}
	
	public void decreaseCapacity() {
		// Remove one equipment is the survivor has backpack full
		if( this.isFull() ) {
			this.inReserveEquipments.poll();
		}
		this.capacity--;
	}
	
	private int getCapacity() {
		return capacity;
	}
	
	public LinkedList<Equipment> getEquipments() {
		LinkedList<Equipment> equipmentsToReturn = new LinkedList<Equipment>(inHandEquipments);
		equipmentsToReturn.addAll(inReserveEquipments);
		return equipmentsToReturn;
	}
	
	public String getEquipmentsAsString() {
		return "In Hand: " +
				this.inHandEquipments.toString() +
				"\n" +
				"In Reserve: " +
				inReserveEquipments.toString();
	}
	
	public LinkedList<Equipment> getInReserveEquipments() {
		return inReserveEquipments;
	}
	
	public LinkedList<Equipment> getInHandEquipments() {
		return inHandEquipments;
	}
	
	private int getNumOfEquipments() {
		return inReserveEquipments.size() + inHandEquipments.size();
	}
	
	private boolean inHandIsFull() {
		return inHandEquipments.size()==2;
	}
	
	private boolean inHandIsEmpty() {
		return inHandEquipments.isEmpty();
	}
	
	private boolean inReserveIsEmpty() {
		return inReserveEquipments.isEmpty();
	}
	
	public boolean isFull() {
		return numEquipments() == capacity;
	} 
	
	public int numEquipments() {
		return this.inHandEquipments.size() + this.inReserveEquipments.size();
	}
	
	public int numEquipmentsInHand() {
		return this.inHandEquipments.size();
	}
	
	public int numEquipmentsInReserve() {
		return this.inReserveEquipments.size();
	}
	
	public void pickEquipment(Equipment equipment) throws FullCarryingCapacity {
		if( isFull() ) {
			throw new FullCarryingCapacity("Your cap is full.");
		}
		
		// Add in hand by default.
		if ( !inHandIsFull() ) {
			inHandEquipments.add(equipment);
			return;
		}
		
		inReserveEquipments.add(equipment);
	}
	
	private boolean reserveIsFull() {
		return inReserveEquipments.size() == getCapacity() - numEquipmentsInHand();
	}
	
	
	public void useEquipmentInHand(Equipment equipment) throws EquimentDoesntExists {
		// Verify is the equipment is available in reserve.
		if ( !inReserveEquipments.contains(equipment) ) {
			throw new EquimentDoesntExists("Equipment is not in reserve.");
		}
		
		// Check if there's enough capacity.
		if ( this.inHandIsFull() ) {
			// If there is not enough capacity, remove a random equipment from hand and add it in reserve.
			saveEquipmentInReserve( inHandEquipments.peek() );
		}
		
		inReserveEquipments.remove( equipment );
		inHandEquipments.add( equipment );
	}
	
	public void saveEquipmentInReserve(Equipment equipment) throws EquimentDoesntExists {
		// Verify if equipment is not in Hand
		if ( !inHandEquipments.contains(equipment) ) {
			throw new EquimentDoesntExists("Equipment: "+ equipment.toString() +" is not available in Hand.");
		}
		
		inHandEquipments.remove( equipment );
		inReserveEquipments.add( equipment );
	}
	
	public void useEquipmentInHand(Equipment equipmentToAddInHand, Equipment equipmentToSave) {
		// Verify if the equipment is available in reserve.
		if ( !inReserveEquipments.contains(equipmentToAddInHand) ) {
			throw new EquimentDoesntExists("Equipment: " + equipmentToAddInHand + " is not in reserve.");
		}
		// Verify if the equipment is available in hand.
		if ( !inHandEquipments.contains(equipmentToSave) ) {
			throw new EquimentDoesntExists("Equipment: " + equipmentToSave + " is not in reserve.");
		}
		
		inReserveEquipments.remove(equipmentToAddInHand);
		inHandEquipments.add(equipmentToAddInHand);
		inHandEquipments.remove(equipmentToSave);
		inReserveEquipments.add(equipmentToSave);
	}
}
