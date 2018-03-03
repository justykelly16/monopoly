package monoversity;
/**
 * This class represents the Property Square on the board
 */

import java.util.Scanner;

import monoversity.Player;;

public class PropertySquare extends Square implements ISquare {
	// Public properties
	

	// Private fields
	private Player owner;

	private int priceOfHouse = 50;
	private int rentMultiplier = 1;
	private int numberOfHouses;
	private int price;
	private int rent;
	
	
	public final static int MIN_RENT_MULTIPLIER = 1;
	public final static int MAX_RENT_MULTIPLIER = 5;
	public final static int MIN_NUMBER_OF_HOUSES =0;
	public final static int MAX_NUMBER_OF_HOUSES=4;
	public final static int MIN_PRICE = 0;
	public final static int MAX_PRICE = 200;
	public final static int MIN_RENT = 24;
	public final static int MAX_RENT = 400;
	public final static int MIN_PRICE_OF_HOUSE = 50;
	public final static int MAX_PRICE_OF_HOUSE = 150;
	
	
	


	/**
	 * Default constructor
	 */
	public PropertySquare() {
	
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
		this.setPrice(price);
		this.setRent(rent);
		
	}






	/**
	 * @return the rentMultiplier
	 */
	public int getRentMultiplier() {
		return rentMultiplier;
	}

	/**
	 * @param rentMultiplier the rentMultiplier to set
	 */
	public void setRentMultiplier(int rentMultiplier) throws IllegalArgumentException{
		if(rentMultiplier>=MIN_RENT_MULTIPLIER && rentMultiplier<=MAX_RENT_MULTIPLIER) {
		this.rentMultiplier = rentMultiplier;
		}else {
			throw new IllegalArgumentException("invalid entry");
		}
	}

	/**
	 * @return the numberOfHouses
	 */
	public int getNumberOfHouses() {
		return numberOfHouses;
	}

	/**
	 * @param numberOfHouses the numberOfHouses to set
	 */
	public void setNumberOfHouses(int numberOfHouses) throws IllegalArgumentException{
		if(numberOfHouses>=MIN_NUMBER_OF_HOUSES&&numberOfHouses<=MAX_NUMBER_OF_HOUSES) {
		this.numberOfHouses = numberOfHouses;
		}else {
			throw new IllegalArgumentException("invalid number of houses");
		}
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) throws IllegalArgumentException{
		if(price>=MIN_PRICE&&price<=MAX_PRICE) {
		this.price = price;
		}else {
			throw new IllegalArgumentException("Invalid price");
		}
	}

	/**
	 * @return the rent
	 */
	public int getRent() {
		return rent;
	}

	/**
	 * @param rent the rent to set
	 */
	public void setRent(int rent)throws IllegalArgumentException{
		if(rent>=MIN_RENT&&rent<=MAX_RENT) {
		this.rent = rent;
		}else {
			throw new IllegalArgumentException("Invalid amount");
		}
	}
	/**
	 * 
	 * @return
	 */
	public int getPriceOfHouse() {
		return priceOfHouse;
	}
	
	/**
	 * 
	 * @param priceOfHouse
	 */
	public void setPriceOfHouse(int priceOfHouse) throws IllegalArgumentException {
		if(priceOfHouse>=MIN_PRICE_OF_HOUSE&&priceOfHouse<=MAX_PRICE_OF_HOUSE) {
		this.priceOfHouse = priceOfHouse;
		}else {
			throw new IllegalArgumentException("invalid price of house");
		}
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
			System.out.println("You have landed on the " + this.getName()
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

		System.out.printf("%s nows owns the %s square.\n", players.playerName, this.getName());
		System.out.println("Your current balance is now : £" + players.getPlayerBalance());
	}

	/**
	 * Method to check if owner can buy an additional house on the property
	 * 
	 * @param player
	 */
	public void CheckIfOwnerCanBuyHouse(Player player) {
		System.out.println("You own this property.");

		if (this.numberOfHouses < MAX_NUMBER_OF_HOUSES ) {
			if (player.getPlayerBalance() > this.priceOfHouse) {
				System.out.printf("This property currently has %d floors.\n" ,this.numberOfHouses);
				System.out.printf("Would you like to buy one for £%s? (Yes/No)" + "\r\n", this.priceOfHouse);

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
		players.setPlayerBalance(players.getPlayerBalance() - this.priceOfHouse);
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