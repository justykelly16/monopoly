/**
 * 
 */
package monoversity;



import java.util.Scanner;

import monoversity.Player;

/**
 * @author paddy
 *
 */
public class GameManager {
	// setting the size of the board
	public final static int NUM_SQUARES = 8;
	private boolean isPlayerOneTurn = true;
	private boolean isPlayerTwoTurn = false;
	private boolean sameNumber = false;
	// creation of Player Details objects
	Player p1 = new Player();
	Player p2 = new Player();
	
	// populating board square data
	Square go = new GoSquare("Go", 1,null);
	Square csb = new PropertySquare("CSB", 2, null, 120, 24, 60);
	Square dkb = new PropertySquare("DKB", 3,  null, 130, 26, 65);
	Square pec = new PropertySquare("PEC", 4,  null, 140, 28, 70);
	Square fps = new FreeParking("Free Parking", 5,null);
	Square bot = new PropertySquare("Bot", 6, null, 190, 38, 95);
	Square hat = new PropertySquare("Hatfield", 7, null, 200, 40, 100);
	Square pc = new PubCrawl("Pubcrawl", 8,null);
	
	
	PropertySquare[] red = {(PropertySquare) csb,(PropertySquare) dkb,(PropertySquare) pec};
	PropertySquare[] yellow = {(PropertySquare) bot,(PropertySquare) hat};

	Square[] squares = { go, csb, dkb, pec, fps, bot, hat, pc };

	/**
	 * 
	 */
	public GameManager() {

	}

