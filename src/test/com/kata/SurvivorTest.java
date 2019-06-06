package com.kata;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

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
    }
}
