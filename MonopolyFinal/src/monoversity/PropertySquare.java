package monoversity;
/**
 * This class represents the Property Square on the board
 */

import java.util.Scanner;

import monoversity.GameManager;
import monoversity.Player;

public class PropertySquare extends Square implements ISquare {
	// Public properties

	// Private fields


	private int priceOfFloor;
	private int rentMultiplier = 1;
	private int numberOfHouses;
	private int price;
	private int rent;
	
	





	public final static int MIN_RENT_MULTIPLIER = 1;
	public final static int MAX_RENT_MULTIPLIER = 5;
	public final static int MIN_NUMBER_OF_FLOORS = 0;
	public final static int MAX_NUMBER_OF_FLOORS = 3;
	public final static int MIN_PRICE = 0;
	public final static int MAX_PRICE = 200;
	public final static int MIN_RENT = 24;
	public final static int MAX_RENT = 400;
	public final static int MIN_PRICE_OF_FLOOR = 50;
	public final static int MAX_PRICE_OF_FLOOR = 200;
	public final static int EXTENSION = 1;

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
	public PropertySquare(String name, int boardLocation, Player owner, int price, int rent, int priceOfFloor) {
		super(name, boardLocation, owner);
		this.setPrice(price);
		this.setRent(rent);
		this.setPriceOfFloor(priceOfFloor);
		
		

	}





	/**
	 * @return the rentMultiplier
	 */
	public int getRentMultiplier() {
		return rentMultiplier;
	}

