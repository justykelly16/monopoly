package monoversity;
/**
 * This class represents the Property Square on the board
 */

import java.util.Scanner;

import monoversity.Player;;

public class PropertySquare extends Square implements ISquare {
	// Public properties
	private String Name;

	// Private fields
	private Player owner;

	private static final int PRICE_HOUSE = 50;
	private int rentMultiplier = 1;
	private int numberOfHouses;
	private int price;
	private int rent;
	
	
	


	/**
	 * 
	 */
	public PropertySquare() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with args
	 * 
	 * @param name
	 * @param price
	 * @param rent
	 * @param boardLoaction
	 */
	public PropertySquare(String name, int boardLocation, int price, int rent) {
		super(name, boardLocation);
		this.price = price;
		this.rent = rent;
		
	}




	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void Modify(Player player) {
		System.out.println("You landed on the " + this.getName() +" square.");

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
			System.out.println("You have landed on the " + this.Name
					+ " square, this property is available to buy, but you don't have enough money.");
		}
	}

	/**
	 * Method to ask whether or not the player wants to buy the property
	 * 
	 * @param players
	 * @return
	 */
	public boolean AskIfPlayerWishesToPurchaseProperty(Player players) {
		System.out.println("You currently have a balance of £" + players.getPlayerBalance());
		System.out.println("This property is available to buy for £" + this.price);
		System.out.println("It also has a rental value of £" + this.rent);
		System.out.println("Do you want to buy it? (Y for Yes, N for No, then press enter.)");
		@SuppressWarnings("resource")
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

		System.out.printf("%s nows owns the %s square.\n", players.playerName, this.Name);
		System.out.println("Your current balance is now : £" + players.getPlayerBalance());
	}

	/**
	 * Method to check if owner can buy an additional house on the property
	 * 
	 * @param player
	 */
	public void CheckIfOwnerCanBuyHouse(Player player) {
		System.out.println("You own this property.");
		if (this.numberOfHouses < 4) {
			if (player.getPlayerBalance() > PRICE_HOUSE) {
				System.out.printf("This property currently has %d floors.\n" ,this.numberOfHouses);
				System.out.printf("Would you like to buy one for £%s? (Yes/No)" + "\r\n", PRICE_HOUSE);

				@SuppressWarnings("resource")
				String buyHouse = new Scanner(System.in).nextLine().trim();
				if (buyHouse.toLowerCase().equals("yes") || buyHouse.toLowerCase().equals("y")) {
					BuyHouse(player);
				}
			}
		} else {
			System.out.println("This property already has the maximum number of floors (3).");
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

		System.out.println("You now have " + this.numberOfHouses + " on this property.");
		System.out.println("Your rental income has increased to  £" + (this.rent * rentMultiplier));
		System.out.println("Your current balance is now : £" + players.getPlayerBalance());
	}

	/**
	 * Method for player to pay rent
	 * 
	 * @param players
	 */
	public void PlayerHasToPayRent(Player players) {
		System.out.println(owner.playerName + " owns this property.");
		System.out.println("You have to pay £" + (this.rent * rentMultiplier) + " in rent");

		players.setPlayerBalance(players.getPlayerBalance() - (rent * rentMultiplier)); // Take money from renter
		owner.setPlayerBalance(owner.getPlayerBalance() + (rent * rentMultiplier)); // Give money to owner
		System.out.println("Your balance is now : £" + players.getPlayerBalance());
		
		
	}

}