	/**
	 * Method to play the game
	 * 
	 * @param args
	 */
	public void Play() {


		
	

	
		// method to create players
		createPlayers();
	
		// method to determine the order of the the players
		determineOrderOfPlayers();
		
		
		// The method for the game
		playGame();
		
		// method to find out who won
		FindOutWhoWon();
		
		
		// method to ask players if they would like to play again
		askIfTheyWantToPlayAgain();
	}
		

	
		
		



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
				s.modify(player);
				

			}
		}
	}
	
	public void createPlayers() {
		System.out.printf("Player One, ");
		p1.userInputSetPlayerNames();

		// User input to get Player Two name
		System.out.printf("Player Two, ");
		p2.userInputSetPlayerNames();
		System.out.println(); // formatting space
		
		
		
	}

	public  void determineOrderOfPlayers() {

		// creation of Roll Dice object
		RollDice d1 = new RollDice();
		RollDice d2 = new RollDice();
		// determines the order of players by whoever rolls the highest number
		sameNumber = true;
		 isPlayerOneTurn = true;
		 isPlayerTwoTurn = false;
		do {
			System.out.println(p1.playerName);
			d1.throwDice(p1);

			System.out.println(p2.playerName);
			d2.throwDice(p2);

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


	}
	
	public void playGame() {
		p1.setPropertyRedType(0);
		p2.setPropertyRedType(0);
		p1.setPropertyYellowType(0);
		p2.setPropertyYellowType(0);
		RollDice d1 = new RollDice();
		boolean winnerFound = false;

		do {

			if (isPlayerOneTurn == true && isPlayerTwoTurn == false) {
				System.out.printf("Player One: %s, your turn.\n\n", p1.getPlayerName());
				System.out.println(p1.getPlayerName() + " your current balance is : £" + p1.getPlayerBalance());

				// to output squares owned by a player
				System.out.println();// line break
				System.out.println("Player One, you own the following Property Squares : ");
				outputSquaresOwned(p1, squares);
				checkIfPlayerOneOwnsRedProperties(p1,red);
				checkIfPlayerOneOwnsYellowProperties(p1,yellow);

				d1.throwDice(p1);
				if (p1.getCurrentLocation() == 10) {
					winnerFound = true;
					break;
				}
				p1.calculatePlayerLoc(d1.getDiceNumber(), p1.getCurrentLocation());
				// System.out.println("Loc Calculator test : " + p1.getCurrentLocation());
				p1.setCurrentLocation(p1.getCurrentLocation());

				outputDetailsSquareLandedOn(p1, squares, p1.getCurrentLocation());
				
				System.out.println("------------------------------------------------------\n\n");
				isPlayerOneTurn = false;
				isPlayerTwoTurn = true;

			} else if (isPlayerTwoTurn == true && isPlayerOneTurn == false) {

				System.out.printf("Player Two: %s, your turn.\n\n", p2.getPlayerName());
				System.out.println(p2.getPlayerName() + " your current balance is : £" + p2.getPlayerBalance());

				// to output squares owned by a player
				System.out.println();// line break
				
				System.out.println("Player Two, you own the following Property Squares : ");
				outputSquaresOwned(p2, squares);
				checkIfPlayerTwoOwnsRedProperties(p2, red);
				checkIfPlayerTwoOwnsYellowProperties(p2,yellow);

				d1.throwDice(p2);
				if (p2.getCurrentLocation() == 10) {
					winnerFound = true;
					break;
				}
				p2.calculatePlayerLoc(d1.getDiceNumber(), p2.getCurrentLocation());
				// System.out.println("Loc Calculator test : " + p2.getCurrentLocation());
				p2.setCurrentLocation(p2.getCurrentLocation());

				outputDetailsSquareLandedOn(p2, squares, p2.getCurrentLocation());
				
				System.out.println("------------------------------------------------------\n\n");

				isPlayerOneTurn = true;
				isPlayerTwoTurn = false;
			}

			if (p1.getPlayerBalance() <= 0 || p2.getPlayerBalance() <= 0) {
				winnerFound = true;
			}

		} while (!winnerFound);
		
	}
	
	public void FindOutWhoWon() {
		
		if (p2.getCurrentLocation() == 9) {
			System.out.println(p2.playerName + " has decided to terminate the the game so " + p1.playerName
					+ " you have won the game, with a balance of £" + p1.getPlayerBalance() + "! " + p2.playerName
					+ " you quit the game with a balance of £" + p2.getPlayerBalance());

		} else if (p1.getCurrentLocation() == 9) {
			System.out.println(p1.playerName + " has decided to terminate the the game so " + p2.playerName
					+ " you have won the game, with a balance of £" + p2.getPlayerBalance() + "! " + p1.playerName
					+ " you quit the game with a balance of £" + p1.getPlayerBalance());
		} else if (p1.getPlayerBalance() > p2.getPlayerBalance()) {
			System.out.println("Congratulations " + p1.playerName + " you have won the game, with a balance of £"
					+ p1.getPlayerBalance() + "! " + p2.playerName
					+ " you have been declared bankrupt with a balance of £" + p2.getPlayerBalance());
		} else if ((p1.getPlayerBalance() < p2.getPlayerBalance())) {
			System.out.println("Congratulations " + p2.playerName + " you have won the game with a balance of £"
					+ p2.getPlayerBalance() + "! " + p1.playerName
					+ " you have been declared bankrupt with a balance of £" + p1.getPlayerBalance());
		}

		 
	}
	
	
		
	

	/**
	 * Method to set the ownership of a Property Square
	 * @param playerName
	 * @param squares
	 */
	public void outputSquaresOwned(Player player, Square[] squares) {
		for (Square s : squares) {
			if(s.getOwner()==player) {
				System.out.println(s.getName());
				
			}
				
			}
	
		
	}
	
	public void checkIfPlayerOneOwnsRedProperties(Player player,PropertySquare[] red) {
		
		for(int loop=1;loop<red.length;loop++) {
			if((red[0].getOwner()==p1) && (red[1].getOwner()==p1) && (red[2].getOwner()==p1)) {
				p1.setPropertyRedType(1);
				p2.setPropertyRedType(0);
				System.out.println(p1.playerName+" you own all the QUB(red) properties and can develop on these properties");
				break;
				
				
			}
		}
	}
	
	public void checkIfPlayerTwoOwnsRedProperties(Player player,PropertySquare[] red) {
		for(int loop=1;loop<red.length;loop++) {
			if((red[0].getOwner()==p2) && (red[1].getOwner()==p2) && (red[2].getOwner()==p2)) {
				p2.setPropertyRedType(1);
				p1.setPropertyRedType(0);
				System.out.println(p2.playerName+" you own all the QUB(red) properties and can develop on these properties");
				break;
				
		}
		}
		
	}
	
	public void checkIfPlayerOneOwnsYellowProperties(Player player, PropertySquare[] yellow) {
		for(int loop=1;loop<yellow.length;loop++) {
			if((yellow[0].getOwner()==p1) && (yellow[1].getOwner()==p1) ) {
				p1.setPropertyYellowType(1);
				p2.setPropertyYellowType(0);
				System.out.println(p1.playerName+" you own all the Bars(yellow) property squares and can develop on these properties");
				
			}
		}
		
	}
	
	public void checkIfPlayerTwoOwnsYellowProperties(Player player, PropertySquare[] yellow) {
		for(int loop=1;loop<yellow.length;loop++) {
			if((yellow[0].getOwner()==p2) && (yellow[1].getOwner()==p2) ) {
				p2.setPropertyYellowType(1);
				p1.setPropertyYellowType(0);
				System.out.println(p2.playerName+" you own all the Bars(yellow) property squares and can develop on these properties");
				
			}
		}
		
	}
	
	public void askIfTheyWantToPlayAgain() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play again? Y for Yes or N for No");
		String response = scanner.nextLine();
		if(response.equalsIgnoreCase("y")) {
			GameManager play = new GameManager();
			play.Play();
		}else {
			System.out.println("Thanks for playing. See you again soon!");
		}
	}
	
	
	
	
	
	
				
	}
		

	
				

			
			
		

	

	
