package com.kata;

import com.kata.equipments.*;
import com.testutil.TestUtil;

import org.junit.Assert;
import org.junit.Test;

public class SurvivorTest {
	
	@Test
	public void mustBeBornHealthy(){
		Survivor survivor = new Survivor("Name");
		Assert.assertEquals(survivor.getWounds(), 0);
		survivor.wound();
		Assert.assertEquals(survivor.getWounds(), 1);
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
	
	// Success Case: move an equipment from reserve to hand.
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
		survivor.pickEquipment(equip4);
		survivor.pickEquipment(equip5);
		
		survivor.useEquipmentInHand(equip4);
		survivor.useEquipmentInHand(equip5);
		
		Assert.assertEquals(2,survivor.numEquipmentsInHand());
		Assert.assertEquals(3,survivor.numEquipmentsInReserve());
		Assert.assertEquals(equip2, survivor.getEquipments().peekLast());
		Assert.assertEquals(equip4, survivor.getInHandEquipments().peekFirst() );
		Assert.assertEquals(equip5, survivor.getInHandEquipments().peekLast() );
	}
	
	@Test
	public void success_useEquipmentInHand_TwoArguments() {
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
		
		survivor.useEquipmentInHand(equip4,equip1);
		survivor.useEquipmentInHand(equip5,equip4);
		
		Assert.assertEquals(2,survivor.numEquipmentsInHand());
		Assert.assertEquals(3,survivor.numEquipmentsInReserve());
		Assert.assertEquals(equip4, survivor.getEquipments().peekLast());
		Assert.assertEquals(equip2, survivor.getInHandEquipments().peekFirst());
		Assert.assertEquals(equip5, survivor.getInHandEquipments().peekLast());
		
	}
	
	
	@Test
	public void success_saveEquipmentInReserve() {
		Survivor survivor = TestUtil.buildSurvivor_with2Equipments();
		
		Equipment equipment1 = new BaseballBat();
		Equipment equipment2 = new BottledWater();
		
		survivor.saveEquipmentInReserve( equipment1 );
		survivor.saveEquipmentInReserve( equipment2 );
		
		Assert.assertEquals(equipment1 , survivor.getInReserveEquipments().peekFirst());
		Assert.assertEquals(equipment2 , survivor.getInReserveEquipments().peekLast());
	}
	
	@Test(expected = EquimentDoesntExists.class)
	public void error_useEquipmentInHand() {
		Survivor survivor = TestUtil.buildSurvivor_with2Equipments();
		Equipment equip1 = new FryingPan();
		
		survivor.useEquipmentInHand(equip1);
	}
	
	@Test(expected = EquimentDoesntExists.class)
	public void error_useEquipmentInHand_TwoArguments_ErrorWithEquipmentInReserve() {
		Survivor survivor = TestUtil.buildSurvivor_with2Equipments();
		
		Equipment equip1 = new FryingPan();
		Equipment equip2 = new FryingPan();
		
		survivor.useEquipmentInHand(equip1,equip2);
	}
	
	@Test (expected = EquimentDoesntExists.class)
	public void error_useEquipmentInHand_TwoArguments_ErrorWithEquipmentInHand() {
		Survivor survivor = TestUtil.buildSurvivor_with4Equipments();
		
		// This equip is in hand
		Equipment equip_thatGoesToReserve = new Pistol();
		// This equip is not in reserve
		Equipment equip_thatGoesToHand = new FryingPan();
		
		survivor.useEquipmentInHand(equip_thatGoesToHand, equip_thatGoesToReserve);
	}
	
	@Test (expected = EquimentDoesntExists.class)
	public void error_saveEquipmentInReserve() {
		Survivor survivor = TestUtil.buildSurvivor_with4Equipments();
		
		Equipment equipment_notExistent = new Pistol();
		
		survivor.saveEquipmentInReserve(equipment_notExistent);
	}
	
	@Test
	public void success_wound() {
		/**
		 * Survivor must lose equipments when get wound
		 */
		Survivor survivor = TestUtil.buildSurvivor_with4Equipments();
		
		survivor.wound();
		Assert.assertEquals(4, survivor.getEquipments().size());
		Assert.assertEquals(2, survivor.getInHandEquipments().size());
		Assert.assertEquals(2, survivor.getInReserveEquipments().size());
		
		survivor.wound();
		Assert.assertEquals(3, survivor.getEquipments().size());
		Assert.assertEquals(2, survivor.getInHandEquipments().size());
		Assert.assertEquals(1, survivor.getInReserveEquipments().size());
		Assert.assertFalse(survivor.isAlive());
		
		survivor.wound();
		Assert.assertEquals(3, survivor.getEquipments().size());
		Assert.assertEquals(2, survivor.getInHandEquipments().size());
		Assert.assertEquals(1, survivor.getInReserveEquipments().size());
		Assert.assertFalse(survivor.isAlive());
	}
	
	
}
