/**
 * 
 */
package monoversity;

import monoversity.Player;

/**
 * @author paddy
 *
 */
public class Board {
	// setting the size of the board
	public final static int NUM_SQUARES = 8;

	/**
	 * 
	 */
	public Board() {
		
	}

	/**
	 * Method to play the game
	 * 
	 * @param args
	 */
	public void Play() {
		// populating board square data
		Square go = new GoSquare("Go", 1);
		Square csb = new PropertySquare("CSB", 2, 120, 24);
		Square dkb = new PropertySquare("DKB", 3, 130, 26);
		Square pec = new PropertySquare("PEC", 4, 140, 28);
		Square fps = new FreeParking("Free Parking", 5);
		Square bot = new PropertySquare("Bot", 6, 190, 38);
		Square hat = new PropertySquare("Hatfield", 7, 200, 40);
		Square pc = new PubCrawl("Pubcrawl", 8);
		
	

		Square[] squares = { go, csb, dkb, pec, fps, bot, hat, pc };

		// setting initial var values for Player Turn

		// creation of Player Details objects
		Player p1 = new Player();
		Player p2 = new Player();

		// creation of Roll Dice object
		RollDice d1 = new RollDice();
		RollDice d2 = new RollDice();

		System.out.printf("Player One, ");
		p1.userInputSetPlayerNames();

		// User input to get Player Two name
		System.out.printf("Player Two, ");
		p2.userInputSetPlayerNames();
		System.out.println(); // formatting space

		// determines the order of players by whoever rolls the highest number
		boolean sameNumber = true;
		boolean isPlayerOneTurn = true;
		boolean isPlayerTwoTurn = false;
		do {
			System.out.println(p1.playerName);
			d1.throwDice();
			

			System.out.println(p2.playerName);
			d2.throwDice();
			

			sameNumber = (d1.getDiceNumber() == d2.getDiceNumber());

			if (sameNumber) {
				System.out.println("You both got the same value let's try that again");
			
			}
		} while (sameNumber);

		if (d1.getDiceNumber() > d2.getDiceNumber()) {
			System.out.println(p1.playerName + " you got the highest value and will begin the game first\n");
		} else {
			isPlayerOneTurn = false;
			isPlayerTwoTurn = true;

			System.out.println(p2.playerName + " got the highest value and will now begin the game first\n");
		}

		p1.setCurrentLocation(1);
		p2.setCurrentLocation(1);

		boolean winnerFound = false;
	

		do {

			if (isPlayerOneTurn == true && isPlayerTwoTurn == false) {
				System.out.printf("Player One: %s, your turn.\n\n", p1.getPlayerName());
				System.out.println(p1.getPlayerName() + " your current balance is : �" + p1.getPlayerBalance());

				d1.throwDice();
				p1.calculatePlayerLoc(d1.getDiceNumber(), p1.getCurrentLocation());
				//System.out.println("Loc Calculator test : " + p1.getCurrentLocation());
				p1.setCurrentLocation(p1.getCurrentLocation());

				outputDetailsSquareLandedOn(p1, squares, p1.getCurrentLocation());
				System.out.println("------------------------------------------------------\n\n");
				isPlayerOneTurn = false;
				isPlayerTwoTurn = true;

			} else if (isPlayerTwoTurn == true && isPlayerOneTurn == false) {

				System.out.printf("Player Two: %s, your turn.\n\n", p2.getPlayerName());
				System.out.println(p2.getPlayerName() + " your current balance is : �" + p2.getPlayerBalance());

				d1.throwDice();
				p2.calculatePlayerLoc(d1.getDiceNumber(), p2.getCurrentLocation());
				//System.out.println("Loc Calculator test : " + p2.getCurrentLocation());
				p2.setCurrentLocation(p2.getCurrentLocation());

				outputDetailsSquareLandedOn(p2, squares, p2.getCurrentLocation());
				System.out.println("------------------------------------------------------\n\n");

				isPlayerOneTurn = true;
				isPlayerTwoTurn = false;
			}

			winnerFound = (p1.getPlayerBalance() < 0 || p2.getPlayerBalance() < 0);

		} while (!winnerFound);
		if (p1.getPlayerBalance() > p2.getPlayerBalance()) {
			System.out.println("Congratulations " + p1.playerName + " you have won the game, with a balance of �"
					+ p1.getPlayerBalance());
		} else {
			System.out.println("Congratulations " + p2.playerName + " you have won the game with a balance of �"
					+ p2.getPlayerBalance());

		}
	}

	/*
	 * private static boolean AskIfTheyWantToPlayAgain() {
	 * System.out.println("Do you want to play again?"); String response = new
	 * Scanner(System.in).nextLine();
	 * 
	 * return (response.toLowerCase().equals("yes") ||
	 * response.toLowerCase().equals("y"));
	 */

	/**
	 * Method to output the details of the square in which the player has landed on
	 * 
	 * @param player
	 * @param squares
	 * @param currentBoardLocation
	 */
	public static void outputDetailsSquareLandedOn(Player player, Square[] squares, int currentBoardLocation) {
		for (Square s : squares) {
			if (s.getBoardLocation() == currentBoardLocation) {
				s.Modify(player);
			}
		}
	}

}
