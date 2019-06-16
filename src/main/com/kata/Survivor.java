package com.kata;

import com.kata.equipments.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

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
	
	public String getEquipmentsAsString() {
	    return backpack.getEquipmentsAsString();
	}
	
	public LinkedList getEquipments() {
		return backpack.getEquipments();
	}
	
	
	public LinkedList<Equipment> getInReserveEquipments() {
		return backpack.getInReserveEquipments();
	}
	
	public LinkedList<Equipment> getInHandEquipments() {
		return backpack.getInHandEquipments();
	}
	
	public int getTurns() {
		return this.turns;
	}
	
	public int getWounds() {
		return wounds;
	}
	
	public boolean isAlive() {
		return this.wounds < 2;
	}
	
	public int numEquipments() {
	    return backpack.numEquipments();
    }
	
	public int numEquipmentsInHand() {
		return this.backpack.numEquipmentsInHand();
	}
	
	public int numEquipmentsInReserve() {
		return this.backpack.numEquipmentsInReserve();
	}
	
	public void pickEquipment(Equipment equipment) {
		this.backpack.pickEquipment(equipment);
	}
	
	public void saveEquipmentInReserve(Equipment equipment) {
		/**
		 * Move the equipment to reserve.
		 * The equipment must be in hand.
		 */
		
		this.backpack.saveEquipmentInReserve(equipment);
	}
	
    public void useEquipmentInHand(Equipment equipment) {
	    /**
	     * Add the equipment in hand.
	     * The equipment must be in reserve.
	     */
	    
		this.backpack.useEquipmentInHand(equipment);
    }
	
	public void useEquipmentInHand(Equipment equipmentToAddInHand, Equipment equipmentToSave) {
		/**
		 * Move the equipmentToAddInHand to hand and move the equipmentToSave to reserve.
		 * The equipmentToAddInHand must be in reserve.
		 * The equipmentToSave must be in hand.
		 */
		
		this.backpack.useEquipmentInHand(equipmentToAddInHand, equipmentToSave);
	}
	
	public void wound() {
		if( isAlive() ) {
			this.wounds++;
			this.backpack.decreaseCapacity();
		}
	}
	
}
