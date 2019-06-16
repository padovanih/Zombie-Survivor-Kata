package com.kata;

import com.testutil.TestUtil;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	
	// Game exists and has 0 survivors on init
	@Test
	public void success_GameExists() {
		Game game = new Game();
		Assert.assertEquals(0, game.numSurvivors() );
	}
	
	// A Game can have Survivors added to it at any time.
	//Survivor Names within a Game must be unique.
	@Test
	public void success_GameHaveUniqueSurvivor() {
		Game game = new Game();
		Assert.assertEquals(0, game.numSurvivors());
		
		Survivor s1 = TestUtil.buildSurvivor("n1");
		Survivor s2 = TestUtil.buildSurvivor("n2");
		
		game.addSurvivor(s1);
		Assert.assertEquals(1, game.numSurvivors());
		
		game.addSurvivor(s2);
		Assert.assertEquals(2, game.numSurvivors());
	}
	
	//Survivor Names within a Game must be unique.
	@Test (expected = GameException.class)
	public void error_GameHaveUniqueSurvivor() {
		Game game = new Game();
		Assert.assertEquals(0, game.numSurvivors());
		
		Survivor s1 = TestUtil.buildSurvivor("n1");
		Survivor s2 = TestUtil.buildSurvivor("n2");
		Survivor s3 = TestUtil.buildSurvivor("n1");
		
		game.addSurvivor(s1);
		game.addSurvivor(s2);
		game.addSurvivor(s3);
	}
	
	
}
