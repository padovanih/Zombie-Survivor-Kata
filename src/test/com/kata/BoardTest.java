package com.kata;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void boardMustBeCreatable() {
        Assert.assertNotNull(new Board());
    }
    @Test
    public void boardHasSurvivor(){
        Board board = new Board();
        board.insertSurvivor(new Survivor(" "));
        Assert.assertEquals(1, board.getSurvivors().size());
    }
    @Test
    public void boardHasTurn(){
        Board board = new Board();
        Survivor playerOne = new Survivor("P1");
        Survivor playerTwo = new Survivor("P2");
        board.insertSurvivor(playerOne);
        board.insertSurvivor(playerTwo);
        Assert.assertEquals(board.getActiveSurvivor(), playerOne);
        playerOne.act();
        Assert.assertEquals(board.getActiveSurvivor(), playerOne);
        playerOne.act();
        Assert.assertEquals(board.getActiveSurvivor(), playerOne);
        playerOne.act();
        Assert.assertEquals(board.getActiveSurvivor(), playerTwo);
    }
}
