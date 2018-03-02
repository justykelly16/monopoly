package monoversity;
/**
 * This class represents the Property Square on the board
 */

import java.util.Scanner;

import monoversity.Player;;

public class PropertySquare implements ISquare {
	// Public properties
	private String Name;

	// Private fields
	private Player owner;

	private static final int PRICE_HOUSE = 50;
	private int rentMultiplier = 1;
	private int numberOfHouses;
	private int price;
	private int rent;
	private int boardLocation;
	private int type;
	

	public final String getName() {
		return Name;
	}

	public final void setName(String value) {
		Name = value;
	}

	/**
	 * @return the boardLocation
	 */
	public int getBoardLocation() {
		return boardLocation;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @param boardLocation
	 *            the boardLocation to set
	 */
	@Override
	public void setBoardLocation(int boardLocation) {
		this.boardLocation = boardLocation;
	}

	/**
	 * Constructor with args
	 * 
	 * @param name
	 * @param price
	 * @param rent
	 * @param boardLoaction
	 */
	public PropertySquare(String name, int price, int rent, int boardLoaction, int type) {
		// Set public properties
		this.setName(name);

		// Set private fields
		this.price = price;
		this.rent = rent;
		this.boardLocation = boardLoaction;
		this.type=type;
	}

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player player) {
		System.out.println("You landed on " + this.getName());

		if (owner == null) {
			CheckIfPlayerCanBuyProperty(player);
		} else if (player == owner) {
			CheckIfOwnerCanBuyHouse(player);
		} else {
			PlayerHasToPayRent(player);
		}
	}

	/**
	 * Method to check of the player can buy the property they have landed on
	 * 
	 * @param players
	 */
	public void CheckIfPlayerCanBuyProperty(Player players) {
		if (players.getPlayerBalance() > price) {
			if (AskIfPlayerWishesToPurchaseProperty(players)) {
				BuyProperty(players);
			}
		} else {
			System.out.println("You have landed on " + this.Name
					+ ", this property is available to buy, but you don't have enough money.");
		}
	}

	/**
	 * Method to ask whether or not the player wants to buy the property
	 * 
	 * @param players
	 * @return
	 */
	public boolean AskIfPlayerWishesToPurchaseProperty(Player players) {
		System.out.println("You have a balance of " + players.getPlayerBalance());
		System.out.println("This property is available to buy for " + this.price);
		System.out.println("It also has a rental value of " + this.rent);
		System.out.println("Do you want to buy it? (Yes/No)");
		String userInput = new Scanner(System.in).nextLine().trim();

		return (userInput.toLowerCase().equals("yes") || userInput.toLowerCase().equals("y"));
	}

	/**
	 * Method for the player to buy the property
	 * 
	 * @param players
	 */
	public void BuyProperty(Player players) {
		players.setPlayerBalance(players.getPlayerBalance() - price);
		owner = players;

		System.out.println(players.playerName + " nows owns " + this.Name);
	}

	/**
	 * Method to check if owner can buy an additional house on the property
	 * 
	 * @param player
	 */
	public void CheckIfOwnerCanBuyHouse(Player player) {
		System.out.println("You own this property.");

		if (this.numberOfHouses < 4) {
			if ((type==(1)&type==(2)&type==(3))&&(player.getPlayerBalance() > PRICE_HOUSE)) {
				System.out.println("This property has " + this.numberOfHouses);
				System.out.printf("Would you like to buy one for £%1$s? (Yes/No)" + "\r\n", PRICE_HOUSE);

				String buyHouse = new Scanner(System.in).nextLine().trim();
				if (buyHouse.toLowerCase().equals("yes") || buyHouse.toLowerCase().equals("y")) {
					BuyHouse(player);
				}
			}
		} else {
			System.out.println("This property already has the maximum number of houses (3).");
		}
	}

	/**
	 * Method for player to buy a house on the property
	 * 
	 * @param players
	 */
	public void BuyHouse(Player players) {
		players.setPlayerBalance(players.getPlayerBalance() - PRICE_HOUSE);
		numberOfHouses++;
		rentMultiplier++;

		System.out.println("You now own " + this.numberOfHouses + " on this property.");
		System.out.println("Your rental income has increased to  " + (this.rent * rentMultiplier));
	}

	/**
	 * Method for player to pay rent
	 * 
	 * @param players
	 */
	public void PlayerHasToPayRent(Player players) {
		System.out.println(owner.playerName + " owns this property.");
		System.out.println("You have to pay " + (this.rent * rentMultiplier) + " in rent");

		players.setPlayerBalance(players.getPlayerBalance() - (rent * rentMultiplier)); // Take money from renter
		owner.setPlayerBalance(owner.getPlayerBalance() + (rent * rentMultiplier)); // Give money to owner
	}

}