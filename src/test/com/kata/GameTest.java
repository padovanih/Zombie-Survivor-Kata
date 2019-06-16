package com.kata;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	
	// Game exists and has 0 survivors on init
	@Test
	public void sucess_GameExists() {
		Game game = new Game();
		Assert.assertEquals(0, game.numSurvivors() );
	}
	
	
	
}
