/**
 * 
 */
package monoversity;
/**
 * This class represents rolling a dice
 */

import java.util.Random;

import java.util.Scanner;
import monoversity.Player;
/**
 * @author paddy
 *
 */
public class RollDice {

	private int diceNumber;
	private static final int NUM_FACES = 6;

	/**
	 * default constructor
	 */
	public RollDice() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param diceNumber
	 */
	public RollDice(int diceNumber) {
		this.setDiceNumber(diceNumber);
	}

	/**
	 * @return the diceNumber
	 */
	public int getDiceNumber() {
		return diceNumber;
	}

	/**
	 * @param diceNumber
	 *            the diceNumber to set
	 */
	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}

	/**
	 * Method to output a random dice number
	 * 
	 * @return
	 */
	public void throwDice(Player player) {
		String choice;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
		
		System.out.println("Do you wish to roll the dice? (Press Y for yes,  or N for no then Enter)");
		choice = scanner.next();

		if (choice.equalsIgnoreCase("y")) {
			Random randomGenerator = new Random();
			// pm1.setPlayerTurn(true);
			diceNumber = (randomGenerator.nextInt(NUM_FACES) + 1);
			this.setDiceNumber(diceNumber);
			System.out.println("You rolled a " + diceNumber +"\n");

		} else if (choice.equalsIgnoreCase("n")) {
			
			System.out.println("Are you sure you want to end the game? (Press Y to end the game, or N to continue then Enter)");
			choice=scanner.next();
			if(choice.equalsIgnoreCase("y")) {
			System.out.println("You have chosen not to roll, Game over");
			player.setCurrentLocation(10);
		
			}
			}
		
		}while(!choice.equals("y"));
		

	}

}
