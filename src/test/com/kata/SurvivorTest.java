package com.kata;

import com.kata.equipments.*;
import org.junit.Assert;
import org.junit.Test;

public class SurvivorTest {
	@Test
	public void mustBeBornHealthy(){
		Survivor zombie = new Survivor("Name");
		Assert.assertEquals(zombie.getWounds(), 0);
	}

	@Test
	public void mustDie(){
		Survivor zombie = new Survivor(" ");
		Assert.assertEquals(zombie.getWounds(), 0);
		zombie.wound();
		Assert.assertTrue(zombie.isAlive());
		Assert.assertEquals(zombie.getWounds(), 1);
		zombie.wound();
		Assert.assertFalse(zombie.isAlive());
	}

	@Test
	public void playerMustHave3Turns() {
		Survivor zombie = new Survivor(" ");
		Assert.assertEquals(zombie.getTurns(), 3);
	}
	
	// Here we start with EQUIPMENT TESTs
	
	// Check success case
	@Test
	public void playerHandleEquipment() {
		Survivor survivor = new Survivor(" ");
		Equipment equip1 = new BaseballBat();
		Equipment equip2 = new FryingPan();
		Equipment equip3 = new Katana();
		Equipment equip4 = new Pistol();
		Equipment equip5 = new BottledWater();
		
		survivor.pickEquipment(equip1);
		survivor.pickEquipment(equip2);
		survivor.pickEquipment(equip3);
		survivor.pickEquipment(equip4);
		survivor.pickEquipment(equip5);
		
		Assert.assertNotNull(survivor.getEquipments());
		Assert.assertEquals(survivor.numEquipments(), 5);
	}
	
	// Case where trying to insert more them 5 Equipment
	@Test(expected = FullCarryingCapacity.class)
	public void shouldThrowWhenTryingToCarryTooMuchItems() {
		Survivor survivor = new Survivor(" ");
		Equipment equip1 = new BaseballBat();
		Equipment equip2 = new FryingPan();
		Equipment equip3 = new Katana();
		Equipment equip4 = new Pistol();
		Equipment equip5 = new BottledWater();
		
		survivor.pickEquipment(equip1);
		survivor.pickEquipment(equip2);
		survivor.pickEquipment(equip3);
		survivor.pickEquipment(equip4);
		survivor.pickEquipment(equip5);
		survivor.pickEquipment(equip3);
	}
	
	// Success Case: handle equipments in hand and in reserve
	@Test
	public void handleEquipmentsSuccessfully() {
		Survivor survivor = new Survivor(" ");
		
		Equipment equip1 = new BaseballBat();
		Equipment equip2 = new FryingPan();
		Equipment equip3 = new Katana();
		Equipment equip4 = new Pistol();
		Equipment equip5 = new BottledWater();
		
		survivor.pickEquipment(equip1);
		survivor.pickEquipment(equip2);
		survivor.pickEquipment(equip3);
		
		survivor.useEquipmentInHand(equip3);
		
		survivor.pickEquipment(equip4);
		survivor.pickEquipment(equip5);
		
		survivor.useEquipmentInHand(equip5);
		survivor.useEquipmentInHand(equip4, equip5);
		
		
		Assert.assertEquals(2, survivor.numEquipmentsInHand());
		Assert.assertEquals(3, survivor.numEquipmentsInReserve());
		
		survivor.useEquipmentInReserve(equip4);
		survivor.useEquipmentInReserve(equip3);
		
		Assert.assertEquals(0, survivor.numEquipmentsInHand());
        Assert.assertEquals(5, survivor.numEquipmentsInReserve());
		
	}
}
