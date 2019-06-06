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
}
