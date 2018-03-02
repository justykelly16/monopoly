package monoversity;

import java.util.Scanner;

public class Player {
	public String playerName;
	private int currentLocation;
	private int playerBalance = 500;
	private int maxCashAvailable = 1000;

	// Constant vars to define minimum and maximum name length (String characters)
	public final static int MIN_NAME_LENGTH = 1;
	public final static int MAX_NAME_LENGTH = 20;

	public Player() {

	}

	/**
	 * @param playerName
	 * @param currentLocation
	 * @param playerBalance
	 */
	public Player(String playerName, int currentLocation, int playerBalance) {
		super();
		this.playerName = playerName;
		this.currentLocation = currentLocation;
		this.playerBalance = playerBalance;
	}

	public Player(String playerName) {
		this.playerName = playerName;

	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Player name to be between 1 and 20 characters in length
	 * 
	 * @param playerName
	 *            the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;

	}

	public int getPlayerBalance() {
		return playerBalance;
	}

	/**
	 * @param playerBalance
	 *            the playerBalance to set
	 */
	public void setPlayerBalance(int playerBalance) {
		this.playerBalance = playerBalance;
	}

	/**
	 * Outputs the current balance for Player One
	 */
	public void playerCurrentBalance() {
		System.out.printf("Plyer One balance : £%.2f/n", playerBalance);
	}

	public int getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * Validation added to ensure if the location is calculated to be 8, it will be
	 * reset to Zero
	 * 
	 * @param currentLocation
	 *            the currentLocation to set
	 */
	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * method to calculate new player location on the board
	 * 
	 * @param squareNum
	 * @param diceNum
	 */

	public int calculatePlayerLoc(int diceNumber, int currentLoc) {

		int payout = 200;

		if (currentLocation + diceNumber > 8) {
			currentLocation = currentLocation - (8 - diceNumber);
			if (maxCashAvailable > payout) {
				setPlayerBalance(getPlayerBalance() + payout);
				maxCashAvailable -= payout;
				System.out.println("You have passed Go £" + payout + "has been added to your balance");
			} else {
				System.out.println("You have passed GO however the bank is empty. You have collected no money");
			}
		} else if (currentLocation - (8 - diceNumber) == 8) {
			currentLocation = 0;
		} else {
			currentLocation = (currentLocation + diceNumber);
		}

		return currentLocation;

	}
	
	/**
	 * Method to ask players to enter a valid name
	 */
	public void userInputSetPlayerNames() {

		// temporary fix possibly to get rid of resource leak warning
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter your name : ");
		playerName = scanner.nextLine();

		if (playerName != null && (playerName.trim().length() >= Player.MIN_NAME_LENGTH)
				&& (playerName.trim().length() <= Player.MAX_NAME_LENGTH)) {
			System.out.printf("Thank you %s, get ready to start. \n\n", playerName);
			System.out.println("-------------------------------------------------------------------");
		} else {
			System.out.println("Please enter a name of valid length (between 1 & 20 characters)");
			playerName = scanner.nextLine();
		}

	}
}
