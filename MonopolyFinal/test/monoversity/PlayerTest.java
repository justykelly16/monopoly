package monoversity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	String validPlayerName, invalidPlayerNameTooLong,invalidPlayerNameEmpty; 

	int validPlayerLocation, validPlayerBalance;
	
	@Before
	public void setUp() throws Exception {
		validPlayerName="Valid Name";
		invalidPlayerNameEmpty="";
		invalidPlayerNameTooLong="Over twenty characters long";
		
		validPlayerLocation=5;
		
		validPlayerBalance=100;
		
	}

	@Test
	public void testPlayerDefaultConstructor() {
		Player player = new Player();
		assertNotNull(player);
	}

	@Test
	public void testPlayerConstructorWithArgs() {
		Player player = new Player(validPlayerName, validPlayerLocation, validPlayerBalance);
		
		assertEquals(validPlayerName, player.getPlayerName());
		assertEquals(validPlayerLocation, player.getCurrentLocation());
		assertEquals(validPlayerBalance, player.getPlayerBalance());
	}
	
	@Test
	public void testGetSetPlayerNameValid() {
		Player player = new Player();
		player.setPlayerName(validPlayerName);
		assertEquals(validPlayerName, player.getPlayerName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSetPlayerNameInvalidEmpty() {
		Player player = new Player();
		player.setPlayerName(invalidPlayerNameEmpty);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetSetPlayerNameInvalidTooLong() {
		Player player = new Player();
		player.setPlayerName(invalidPlayerNameTooLong);
	}

	@Test
	public void testPlayerCurrentBalanceValid() {
		Player player = new Player();
		player.setPlayerBalance(validPlayerBalance);
		assertEquals(validPlayerBalance, player.getPlayerBalance());
	}

	@Test
	public void testSetCurrentLocationValid() {
		Player player = new Player();
		player.setCurrentLocation(validPlayerLocation);
		assertEquals(validPlayerLocation, player.getCurrentLocation());
	}

	@Test
	public void testCalculatePlayerLoc() {
		
	}

	@Test
	public void testUserInputSetPlayerNames() {
		
	}

}