	/**
	 * @param rentMultiplier
	 *            the rentMultiplier to set
	 */
	public void setRentMultiplier(int rentMultiplier) throws IllegalArgumentException {
		if (rentMultiplier >= MIN_RENT_MULTIPLIER && rentMultiplier <= MAX_RENT_MULTIPLIER) {
			this.rentMultiplier = rentMultiplier;
		} else {
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
	 * @param numberOfHouses
	 *            the numberOfHouses to set
	 */
	public void setNumberOfHouses(int numberOfHouses) throws IllegalArgumentException {
		if (numberOfHouses >= MIN_NUMBER_OF_FLOORS && numberOfHouses <= MAX_NUMBER_OF_FLOORS) {
			this.numberOfHouses = numberOfHouses;
		} else {
			throw new IllegalArgumentException("invalid number of floors");
		}
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) throws IllegalArgumentException {
		if (price >= MIN_PRICE && price <= MAX_PRICE) {
			this.price = price;
		} else {
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
	 * @param rent
	 *            the rent to set
	 */
	public void setRent(int rent) throws IllegalArgumentException {
		if (rent >= MIN_RENT && rent <= MAX_RENT) {
			this.rent = rent;
		} else {
			throw new IllegalArgumentException("Invalid amount");
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getPriceOfFloor() {
		return priceOfFloor;
	}

	/**
	 * 
	 * @param priceOfFloor
	 */
	public void setPriceOfFloor(int priceOfFloor) throws IllegalArgumentException {
		if (priceOfFloor >= MIN_PRICE_OF_FLOOR && priceOfFloor <= MAX_PRICE_OF_FLOOR) {
			this.priceOfFloor = priceOfFloor;
		} else {
			throw new IllegalArgumentException("invalid price of house");
		}
	}

	/**
	 * Modifies the players details when they land on this square
	 */
	@Override
	public void modify(Player player) {
		System.out.println("You landed on the " + this.getName() + " square.");

		if (this.getOwner() == null) {
			checkIfPlayerCanBuyProperty(player);
			
		} else if (player == this.getOwner()) {
			checkIfOwnerCanBuyHouse(player);
		} else {
			playerHasToPayRent(player);

		}

	}



	/**
	 * Method to check of the player can buy the property they have landed on
	 * 
	 * @param players
	 */
	public void checkIfPlayerCanBuyProperty(Player players) {
		if (players.getPlayerBalance() > price) {
			askIfPlayerWishesToPurchaseProperty(players);
			
				
			}else if(players.getPlayerBalance() < price){
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
	public void askIfPlayerWishesToPurchaseProperty(Player players) {
		System.out.println("You currently have a balance of £" + players.getPlayerBalance());
		System.out.println("This property is available to buy for £" + this.price);
		
		System.out.println("It also has a rental value of £" + this.rent);
		System.out.println("Do you want to buy it? (Y for Yes, N for No, then press enter.)");
		@SuppressWarnings("resource")
		String userInput = new Scanner(System.in).nextLine().trim();
		
		if(userInput.equalsIgnoreCase("y")) {
			buyProperty(players);
		}else {
			System.out.println("You have decided not to buy this property");
		}

	
	}

	/**
	 * Method for the player to buy the property
	 * 
	 * @param players
	 */
	public void buyProperty(Player players) {
		players.setPlayerBalance(players.getPlayerBalance() - price);
		setOwner(players);
		System.out.printf("%s nows owns the %s square.\n", players.playerName, this.getName());
		System.out.println("Your current balance is now : £" + players.getPlayerBalance());
		

	}

	/**
	 * Method to check if owner can buy an additional house on the property
	 * 
	 * @param player
	 */
	public void checkIfOwnerCanBuyHouse(Player player) {
		System.out.println("You own this property.");
		if((player.getPropertyRedType()==1) && ((player.getCurrentLocation()==2)
				||(player.getPropertyRedType()==1) && (player.getCurrentLocation()==3))||(player.getPropertyRedType()==1)&&(player.getCurrentLocation()==4)) {
		
				if (this.numberOfHouses < MAX_NUMBER_OF_FLOORS) {
					if (player.getPlayerBalance() > this.priceOfFloor) {
						System.out.printf("This property currently has %d floors.\n", this.numberOfHouses);
						System.out.printf("Would you like to buy one for £%s? (Yes/No)" + "\r\n", this.priceOfFloor);

						@SuppressWarnings("resource")
						String buyHouse = new Scanner(System.in).nextLine().trim();
						if (buyHouse.toLowerCase().equals("yes") || buyHouse.toLowerCase().equals("y")) {
							buyFloor(player);
							System.out.println(player.getPlayerName() + " you now own " + this.numberOfHouses + " floor/s on "
									+ this.getName());
						}
					}
					
				} else if(this.numberOfHouses==MAX_NUMBER_OF_FLOORS) {
					if (player.getPlayerBalance() > (this.priceOfFloor*2)) {
						System.out.printf("This property currently has %d floors.\n", this.numberOfHouses);
						System.out.printf("Would you like to buy an extension for £%s? (Yes/No)" + "\r\n", (this.priceOfFloor*2));
						
						@SuppressWarnings("resource")
						String buyExtension = new Scanner(System.in).nextLine().trim();
						if (buyExtension.toLowerCase().equals("yes") || buyExtension.toLowerCase().equals("y")) {
							buyExtension(player);
							System.out.println(player.getPlayerName() + " you now own 3 floors and "+EXTENSION+" extension on"
									+ this.getName());
						}
						
					}
					
				} else {
					System.out.println("This property already has the maximum number of floors (3) and extensions(1)..");
				}
		}else if ((player.getPropertyYellowType()==1 &&player.getCurrentLocation()==6)||(player.getPropertyYellowType()==1 && player.getCurrentLocation()==7)) {
			
			if (this.numberOfHouses < MAX_NUMBER_OF_FLOORS) {
				if (player.getPlayerBalance() > this.priceOfFloor) {
					System.out.printf("This property currently has %d floors.\n", this.numberOfHouses);
					System.out.printf("Would you like to buy one for £%s? (Yes/No)" + "\r\n", this.priceOfFloor);

					@SuppressWarnings("resource")
					String buyHouse = new Scanner(System.in).nextLine().trim();
					if (buyHouse.toLowerCase().equals("yes") || buyHouse.toLowerCase().equals("y")) {
						buyFloor(player);
						System.out.println(player.getPlayerName() + " you now own " + this.numberOfHouses + " floor/s on "
								+ this.getName());
					}
				}
			} else if(this.numberOfHouses==MAX_NUMBER_OF_FLOORS) {
				if (player.getPlayerBalance() > (this.priceOfFloor*2)) {
					System.out.printf("This property currently has %d floors.\n", this.numberOfHouses);
					System.out.printf("Would you like to buy an extension for £%s? (Yes/No)" + "\r\n", (this.priceOfFloor*2));
					
					@SuppressWarnings("resource")
					String buyExtension = new Scanner(System.in).nextLine().trim();
					if (buyExtension.toLowerCase().equals("yes") || buyExtension.toLowerCase().equals("y")) {
						buyExtension(player);
						System.out.println(player.getPlayerName() + " you now own 3 floors and "+EXTENSION+" extension on"
								+ this.getName());
					}
					
				}
				
			}
			
			else {
				System.out.println("This property already has the maximum number of floors (3) and extensions(1).");
			}
			
		} else {
			System.out.println("However, you do not own the whole property set and therefore cannot develop this property");
		}
		}
		
			

			

	
	

	/**
	 * Method for player to buy a house on the property
	 * 
	 * @param players
	 */
	public void buyFloor(Player players) {
		
		
		players.setPlayerBalance(players.getPlayerBalance() - this.priceOfFloor);
		numberOfHouses++;
		rentMultiplier++;

		System.out.println("You now have " + this.numberOfHouses + " of floors on this property.");
		System.out.println("Your rental income has increased to  £" + (this.rent * rentMultiplier));
		System.out.println("Your current balance is now : £" + players.getPlayerBalance());
		
			
		}
	
	public void buyExtension(Player players) {
		players.setPlayerBalance(players.getPlayerBalance() - (this.priceOfFloor*2));
		numberOfHouses++;
		rentMultiplier+=2;
		
		System.out.println("You now have 3 floors and "+EXTENSION+" extension on this property");
		System.out.println("Your rental income has increased to £"+(this.rent*rentMultiplier));
		System.out.println("Your current balance is now : £"+players.getPlayerBalance());
		
		
	}
			
		
	

	/**
	 * Method for player to pay rent
	 * 
	 * @param players
	 */
	public void playerHasToPayRent(Player players) {
		System.out.println(this.getOwner().playerName + " owns this property.");
		System.out.println("You have to pay £" + (this.rent * rentMultiplier) + " in rent");

		players.setPlayerBalance(players.getPlayerBalance() - (rent * rentMultiplier)); // Take money from renter
		this.getOwner().setPlayerBalance(this.getOwner().getPlayerBalance() + (rent * rentMultiplier)); // Give money to owner
		System.out.println("Your balance is now : £" + players.getPlayerBalance());
		System.out.println("----------------------------------------------------------");
		System.out.println();
		System.out.println(this.getOwner().getPlayerName() + " £" + (rent * rentMultiplier)
				+ " been added to your balance. Your new balance is now £" + this.getOwner().getPlayerBalance());

	}

	


}