package com.testutil;

import com.kata.Survivor;
import com.kata.equipments.*;

public class TestUtil {
	
	public static Survivor buildSurvivor() {
		return new Survivor(" ");
	}
	
	public static Survivor buildSurvivor(String name) {
		return new Survivor(name);
	}
	
	public static Survivor buildSurvivor_with2Equipments() {
		Survivor survivor = new Survivor(" ");
		
		Equipment equip1 = new BaseballBat();
		Equipment equip2 = new BottledWater();
		
		survivor.pickEquipment(equip1);
		survivor.pickEquipment(equip2);
		
		return survivor;
	}
	
	public static Survivor buildSurvivor_with4Equipments() {
		Survivor survivor = new Survivor(" ");
		
		Equipment equip1 = new BaseballBat();
		Equipment equip2 = new BottledWater();
		Equipment equip3 = new FryingPan();
		Equipment equip4 = new Katana();
		
		
		survivor.pickEquipment(equip1);
		survivor.pickEquipment(equip2);
		survivor.pickEquipment(equip3);
		survivor.pickEquipment(equip4);
		
		
		return survivor;
	}
	
	public static Survivor buildSurvivor_with4Equipments(String name) {
		Survivor survivor = new Survivor(name);
		
		Equipment equip1 = new BaseballBat();
		Equipment equip2 = new BottledWater();
		Equipment equip3 = new FryingPan();
		Equipment equip4 = new Katana();
		
		
		survivor.pickEquipment(equip1);
		survivor.pickEquipment(equip2);
		survivor.pickEquipment(equip3);
		survivor.pickEquipment(equip4);
		
		
		return survivor;
	}
	
	
	
}
