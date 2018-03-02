/**
 * 
 */
package monoversity;
/**
 * This class represents rolling a dice
 */

import java.util.Random;
import java.util.Scanner;

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
	public int throwDice() {
		Random randomGenerator = new Random();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Do you wish to roll the dice? (Press Y for yes, or or N for no then Enter)");

		if (scanner.next().equalsIgnoreCase("y")) {
			// pm1.setPlayerTurn(true);
			diceNumber = (randomGenerator.nextInt(NUM_FACES) + 1);
			this.setDiceNumber(diceNumber);
			System.out.println("You rolled a " + diceNumber +"\n");

		} else if (scanner.next().equalsIgnoreCase("n")) {
			System.out.println("You have chosen not to roll, Game over");
			// pm1.setPlayerTurn(false);

		}

		return diceNumber;

	}

}
